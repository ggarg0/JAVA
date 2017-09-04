package com.tool.spellchecker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Highlighter;

import org.languagetool.rules.ITSIssueType;
import org.languagetool.rules.RuleMatch;

public class SpellCheckerGUI {

	private JFrame mainFrame;
	private JLabel messageLabel = new JLabel("Message");
	private JTextArea messageTextArea = new JTextArea(15, 50);
	private JButton checkButton = new JButton("Spell Check");

	private JScrollPane messagescrollPane;
	private List<RuleMatch> matches;
	private int matchSize;

	private HighlightPainter redPainter;											
	private HighlightPainter bluePainter; 											

	private String messageText;
	private String language;

	public int getMatchSize() {
		return matchSize;
	}

	public void setMatchSize(int matchSize) {
		this.matchSize = matchSize;
	}

	public SpellCheckerGUI() {
		prepareGUI();
	}

	public static void main(String[] args) {
		SpellCheckerGUI spellChecker = new SpellCheckerGUI();
	}

	private void prepareGUI() {
		redPainter = new HighlightPainter(Color.red);
		bluePainter = new HighlightPainter(Color.blue);
		setLanguage("French");

		mainFrame = new JFrame("Spell Checker Demo");
		mainFrame.setSize(600, 550);
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		mainFrame.add(getMainPanel());
		mainFrame.setVisible(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		mainFrame.setLocation(dim.width / 2 - mainFrame.getSize().width / 2,
				dim.height / 2 - mainFrame.getSize().height / 2);
	}

	private JScrollPane getMessagescrollPane() {
		if (messagescrollPane == null) {
			messageTextArea.setLineWrap(true);
			messageTextArea.setEditable(true);
			messagescrollPane = new JScrollPane(messageTextArea,
					JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			setMessageText(messageTextArea.getText());
			Highlighter highlighter = messageTextArea.getHighlighter();
			messageTextArea.getDocument().addDocumentListener(
					new DocumentListener() {

						@Override
						public void insertUpdate(DocumentEvent e) {
							try {
								highlighter.removeAllHighlights();
								matches = new SpellCheckerImpl().check(
										messageTextArea.getText(),
										getLanguage());
				
								
								
								for (int counter = 0; matches.size() > counter; counter++) {
									RuleMatch match = matches.get(counter);
									
									  /*System.out.println("Potential typo at line " +
							                  match.getLine() + ", column " +
							                  match.getColumn() + ": " + match.getMessage());
							                  System.out.println("Suggested correction(s): " +
							                  match.getSuggestedReplacements());*/
									
									if (ITSIssueType.Misspelling
											.equals(match.getRule()
													.getLocQualityIssueType())) {
										highlighter.addHighlight(
												match.getFromPos(),
												match.getToPos(), redPainter);
									} else {
										highlighter.addHighlight(
												match.getFromPos(),
												match.getToPos(), bluePainter);
									}
								}
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						}

						@Override
						public void removeUpdate(DocumentEvent e) {
							try {
								highlighter.removeAllHighlights();
								matches = new SpellCheckerImpl().check(
										messageTextArea.getText(),
										getLanguage());
								for (int counter = 0; matches.size() > counter; counter++) {
									RuleMatch match = matches.get(counter);
									  System.out.println("Potential typo at line " +
							                  match.getLine() + ", column " +
							                  match.getColumn() + ": " + match.getMessage());
							                  System.out.println("Suggested correction(s): " +
							                  match.getSuggestedReplacements());
									if (ITSIssueType.Misspelling
											.equals(match.getRule()
													.getLocQualityIssueType())) {
										highlighter.addHighlight(
												match.getFromPos(),
												match.getToPos(), redPainter);
									} else {
										highlighter.addHighlight(
												match.getFromPos(),
												match.getToPos(), bluePainter);
									}
								}
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						}

						@Override
						public void changedUpdate(DocumentEvent e) {
							try {
								highlighter.removeAllHighlights();
								matches = new SpellCheckerImpl().check(
										messageTextArea.getText(),
										getLanguage());
								for (int counter = 0; matches.size() > counter; counter++) {
									RuleMatch match = matches.get(counter);
									  System.out.println("Potential typo at line " +
							                  match.getLine() + ", column " +
							                  match.getColumn() + ": " + match.getMessage());
							                  System.out.println("Suggested correction(s): " +
							                  match.getSuggestedReplacements());
									
									if (ITSIssueType.Misspelling
											.equals(match.getRule()
													.getLocQualityIssueType())) {
										highlighter.addHighlight(
												match.getFromPos(),
												match.getToPos(), redPainter);
									} else {
										highlighter.addHighlight(
												match.getFromPos(),
												match.getToPos(), bluePainter);
									}
								}
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						}
					});
		}
		return messagescrollPane;
	}
	
	public void updateText(String text){
		messageTextArea.setText(text);		
	}

	public JPanel getMainPanel() {
		JPanel msgPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc1 = new GridBagConstraints();
		gbc1.gridx = 0;
		gbc1.gridy = 0;

		gbc1.ipadx = 0;
		gbc1.insets = new Insets(50, 10, 0, 0);
		gbc1.anchor = GridBagConstraints.CENTER;
		gbc1.fill = GridBagConstraints.VERTICAL;

		msgPanel.add(messageLabel, gbc1);
		gbc1.gridx = 0;
		gbc1.gridy = 100;
		gbc1.anchor = GridBagConstraints.WEST;
		msgPanel.add(getMessagescrollPane(), gbc1);
		gbc1.gridx = 0;
		gbc1.gridy = 150;
		gbc1.anchor = GridBagConstraints.CENTER;
		msgPanel.add(checkButton, gbc1);

		checkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SpellCheckerDialog dialog = new SpellCheckerDialog(mainFrame, messageTextArea, language);
					dialog.setLocation(1200, 100);
					dialog.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		return msgPanel;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
}
