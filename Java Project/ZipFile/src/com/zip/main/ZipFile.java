package com.zip.main;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.border.Border;

import org.apache.log4j.Logger;

public class ZipFile implements Runnable{
	List<String> fileList;
	
	static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private static String OUTPUT_ZIP_FILE = "";
	private static String SOURCE_FOLDER = "";
	private static String zipFileName = "";
	final static Logger logger = Logger.getLogger(ZipFile.class);
	
	String time = "";
	Date Startdate = new Date();
	ZipFile() {
	fileList = new ArrayList<String>();
	}
	
	public void ZipIt(String Srce , String Dest) {
		
		  Runnable runnable = new ZipFile();
	        Thread thread = new Thread(runnable,"thread-1");
	        Thread thread1 = new Thread(runnable,"thread-1");
	     
		SOURCE_FOLDER=Srce;
		zipFileName=Srce.substring(Srce.lastIndexOf("\\"), Srce.length())+".zip";
		OUTPUT_ZIP_FILE = Dest+zipFileName;
		logger.info("Zip process started ");
		logger.info("Source Folder : " +SOURCE_FOLDER);
		logger.info("Destination Folder : " +OUTPUT_ZIP_FILE);
		thread.run();
		
	}

	
	
	public synchronized void   zipIt(String zipFile) throws Exception {
		FileOutputStream fos = null;
		ZipOutputStream zos = null;
		FileInputStream in = null;
		byte[] buffer = new byte[1024];
		String FileLog = "Getting file listing ...... ";
		try {
			fos = new FileOutputStream(zipFile);
			zos = new ZipOutputStream(fos);
			logger.info("No of Files to be Zipped : " + this.fileList.size());
			System.out.println("No of Files : " + this.fileList.size());
			FileLog = "No of Files : " + this.fileList.size();
			int counter =0;
		
			for (String file : this.fileList) {
				counter++;
				
				logger.info( counter  + " : " + file + " added ....");
					
				ZipEntry ze = new ZipEntry(file);
				zos.putNextEntry(ze);

				in = new FileInputStream(SOURCE_FOLDER
						+ File.separator + file);
				ZipMain.LogText.setText(SOURCE_FOLDER
						+ File.separator + file);
				int len;
				while ((len = in.read(buffer)) > 0) {
					zos.write(buffer, 0, len);
				}
				
			}
		} catch (IOException ex) {
			throw ex;
		}
		finally
		{
			try {
				zos.closeEntry();
				zos.close();
				in.close();
			} catch (IOException e) {
				throw e;
			}
		}
	}

	public void generateFileList(File node) {
		
	
		if (node.isFile()) {
			fileList.add(generateZipEntry(node.getAbsoluteFile().toString()));
		}

		if (node.isDirectory()) {
			String[] subNote = node.list();
			
			for (String filename : subNote) {
				generateFileList(new File(node, filename));
			}
		}
	}

	private String generateZipEntry(String file) {
		return file.substring(SOURCE_FOLDER.length() + 1, file.length());
	}

	@Override
	public void run() {
		try
		{
			
			ZipFile appZip = new ZipFile();
			appZip.generateFileList(new File(SOURCE_FOLDER));

			appZip.zipIt(OUTPUT_ZIP_FILE);
			Date EndDate = new Date();
			
			// System.out.println("End Date : " + dateFormat.format(EndDate));
			long diff = EndDate.getTime() - Startdate.getTime();

			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;
			long diffHours = diff / (60 * 60 * 1000) % 24;
			time = "Time taken for zipping files - "
					+ diffHours + " Hrs: " + diffMinutes + " Mins: " 
					+ diffSeconds + " Secs" ;
			logger.info("Zip process Ended \n");
			JOptionPane.showMessageDialog(null,
					time, "Message",JOptionPane.INFORMATION_MESSAGE);
				
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null,
					"Exception Occured : \n" + e, "Message",JOptionPane.ERROR_MESSAGE);
		}
	}

}
