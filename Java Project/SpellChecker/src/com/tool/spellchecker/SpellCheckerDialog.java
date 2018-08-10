package com.tool.spellchecker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.languagetool.rules.RuleMatch;

public class SpellCheckerDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel errorWordLabel;
	private JLabel replaceByLabel;
	private JLabel possibleErrorLabel;
	private JLabel suggestionslabel;
	private JLabel dictionarylabel;

	private JTextField errorWordTextField;
	private JTextField replaceByTextField;

	private JScrollPane possibleErrorPane;
	private JScrollPane suggestionsPane;

	private JTextArea possibleErrorTextArea;

	private DefaultListModel<String> suggestionsListModel;
	private JList<String> suggestionsList;

	private JButton replaceButton;
	private JButton replaceAllButton;
	private JButton ignoreButton;
	private JButton ignoreAllButton;

	private JButton closeButton;

	private JComboBox<String> dictionaryComboBox;

	private String messageText;

	private transient List<RuleMatch> matches;
	private String language;
	private int matchSize;
	private int counter;
	private int startLocation;
	private int endLocation;
	private String fontType = "calibri";

	JPanel dictionaryPanel;
	JPanel buttonPanel;
	JPanel actionButtonPanel;
	JPanel closeButtonPanel;

	JPanel fieldPanel;
	JPanel allFieldsPanel;

	public void enableButtons(boolean enable) {
		replaceButton.setEnabled(enable);
		replaceAllButton.setEnabled(enable);
		ignoreButton.setEnabled(enable);
		ignoreAllButton.setEnabled(enable);
	}

	public void clearFields() {
		errorWordTextField.setText(null);
		replaceByTextField.setText(null);
		possibleErrorTextArea.setText(null);
		suggestionsListModel.clear();
	}

	public SpellCheckerDialog(JFrame parent, JTextArea messageText,
			String language){
		super(parent, false);
		setMessageText(messageText.getText());
		setLanguage(language);
		initComponents();
		startSpellChecker();
	}

	private void startSpellChecker() {
		try {
			counter = 0;
			if (matches != null && !matches.isEmpty())
				matches.clear();

			matches = new SpellCheckerImpl().check(getMessageText(), getLanguage());
			if (!matches.isEmpty()) {
				errorWordLabel.setFont(new Font(fontType, Font.BOLD, 13));
				errorWordLabel.setForeground(Color.RED);
				errorWordLabel.setText("Unknown word");

				setMatchSize(matches.size());
				RuleMatch match = matches.get(counter);

				List<String> replacementList = match.getSuggestedReplacements();
				setStartLocation(match.getFromPos());
				setEndLocation(match.getToPos());

				errorWordTextField.setText(getMessageText().substring(
						getStartLocation(), getEndLocation()));
				possibleErrorTextArea.setText(match.getMessage());
				possibleErrorTextArea.setCaretPosition(0);

				replaceByTextField.setText(!match.getSuggestedReplacements()
						.isEmpty() ? match.getSuggestedReplacements().get(0)
						: "");
				for (int i = 0; i < replacementList.size(); i++) {
					suggestionsListModel.addElement(replacementList.get(i));
				}
				counter++;
			} else {
				clearFields();
				enableButtons(false);
				errorWordLabel.setFont(new Font(fontType, Font.BOLD, 13));
				errorWordLabel.setForeground(Color.RED);
				errorWordLabel.setText("No suggestions found");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void replaceAllErrorWord(String message) {
		boolean matchExist = true;
		while (matchExist) {
			try {
				RuleMatch match = matches.get(0);
				StringBuilder messageTextBuilder = new StringBuilder(getMessageText()
						.substring(0, match.getFromPos()));
				messageTextBuilder.append(match.getSuggestedReplacements().get(0));
				messageTextBuilder.append(getMessageText().substring(match.getToPos(),
						getMessageText().length()));
				setMessageText(messageTextBuilder.toString());
				matches.clear();
				matches = new SpellCheckerImpl().check(getMessageText(),
						getLanguage());
				if (matches.isEmpty()) {
					matchExist = false;
					dispose();
				}
			} catch (Exception e) {
				errorWordLabel.setFont(new Font(fontType, Font.BOLD, 13));
				errorWordLabel.setForeground(Color.RED);
				errorWordLabel.setText("Use Replace button");
				setMessageText(message);
				matchExist = false;
			}
		}
	}

	private void replaceErrorWord() {
		counter = 0;
		if (matches != null && !matches.isEmpty())
			matches.clear();
		matches = new SpellCheckerImpl().check(getMessageText(), getLanguage());

		if (!matches.isEmpty()) {
			suggestionsListModel.clear();
			errorWordLabel.setFont(new Font(fontType, Font.BOLD, 13));
			errorWordLabel.setForeground(Color.RED);
			errorWordLabel.setText("Unknown word");

			setMatchSize(matches.size());
			RuleMatch match = matches.get(counter);

			List<String> replacementList = match.getSuggestedReplacements();
			setStartLocation(match.getFromPos());
			setEndLocation(match.getToPos());

			errorWordTextField.setText(getMessageText().substring(
					getStartLocation(), getEndLocation()));
			possibleErrorTextArea.setText(match.getMessage());
			possibleErrorTextArea.setCaretPosition(0);

			replaceByTextField.setText(!match.getSuggestedReplacements()
					.isEmpty() ? match.getSuggestedReplacements().get(0) : "");
			for (int i = 0; i < replacementList.size(); i++) {
				suggestionsListModel.addElement(replacementList.get(i));
			}
			counter++;
		} else {
			errorWordLabel.setFont(new Font(fontType, Font.BOLD, 13));
			errorWordLabel.setForeground(Color.RED);
			errorWordLabel.setText("Spell check completed");
		}
	}

	private void getNextErrorWord() {
		if (getMatchSize() > counter) {
			RuleMatch match = matches.get(counter);
		
			setStartLocation(match.getFromPos());
			setEndLocation(match.getToPos());

			errorWordTextField.setText(getMessageText().substring(
					getStartLocation(), getEndLocation()));
			possibleErrorTextArea.setText(match.getMessage());
			possibleErrorTextArea.setCaretPosition(0);

			replaceByTextField.setText(!match.getSuggestedReplacements()
					.isEmpty() ? match.getSuggestedReplacements().get(0) : "");
			List<String> replacementList = match.getSuggestedReplacements();
			suggestionsListModel.clear();
			for (int i = 0; i < replacementList.size(); i++) {
				suggestionsListModel.addElement(replacementList.get(i));
			}
			counter++;

		} else {
			errorWordLabel.setFont(new Font(fontType, Font.BOLD, 13));
			errorWordLabel.setForeground(Color.RED);
			errorWordLabel.setText("Spell check completed");
		}
	}

	private void initComponents()  {
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setFont(new Font("Dialog", Font.BOLD, 14));
		setTitle("Spell-Checker");
		setContentPane(getJContentPane());
		setMinimumSize(new Dimension(400, 450));
		pack();
	}

	private JLabel getErrorWordLabel() {
		if (errorWordLabel == null) {
			errorWordLabel = new JLabel();
		}
		return errorWordLabel;
	}

	private JLabel getReplaceByLabel() {
		if (replaceByLabel == null) {
			replaceByLabel = new JLabel();
			replaceByLabel.setText("Replace By:");
		}
		return replaceByLabel;
	}

	private JLabel getPossibleErrorLabel() {
		if (possibleErrorLabel == null) {
			possibleErrorLabel = new JLabel();
			possibleErrorLabel.setText("Possible Error:");
		}
		return possibleErrorLabel;
	}

	private JLabel getSuggestionsLabel() {
		if (suggestionslabel == null) {
			suggestionslabel = new JLabel();
			suggestionslabel.setText("Suggestions:");
		}
		return suggestionslabel;
	}

	private JLabel getDictionaryLabel() {
		if (dictionarylabel == null) {
			dictionarylabel = new JLabel();
			dictionarylabel.setText("Dictionary ");
		}
		return dictionarylabel;
	}

	private JTextField getErrorWordTextField() {
		if (errorWordTextField == null) {
			errorWordTextField = new JTextField(20);
			errorWordTextField.setEditable(false);
		}
		return errorWordTextField;
	}

	private JTextField getReplaceByTextField() {
		if (replaceByTextField == null) {
			replaceByTextField = new JTextField(20);
		}
		return replaceByTextField;
	}

	private JScrollPane getPossibleErrorPane() {
		if (possibleErrorPane == null) {
			possibleErrorTextArea = new JTextArea(5, 20);
			possibleErrorTextArea.setLineWrap(true);
			possibleErrorTextArea.setEditable(false);
			possibleErrorPane = new JScrollPane(possibleErrorTextArea,
					JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			possibleErrorPane.setPreferredSize(new Dimension(175, 90));
		}
		return possibleErrorPane;
	}

	private JScrollPane getSuggestionsPane() {
		if (suggestionsPane == null) {
			suggestionsListModel = new DefaultListModel<>();
			suggestionsList = new JList<>(suggestionsListModel);
			suggestionsList
					.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			suggestionsList.setSelectedIndex(0);
			suggestionsPane = new JScrollPane(suggestionsList);
			suggestionsPane.setPreferredSize(new Dimension(175, 160));
			suggestionsList
					.addListSelectionListener(new ListSelectionListener() {
						public void valueChanged(ListSelectionEvent e) {
							if (!suggestionsList.isSelectionEmpty()) {
								replaceByTextField.setText(suggestionsList
										.getSelectedValue());
							}
						}
					});
		}
		return suggestionsPane;
	}

	private JButton getReplaceButton() {
		if (replaceButton == null) {
			replaceButton = new JButton("Replace");
			replaceButton.setPreferredSize(new Dimension(100, 25));
			replaceButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					StringBuilder messageStartText = new StringBuilder(
							getMessageText().substring(0, getStartLocation()));
					messageStartText.append(replaceByTextField.getText());
					messageStartText.append(getMessageText().substring(
							getEndLocation(), getMessageText().length()));
					setMessageText(messageStartText.toString());
					replaceErrorWord();
					System.out.println("From replace : " + getMessageText());
				}
			});
		}
		return replaceButton;
	}

	private JButton getReplaceAllButton() {
		if (replaceAllButton == null) {
			replaceAllButton = new JButton("Replace All");
			replaceAllButton.setPreferredSize(new Dimension(100, 25));
			replaceAllButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					replaceAllErrorWord(getMessageText());
					System.out
							.println("From replace All : " + getMessageText());
				}
			});
		}
		return replaceAllButton;
	}

	private JButton getIgnoreButton() {
		if (ignoreButton == null) {
			ignoreButton = new JButton("Ignore");
			ignoreButton.setPreferredSize(new Dimension(100, 25));
			ignoreButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getNextErrorWord();
				}
			});
		}
		return ignoreButton;
	}

	private JButton getIgnoreAllButton() {
		if (ignoreAllButton == null) {
			ignoreAllButton = new JButton("Ignore All");
			ignoreAllButton.setPreferredSize(new Dimension(100, 25));
			ignoreAllButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		}
		return ignoreAllButton;
	}

	private JButton getCloseButton() {
		if (closeButton == null) {
			closeButton = new JButton("Close");
			closeButton.setPreferredSize(new Dimension(100, 25));
			closeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		}
		return closeButton;
	}

	private JComboBox<String> getDictionaryComboBox() {
		if (dictionaryComboBox == null) {
			List<String> languages = new ArrayList<>();
			BufferedReader input = null;
			try {
				URL path = SpellCheckerDialog.class
						.getResource("SpellChecker.properties");
				File f = new File(path.getFile());
				input = new BufferedReader(new FileReader(f));
				String line = null;
				while ((line = input.readLine()) != null) {
					languages.add(line);
				}
			} catch (Exception e) {
				System.err.println("Error, file ");
			} finally {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			String[] lineArray = languages.toArray(new String[] {});
			dictionaryComboBox = new JComboBox<>(lineArray);
			boolean exists = false;
			int selectedIndex = 0;
			for (int index = 0; index < dictionaryComboBox.getItemCount()
					&& !exists; index++) {
				if (getLanguage().equalsIgnoreCase(
						dictionaryComboBox.getItemAt(index))) {
					exists = true;
					selectedIndex = index;
				}
			}
			dictionaryComboBox.setSelectedIndex(selectedIndex);
			dictionaryComboBox.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent itemEvent) {
					String selectedDictionaryLangugae = itemEvent.getItem()
							.toString();
					setLanguage(selectedDictionaryLangugae);
					enableButtons(true);
					suggestionsListModel.clear();
					startSpellChecker();
				}
			});
		}
		return dictionaryComboBox;
	}

	private JPanel getDictionaryPanel() {
		if (dictionaryPanel == null) {
			dictionaryPanel = new JPanel();
			FlowLayout layout = new FlowLayout();
			dictionaryPanel.setLayout(layout);
			layout.setHgap(40);
			layout.setVgap(10);
			dictionaryPanel.add(getDictionaryLabel());
			dictionaryPanel.add(getDictionaryComboBox());
		}
		return dictionaryPanel;
	}

	private JPanel getCloseButtonPanel() {
		if (closeButtonPanel == null) {
			closeButtonPanel = new JPanel();
			closeButtonPanel.setLayout(new GridBagLayout());

			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = 20;
			gbc.gridy = 70;
			gbc.insets = new Insets(35, 0, 10, 0);
			closeButtonPanel.add(getCloseButton(), gbc);
		}
		return closeButtonPanel;
	}

	private JPanel getActionButtonPanel() {
		if (actionButtonPanel == null) {
			actionButtonPanel = new JPanel();
			actionButtonPanel.setLayout(new GridBagLayout());

			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = 20;
			gbc.gridy = 20;
			gbc.insets = new Insets(0, 0, 5, 0);
			gbc.anchor = GridBagConstraints.EAST;
			actionButtonPanel.add(getReplaceButton(), gbc);

			gbc.gridx = 20;
			gbc.gridy = 40;
			gbc.insets = new Insets(5, 0, 5, 0);
			actionButtonPanel.add(getReplaceAllButton(), gbc);

			gbc.gridx = 20;
			gbc.gridy = 60;
			gbc.insets = new Insets(5, 0, 5, 0);
			actionButtonPanel.add(getIgnoreButton(), gbc);

			gbc.gridx = 20;
			gbc.gridy = 80;
			gbc.insets = new Insets(5, 0, 170, 0);
			actionButtonPanel.add(getIgnoreAllButton(), gbc);
		}
		return actionButtonPanel;
	}

	private JPanel getButtonPanel() {
		if (buttonPanel == null) {
			buttonPanel = new JPanel();
			buttonPanel.setLayout(new BorderLayout());
			buttonPanel.add(BorderLayout.CENTER, getActionButtonPanel());
			buttonPanel.add(BorderLayout.PAGE_END, getCloseButtonPanel());
		}
		return buttonPanel;
	}

	private JPanel getFieldsPanel() {
		if (fieldPanel == null) {
			fieldPanel = new JPanel();

			fieldPanel.setLayout(new GridBagLayout());

			GridBagConstraints gbc1 = new GridBagConstraints();
			gbc1.gridx = 0;
			gbc1.gridy = 0;
			gbc1.anchor = GridBagConstraints.WEST;
			fieldPanel.add(getErrorWordLabel(), gbc1);

			gbc1.gridx = 0;
			gbc1.gridy = 10;
			gbc1.anchor = GridBagConstraints.WEST;
			fieldPanel.add(getErrorWordTextField(), gbc1);

			gbc1.gridx = 0;
			gbc1.gridy = 20;
			gbc1.anchor = GridBagConstraints.WEST;
			fieldPanel.add(getReplaceByLabel(), gbc1);

			gbc1.gridx = 0;
			gbc1.gridy = 30;
			gbc1.anchor = GridBagConstraints.WEST;
			fieldPanel.add(getReplaceByTextField(), gbc1);

			gbc1.gridx = 0;
			gbc1.gridy = 40;
			gbc1.anchor = GridBagConstraints.WEST;
			fieldPanel.add(getPossibleErrorLabel(), gbc1);

			gbc1.gridx = 0;
			gbc1.gridy = 50;
			gbc1.anchor = GridBagConstraints.WEST;
			fieldPanel.add(getPossibleErrorPane(), gbc1);

			gbc1.gridx = 0;
			gbc1.gridy = 90;
			gbc1.anchor = GridBagConstraints.WEST;
			fieldPanel.add(getSuggestionsLabel(), gbc1);

			gbc1.gridx = 0;
			gbc1.gridy = 100;
			gbc1.anchor = GridBagConstraints.WEST;
			fieldPanel.add(getSuggestionsPane(), gbc1);
		}
		return fieldPanel;
	}

	private JPanel getAllFieldsPanel() {
		if (allFieldsPanel == null) {
			allFieldsPanel = new JPanel(new BorderLayout());
			allFieldsPanel.add(BorderLayout.CENTER, getFieldsPanel());
			allFieldsPanel.add(BorderLayout.SOUTH, getDictionaryPanel());
		}
		return allFieldsPanel;
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel(new BorderLayout());
			jContentPane.add(BorderLayout.CENTER, getAllFieldsPanel());
			jContentPane.add(BorderLayout.EAST, getButtonPanel());
		}
		return jContentPane;
	}

	public int getMatchSize() {
		return matchSize;
	}

	public void setMatchSize(int matchSize) {
		this.matchSize = matchSize;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public int getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(int startLocation) {
		this.startLocation = startLocation;
	}

	public int getEndLocation() {
		return endLocation;
	}

	public void setEndLocation(int endLocation) {
		this.endLocation = endLocation;
	}
}