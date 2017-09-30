package QueryDataBase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class QueryDataBaseDB {

	int i = 1;
	int n = 0;
	int k = 0;
	int len = 0;
	int rowsUpdated = 0;
	boolean schemaFlag = false;
	String oracleserver = "";

	// excel sheet for matched records
	HSSFWorkbook wb = new HSSFWorkbook();
	HSSFSheet sheet = wb.createSheet("new sheet");
	HSSFRow row[] = new HSSFRow[50000];

	public void QueryData(String user, String password, String database,
			String OracleServer, String query, String FilePath,
			String outputFilePath, String outputMissFilePath,
			String TransactionFlag) throws Exception {

		String filePath = FilePath;
		String selectquery = "";
		String updatequeryDB = "";
		String updateQueryExecute="";

		if (TransactionFlag.equalsIgnoreCase("select")) {
			selectquery = query;
		} else if (TransactionFlag.equalsIgnoreCase("update")) {
			updatequeryDB = query.toLowerCase();
			updateQueryExecute=query;
			int indexOfUpdate = updatequeryDB.indexOf("update") + 6;
			int indexOfSet = updatequeryDB.indexOf("set") - 1;
			int indexOfWhere = updatequeryDB.indexOf("where") - 1;
			String tableName = (updatequeryDB.substring(indexOfUpdate,
					indexOfSet).trim());
			String query2 = (updatequeryDB.substring(indexOfWhere,
					updatequeryDB.length()).trim());
			selectquery = "select * from " + tableName + " " + query2;
			System.out.println("selectquery: " + selectquery);

		}
		else if (TransactionFlag.equalsIgnoreCase("delete")) {
			updatequeryDB = query.toLowerCase();
			updateQueryExecute=query;
			int indexOfFrom = updatequeryDB.indexOf("from") + 4;
		//	int indexOfSet = updatequeryDB.indexOf("set") - 1;
			int indexOfWhere = updatequeryDB.indexOf("where") - 1;
			String tableName = (updatequeryDB.substring(indexOfFrom,
					indexOfWhere).trim());
			String query2 = (updatequeryDB.substring(indexOfWhere,
					updatequeryDB.length()).trim());
			selectquery = "select * from " + tableName + " " + query2;
			System.out.println("selectquery: " + selectquery);

		}
		int[] result = new int[2];
		String queryIgnoreCase = selectquery.toLowerCase();
		if (queryIgnoreCase.contains("variable")) {

			String schemaDetails = database;
			String userDetails = user;
			String passwordDetails = password;
			String OracleServerDetails = OracleServer;

			row[0] = sheet.createRow((short) 0);

			try {
				Connection connectionCol = null;
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("Conn : " + "jdbc:oracle:thin:@"
						+ OracleServerDetails + ":1521:" + schemaDetails
						+ userDetails + passwordDetails);

				connectionCol = DriverManager.getConnection(
						"jdbc:oracle:thin:@" + OracleServerDetails + ":1521:"
								+ schemaDetails, userDetails, passwordDetails);

				int col = 0;
				String[] aColumnName = new String[15];
				String[] aTableName = new String[7];
				String selectQueryDB = selectquery.toLowerCase();

				System.out.println("Calling tableName function");

				aTableName = tableName(selectQueryDB, userDetails); // function
				// retrieving
				// Table Name

				if (selectQueryDB.contains("*")) {

					int x = 1;

					String queryCol = "SELECT column_name FROM "
							+ "all_tab_cols where table_name =" + "'"
							+ aTableName[0].toUpperCase() + "'";

					Statement statementCol = connectionCol.createStatement();
					ResultSet resultsetCol = statementCol
							.executeQuery(queryCol);

					resultsetCol.next();

					row[0].createCell((short) 0).setCellValue(
							resultsetCol.getString(1).toUpperCase());

					while (resultsetCol.next()) {

						row[0].createCell((short) x).setCellValue(
								resultsetCol.getString(1).toUpperCase());
						x++;

					}
					System.out.println("Schema flag : " + schemaFlag);
					if (schemaFlag == true) {
						len = x / 2;
						int counter = len;
						while (counter != x) {

							row[0].createCell((short) counter)
									.setCellValue(" ");
							counter++;
						}
					}

					else {
						len = x;
					}

					System.out.println("Column value : " + len);
					resultsetCol.close();
					statementCol.close();
					connectionCol.close();

				}

				else {

					System.out.println("Calling columnName function");
					aColumnName = columnName(selectQueryDB); // function
																// retrieving
					// Column Name
					col = aColumnName.length;

					while (len <= aColumnName.length) {

						row[0].createCell((short) len).setCellValue(
								aColumnName[len].toUpperCase());

						len++;
						if (aColumnName[len].length() < 2)
							break;
					}
				} // end else column

				queryTables(len, selectQueryDB, updateQueryExecute, filePath, user,
						password, database, OracleServerDetails,
						outputFilePath, outputMissFilePath);

				
			} // end try
			catch (Exception e) {
				JOptionPane
				.showMessageDialog(
						null,
						"Exception occured : "
								+ e
								,
						"Error Message", 1);

			}

		} else {
			System.out.println(" Query should contain variable");
			result[0] = -1;

		}

	}

	public String[] tableName(String queryDB, String userDetails) {

		int indexOfFrom = queryDB.indexOf("from") + 4;
		int indexOfWhere = queryDB.indexOf("where") - 1;

		String tableName = (queryDB.substring(indexOfFrom, indexOfWhere).trim());

		String[] aTable = new String[8];

		int colTable = 0;
		while (tableName.contains(",")) {

			int indexOfComma = tableName.indexOf(",");
			aTable[colTable] = (tableName.substring(0, indexOfComma).trim());

			tableName = (tableName.substring(indexOfComma + 1,
					tableName.length()).trim());
			if (aTable[colTable].contains(" ")) {

				int indexOfSpace1 = aTable[colTable].indexOf(" ");
				aTable[colTable] = (aTable[colTable]
						.substring(0, indexOfSpace1).trim());
				if (aTable[colTable].contains(".")) {

					int indexOfDot = aTable[colTable].indexOf(".");
					aTable[colTable] = (aTable[colTable].substring(
							indexOfDot + 1, aTable[colTable].length()).trim());
					String schemaName = (aTable[colTable].substring(0,
							indexOfDot).trim());
					if (userDetails != schemaName) {
						schemaFlag = true;
					}

				}
			}
			colTable = colTable + 1;
		}// end while

		if (tableName.contains(" ")) {

			int indexOfSpace1 = tableName.indexOf(" ");
			aTable[colTable] = (tableName.substring(0, indexOfSpace1).trim());
			if (aTable[colTable].contains(".")) {

				int indexOfDot = aTable[colTable].indexOf(".");
				aTable[colTable] = (aTable[colTable].substring(indexOfDot + 1,
						aTable[colTable].length()).trim());

			}
		}

		else if (tableName.contains(".")) {
			int indexOfDot = tableName.indexOf(".");
			aTable[colTable] = (tableName.substring(indexOfDot + 1,
					tableName.length()).trim());
			String schemaName = (tableName.substring(0, indexOfDot).trim());
			if (userDetails != schemaName) {
				schemaFlag = true;
			}

		}

		else {
			aTable[colTable] = (tableName).trim();
		}

		int t = 0;
		while (t <= colTable) {

			t++;
		}
		return aTable;
	} // end of tableName function

	public String[] columnName(String queryDB) {
		int indexOfSelect = queryDB.indexOf("select") + 6;
		int indexOfFrom1 = queryDB.indexOf("from") - 1;
		String[] aColumn = new String[15];

		for (int r = 0; r < 15; r++) {
			aColumn[r] = "a";
		}
		int col = 0;
		String ColumnNameDB = (queryDB.substring(indexOfSelect, indexOfFrom1)
				.trim());

		while (ColumnNameDB.contains(",")) {

			int indexOfComma = ColumnNameDB.indexOf(",");
			aColumn[col] = (ColumnNameDB.substring(0, indexOfComma).trim());

			ColumnNameDB = (ColumnNameDB.substring(indexOfComma + 1,
					ColumnNameDB.length()).trim());

			if (aColumn[col].contains(".")) {
				int indexOfDot = aColumn[col].indexOf(".");
				aColumn[col] = (aColumn[col].substring(indexOfDot + 1,
						aColumn[col].length()).trim());
			}

			if (aColumn[col].contains(" ")) {
				int indexOfSpace = aColumn[col].indexOf(" ");
				aColumn[col] = (aColumn[col].substring(indexOfSpace + 1,
						aColumn[col].length()).trim());
			}

			if (aColumn[col].contains("\"")) {
				int indexOfdoubleQuote = aColumn[col].indexOf("\"");
				aColumn[col] = (aColumn[col].substring(indexOfdoubleQuote + 1,
						aColumn[col].length() - 1).trim());
			}
			col = col + 1;
		}// end while

		if (ColumnNameDB.contains(".")) {
			int indexOfDot = ColumnNameDB.indexOf(".");
			aColumn[col] = (ColumnNameDB.substring(indexOfDot + 1,
					ColumnNameDB.length()).trim());
		}

		if (ColumnNameDB.contains(" ")) {
			int indexOfSpace = ColumnNameDB.indexOf(" ");
			aColumn[col] = (ColumnNameDB.substring(indexOfSpace + 1,
					ColumnNameDB.length()).trim());
		}

		if (ColumnNameDB.contains("\"")) {
			int indexOfdoubleQuote = ColumnNameDB.indexOf("\"");
			aColumn[col] = (ColumnNameDB.substring(indexOfdoubleQuote + 1,
					ColumnNameDB.length() - 1).trim());
		}

		else {
			aColumn[col] = ColumnNameDB;
		}

		int h = 0;

		while (h <= col) {
			h++;
		}
		return aColumn;
	}

	public void queryTables(int colValue, String selectQueryDB,
			String updateQueryDB, String filePath, String user,
			String password, String database, String oracleserver,
			String outputFilePath, String outputMissFilePath) throws Exception {

		try {

			// input excel sheet
			InputStream input = new FileInputStream(filePath);
			HSSFWorkbook excelinput = new HSSFWorkbook(input);
			HSSFSheet sheetinput = excelinput.getSheetAt(0);

			String schemaDetails = database;
			String userDetails = user;
			String passwordDetails = password;

			Connection connectionQuery = null;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connectionQuery = DriverManager.getConnection("jdbc:oracle:thin:@"
					+ oracleserver + ":1521:" + schemaDetails, userDetails,
					passwordDetails);

			Statement statementQuery = connectionQuery.createStatement();
			ResultSet resultsetQuery = null;
			int rowsAffected=0;
			Iterator rowItr = sheetinput.rowIterator();

			// excel sheet for not matched records
			HSSFWorkbook wbOutput = new HSSFWorkbook();
			HSSFSheet sheetOutput = wbOutput.createSheet("new sheet");
			HSSFRow rowOutput[] = new HSSFRow[50000];
			int itr = 0;
			rowOutput[0] = sheetOutput.createRow((short) 0);
			rowOutput[0].createCell((short) 0).setCellValue("Data not found");
			int itemCount = 0; // count for no of rows present in input excel
			// sheet
			while (rowItr.hasNext()) {
				itr++;
				HSSFRow rowinput = (HSSFRow) rowItr.next();
				HSSFCell cellinput = rowinput.getCell((short) 0); // taking
				// input
				// from
				// input
				// excel
				// sheet
				String selectQueryPassed = selectQueryDB.toLowerCase();

				String updateQueryNameFinal="";
				if (updateQueryDB.trim().length() > 2) {
					String updateQueryPassed = updateQueryDB.toLowerCase();
					int indexOfVariableUpdate = updateQueryPassed
							.indexOf("variable");
					String updateQueryName1 = (updateQueryDB.substring(0,
							indexOfVariableUpdate).trim());
					String updateQueryName2 = (updateQueryDB
							.substring(indexOfVariableUpdate + 8).trim());
					updateQueryNameFinal = updateQueryName1 + "'variable'"
							+ updateQueryName2;
				}

				int indexOfVariable = selectQueryPassed.indexOf("variable");

				String selectQueryName1 = (selectQueryPassed.substring(0,
						indexOfVariable).trim());
				String selectQueryName2 = (selectQueryPassed
						.substring(indexOfVariable + 8).trim());

				String selectQueryNameFinal = selectQueryName1 + "'variable'"
						+ selectQueryName2;

				String executeSelectQuery="";
				String executeUpdateQuery="";

				if (cellinput.getStringCellValue().length() > 2) {
					String dataItem = cellinput.getStringCellValue();

					executeSelectQuery = selectQueryNameFinal.replaceFirst(
							"variable", dataItem);
					if (updateQueryNameFinal.trim().length() > 2) 
					{
						executeUpdateQuery = updateQueryNameFinal.replaceFirst("variable", dataItem);
					}
				
					System.out.println();
					System.out.println("Select Query in DB : "
							+ executeSelectQuery);
					System.out.println("Update Query in DB : "
							+ executeUpdateQuery);
					resultsetQuery = statementQuery
							.executeQuery(executeSelectQuery);
					System.out.println("Item in excel : " + dataItem.trim());

					if (resultsetQuery.next()) {
						String Dt;
						itemCount++;

						row[i] = sheet.createRow((short) i);
						System.out.println("Rows checked from excel :"
								+ itemCount);
						System.out.println("Rows found in excel :" + i);
						System.out.println("Rows not found in excel : " + n);
						int d = 1; // count for no of columns created in output
						// excel sheet
						for (int c = 0; c < colValue; c++) {

							if (resultsetQuery.getString(d) == null)
								row[i].createCell((short) c).setCellValue(
										"null");
							else {
								Dt = resultsetQuery.getString(d);
								row[i].createCell((short) c).setCellValue(Dt);
							}

							d = d + 1;
						}
						
						if(executeUpdateQuery.trim().length()>2)
						{
							rowsAffected=statementQuery.executeUpdate(executeUpdateQuery);
							rowsUpdated=rowsAffected+rowsUpdated;
							
						}
						
						resultsetQuery.close();
						i = i + 1; // count for no of rows matched from input
						// excel

					}// end if resultset
					else {
						itemCount++;
						n = n + 1; // count for no of rows not matched from
						// input excel
						System.out.println("Rows checked from excel :"
								+ itemCount);
						System.out.println("Rows found in excel :" + i);
						System.out.println("Rows updated in DB :" + rowsUpdated);
						System.out.println("Rows not found in excel : " + n);
						rowOutput[n] = sheetOutput.createRow((short) n);
						rowOutput[n].createCell((short) 0).setCellValue(
								dataItem.trim());

					}

				}// end if length

				
				k = i - 1; // count for no of rows found in excel since value of
				// i was declared as 1

			}// end while iterator
				// System.out.println(itr + " Rows itr");
			statementQuery.close();
			connectionQuery.close();

			if (i == 1) {

				System.out.println();
				System.out.println(k + " Rows found");
				System.out.println(rowsUpdated + " Rows updated in DB :");
				System.out.println(n + " Rows not found");
				FileOutputStream fileOut1 = new FileOutputStream(
						outputMissFilePath);
				wbOutput.write(fileOut1);
				fileOut1.close();

				JOptionPane.showMessageDialog(null,
						"Total number of rows checked " + itemCount
								+ "\nRows found in excel : " + k
								+ "\nRows updated in DB : " + rowsUpdated
								+ "\nRows not found in excel : " + n,
						"Message", 1);

			} // end if ==1
			else {

				FileOutputStream fileOut = new FileOutputStream(outputFilePath);
				FileOutputStream fileOut1 = new FileOutputStream(
						outputMissFilePath);

				wb.write(fileOut);
				wbOutput.write(fileOut1);

				fileOut.close();
				fileOut1.close();

				JOptionPane.showMessageDialog(null,
						"Total number of rows checked " + itemCount
								+ "\nRows found in excel :" + k
								+ "\nRows updated in DB : " + rowsUpdated
								+ "\nRows not found in excel : " + n,
						"Message", 1);

			} // end else

		} catch (Exception e) {
			JOptionPane
			.showMessageDialog(
					null,
					"Exception occured : "
							+ e
							,
					"Error Message", 1);

		}

	}

}
