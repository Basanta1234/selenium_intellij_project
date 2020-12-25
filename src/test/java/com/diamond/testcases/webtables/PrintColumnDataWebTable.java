package com.diamond.testcases.webtables;

import com.diamond.base.DiamondTestBase;
import diamondpages.Guru99WebTablePage;
import org.testng.annotations.Test;

import java.util.List;

public class PrintColumnDataWebTable extends DiamondTestBase {



@Test
    public void getGuru99ColumnData() throws InterruptedException {
    Guru99WebTablePage gtd=new Guru99WebTablePage();
    //Column Name= Company
    //Column Name= Group
    //Column Name= Prev Close (Rs)
    diamondDriver.get("http://demo.guru99.com/test/web-table-element.php#");
    List<String> myData=gtd.getColumnData("Prev Close (Rs)");
    for(String d:myData){
        System.out.println(d);
        Thread.sleep(1000);
    }
}
}
