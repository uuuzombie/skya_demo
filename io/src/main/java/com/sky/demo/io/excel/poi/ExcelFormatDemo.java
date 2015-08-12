package com.sky.demo.io.excel.poi;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

/**
 * Created by rg on 2015/7/21.
 */
public class ExcelFormatDemo {


    public void createIndexedColorExcel() throws Exception {
        Workbook wb = new XSSFWorkbook();

        //cell_fill_color
        Sheet sheet = wb.createSheet("cell_fill_color");
        sheet.setDefaultColumnWidth(20);
        int i = 0;
        for (IndexedColors color : IndexedColors.values()) {
            Row row = sheet.createRow(i);
            Cell cell = row.createCell(0);
            CellStyle style = wb.createCellStyle();
            style.setFillForegroundColor(color.getIndex());
            style.setFillPattern(CellStyle.SOLID_FOREGROUND);
            cell.setCellStyle(style);

            cell = row.createCell(1);
            cell.setCellValue(color.name());
            cell = row.createCell(2);
            cell.setCellValue(color.getIndex());
            i++;
        }

        //cell_fill_pattern
        sheet = wb.createSheet("cell_fill_pattern");
        sheet.setDefaultColumnWidth(20);
        for (i = 0; i <= 18; i++) {
            Row row = sheet.createRow(i * 2);
            CellStyle style = wb.createCellStyle();
            style.setFillForegroundColor(IndexedColors.ROSE.getIndex());
            style.setFillPattern((short) i);
            Cell cell = row.createCell(0);
            cell.setCellStyle(style);
            cell = row.createCell(1);
            cell.setCellValue("cell_fill_pattern_" + i);
        }

        //cell_border
        sheet = wb.createSheet("cell_border");
        sheet.setDefaultColumnWidth(20);
        for (i = 0; i <= 13; i++) {
            Row row = sheet.createRow(i * 2);
            CellStyle style = wb.createCellStyle();
            style.setFillForegroundColor(IndexedColors.PINK.getIndex());
            style.setBorderBottom((short) i);
            style.setBorderLeft((short) i);
            style.setBorderRight((short) i);
            style.setBorderTop((short) i);
            Cell cell = row.createCell(0);
            cell.setCellStyle(style);
            cell = row.createCell(1);
            cell.setCellValue("cell_border_" + i);
        }

        //cell_fill_pattern_border
        sheet = wb.createSheet("cell_fill_pattern_border");
        sheet.setDefaultColumnWidth(20);
        for (i = 0; i <= 18; i++) {
            Row row = sheet.createRow(i * 2);
            CellStyle style = wb.createCellStyle();
            style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
            style.setFillPattern((short) i);
            style.setBorderBottom((short) (i % 14));
            style.setBorderLeft((short) (i % 14));
            style.setBorderRight((short) (i % 14));
            style.setBorderTop((short) (i % 14));
            style.setBottomBorderColor(IndexedColors.LIME.getIndex());
            style.setLeftBorderColor(IndexedColors.LIME.getIndex());
            style.setTopBorderColor(IndexedColors.LIME.getIndex());
            style.setRightBorderColor(IndexedColors.LIME.getIndex());
            Cell cell = row.createCell(0);
            cell.setCellStyle(style);
            cell = row.createCell(1);
            cell.setCellValue("cell_fill_pattern_border_" + i);
        }

        saveWorkBook(wb);
    }



