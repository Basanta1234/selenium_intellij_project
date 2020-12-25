package diamondpages;

import com.diamond.base.DiamondTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Guru99WebTablePage extends DiamondTestBase {

    public Guru99WebTablePage() {
        PageFactory.initElements(diamondDriver, this);
    }

    public List<String> getColumnData(String columnName) {
        List<String> colData = new ArrayList<String>();
        List<WebElement> columnHearder = diamondDriver.findElements(By.cssSelector("table.dataTable>thead>tr>th"));
        List<WebElement> rows = diamondDriver.findElements(By.cssSelector("#leftcontainer>table>tbody>tr"));
        int noOfRows = rows.size();
        System.out.println(" Total Number of rows : "+ noOfRows);
        for (int r = 1; r <= rows.size(); r++) {
            String dynamicXpath = getColumnData(r, columnName);
            String fieldValue = diamondDriver.findElement(By.xpath(dynamicXpath)).getText();
            colData.add(fieldValue);

        }
        return colData;
    }


    private String getColumnData(int rows, String colName) {

        return "//div[@id='leftcontainer']/table/tbody/tr[" + rows + "]/td[count(//div[@id='leftcontainer']/table/thead/tr/th[text()='" + colName + "']/preceding-sibling::th)+1]";
    }
}
