
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.BasePage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


public class BasePageTest extends TestBase {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Verify home page title")
    @Story("Test verify base page title")
    @Test
    public void verifyHomePage() {
        System.out.println("Home page test...");
        BasePage basePage = new BasePage(driver);
        Assert.assertTrue(basePage.verifyBasePageTitle("Google"), "Home page title doesn't match");
    }

    @Severity(SeverityLevel.TRIVIAL)
    @Description("Verify home page test 1")
    @Story("Test verify base Test1")
    @Test
    public void baseTest1() {

        System.out.println("Hey im in test1 test");

    }

    @Severity(SeverityLevel.TRIVIAL)
    @Description("Verify home page test 2")
    @Story("Test verify base Test")
    @Test
    public void baseTest2() throws InterruptedException {
        Assert.assertTrue(true, "Simple test ");
    }

    @Severity(SeverityLevel.TRIVIAL)
    @Description("Verify home page test 3")
    @Story("Test verify base Test")
    @Test
    public void baseTest3() {
        Assert.assertTrue(false, "This is expected failure");
    }

}