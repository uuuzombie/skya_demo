package com.sky.demo.io.excel.poi;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.Region;
import org.junit.Test;

import javax.imageio.ImageIO;

/**
 * Created by rg on 2015/7/20.
 */
public class ExcelUtilTest {

    @Test
    public void test_writeFile() {

        String path = "D:\\test.xlsx";
        //String path = "D:\\test.xls";
        //String path = "D:/";
        //String path = "D:\\";

        long startTime = System.currentTimeMillis();
        try {
            ExcelUtil.writeFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("cost :" + (System.currentTimeMillis() - startTime));
    }

    
    @Test
    public void test_poi() {

        final int rowNum = 27;
        final int colNum = 15;
        HSSFWorkbook wb = null;
        Sheet sheet = null;

        String today = "2013/8/31";
        String sign = "Month to date";

        String[] titles = { "", "", "", "Chinapay eMail\r\n 商城总计", "Japan Page\r\n 日本馆首页", "Taiwan Page\r\n 台湾馆首页",
                "USA Page\r\n 美国馆首页", "Anhui Page\r\n 安徽馆首页", "China Page\r\n 中国馆首页" };

        String[] colNames = { "", "Page View (PV)\r\n 浏览量", "Unique Visitor (UV)\r\n 独立访客",
                "Completed Orders\r\n 确认订单", "Transaction Amount\r\n 交易金额",

                "1st Top Seller\r\n 最佳销量", "Unit Price 单价", "Qty Sold 销量", "2nd Top Seller\r\n 第二销量", "Unit Price 单价",
                "Qty Sold 销量", "3rd Top Seller\r\n 第三销量", "Unit Price 单价", "Qty Sold 销量",

                "1st Top Seller\r\n 最佳销量", "Unit Price 单价", "Qty Sold 销量", "2nd Top Seller\r\n 第二销量", "Unit Price 单价",
                "Qty Sold 销量", "3rd Top Seller\r\n 第三销量", "Unit Price 单价", "Qty Sold 销量" };


        int n = 0;
        int len = 1;
        String fileName = "D:/日报.xls";
        File f = new File(fileName);

        ByteArrayOutputStream byteArrayOut = null;
        BufferedImage bufferImg = null;

        String[] jpgUrls = { "http://img.chinapay.com/data/files/store_37452/goods_93/small_201303271804531386.jpg",
                "http://img.chinapay.com/data/files/store_44066/goods_37/201308280953576580.jpg",
                "http://img.chinapay.com/data/files/store_289253/goods_95/small_201309031434558044.jpg",
                "http://img.chinapay.com/data/files/store_289253/goods_180/small_201309031403003861.jpg",
                "http://img.chinapay.com/data/files/store_37452/goods_98/small_201309121508186810.jpg",
                "http://img.chinapay.com/data/files/store_37452/goods_24/small_201301241133447193.jpg" };
        String[] https = { "http://emall.chinapay.com/goods/37452/1010000109792.html",
                "http://emall.chinapay.com/goods/44066/1010000119323.html",
                "http://emall.chinapay.com/goods/289253/1010000119621.html?jpsv=laoxcashback6",
                "http://emall.chinapay.com/goods/289253/1010000119627.html?jpsv=laoxcashback6",
                "http://emall.chinapay.com/goods/37452/1010000120588.html",
                "http://emall.chinapay.com/goods/37452/1010000107096.html" };

        URL url = null;

        HSSFHyperlink link = null;
        HSSFPatriarch patri = null;
        HSSFClientAnchor anchor = null;

        try {

            if (!f.exists()) {
                wb = new HSSFWorkbook();
            } else {
                FileInputStream in = new FileInputStream(fileName);
                wb = new HSSFWorkbook(in);
            }

            CellStyle style = wb.createCellStyle();
            style.setFillForegroundColor(HSSFCellStyle.THIN_BACKWARD_DIAG);
            style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直居中
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            // style.setLeftBorderColor(HSSFColor.RED.index);

            style.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 下边框
            style.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
            style.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框
            style.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框

            style.setWrapText(true);

            sheet = wb.createSheet("sheet " + ((int) (100000 * Math.random())));

            // 设置列的宽度
            sheet.setDefaultColumnWidth(20);
            sheet.setDefaultRowHeight((short) 400);

            Row row = null;
            Cell cell = null;

            for (int r = 0; r < rowNum; r++) {
                row = sheet.createRow(r);

                // 设置第1行当高度
                if (r == 0) {
                    row.setHeightInPoints(30);
                }

                // 设置第2列以后的宽度(即列号>=2的列，列号从0开始)
                if (r >= 2) {
                    sheet.setColumnWidth(r, 3020);
                }

                for (int c = 0; c < colNum; c++) {
                    cell = row.createCell(c);
                    cell.setCellStyle(style);

                    // 处理第一行
                    if (r == 0) {
                        sheet.addMergedRegion(new CellRangeAddress(r, r, 3, 4));
                        sheet.addMergedRegion(new CellRangeAddress(r, r, 5, 6));
                        sheet.addMergedRegion(new CellRangeAddress(r, r, 7, 8));
                        sheet.addMergedRegion(new CellRangeAddress(r, r, 9, 10));
                        sheet.addMergedRegion(new CellRangeAddress(r, r, 11, 12));
                        sheet.addMergedRegion(new CellRangeAddress(r, r, 13, 14));

                        if (c < 3) {
                            cell.setCellValue(titles[n++]);
                        } else {
                            if ((c & 1) == 1) {
                                System.out.println("c===" + c);
                                cell.setCellValue(titles[n++]);
                            }
                        }
                    }

                    // 处理第2~8行
                    if (r > 0 && r <= 8) {
                        if (c == 0) {
                            if (r < 8 && (r & 1) == 1) {

                                sheet.addMergedRegion(new CellRangeAddress(r, r + 1, 0, 0));

                                System.err.println("row----->" + r + "   len----->" + (len));
                                cell.setCellValue(colNames[len++]);
                            } else if (r > 8) {

                                System.out.println("len+++++++++>" + (len));
                                cell.setCellValue(colNames[len++]);
                            }
                        } else if (c == 1) {
                            cell.setCellValue((r & 1) == 1 ? today : sign);
                            System.err.println("r---->" + r);
                        } else if (c == 2) {
                            cell.setCellValue((r & 1) == 1 ? "当天" : "当月");
                        } else {
                            if ((c & 1) == 1) {
                                sheet.addMergedRegion(new CellRangeAddress(r, r, c, c + 1));
                                cell.setCellValue("26.55");
                            }
                        }
                    }

                    // 处理第8行以后的数据(不包括第8行)
                    if (r > 8) {
                        // 设置列高(图片的高度)
                        if (r % 3 == 0) {
                            sheet.getRow(r).setHeightInPoints(110);
                        }

                        if (c == 0) {
                            System.err.println("r---->" + r);
                            cell.setCellValue(colNames[r - 4]);
                        } else if (c == 1) {
                            cell.setCellValue((r % 3) == 0 ? today : (r % 3 == 1 ? "PV 浏览量" : "Total Sales 总额"));

                        } else if (c == 2) {
                            if (r % 9 == 0) {
                                sheet.addMergedRegion(new CellRangeAddress(r, r + 8, c, c));

                                if (r / 9 == 1)
                                    cell.setCellValue("当天");
                                else
                                    cell.setCellValue("当月");

                                cell.setCellStyle(style);
                            }

                        } else {
                            if (r % 3 == 0) {
                                if ((c & 1) == 1) {
                                    sheet.addMergedRegion(new CellRangeAddress(r, r, c, c + 1));

                                    // 添加远程图片信息
                                    url = new URL(jpgUrls[(c - 3) / 2]);
                                    bufferImg = ImageIO.read(url.openStream());

                                    byteArrayOut = new ByteArrayOutputStream();
                                    ImageIO.write(bufferImg, "jpg", byteArrayOut);

                                    patri = (HSSFPatriarch) sheet.createDrawingPatriarch();
                                    anchor = new HSSFClientAnchor(10, 2, 0, 0, (short) c, r, (short) (c + 2), r + 1);
                                    patri.createPicture(anchor,
                                            wb.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));

                                    bufferImg.flush();
                                    // link = new HSSFHyperlink(HSSFHyperlink.LINK_URL);

                                    // System.out.println(https[(c-3)/2]);
                                    // link.setAddress("fetion/"+https[(c-3)/2]);
                                    // cell.setHyperlink(link);

                                    // link = (HSSFHyperlink) cell.getHyperlink();
                                    // link = new HSSFHyperlink(HSSFHyperlink.LINK_URL);
                                    // link.setAddress(https[(c-3)/2]);
                                    // cell.setHyperlink(link);
                                }

                            } else {
                                if ((c & 1) == 0) {
                                    link = wb.getCreationHelper().createHyperlink(Hyperlink.LINK_URL);
                                    link.setAddress(https[(c - 3) / 2]);
                                    cell.setHyperlink(link);// 设定单元格的链接
                                    cell.setCellValue("图片超链接");
                                } else {
                                    cell.setCellValue("Number");
                                }

                            }
                        }
                    }
                }

            }

            // 备注
            row = sheet.createRow(27);
            cell = row.createCell(0);
            sheet.addMergedRegion(new CellRangeAddress(27, 27, 0, colNum - 1));
            cell.setCellValue("* 销量排名不以销售金额计算，如相同销量者，则以PV量少者为优胜");

            FileOutputStream out = new FileOutputStream(fileName);
            wb.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("++++++++++++  EXCEl文件  success  +++++++++++++");
    }
        
    


}
