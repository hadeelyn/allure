
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.BasePage;
import com.pages.CreateAccountPage;
import com.pages.SignInPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class CreateAccountTest extends TestBase {

    private WebDriver driver;
    private SignInPage signInPage;
    private BasePage basePage;
    private CreateAccountPage createAccountPage;

    @BeforeClass
    public void setUp() {
        driver = getDriver();
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Create account test")
    @Story("Test create account verify")
    @Test
    public void verifyCreateAnAccountPage() {
        System.out.println("Create An Account page test...");
        basePage = new BasePage(driver);
        signInPage = basePage.clickSignInBtn();
        createAccountPage = signInPage.clickonCreateAnAccount();
        Assert.assertTrue(createAccountPage.verifyPageTitle(), "Page title not matching");
        Assert.assertTrue(createAccountPage.verifyCreateAccountPageText(), "Page text not matching");
    }

    @Severity(SeverityLevel.NORMAL)
    @Description("Create account test")
    @Story("Test create account test1")
    @Test
    public void createAccountExample1() {
        Assert.assertTrue(false, "This is expected failure");
    }

    @Story("Test create account test2")
    @Test
    public void createAccountExample2() {
        Assert.assertTrue(false, "This is expected failure");
    }
}