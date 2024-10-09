package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	// DataProvider 1

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {

		String path = ".\\testData\\Opencart_LoginData.xlsx"; // Taking xl file from testData

		ExcelUtility xlUtil = new ExcelUtility(path); //creating an object for ExcelUtility

		int totalRows = xlUtil.getRowCount("Sheet1");
		int totalCols = xlUtil.getCellCount("Sheet1", 1);

		String logindata[][] = new String[totalRows][totalCols]; // created for two dimensional array to store data

		for (int i = 1; i <= totalRows; i++) {
			
			for (int j = 0; j < totalCols; j++) {
				
				logindata[i-1][j]= xlUtil.getCellData("Sheet1", i, j);
			}
		}
		return logindata;  // returning two dimensional array
	}

}
