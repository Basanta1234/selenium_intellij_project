package com.diamond.testcases.webtables;

import com.diamond.base.DiamondTestBase;
import org.apache.commons.collections.map.HashedMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo1WebTable extends DiamondTestBase {


    @Test
    public void webTablesData() throws InterruptedException {
        diamondDriver.get("http://demo.guru99.com/test/web-table-element.php#");
        List<WebElement> columnHearder = diamondDriver.findElements(By.cssSelector("table.dataTable>thead>tr>th"));
        List<WebElement> rows = diamondDriver.findElements(By.cssSelector("#leftcontainer>table>tbody>tr"));
         Map<String, ArrayList<String>> mapData=new HashMap<>();
         ArrayList<String> column=new ArrayList<>();
        int noOfColumns = columnHearder.size();
        int noOfRows = rows.size();
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
                for (WebElement cell : cells) {
                    System.out.print(cell.getText() + "\t");
                    Thread.sleep(250);
                }
                System.out.println("");
            }
        }}
