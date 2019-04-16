package com.jira.main;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.JiraRestClientFactory;
import com.atlassian.jira.rest.client.api.domain.BasicProject;
import com.atlassian.jira.rest.client.api.domain.Issue;
import com.atlassian.jira.rest.client.api.domain.SearchResult;
import com.atlassian.jira.rest.client.api.domain.User;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import com.atlassian.util.concurrent.Promise;
import java.net.URI;

public class JiraMainCall {
	private static final String JIRA_URL = "https://engjira.int.kronos.com";
	private static final String JIRA_ADMIN_USERNAME = "gaurav.garg@kronos.com";
	private static final String JIRA_ADMIN_PASSWORD = "Heyram@2016";

	public static void main(String[] args) throws Exception {
		// Construct the JRJC client
		System.out.println("Logging in to " + JIRA_URL + " with username " + JIRA_ADMIN_USERNAME);
		JiraRestClientFactory factory = new AsynchronousJiraRestClientFactory();
		URI uri = new URI(JIRA_URL);
		JiraRestClient client = factory.createWithBasicHttpAuthentication(uri, JIRA_ADMIN_USERNAME,
				JIRA_ADMIN_PASSWORD);

		// Invoke the JRJC Client
		System.out.println("Invoke the JRJC Client");
		Promise<User> promise = client.getUserClient().getUser(JIRA_ADMIN_USERNAME);
		User user = promise.claim();

		/*
		 * for (BasicProject project :
		 * client.getProjectClient().getAllProjects().claim()) {
		 * System.out.println(project.getKey() + ": " + project.getName()); }
		 */
		String name = "gaurav.garg@kronos.com";
		Promise<SearchResult> searchJqlPromise = client.getSearchClient()
				.searchJql("project = CENG AND issuetype in (Defect) " 
						+ "AND status in (Closed) "
						+ "AND Team in (\"CE: UP: Timekeeping\")" 
						+ "AND Developer in (\"gaurav.garg@kronos.com\")"
						+ "ORDER BY assignee, resolutiondate");

		
		int num = 0;
		for (Issue issue : searchJqlPromise.claim().getIssues()) {
			num++;
			System.out.println(num + ") " + 
			issue.getKey() + " - " + 
			issue.getAssignee().getDisplayName() + " - " +
			issue.getField("customfield_10503").getValue().toString() + " - " +
			issue.getField("customfield_12400").getName());
		}

		// Print the result
		System.out.println("Your admin user's email address is: " + user.getEmailAddress());
		// Done
		System.out.println("Example complete. Now exiting.");
		System.exit(0);
	}

}
