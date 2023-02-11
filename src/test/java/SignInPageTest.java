
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.BasePage;
import com.pages.SignInPage;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class SignInPageTest extends TestBase {

    private WebDriver driver;
    private SignInPage signInPage;
    private BasePage basePage;

    @BeforeClass
    public void setUp() {
        //Get driver
        driver = getDriver();
    }

    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify Sign In functionality")
    @Story("Test verify sign in")
    @Test
    public void verifySignInFunction() {
        System.out.println("Sign In functionality details...");
        basePage = new BasePage(driver);
        signInPage = basePage.clickSignInBtn();
        Assert.assertTrue(signInPage.verifySignInPageTitle(), "Sign In page title doesn't match");
        Assert.assertTrue(signInPage.verifySignInPageText(), "Page text not matching");
        Assert.assertTrue(signInPage.verifySignIn("usertest", "p123"), "Unable to sign in");
    }

    @Story("Test verify sign in test1")
    @Test
    public void SignInPageTestOne() {
        Assert.assertTrue(true, "This is simple test");
    }

    @Story("Test verify sign in test2")
    @Test
    public void SignInPageTestTwo() {
        Assert.assertTrue(false, "This is expected failure");
    }

    @Story("Test verify sign in test3")
    @Test
    public void SignInPageTestThree() {
        Assert.assertTrue(true, "This is not expected failure");
    }
}