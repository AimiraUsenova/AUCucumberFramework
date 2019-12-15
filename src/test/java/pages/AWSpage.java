package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverUtil;

public class AWSpage {

    //div[@class='gwt-PushButton small gwt-PushButton-up']

    //*[@class="cell firstCell"])[2]

    WebDriver driver;
    public AWSpage() {
        driver= DriverUtil.driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath ="( //*[@class='cell firstCell'])[2]")
    public WebElement ec2InstanceAddButton;

    @FindBy(xpath ="//*[@class='billLabel']")
    public WebElement estimateOfMBillPart;

    @FindBy(xpath =" (//input[@class='gwt-TextBox gwt-TextBox-readonly'])[4119]")
    public WebElement totalAmount ;



}
