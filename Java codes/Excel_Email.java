package BOMData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFRow;
import SupportMonitoring.SupportDB;
import javax.mail.Session;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.activation.DataHandler;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import java.io.*;
import java.util.*;


public class BOMDataDB {
	public String GenerateBOMData() {

		Connection connection;
		String FileName = "";
		String name = "SBM_Active products_No planning";
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:oci8:@FLN1P",
					"sbm", "sbm4prod");
			Statement statement1 = connection.createStatement();

			SupportDB obj = new SupportDB();

			String formattedDate = obj.ChangeDateFormat();

			String Query = "SELECT DISTINCT ip.item_nbr, ip.item_cd_code, bd.bom_descp,"
					+ " ba.bom_stat_ind BOM_STAT_IND,"
					+ " co.item_nbr packaging, ii.item_comm_desc, ba.mfg_class_code,"
					+ " bo.bom_end_dt, pp.last_updte_dt, ba.bom_attr_eff_dt,"
					+ " pp.plan_eff_dt, pp.plan_end_dt "
					+ " FROM item_prod ip,"
					+ " compn co,"
					+ " bom bo,"
					+ " bom_attr ba,"
					+ " bom_descp bd,"
					+ " imf.item ii,"
					+ " plan_prod pp"
					+ " WHERE ip.bom_id = co.bom_id"
					+ " AND ip.bom_id = bo.bom_id"
					+ " AND bo.bom_id = ba.bom_id"
					+ " AND ba.bom_id = bd.bom_id"
					+ " AND ip.item_nbr = pp.item_nbr(+)"
					+ " AND ip.item_cd_code = pp.item_cd_code(+)"
					+ " AND bo.bom_end_dt > SYSDATE"
					+ " AND ba.bom_attr_eff_dt = (SELECT MAX (bat.bom_attr_eff_dt)"
					+ " FROM bom_attr bat"
					+ " WHERE bo.bom_id = bat.bom_id)"
					+ " AND co.compn_type_code = '011'"
					+ " AND co.item_nbr = ii.item_id"
					+ " AND ip.item_nbr IN ("
					+ " SELECT DISTINCT ip.item_nbr"
					+ " FROM bom bo, bom_attr ba, item_prod ip"
					+ " WHERE ip.bom_id = bo.bom_id"
					+ " AND bo.bom_id = ba.bom_id"
					+ " AND bo.bom_end_dt > SYSDATE"
					+ " MINUS"
					+ " SELECT DISTINCT pp.item_nbr"
					+ " FROM bom bo,"
					+ " bom_attr ba,"
					+ " item_prod ip,"
					+ " plan_prod pp"
					+ " WHERE bo.bom_id = ba.bom_id"
					+ " AND ip.bom_id = bo.bom_id"
					+ " AND ip.item_cd_code = pp.item_cd_code"
					+ " AND ip.item_nbr = pp.item_nbr"
					+ " AND plan_end_dt > SYSDATE)";

			ResultSet resultset = statement1.executeQuery(Query);

			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("new sheet");
			HSSFRow row[] = new HSSFRow[900];
			row[0] = sheet.createRow((short) 0);

