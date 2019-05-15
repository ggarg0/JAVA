package com.jira.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.atlassian.jira.rest.client.api.domain.IssueField;
import com.atlassian.jira.rest.client.api.domain.Version;
import com.google.gson.Gson;
import com.jira.bean.Customer;
import com.jira.bean.Developer;
import com.jira.bean.EscalationStatus;
import com.jira.bean.ProductComponent;
import com.jira.bean.Team;

public class JiraUtil {

	public static String getCustomField(IssueField issueField) {
		String result = "";
		Gson gson = new Gson();

		if (issueField.getName().toString().equalsIgnoreCase("Developer") && issueField.getValue() != null)
			result = gson.fromJson(issueField.getValue().toString(), Developer.class).getDisplayName();
		
		else if (issueField.getName().toString().equalsIgnoreCase("Escalation Status") && issueField.getValue() != null)
			result = gson.fromJson(issueField.getValue().toString(), EscalationStatus.class).getValue();

		else if (issueField.getName().toString().equalsIgnoreCase("Product / Component") && issueField.getValue() != null) {
			if(gson.fromJson(issueField.getValue().toString(), ProductComponent.class).getChild() != null) {
				result = (gson.fromJson(issueField.getValue().toString(), ProductComponent.class).getValue() + "/"
						+ (gson.fromJson(issueField.getValue().toString(), ProductComponent.class).getChild().getValue()));
			}else
				result = (gson.fromJson(issueField.getValue().toString(), ProductComponent.class).getValue());
		}

		else if (issueField.getName().toString().equalsIgnoreCase("Team") && issueField.getValue() != null)
			result = gson.fromJson(issueField.getValue().toString(), Team.class).getValue();

		else if (issueField.getName().toString().equalsIgnoreCase("Customer") && issueField.getValue() != null )
			result = gson.fromJson(issueField.getValue().toString(), Customer.class).getDetails()[0].getValue();

		return result;
	}

	public static String getAffectedVersion(Iterable<Version> versions) {
		String affectedVersion = null;
		Iterator<Version> it = versions.iterator();
		while (it.hasNext()) {
			String next = it.next().getName();
			if (null != affectedVersion)
				affectedVersion = affectedVersion + ", " + next;
			else
				affectedVersion = next;
		}
		return affectedVersion;
	}

	public static boolean searchIssue(String issueSummary, List<String> searchFor, boolean skipSearchValidation) {
		if (skipSearchValidation)
			return skipSearchValidation;

		boolean result = false;
		for (String search : searchFor) {
			if (issueSummary.contains(search))
				result = true;
		}
		return result;
	}

	public static String checkForNullAndReturnEmptyString(String value) {
		String result = "";
		if(value != null)
			result = value.trim();
		return result;		
	}

}
