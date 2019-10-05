package com.jira.main;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.JiraRestClientFactory;
import com.atlassian.jira.rest.client.api.domain.Issue;
import com.atlassian.jira.rest.client.api.domain.SearchResult;
import com.atlassian.jira.rest.client.api.domain.User;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import com.atlassian.util.concurrent.Promise;
import com.jira.util.JiraUtil;

public class JiraMainCall {
	private final String JIRA_URL = "https://engjira.int.gmail.com";
	private final String JIRA_ADMIN_USERNAME = "gaurav.garg@gmail.com";
	private final String JIRA_ADMIN_PASSWORD = "";
	private XSSFWorkbook workbook;
	private boolean skipSearchValidation = true;
	private String developerInQuery = "";
	private String jqlQuery = "project = CENG AND issuetype in (Defect) "
			//	+ "AND status in (Closed) "
			//+ "AND Team in (\"CE: UP: \")"
			+ "AND Developer in (\"gaurav.garg@gmail.com\")"
			//+ "AND Assignee in (\"gaurav.garg@gmail.com\")"
			// + "AND resolved > (\"2018-04-16T12:43:22.657-0400\") and resolved <
			// (\\\"2019-04-16T12:43:22.657-0400\\\")"
			+ "ORDER BY key desc";

	public static void main(String[] args) throws Exception {
		try {
			JiraMainCall obj = new JiraMainCall();
			//obj.callJiraAPI();
			obj.callJiraAPIAndCreateExcel();
		} catch (Exception e) {
			System.out.println("Exception : " + e.toString());
		}
	}

	public void callJiraAPI() throws URISyntaxException {
		// Construct the JRJC client
		System.out.println("Logging in to " + JIRA_URL + " with username " + JIRA_ADMIN_USERNAME);
		JiraRestClientFactory factory = new AsynchronousJiraRestClientFactory();
		URI uri = new URI(JIRA_URL);
		JiraRestClient client = factory.createWithBasicHttpAuthentication(uri, JIRA_ADMIN_USERNAME,
				JIRA_ADMIN_PASSWORD);

		// Invoke the JRJC Client
		System.out.println("Invoke the JRJC Client");
		//Promise<User> promise = client.getUserClient().getUser(JIRA_ADMIN_USERNAME);
		/*
		 * for (BasicProject project :
		 * client.getProjectClient().getAllProjects().claim()) {
		 * System.out.println(project.getKey() + ": " + project.getName()); }
		 */

		Promise<SearchResult> searchJqlPromise = client.getSearchClient().
				searchJql(jqlQuery, 100, 0, null);

		int issueCount = 0;
		int issueSearched = 0;

		for (Issue issue : searchJqlPromise.claim().getIssues()) {
			issueSearched++;
			if (JiraUtil.searchIssue(issue.getSummary().toLowerCase(),searchFor(), skipSearchValidation)) {
				issueCount++;
				System.out.println(	issueCount + ") - "
					+ issue.getKey() + " - "
					+ JiraUtil.getAffectedVersion(issue.getAffectedVersions()) + " - "
					+ issue.getSummary() + " - "
					+ JiraUtil.getCustomField(issue.getFieldByName("Developer")) + " - "
					+ JiraUtil.getCustomField(issue.getFieldByName("Escalation Status")) + " - "
					//+ issue.getFieldByName("Date Closed").getValue().toString().substring(0, 10) + " - "
					+ issue.getStatus().getName() + " - "
					+ issue.getAssignee().getDisplayName() + " - "
					+ JiraUtil.getCustomField(issue.getFieldByName("Product / Component")) + " - "
					+ JiraUtil.getCustomField(issue.getFieldByName("Team"))

				// + " - " + JiraUtil.getCustomField(issue.getFieldByName("Customer"))
				);
			}
		}
		System.out.println("Issue search completed with "
				+ issueSearched + " issues searched and found "
				+ issueCount + " similar issues.");
	}

	public void callJiraAPIAndCreateExcel() {
		try {
			int columnSize = 9;

			// Construct the JRJC client
			System.out.println("Logging in to " + JIRA_URL + " with username " + JIRA_ADMIN_USERNAME);
			JiraRestClientFactory factory = new AsynchronousJiraRestClientFactory();
			URI uri = new URI(JIRA_URL);
			JiraRestClient client = factory.createWithBasicHttpAuthentication(uri, JIRA_ADMIN_USERNAME,
					JIRA_ADMIN_PASSWORD);

			Promise<SearchResult> searchJqlPromise = client.getSearchClient().
					searchJql(jqlQuery, 100, 0, null);

			int issueCount = 0;
			int issueSearched = 0;

			workbook = new XSSFWorkbook();

			// Create a blank sheet
			XSSFSheet spreadsheet = workbook.createSheet(" Jira Details ");

			// Create row object
			XSSFRow row;
			row = spreadsheet.createRow(0);

			row.createCell(0).setCellValue("S No.");
			row.createCell(1).setCellValue("Jira Id");
			row.createCell(2).setCellValue("Affected Version");
			row.createCell(3).setCellValue("Summary");
			row.createCell(4).setCellValue("Developer");
			row.createCell(5).setCellValue("Escalation Status");
			row.createCell(6).setCellValue("Status");
			row.createCell(7).setCellValue("Assignee");
			row.createCell(8).setCellValue("Product / Component");
			row.createCell(9).setCellValue("Team");

			for (Issue issue : searchJqlPromise.claim().getIssues()) {
				issueSearched++;
				List<Comparable> excelItems = new ArrayList<Comparable>();
				if (JiraUtil.searchIssue(issue.getSummary().toLowerCase(),searchFor(), skipSearchValidation)) {
					issueCount++;
					excelItems.add(0, issueCount);
					excelItems.add(1, issue.getKey());
					//excelItems.add(1, "https://engjira.int.kronos.com/browse/" +issue.getKey());
					excelItems.add(2, JiraUtil.getAffectedVersion(issue.getAffectedVersions()));
					excelItems.add(3, issue.getSummary());
					excelItems.add(4, JiraUtil.getCustomField(issue.getFieldByName("Developer")));
					excelItems.add(5, JiraUtil.getCustomField(issue.getFieldByName("Escalation Status")));
					excelItems.add(6, issue.getStatus().getName());
					excelItems.add(7, issue.getAssignee().getDisplayName());
					excelItems.add(8, JiraUtil.getCustomField(issue.getFieldByName("Product / Component")));
					excelItems.add(9, JiraUtil.getCustomField(issue.getFieldByName("Team")));

					int rowid = (int) excelItems.get(0);
					row = spreadsheet.createRow(rowid++);
					int cellid = 0;
					for (int i = 0; i <= columnSize; i++) {
						Cell cell = row.createCell(cellid++);
						cell.setCellValue(excelItems.get(i).toString());
					}
				}
			}
			// Write the workbook in file system
			String fileName = "C://Mine//Docs//JiraDetails_" + developerInQuery +"_" +
									new SimpleDateFormat("MMddyyyyHHmmss").format(new Date()) + ".xlsx";
			FileOutputStream out = new FileOutputStream(new File(fileName));
			workbook.write(out);
			out.close();
			System.out.println("Excel created successfully");
			System.out.println("Issue search completed with "
					+ issueSearched + " issues searched and found "
					+ issueCount + " similar issues.");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> searchFor(){
		List<String> search = new ArrayList<String>();
		search.add(("prorat").toLowerCase());
		search.add(("historical correction").toLowerCase());
		search.add(("BGP").toLowerCase());
		return search;
	}
}
