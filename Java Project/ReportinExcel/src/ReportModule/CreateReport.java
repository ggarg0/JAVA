package ReportModule;

import ReadFile.ReadFileData;
import ExcelCreation.CreateExcelSheet;


public class CreateReport {

		public static void main(String args[]) {
			
			String [][] EachFilePeriod = new String[100][2];
			String [][] EachFileWeek = new String[100][2];
			String [][] EachFileYear = new String[100][2];
			String [][] test = new String[100][];
			CreateExcelSheet excelObj=new CreateExcelSheet();
			ReadFileData readobj = new ReadFileData();
			
			EachFilePeriod=readobj.ReadDatafile("C:\\Users\\Gaurav\\Desktop\\prd\\Each - Ouput file-Period.txt",2);
			EachFileWeek=readobj.ReadDatafile("C:\\Users\\Gaurav\\Desktop\\prd\\Each - Ouput file-Week.txt",2);
			EachFileYear=readobj.ReadDatafile("C:\\Users\\Gaurav\\Desktop\\prd\\Each - Ouput file-Year.txt",2);
			
			//test=readobj.ReadDatafile("C:\\Users\\Gaurav\\Desktop\\prd\\gaurav.txt");
			
			
			excelObj.CreateCaseExcel(EachFilePeriod, EachFileWeek);
		}
}