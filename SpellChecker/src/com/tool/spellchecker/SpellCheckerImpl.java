package com.tool.spellchecker;

import java.io.IOException;
import java.util.List;

import org.languagetool.JLanguageTool;
import org.languagetool.Language;
import org.languagetool.language.BritishEnglish;
import org.languagetool.language.Chinese;
import org.languagetool.language.Dutch;
import org.languagetool.language.French;
import org.languagetool.language.Spanish;
import org.languagetool.language.SwissGerman;
import org.languagetool.rules.RuleMatch;

public class SpellCheckerImpl {

	public List<RuleMatch> check(String messageText, String language) {
		List<RuleMatch> matches = null;
		Language lang;
		try {

			switch (language) {
			case "English":
				lang = new BritishEnglish();
				break;
			case "French":
				lang = new French();
				break;
			case "Espanol":
				lang = new Spanish();
				break;
			case "German":
				lang = new SwissGerman();
				break;
			case "Dutch":
				lang = new Dutch();
				break;
			case "Chinese":
				lang = new Chinese();
				break;
			default:
				lang = new BritishEnglish();
			}

			JLanguageTool langTool = new JLanguageTool(lang);
			matches = langTool.check(messageText);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return matches;
	}
}
