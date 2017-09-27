package SBMData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.*;


import SupportMonitoring.SupportDB;

public class SBMDataDB {

	public void generateSBMData() {
		Connection connection;
		String formattedDate = "";

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			connection = DriverManager.getConnection("jdbc:oracle:oci8:@FLN1P",
					"sbm", "sbm4prod");
			Statement statement1 = connection.createStatement();

			SupportDB obj = new SupportDB();
			formattedDate = obj.ChangeDateFormat();

			String filename = "d:\\SBM Reports\\CSV files\\SBMDATA" + "("
					+ formattedDate + ")" + ".csv";

			String Query = "select distinct ii.ITEM_NBR , bd.BOM_DESCP,"
					+ " ii.item_cd_code,  cc.ITEM_NBR," + " CC.COMPN_EFF_DT,"
					+ " BO.BOM_END_DT,"
					+ " I.ITEM_COMM_DESC from item_prod ii , bom bo,"
					+ " bom_attr ba , bom_descp bd , compn cc,"
					+ " imf.item i where ii.BOM_ID = bo.BOM_ID"
					+ " and bo.bom_id = ba.bom_id"
					+ " and ba.bom_id = bd.bom_id"
					+ " and bd.bom_id = cc.bom_id"
					+ " and bo.BOM_END_DT > sysdate"
					+ " and ba.BOM_ATTR_EFF_DT < sysdate"
					+ " and cc.COMPN_TYPE_CODE = '011'"
					+ " and cc.ITEM_NBR = i.ITEM_ID"
					+ " and i.ITEM_START_DT < sysdate"
					+ " and i.ITEM_END_DT > sysdate";

			ResultSet resultset = statement1.executeQuery(Query);
			System.out.println("Query : " + Query);

			FileWriter fw = new FileWriter(filename);
			fw.append("ITEM_NBR");
			fw.append(',');
			fw.append("BOM_DESCP");
			fw.append(',');
			fw.append("ITEM_CD_CODE");
			fw.append(',');
			fw.append("PACKAGING_ITEM");
			fw.append(',');
			fw.append("PACKAGING_ACTIVE_DATE");
			fw.append(',');
			fw.append("PACKAGING_END_DATE");
			fw.append(',');
			fw.append("ITEM_COMM_DESC");
			fw.append('\n');

			while (resultset.next()) {

				fw.append(resultset.getString(1));
				fw.append(',');
				fw.append(resultset.getString(2));
				fw.append(',');
				fw.append(resultset.getString(3));
				fw.append(',');
				fw.append(resultset.getString(4));
				fw.append(',');
				fw.append(resultset.getString(5));
				fw.append(',');
				fw.append(resultset.getString(6));
				fw.append(',');
				fw.append(resultset.getString(7));
				fw.append('\n');

			}
			fw.flush();
			fw.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(" Hello there is an exception :Exception" + e);

		}
	}

}
