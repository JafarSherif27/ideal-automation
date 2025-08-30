package app.ideal.automation.dataprovider;

import app.ideal.automation.config.ConfigReader;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelDataProvider {

    @DataProvider(name = "excel-data")
    public Object[][] getData(Method m) throws IOException {
        List<List<String>> outputList = new ArrayList<>();

        // Fetch Excel path from config.properties
        String filePath = ConfigReader.get("testDataPath");
        if (filePath == null || filePath.isEmpty()) {
            throw new RuntimeException("Error: TestDataPath is not set in config.properties");
        }

        File file = new File(filePath);
        if (!file.exists()) {
            throw new RuntimeException("Error: Test Data file not found at: " + file.getAbsolutePath());
        }

        try (FileInputStream fis = new FileInputStream(file);
                Workbook workbook = new XSSFWorkbook(fis)) {

            String sheetName = m.getName(); 
            Sheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                throw new RuntimeException("Error: Sheet '" + sheetName + "' not found in " + filePath);
            }

            Iterator<Row> rowIterator = sheet.iterator();
            int rowIndex = 0;

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                if (rowIndex == 0) { // Skip header column
                    rowIndex++;
                    continue;
                }

                List<String> innerList = new ArrayList<>();
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING -> innerList.add(cell.getStringCellValue());
                        case NUMERIC -> innerList.add(String.valueOf(cell.getNumericCellValue()));
                        case BOOLEAN -> innerList.add(String.valueOf(cell.getBooleanCellValue()));
                        default -> innerList.add(""); // Blank or formula
                    }
                }

                if (!innerList.isEmpty()) {
                    outputList.add(innerList);
                }

                rowIndex++;
            }
        }

        // Convert List<List<String>> to Object[][]
        Object[][] dataSet = new Object[outputList.size()][];
        for (int i = 0; i < outputList.size(); i++) {
            dataSet[i] = outputList.get(i).toArray(new String[0]);
        }
        return dataSet;
    }
}
