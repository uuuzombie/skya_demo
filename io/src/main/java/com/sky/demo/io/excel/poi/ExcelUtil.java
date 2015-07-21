package com.sky.demo.io.excel.poi;

import com.google.common.base.Preconditions;
import com.google.common.io.Closeables;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.*;

/**
 * Created by rg on 2015/7/20.
 */
public class ExcelUtil {

    public static void writeFile(String filePath) throws IOException {
        Preconditions.checkNotNull(filePath);
        if (filePath.endsWith("/") || filePath.endsWith("\\")) {
            filePath += "reuslt.xlsx";
        }
        if (!filePath.endsWith(".xlsx")) {
            filePath += ".xlsx";
        }

        File outputFile = new File(filePath);
        if (outputFile.exists()) {
            outputFile.delete();
        }

        if (!outputFile.createNewFile()) {
            throw new RuntimeException("Can not create file!");
        }

        Workbook wb = null;
        FileOutputStream outputStream = null;
        try {
            wb = new SXSSFWorkbook(100); // keep 100 rows in memory, exceeding rows will be flushed to disk
            Sheet sheet = wb.createSheet();

            CellStyle style = wb.createCellStyle();


            for (int rowNum = 0; rowNum < 100000; rowNum++) {
                Row row = sheet.createRow(rowNum);
                for (int cellNum = 0; cellNum < 10; cellNum++) {
                    Cell cell = row.createCell(cellNum);
                    String address = new CellReference(cell).formatAsString();
                    cell.setCellValue(address);
                }
            }

            outputStream = new FileOutputStream(outputFile);
            wb.write(outputStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (wb != null) {
                    wb.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



}
