package com.sky.demo.io.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import freemarker.core.ParseException;
import freemarker.template.*;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Locale;

/**
 * Created by rg on 2016/1/7.
 */
public class PdfHelper {

    public static String getPath() {
        return PdfHelper.class.getResource("").getPath().substring(1);
    }

    public static ITextRenderer getRender() throws DocumentException, IOException {
        ITextRenderer render = new ITextRenderer();
        String path = getPath();
        //添加字体，以支持中文
        render.getFontResolver().addFont(path + "resources/ARIALUNI.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        render.getFontResolver().addFont(path + "resources/SIMSUN.TTC", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        return render;
    }


    /**
     * 获取要写入PDF的内容
     * @param ftlPath
     * @param ftlName
     * @param o
     * @return
     * @throws TemplateNotFoundException
     * @throws MalformedTemplateNameException
     * @throws ParseException
     * @throws IOException
     * @throws TemplateException
     */
    public static String getPdfContent(String ftlPath, String ftlName, Object o) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
        return useTemplate(ftlPath, ftlName, o);
    }

    //使用freemarker得到html内容
    public static String useTemplate(String ftlPath, String ftlName, Object o) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
        String html = null;
        Template template = getFreemarkerConfig(ftlPath).getTemplate(ftlName);
        template.setEncoding("UTF-8");

        StringWriter writer = new StringWriter();
        template.process(o, writer);
        writer.flush();
        html = writer.toString();
        return html;
    }

    /**
     * 获取Freemarker配置
     * @param templatePath
     * @return
     * @throws IOException
     */
    private static Configuration getFreemarkerConfig(String templatePath) throws IOException {
        Configuration config = new Configuration();
        config.setDirectoryForTemplateLoading(new File(templatePath));
        config.setEncoding(Locale.CHINA, "utf-8");
        return config;
    }



}
