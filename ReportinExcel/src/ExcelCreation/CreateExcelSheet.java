package ExcelCreation;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

public class CreateExcelSheet {
	public void CreateCaseExcel(String EachFilePeriod[][],String EachFileWeek[][]) {
		try {
			
			int rowcounter=EachFileWeek.length;
			int rowcounter1=EachFilePeriod.length;
			
			System.out.println("EachFileWeek = " + rowcounter1);
			System.out.println("EachFilePeriod = " + rowcounter);
			
			
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet[] sheet = new HSSFSheet[4];
			HSSFRow row[] = new HSSFRow[rowcounter + 5];
			sheet[0] = wb.createSheet("Eaches");
			sheet[1] = wb.createSheet("UPC");
			sheet[2] = wb.createSheet("Cases");
			sheet[3] = wb.createSheet("Both");
			
			row[0] = sheet[0].createRow((short) 0);

			HSSFCellStyle style = wb.createCellStyle();
			HSSFCellStyle style1 = wb.createCellStyle();
			style.setWrapText(true);

			HSSFCell cell1 = row[0].createCell((short) 0);
			HSSFCell cell2 = row[0].createCell((short) 1);
			
			HSSFCell cell3 = row[0].createCell((short) 3);
			HSSFCell cell4 = row[0].createCell((short) 4);
			
			HSSFCell cell5 = row[0].createCell((short) 6);
			HSSFCell cell6 = row[0].createCell((short) 7);

			HSSFFont font = wb.createFont();
			font.setFontHeightInPoints((short) 10);
			font.setFontName("Arial");
			font.setBoldweight((short) 6);

			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			style.setFont(font);
			style.setFillPattern(HSSFCellStyle.SPARSE_DOTS);
			style.setBorderBottom((short) 5);
			style.setBorderLeft((short) 5);
			style.setBorderRight((short) 5);
			style.setBorderTop((short) 5);
			style.setFillBackgroundColor(new HSSFColor.GREY_25_PERCENT()
					.getIndex());

			style1.setBorderBottom((short) 2);
			style1.setBorderLeft((short) 2);
			style1.setBorderRight((short) 2);
			style1.setBorderTop((short) 2);

			cell1.setCellStyle(style);
			cell2.setCellStyle(style);
			cell3.setCellStyle(style);
			cell4.setCellStyle(style);
			cell5.setCellStyle(style);
			cell6.setCellStyle(style);
			
			cell1.setCellValue("Year - Period - Week");
			cell2.setCellValue("Number of Approved Eaches");
			cell3.setCellValue("Year - Period");
			cell4.setCellValue("Number of Approved Eaches");
			cell5.setCellValue("Year");
			cell6.setCellValue("Number of Approved Eaches");
			
			int rowcount = rowcounter;
			int datacounter = 1;
			int counter = 0;
			while (counter < rowcount) {

				row[datacounter] = sheet[0].createRow((short) datacounter);
				System.out.println("counter = " + counter);

				row[datacounter].createCell((short) 0).setCellValue(
						EachFileWeek[counter][0]);
				row[datacounter].createCell((short) 1).setCellValue(
						EachFileWeek[counter][1]);
			
				datacounter++;

				counter = counter + 1;
			}

			int rowcount1 = rowcounter1;
			int datacounter1 = 1;
			int counter1 = 0;
			while (counter1 < rowcount1) {

				row[datacounter1] = sheet[0].createRow((short) datacounter1);
				System.out.println("counter1 = " + counter1);

				row[datacounter1].createCell((short) 3).setCellValue(
						EachFilePeriod[counter1][0]);
				row[datacounter1].createCell((short) 4).setCellValue(
						EachFilePeriod[counter1][1]);
				
				datacounter1++;

				counter1 = counter1 + 1;
			}

			FileOutputStream fileOut = new FileOutputStream("b:\\output.xls");
			wb.write(fileOut);
			fileOut.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(" Hello there is an exception :Exception" + e);
		}

	}
}