    public void createCellText() throws Exception {
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet();

        Row row = sheet.createRow(0);
        setCellValue(wb, row, 0, "微软雅黑", 22, "测试文本字体\n换行");

        setCellValueWithRotate(wb, row, 1, "微软雅黑", 16, "测试文字旋转\n换行", 45);

        row = sheet.createRow(1);
        setCellColorAndStyle(wb, row, 0, "宋体", 16, "测试加粗", IndexedColors.BLACK.getIndex(), true, false, false, false,
                0, CellStyle.ALIGN_LEFT, CellStyle.VERTICAL_TOP);
        setCellColorAndStyle(wb, row, 1, "宋体", 16, "测试倾斜", IndexedColors.BLACK.getIndex(), false, true, false, false,
                0, CellStyle.ALIGN_RIGHT, CellStyle.VERTICAL_BOTTOM);
        setCellColorAndStyle(wb, row, 2, "宋体", 16, "测试删除线", IndexedColors.BLACK.getIndex(), false, false, true, false,
                0, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER);
        setCellColorAndStyle(wb, row, 3, "宋体", 16, "测试下划线", IndexedColors.BLUE.getIndex(), false, false, false, true,
                Font.U_SINGLE, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_JUSTIFY);

        row = sheet.createRow(3);
        setCellColorAndStyle(wb, row, 0, "宋体", 16, "测试混合样式", IndexedColors.BLUE.getIndex(), true, true, true, true,
                Font.U_SINGLE, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER);
        row = sheet.createRow(4);
        setCellColorAndStyle(wb, row, 0, "宋体", 16, "测试对齐", IndexedColors.BLUE.getIndex(), true, true, true, true,
                Font.U_SINGLE, CellStyle.ALIGN_CENTER, CellStyle.VERTICAL_CENTER);

        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);
        sheet.autoSizeColumn(2);
        sheet.autoSizeColumn(3);
        saveWorkBook(wb);
    }

    public void setCellValue(Workbook wb, Row row, int cellIndex, String fontName, int fontSize, String cellContent) {
        Font font = wb.createFont();
        font.setFontName(fontName);
        font.setFontHeightInPoints((short) fontSize);

        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setWrapText(true);// 换行
        cellStyle.setFont(font);

        Cell cell = row.createCell(cellIndex);
        cell.setCellValue(cellContent);
        cell.setCellStyle(cellStyle);

        // 可以只设置字体信息
        // RichTextString richStr = new XSSFRichTextString(cellContent);
        // richStr.applyFont(font);
        // cell.setCellValue(richStr);
    }

    public void setCellValueWithRotate(Workbook wb, Row row, int cellIndex, String fontName, int fontSize,
                                       String cellContent, int rotate) {
        Font font = wb.createFont();
        font.setFontName(fontName);
        font.setFontHeightInPoints((short) fontSize);

        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setWrapText(true);// 自动换行
        cellStyle.setRotation((short) (Math.abs(rotate)));
        cellStyle.setFont(font);

        Cell cell = row.createCell(cellIndex);
        cell.setCellValue(cellContent);
        cell.setCellStyle(cellStyle);
    }

    public void setCellColorAndStyle(Workbook wb, Row row, int cellIndex, String fontName, int fontSize,
                                     String cellContent, int colorIndex, boolean isBold, boolean isItalic, boolean isStrike,
                                     boolean isUnderline, int underLineStyle, int hAlign, int vAlign) {

        Font font = wb.createFont();
        font.setFontName(fontName);
        font.setFontHeightInPoints((short) fontSize);
        if (colorIndex >= 0) {
            font.setColor((short) colorIndex);
        }
        if (isBold) {
            font.setBold(true);
        }
        if (isItalic) {
            font.setItalic(true);
        }
        if (isStrike) {
            font.setStrikeout(true);
        }
        if (isUnderline) {
            font.setUnderline((byte) underLineStyle);
        }
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setWrapText(true);// 换行
        cellStyle.setFont(font);

        cellStyle.setAlignment((short) hAlign);
        cellStyle.setVerticalAlignment((short) vAlign);

        Cell cell = row.createCell(cellIndex);
        cell.setCellValue(cellContent);
        cell.setCellStyle(cellStyle);
    }



    public void saveWorkBook(Workbook wb) throws Exception {
        FileOutputStream fileOut = new FileOutputStream("d:/sys_xlsx_" + System.currentTimeMillis() + ".xlsx");
        wb.write(fileOut);
        fileOut.close();
    }
}
