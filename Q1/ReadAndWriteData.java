package snippet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

class ExcelData {
    private String[] rowData;

    public ExcelData(String[] rowData) {
        this.rowData = rowData;
    }

    public String[] getRowData() {
        return rowData;
    }
}

public class ReadAndWriteData {

	public static void main(String[] args) throws IOException {
		//System.out.println("The class is created");
				String excelFilePath=".\\DataFiles\\Data.xlsx";
				
				//connect the file path to this and open the file in stream mode
				FileInputStream inputstream=new FileInputStream(excelFilePath);
				
				//get the workbook through the stream
				XSSFWorkbook workbook=new XSSFWorkbook(inputstream);
				
				//get the sheet
				//XSSFSheet sheet=workbook.getSheet("Sheet1");
				XSSFSheet sheet=workbook.getSheetAt(0);
				
				//read the data from sheet
				int rows=sheet.getLastRowNum();
				int cols=sheet.getRow(1).getLastCellNum();
				
				List<List<String>> data = new ArrayList<>();
				for(int r=0;r<=rows;r++)
				{
					XSSFRow row=sheet.getRow(r);
					List<String> rowData  = new ArrayList<>();
					for(int c=0;c<cols;c++)
					{
						XSSFCell cell=row.getCell(c);
						//read the data
						switch (cell.getCellType()) {
	                    case STRING:
	                        rowData.add(cell.getStringCellValue());
	                        break;
	                    case BOOLEAN:
	                        rowData.add(String.valueOf(cell.getBooleanCellValue()));
	                        break;
	                    case NUMERIC:
	                        rowData.add(String.valueOf(cell.getNumericCellValue()));
	                        break;
	                }
						//System.out.print("|");
					}
					data.add(rowData);
				}
					// Display the data stored in the list
			        for (List<String> rowData : data) {
			        	System.out.println();
			            for (String cellData : rowData) {
			                System.out.print(cellData + "|");
			            }
			        }
				
	}

}
