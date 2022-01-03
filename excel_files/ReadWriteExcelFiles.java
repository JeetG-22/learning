package excel_files;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteExcelFiles {

	public static void main(String[] args) {
		try {
			//Creating a new file instance
			File file = new File("C:\\Users\\4pupp\\OneDrive\\Documents\\Excel Documents\\testfile.xlsx"); 
			FileInputStream fis = new FileInputStream(file); // obtaining bytes from the file
			// creating Workbook instance that refers to .xlsx file
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0); // creating a Sheet object to retrieve object
			Iterator<Row> itr = sheet.iterator(); // iterating over excel file
			while (itr.hasNext()) {
				Row row = itr.next();
				Iterator<Cell> cellIterator = row.cellIterator(); // iterating over each column
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cell.getCellType().toString()) {
					case "STRING": // field that represents string cell type
						System.out.print(cell.getStringCellValue() + "\t\t");
						break;
					case "NUMERIC": // field that represents number cell type
						System.out.print(cell.getNumericCellValue() + "\t\t");
						break;
					default:
					}
				}
				System.out.println();
			}
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
