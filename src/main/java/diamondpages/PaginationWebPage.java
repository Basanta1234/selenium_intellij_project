package diamondpages;

import com.diamond.base.DiamondTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class PaginationWebPage extends DiamondTestBase {


    public PaginationWebPage() {
        PageFactory.initElements(diamondDriver, this);
    }


    private List<String> getPaginationTableData(String colName) {

        int totalRows = diamondDriver.findElements(By.xpath("//section/div/table/tbody/tr")).size();
        WebElement pagingElement = diamondDriver.findElement(By.cssSelector("ul#myPager"));
        int totalSublinks = pagingElement.findElements(By.tagName("a")).size();
        System.out.println("Total sub links of pages : " + totalSublinks);
        List<String> value = new ArrayList<String>();
        if (totalSublinks > 0) {
            System.out.println("links are present : ");
            for (int i = 1; i < totalSublinks - 1; i++) {
                WebElement link = diamondDriver.findElement(By.linkText(String.valueOf(i)));
                link.click();
                for (int r = 1; r <= totalRows; r++) {
                    String dynamicXpath = getSpecifiedColumnNameDate(r, colName);
                    String fieldValue = diamondDriver.findElement(By.xpath(dynamicXpath)).getText();
                    value.add(fieldValue);
                }
            }
        } else {
            System.out.println(" links are not present ");
        }
        return value;
    }


    private String getSpecifiedColumnNameDate(int r, String colName) {
        return "//tbody[@id='myTable']/tr[" + r + "]/td[count(//section/div/table/thead/tr/th[text()='" + colName + "']/preceding-sibling::th)+1]";
    }

    public String getFieldValue(String colName) {
        String fValue = "";
        for (String a : getPaginationTableData(colName)) {
            fValue = a;
            System.out.println(fValue);
        }
        return fValue;
    }
}
