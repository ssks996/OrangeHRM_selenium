package orangeHRM;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.examples.xssf.usermodel.CreateCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class Excel {

	Workbook wb;
	public Excel() throws  IOException {
		File fl = new File("D:\\sss\\My Testing Projects\\orangeHRM\\Testing Inputs\\inputsheet1.xlsx");
		FileInputStream fs = new FileInputStream(fl);
		wb = WorkbookFactory.create(fs);
		
	}

	public int  rowCount(String sheet) {
		return wb.getSheet(sheet).getLastRowNum();
	}

	public int  colCount(String sheet,int row) {
		return wb.getSheet(sheet).getRow(row).getLastCellNum();

	}

	public String  getData(String sheet, int row, int col) {
		String data ="";
		if(wb.getSheet(sheet).getRow(row).getCell(col).getCellType()==CellType.NUMERIC) {
			int cellData=(int)wb.getSheet(sheet).getRow(row).getCell(col).getNumericCellValue();
			data =String.valueOf(cellData);
		}
		else {
			data = wb.getSheet(sheet).getRow(row).getCell(col).getStringCellValue();
		}
		return data;

	}

	public void setData(String sheet,int row, int col, String status) throws IOException {
		Sheet sh=wb.getSheet(sheet);
		Row rowNum =	sh.getRow(row);
		Cell cell =rowNum.createCell(col);
		cell.setCellValue(status);

		FileOutputStream fos = new FileOutputStream("D:\\sss\\My Testing Projects\\orangeHRM\\Testing Inputs\\outputsheet.xlsx");
		wb.write(fos);
		fos.close();
		
	}



}