			row[0].createCell((short) 0).setCellValue("ITEM_NBR");
			row[0].createCell((short) 1).setCellValue("ITEM_CD_CODE");
			row[0].createCell((short) 2).setCellValue("BOM_DESCP");
			row[0].createCell((short) 3).setCellValue("BOM_STAT_IND");
			row[0].createCell((short) 4).setCellValue("PACKAGING");
			row[0].createCell((short) 5).setCellValue("ITEM_COMM_DESC");
			row[0].createCell((short) 6).setCellValue("MFG_CLASS_CODE");
			row[0].createCell((short) 7).setCellValue("BOM_END_DT");
			row[0].createCell((short) 8).setCellValue("LAST_UPDATE_DT");
			row[0].createCell((short) 9).setCellValue("BOM_ATTR_EFF_DT");
			row[0].createCell((short) 10).setCellValue("PLAN_EFF_DT");
			row[0].createCell((short) 11).setCellValue("PLAN_END_DT");
			int i = 1;
			while (resultset.next()) {

				System.out.println("i = " + i);
				String Dt;

				row[i] = sheet.createRow((short) i);

				row[i].createCell((short) 0).setCellValue(resultset.getInt(1));
				row[i].createCell((short) 1).setCellValue(resultset.getInt(2));
				row[i].createCell((short) 2).setCellValue(
						resultset.getString(3));
				row[i].createCell((short) 3).setCellValue(
						resultset.getString(4));
				row[i].createCell((short) 4).setCellValue(resultset.getInt(5));
				row[i].createCell((short) 5).setCellValue(
						resultset.getString(6));
				row[i].createCell((short) 6).setCellValue(resultset.getInt(7));

				if (resultset.getString(8) == null)
					row[i].createCell((short) 7).setCellValue("null");
				else {
					Dt = resultset.getString(8).substring(0, 10);
					row[i].createCell((short) 7).setCellValue(Dt);
				}

				if (resultset.getString(9) == null)
					row[i].createCell((short) 7).setCellValue("null");
				else {
					Dt = resultset.getString(9).substring(0, 10);
					row[i].createCell((short) 8).setCellValue(Dt);
				}

				if (resultset.getString(10) == null)
					row[i].createCell((short) 9).setCellValue("null");
				else {
					Dt = resultset.getString(10).substring(0, 10);
					row[i].createCell((short) 9).setCellValue(Dt);
				}

				if (resultset.getString(11) == null)
					row[i].createCell((short) 10).setCellValue("null");
				else {
					Dt = resultset.getString(11).substring(0, 10);
					row[i].createCell((short) 10).setCellValue(Dt);
				}

				if (resultset.getString(12) == null)
					row[i].createCell((short) 11).setCellValue("null");
				else {
					Dt = resultset.getString(12).substring(0, 10);
					row[i].createCell((short) 11).setCellValue(Dt);
				}

				i = i + 1;
			}
			FileName = name + "(" + formattedDate + ")";
			FileOutputStream fileOut = new FileOutputStream(
					"d:\\SBM Reports\\Excel files\\" + FileName + ".xls");
			wb.write(fileOut);
			fileOut.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(" Hello there is an exception :Exception" + e);
		}
		return FileName;
	}

	public void sendMailBOM(String FileName) {
		String to = "anish.srinivas@pepsico.com";
		String from = "vidya.s.sharma@pepsico.com";
		String cc = "vidya.s.sharma@pepsico.com";
		String cc1 = "gaurav.garg@pepsico.com";
		String host = "planrr";
		String filename = "d:\\SBM Reports\\Excel files\\" + FileName + ".xls";
		boolean debug = false;
		String msgText1 = "Anish,\n\n	PFA the SBM data generated to retrieve active products with no planning tied.\nThanks,\n Vidya";

		String subject = "SBM data - Active products with no planning";

		Properties props = System.getProperties();

		// Get session
		Session s = Session.getDefaultInstance(props, null);

		props.put("mail.smtp.host", host);

		s.setDebug(debug);

		try {
			// create a message
			Message message = new MimeMessage(s);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));
			message.addRecipient(Message.RecipientType.CC, new InternetAddress(
					cc));
			message.addRecipient(Message.RecipientType.CC, new InternetAddress(
					cc1));
			message.setSubject("SBM data - Active products with no planning");

			// Create the message part
			BodyPart messageBodyPart = new MimeBodyPart();

			// Fill the message
			messageBodyPart
					.setText("Anish,\n\n	PFA the SBM data generated to retrieve active products with no planning tied.\n\nThanks,\n Vidya");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			// Part two is attachment
			messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(FileName + ".xls");
			multipart.addBodyPart(messageBodyPart);

			// Put parts in message
			message.setContent(multipart);

			// Send the message
			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(" Hello there is an exception :Exception" + e);
		}
	}

}
