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
import net.sf.jsqlparser.statement.select.Limit;
import net.sf.jsqlparser.statement.select.PlainSelect;
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

        String sql = "select * from (select * from my.incident_report)report inner join (select * from my.element limit 10)element on report.id=element.report_id limit 20";

        //sql = "SELECT \"d.id\", [d.uuid], `d.name`, \"d.am?ou nt*\", d.percentage, d.modified_time, dc.discount_id FROM discount d LEFT OUTER JOIN \"discount_category\" dc ON d.id = dc.discount_id WHERE merchant_id=? AND deleted=? AND dc.discount_id IS NULL AND modified_time<? AND modified_time>=? and rownum <=10 ORDER BY modified_time ";
        try {
            Select selectStatement = (Select) parserManager.parse(new StringReader(sql));

            TablesNamesFinder tablesNamesFinder = new TablesNamesFinder();
            List<String> tables = tablesNamesFinder.getTableList(selectStatement);
            System.out.println(tables);


            PlainSelect plainSelect = (PlainSelect) selectStatement.getSelectBody();
            System.out.println(plainSelect.getSelectItems());

            Limit limit = plainSelect.getLimit();
            System.out.println(limit);

        } catch (JSQLParserException e) {
            e.printStackTrace();
        }


    }
}
