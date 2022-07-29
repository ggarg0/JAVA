

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFRow;
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
import java.text.*;

public class SupportDB {

	public String ChangeDateFormat() {
		Connection connection;
		String formattedDate = "";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:oci8:@FLN1P",
					"imf", "romeo1");
			Statement statement1 = connection.createStatement();

			ResultSet resultset1 = statement1
					.executeQuery("select sysdate from dual");
			String name = "";
			while (resultset1.next()) {
				name = resultset1.getString(1).substring(0, 10);
			}

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date dateStr = formatter.parse(name);
			formattedDate = formatter.format(dateStr);
			System.out.println("YYYY-MM-DD date is : " + formattedDate);

			Date date1 = formatter.parse(formattedDate);
			formatter = new SimpleDateFormat("dd-MMM-yyyy");
			formattedDate = formatter.format(date1);
			System.out.println("DD-MMM-YYYY date is : " + formattedDate);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(" Hello there is an exception :Exception" + e);
		}
		return formattedDate;
	}

	public int generateSupportData() {
		Connection connection;
		
		int i = 1;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet("new sheet");
			HSSFRow row[] = new HSSFRow[50];
			row[0] = sheet.createRow((short) 0);
			connection = DriverManager.getConnection("jdbc:oracle:oci8:@FLN1P",
					"imf", "romeo1");

			Statement statement1 = connection.createStatement();
			ResultSet resultset = statement1
					.executeQuery("select * from dnld_cntl where trans_stat IN('FAILED') and UNIQUE_ID NOT IN('88854')");

			
			row[0].createCell((short) 0).setCellValue("ITEM_SYS_NBR");
			row[0].createCell((short) 1).setCellValue("SUBSYS_CODE");
			row[0].createCell((short) 2).setCellValue("QUEUE_NAME");
			row[0].createCell((short) 3).setCellValue("TRANS_USEID");
			row[0].createCell((short) 4).setCellValue("TRANS_TYPE_CODE");
			row[0].createCell((short) 5).setCellValue("TRANS_DT");
			row[0].createCell((short) 6).setCellValue("TRANS_STAT");
			row[0].createCell((short) 7).setCellValue("FAIL_REASN");
			row[0].createCell((short) 8).setCellValue("CR_DT");
			row[0].createCell((short) 9).setCellValue("CR_USEID");
			row[0].createCell((short) 10).setCellValue("LAST_MOD_DT");
			row[0].createCell((short) 11).setCellValue("LAST_MOD_USEID");
			row[0].createCell((short) 12).setCellValue("UNIQUE_ID");
			row[0].createCell((short) 13).setCellValue("TRANSACTION_CODE");

			while (resultset.next()) {

				row[i] = sheet.createRow((short) i);
				System.out.println("i = " + i);

				row[i].createCell((short) 0).setCellValue(resultset.getInt(1));
				row[i].createCell((short) 1).setCellValue(resultset.getString(2));
				row[i].createCell((short) 2).setCellValue(resultset.getString(3));
				row[i].createCell((short) 3).setCellValue(resultset.getString(4));
				row[i].createCell((short) 4).setCellValue(resultset.getString(5));
				row[i].createCell((short) 5).setCellValue(resultset.getDate(6));
				row[i].createCell((short) 6).setCellValue(resultset.getString(7));
				row[i].createCell((short) 7).setCellValue(resultset.getString(8));
				row[i].createCell((short) 8).setCellValue(resultset.getDate(9));
				row[i].createCell((short) 9).setCellValue(resultset.getString(10));
				row[i].createCell((short) 10).setCellValue(resultset.getDate(11));
				row[i].createCell((short) 11).setCellValue(resultset.getString(12));
				row[i].createCell((short) 12).setCellValue(resultset.getInt(13));
				row[i].createCell((short) 13).setCellValue(resultset.getString(14));

				i = i + 1;
			}
			if (i == 1) {
				System.out.println("No Failed Rows found");
				return 1;
			} else {
				String formattedDate = ChangeDateFormat();
				FileOutputStream fileOut = new FileOutputStream(
						"d:\\Support Monitoring\\" + "SupportMonitoring"
								+ formattedDate + ".xls");
				wb.write(fileOut);
				fileOut.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(" Hello there is an exception :Exception" + e);
		}
		return i;
	}

	public void UpdateSupportData() {
		Connection connection = null;
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:oci8:@FLN1P",
					"imf", "romeo1");

			PreparedStatement preparedStatement = connection
					.prepareStatement("update mq_transactions set qsentrc =null, qsentdatetime =null where dnld_cntl_unique_id in (select unique_id from dnld_cntl where trans_stat IN 'FAILED' and UNIQUE_ID NOT IN('88854'))");

			int Status = preparedStatement.executeUpdate();
			connection.commit();
			if (Status > 0) {
				System.out
						.println("Data was updated successfully in the tables");

			}
			CallableStatement callableStatement = connection
					.prepareCall("{? = call IMF.IMF_SENDMQ_PKG.SendMQ(?,?)}");

			callableStatement.registerOutParameter(1, Types.VARCHAR);
			callableStatement.setInt(2, 157);
			callableStatement.setInt(3, 001);

			callableStatement.execute();
			System.out.println("Output :" + callableStatement.getString(1));

		} catch (Exception exception) {
			System.out.println(exception);

		}

	}

	public void SendMailSupport(int numOfRows) {
		String to = "anish.srinivas@pepsico.com";
		String from = "gaurav.garg@pepsico.com";
		String cc = "vidya.s.sharma@pepsico.com";
		String cc1 = "gaurav.garg@pepsico.com";
		String host = "planrr";
		String formattedDate = ChangeDateFormat();
		String filename = "d:\\Support Monitoring\\" + "SupportMonitoring"
				+ formattedDate + ".xls";
		boolean debug = false;
		String msgText1 = "Anish\n\nThere was " + numOfRows
				+ " Failed downloads in FLN1P tables.\n"
				+ "Transaction is rerun for the items.\n"
				+ "Attaching the details of rows that Failed to download.\n\n"
				+ "Regards,\nGaurav";
		String subject = "Support Monitoring(" + formattedDate + ")";

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
			message.setSubject("Support Monitoring(" + formattedDate + ")");
			message.addRecipient(Message.RecipientType.CC, new InternetAddress(
					cc));
			message.addRecipient(Message.RecipientType.CC, new InternetAddress(
					cc1));
			// Create the message part
			BodyPart messageBodyPart = new MimeBodyPart();

			// Fill the message
			messageBodyPart
					.setText("Anish\n\nThere was "
							+ numOfRows
							+ " Failed downloads in FLN1P tables.\n"
							+ "Transaction is rerun for the items.\n"
							+ "Attaching the details of rows that Failed to download.\n\n"
							+ "Regards,\nGaurav");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			// Part two is attachment
			messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName("Support Monitoring (" + formattedDate
					+ ")" + ".xls");
			multipart.addBodyPart(messageBodyPart);

			// Put parts in message
			message.setContent(multipart);

			// Send the message
			Transport.send(message);
		} catch (Exception e) {
			System.out.println("ERROR SENDING EMAIL:" + e);
		}
	}
}
