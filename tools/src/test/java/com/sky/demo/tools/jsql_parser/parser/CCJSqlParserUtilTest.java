package com.sky.demo.tools.jsql_parser.parser;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.Parenthesis;
import net.sf.jsqlparser.expression.operators.arithmetic.Addition;
import net.sf.jsqlparser.expression.operators.arithmetic.Multiplication;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SelectBody;
import net.sf.jsqlparser.util.TablesNamesFinder;
import org.junit.Test;

import java.io.StringReader;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by rg on 2015/12/29.
 */
public class CCJSqlParserUtilTest {


    @Test
    public void test_Select_parse() {
        CCJSqlParserManager parserManager = new CCJSqlParserManager();

        //String sql = "select report.*, element.* from my.incident_report as report, my.element element";

        String sql = "select * from (select * from my.incident_report)report inner join (select * from my.element)element on report.id=element.report_id";

        try {
            Select selectStatement = (Select) parserManager.parse(new StringReader(sql));

            TablesNamesFinder tablesNamesFinder = new TablesNamesFinder();
            List<String> tables = tablesNamesFinder.getTableList(selectStatement);
            System.out.println(tables);

            SelectBody selectBody = selectStatement.getSelectBody();


        } catch (JSQLParserException e) {
            e.printStackTrace();
        }


    }
}
