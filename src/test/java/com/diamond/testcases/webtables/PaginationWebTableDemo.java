package com.diamond.testcases.webtables;

import com.diamond.base.DiamondTestBase;
import diamondpages.PaginationWebPage;
import org.testng.annotations.Test;

import java.util.List;

public class PaginationWebTableDemo extends DiamondTestBase {



    @Test
    public void getDataForPaginationWebTable() throws InterruptedException {
        PaginationWebPage pwt=new PaginationWebPage();
        diamondDriver.get("https://www.seleniumeasy.com/test/table-pagination-demo.html");
        String colName="Table heading 4";
        pwt.getFieldValue(colName);
    }
}
