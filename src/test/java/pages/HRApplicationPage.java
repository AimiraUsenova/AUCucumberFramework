package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverUtil;

import java.util.List;

public class HRApplicationPage {

    WebDriver driver;

    public  HRApplicationPage() {
        driver = DriverUtil.driverSetup("Chrome");
        PageFactory.initElements(driver, this);
    }

        @FindBy(xpath = "//table[@id='europe-employees']//tr/td[1]" )
        public List<WebElement> firstName;


        @FindBy(xpath = "//table[@id='europe-employees']//tr/td[2]")
        public List<WebElement> lastName;

    @FindBy(xpath = "//table[@id='number-of-employees-by-department-name']//tr/td[1]")
    public List<WebElement> ListOfDepartmentName;

    @FindBy(xpath = "//table[@id='number-of-employees-by-department-name']//tr/td[2]")
    public List<WebElement> ListOfEmployeesNumber;








}
