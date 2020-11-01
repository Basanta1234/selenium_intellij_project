package diamondpages;

import com.diamond.base.DiamondTestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxDemoPage extends DiamondTestBase {

    @FindBy(css = "input#isAgeSelected")
    WebElement checkBox;
    @FindBy(css = "div#txtAge")
    WebElement confirmationMessage;

    public CheckBoxDemoPage() {
        PageFactory.initElements(diamondDriver, this);
    }

    public void clickCheckBox() {

        checkBox.click();
    }
    public String getConfirmationText(){
        return confirmationMessage.getText();
    }
}
