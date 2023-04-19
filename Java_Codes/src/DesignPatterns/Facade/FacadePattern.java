package DesignPatterns.Facade;

interface Report {
	abstract void printReport();
}

class PDFReport implements Report {
	@Override
	public void printReport() {
		System.out.println("PDF Report");		
	}
}

class ExcelReport implements Report {
	@Override
	public void printReport() {
		System.out.println("Excel Report");		
	}
}

class ReportFacade {
	public static void printReport(String type) {
		switch (type) {
		case "PDF":
			new PDFReport().printReport();
			break;
		case "EXCEL":
			new ExcelReport().printReport();
			break;
		default:
			break;			
		}
	}
}

public class FacadePattern {
	public static void main(String[] args) {
		ReportFacade.printReport("PDF");
		ReportFacade.printReport("EXCEL");
	}
}