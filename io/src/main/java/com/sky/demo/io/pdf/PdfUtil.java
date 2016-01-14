package com.sky.demo.io.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import org.apache.commons.lang.StringUtils;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by rg on 2015/7/21.
 */
public class PdfUtil {

    public static boolean createPDF(String pdfPath) {
        Document document = null;
        try {
            document = new Document();          // 建立一个Document对象
            document.setPageSize(PageSize.A4);  // 设置页面大小

            PdfWriter.getInstance(document, new FileOutputStream(pdfPath));// 建立一个PdfWriter对象
            document.open();

            // 设置中文字体,需引用itext-asian.jar
            BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);

            ///使用windows自带的字体
            //BaseFont bfChinese = BaseFont.createFont("C:/windows/fonts/simsun.ttc,1", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);

            Font titleFont = new Font(bfChinese, 15, Font.BOLD);// 设置字体大小
            Font headFont = new Font(bfChinese, 10, Font.BOLD);// 设置字体大小
            Font headFont1 = new Font(bfChinese, 10, Font.BOLD);// 设置字体大小
            Font headFont2 = new Font(bfChinese, 10, Font.NORMAL);// 设置字体大小

            document.add(new Paragraph("标题", titleFont));

            float[] widths = { 140f, 60f, 320f, 120f, 110f, 110f, 190f };// 设置表格的列宽

            PdfPTable table = new PdfPTable(widths);// 建立一个pdf表格
            table.setSpacingBefore(20f);// 设置表格上面空白宽度
            table.setTotalWidth(535);// 设置表格的宽度
            table.setLockedWidth(true);// 设置表格的宽度固定
            table.getDefaultCell().setBorder(1);// 设置表格默认为边框1

            PdfPCell cell = new PdfPCell(new Paragraph("Taony125 testPdf 中文字体a", headFont));// 建立一个单元格
            // cell.setBorder(0);//设置单元格无边框
            // cell.setColspan(7);// 设置合并单元格的列数
            table.addCell(cell);// 增加单元格

            cell = new PdfPCell(new Paragraph("Taony125 testPdf 中文字体b", headFont));
            // cell.setBorder(0);
            cell.setFixedHeight(20);
            cell.setColspan(7);// 设置合并单元格的列数
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(cell);

//            cell = new PdfPCell(new Paragraph("Taony125 testPdf 中文字体c", headFont1));
//            // cell.setBorder(0);
//            cell.setFixedHeight(20);
//            // cell.setColspan(7);// 设置合并单元格的列数
//            cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
//            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//            table.addCell(cell);
//
//            table.addCell(new Paragraph("Taony125 testPdf 中文字体d", headFont2));
            
            document.add(table);

        } catch (DocumentException de) {
            de.printStackTrace();
            return false;
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return false;
        } finally {
            try {
                if (document != null) {
                    document.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public static boolean createPDF2(String filePath) {
        Document document = null;
        try {
            document = new Document();
            document.setPageSize(PageSize.A4);

            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            // 设置中文字体
            BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            Font titleFont = new Font(bfChinese, 15, Font.BOLD);// 设置字体大小
            Font commonFont = new Font(bfChinese, 10, Font.NORMAL);// 设置字体大小

            document.add(new Paragraph("标题", titleFont));

            float[] widths = { 140f, 60f, 320f, 120f, 110f, 110f, 190f };// 设置表格的列宽
            PdfPTable table = new PdfPTable(widths);// 建立一个pdf表格
            table.setSpacingBefore(20f);// 设置表格上面空白宽度
            table.setTotalWidth(535);// 设置表格的宽度
            table.setLockedWidth(true);// 设置表格的宽度固定
            table.getDefaultCell().setBorder(1);// 设置表格默认为边框1

            PdfPCell cell = new PdfPCell(new Paragraph("Taony125 testPdf 中文字体a", commonFont));// 建立一个单元格
            table.addCell(cell);// 增加单元格

            cell = new PdfPCell(new Paragraph("Taony125 testPdf 中文字体b", commonFont));
            cell.setFixedHeight(20);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);// 设置内容水平居中显示
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table.addCell(cell);

            table.addCell(new Paragraph("3",commonFont));
            table.addCell(new Paragraph("4",commonFont));
            table.addCell(new Paragraph("5",commonFont));
            table.addCell(new Paragraph("6",commonFont));
            table.addCell(new Paragraph("7",commonFont));

            table.addCell(new Paragraph("21",commonFont));
            table.addCell(new Paragraph("22",commonFont));
            table.addCell(new Paragraph("23",commonFont));
            table.addCell(new Paragraph("24",commonFont));
            table.addCell(new Paragraph("25",commonFont));
            table.addCell(new Paragraph("26",commonFont));
            table.addCell(new Paragraph("27",commonFont));

            document.add(table);

        } catch (DocumentException de) {
            de.printStackTrace();
            return false;
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return false;
        } finally {
            try {
                if (document != null) {
                    document.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }


    public static void createCNPdf(String filePath) {
        Document document = null;
        try {
            document = new Document();
            OutputStream os = new FileOutputStream(new File(filePath));
            PdfWriter.getInstance(document,os);
            document.open();
            //方法一：使用Windows系统字体(TrueType)
            //BaseFont baseFont = BaseFont.createFont("C:/Windows/Fonts/SIMYOU.TTF",BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);

            //方法二：使用iTextAsian.jar中的字体
            //BaseFont baseFont = BaseFont.createFont("STSong-Light",BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);
            BaseFont baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);// 设置中文字体

            //方法三：使用资源字体(ClassPath)
            //BaseFont baseFont = BaseFont.createFont("/SIMYOU.TTF",BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED);

            Font font = new Font(baseFont);
            document.add(new Paragraph("解决中文问题了！",font));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (document != null) {
                    document.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }



    public static void creatPDF3(String filePath) {

        // 生成PDF开始
        Document document = null;
        try {
            document = new Document(PageSize.A4, -10f, -10f, 144f, 56f);// 设置页大小A4，也边距（左右，上下）

            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            BaseFont bfChinese = BaseFont.createFont("C:\\Windows\\Fonts\\SIMSUN.TTC,0", BaseFont.IDENTITY_H,
                    BaseFont.NOT_EMBEDDED);// 宋体

            Font fontChinese = new Font(bfChinese, 12, Font.BOLD);
            Font fontChinese2 = new Font(bfChinese, 12, Font.NORMAL);
            Font fontChinese3 = new Font(bfChinese, 10, Font.NORMAL);

            BaseColor skyColor = new BaseColor(224, 234, 239); // 背景颜色天蓝色
            BaseColor whiteColor = new BaseColor(255, 255, 255);
            BaseColor grayLableColor = new BaseColor(100, 255, 255);
            BaseColor grayContentColor = new BaseColor(100, 155, 255);


            PdfPTable mainTable = new PdfPTable(1);// 大表格一列
            mainTable.setSplitLate(false);      // 跨页处理
            mainTable.setSplitRows(true);

            PdfPCell cellMain = new PdfPCell(new Paragraph("偿还指数", fontChinese));// 第一列,创建单元格cell
            cellMain.setHorizontalAlignment(Element.ALIGN_LEFT);// 水平居右
            cellMain.setBackgroundColor(skyColor);// 单元格背景颜色
            cellMain.setBorderWidth(7f);// 边框7px
            cellMain.setFixedHeight(30);// 单元格高30px
            cellMain.setBorderColor(skyColor);// 边框颜色
            mainTable.addCell(cellMain);// 添加到table去，每创一个cell,都添加到table才有效。

            // 第二行
            // 偿还指数信息的cell-----begin------
            PdfPCell repayCell = new PdfPCell();
            repayCell.setBorderWidth(7f);
            repayCell.setBorderColor(grayLableColor);
            repayCell.setPaddingLeft(-45f);
            repayCell.setPaddingTop(10f);
            repayCell.setPaddingBottom(10f);
            repayCell.setPaddingRight(-45f);
            repayCell.setBackgroundColor(whiteColor);

            // 偿还指数信息的表格（嵌入表格）----begin---
            PdfPTable repayTable = new PdfPTable(4);// 一行四列(column,row);
            repayTable.setWidths(new float[] { 0.18f, 0.4f, 0.16f, 0.26f });// 每个单元格占多宽
            PdfPCell cell = new PdfPCell();// 创建单元格
            cell.setColspan(4);// 跨4列
            // 加载图片
//            Image image = Image.getInstance(imagePath + "/images/pic/pic_" + isIndex(repayIndexInfo.getScore())
//                    + ".jpg");
//            cell.setImage(image);
            cell.setBorderColor(whiteColor);// 设置背景颜色
            repayTable.addCell(cell);// table加入单元格

            cell = new PdfPCell(new Paragraph("企业偿还指数:", fontChinese2));
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setVerticalAlignment(Element.ALIGN_TOP);// 垂直居上int positionTop = Element.ALIGN_TOP;
            cell.setBorderWidth(1f);
            cell.setBorderColor(whiteColor);
            cell.setFixedHeight(20);
            cell.setBackgroundColor(grayLableColor);
            repayTable.addCell(cell);

            cell = new PdfPCell(new Paragraph("$ 700.00", fontChinese2));
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setBorderWidth(1f);
            cell.setBorderColor(whiteColor);
            cell.setColspan(3);
            cell.setBackgroundColor(grayContentColor);
            repayTable.addCell(cell);

            cell = new PdfPCell(new Paragraph("信用风险评级:", fontChinese2));
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setBorderWidth(1f);
            cell.setFixedHeight(20);
            cell.setBorderColor(whiteColor);
            cell.setBackgroundColor(grayLableColor);
            repayTable.addCell(cell);

            cell = new PdfPCell(new Paragraph("xxxx", fontChinese2));
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setBorderWidth(1);
            cell.setBorderColor(whiteColor);
            cell.setColspan(3);
            cell.setBackgroundColor(grayContentColor);
            repayTable.addCell(cell);

            cell = new PdfPCell(new Paragraph("建议信用额度:", fontChinese2));
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setVerticalAlignment(Element.ALIGN_TOP);
            cell.setBorderWidth(1f);
            cell.setBorderColor(whiteColor);
            cell.setFixedHeight(20);
            cell.setBackgroundColor(grayLableColor);
            repayTable.addCell(cell);

            cell = new PdfPCell(new Paragraph("目前没有具体信用额度建议", fontChinese2));
            cell.setHorizontalAlignment(Element.ALIGN_LEFT);
            cell.setBorderWidth(1);
            cell.setBorderColor(whiteColor);
            cell.setColspan(3);
            cell.setBackgroundColor(grayContentColor);
            repayTable.addCell(cell);

            cell = new PdfPCell(new Paragraph("注释: 企业偿还指数是判断目标企业偿还付款能力的早期指针，指数越高，拖欠款风险可能越高。企业偿还指数从100分最好的评级",
                    fontChinese3));
            cell.setColspan(4);
            cell.setBorderWidth(1f);
            cell.setBorderColor(whiteColor);
            cell.setFixedHeight(12);
            repayTable.addCell(cell);

            cell = new PdfPCell(new Paragraph("      到600分最高风险。", fontChinese3));
            cell.setColspan(4);
            cell.setBorderWidth(1f);
            cell.setBorderColor(whiteColor);
            cell.setFixedHeight(12);
            repayTable.addCell(cell);

            // 基本信息的表格-----end-----
            repayCell.addElement(repayTable);

            // 基本信息的单元格-----end-----
            mainTable.addCell(repayCell);// 把mainTable 第2行的单元格加进去

            document.add(mainTable); // 把table加入到document对象里

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (document != null) {
                    document.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }



    /**
     * 生成PDF到文件
     * @param ftlPath 模板文件路径（不含文件名）
     * @param ftlName 模板文件（不含路径）
     * @param imageDiskPath 图片的磁盘路径
     * @param data 数据
     * @param outputFile 目标文件（全路径名称）
     */
    public static void generateToFile(String ftlPath, String ftlName, String imageDiskPath, Object data, String outputFile) throws Exception {
        String html = PdfHelper.getPdfContent(ftlPath, ftlName, data);
        OutputStream out = null;
        ITextRenderer render = null;
        try {
            out = new FileOutputStream(outputFile);
            render = PdfHelper.getRender();
            render.setDocumentFromString(html);
            if(StringUtils.isNotBlank(imageDiskPath)) {
                //html中如果有图片，图片的路径则使用这里设置的路径的相对路径，这个是作为根路径
                render.getSharedContext().setBaseURL("file:/" + imageDiskPath);
            }
            render.layout();
            render.createPDF(out);

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (render != null) {
                render.finishPDF();
            }
            render = null;
            if (out != null) {
                out.close();
            }
        }

    }

    /**
     * 生成PDF到输出流中（ServletOutputStream用于下载PDF）
     * @param ftlPath ftl模板文件的路径（不含文件名）
     * @param ftlName ftl模板文件的名称（不含路径）
     * @param imageDiskPath 如果PDF中要求图片，那么需要传入图片所在位置的磁盘路径
     * @param data 输入到FTL中的数据
     */
    public static OutputStream generateToOutputStream(String ftlPath, String ftlName, String imageDiskPath, Object data, OutputStream out) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException, DocumentException {
        String html = PdfHelper.getPdfContent(ftlPath, ftlName, data);
        ITextRenderer render = null;
        try {
            render = PdfHelper.getRender();
            render.setDocumentFromString(html);
            if(StringUtils.isNotBlank(imageDiskPath)) {
                //html中如果有图片，图片的路径则使用这里设置的路径的相对路径，这个是作为根路径
                render.getSharedContext().setBaseURL("file:/" + imageDiskPath);
            }
            render.layout();
            render.createPDF(out);

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (render != null) {
                render.finishPDF();
            }
            render = null;
        }
        return out;
    }



}
