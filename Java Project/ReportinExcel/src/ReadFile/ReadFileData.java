package ReadFile;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

public class ReadFileData {

	public String[][] ReadDatafile(String filename, int ColCount) {
		String[] rowData = new String[100];
		String[][] datareturn = null;
		
		try {
			
			int rowcount = 0;
			FileHandler hand = new FileHandler("C:\\Users\\Gaurav\\Desktop\\prd\\PRDreport.log");
			  Logger log = Logger.getLogger("log_file");
			  log.addHandler(hand);
			  log.warning("Doing carefully!");
			  log.info("Doing something ...");
			  log.severe("Doing strictily ");
			  if(log.isLoggable(Level.OFF)){
				  log.finest("Display a finest message");
				  }
			  System.out.println(log.getName());
			FileInputStream fstream = new FileInputStream(filename);
			System.out.println("FileName : " + filename);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				// Print the content on the console
				rowData[rowcount] = strLine.trim();

				System.out.println("Row Data : " + rowData[rowcount]);
				rowcount++;
			}
			String[][] data = new String[rowcount][ColCount];
			System.out.println("Rowcount :" + rowcount);
			for (int row = 0; row < rowcount; row++) {

				String[] dataarray = rowData[row].split(";");

				for (int col = 0; col < ColCount; col++) {

					data[row][col] = dataarray[col];
					System.out.println("Data : " + "[" + row + "]" + "[" + col
							+ "]" + " = " + dataarray[col]);
				}

			}
			in.close();

			System.out.println();
			datareturn=data;
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
		return datareturn;
	}

}
