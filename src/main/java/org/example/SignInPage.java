package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.qameta.allure.Step;

public class SignInPage {

    private WebDriver driver;

    private By headerPageSubText = By.id("headingSubtext");
    private By createAccountLink = By.cssSelector(".daaWTb content[class='CwaK9'] span.RveJvd");
    private By emailTextBox = By.id("identifierId");
    private By passwordTextBox = By.name("password");
    private By nextBtn = By.id("identifierNext");
    private By loginBtn = By.id("signIn");
    private By errorMsgTxt = By.id("errormsg_0_Passwd");
    private By headText = By.id("headingText");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSignInPageTitle() {
        String pageTitle = driver.getTitle();
        return pageTitle;
    }

    public boolean verifySignInPageTitle() {
        String expectedTitle = "Sign in - Google Accounts";
        return getSignInPageTitle().contains(expectedTitle);
    }

    public boolean verifySignInPageText() {
        WebElement headtext = driver.findElement(headText);
        String text1 = headtext.getText();

        WebElement subText = driver.findElement(headerPageSubText);
        String pageSubText = subText.getText();

        String conpHeaderText = text1 + pageSubText;
        String expectedPageText = "Sign in with your Google Account";
        return conpHeaderText.equalsIgnoreCase(expectedPageText);
    }

    public CreateAccountPage clickonCreateAnAccount() {
        WebElement element = driver.findElement(createAccountLink);
        if (element.isDisplayed() || element.isEnabled())
            element.click();
        return new CreateAccountPage(driver);
    }

    @Step("Verify sign with uname {0 and password {1}")
    public boolean verifySignIn(String uname, String pwd) {
        enterUserName(uname);
        enterPassword(pwd);
        clickOnSignIn();
        return getErrorMessage().contains("incorrect");
    }

    @Step("Enter username {0}")
    public void enterUserName(String userName) {
        WebElement emailTxtBox = driver.findElement(emailTextBox);
        if (emailTxtBox.isDisplayed())
            emailTxtBox.sendKeys(userName);
    }

    @Step("Enter password {0}")
    public void enterPassword(String password) {
        WebElement passwordTxtBox = driver.findElement(passwordTextBox);
        if (passwordTxtBox.isDisplayed())
            passwordTxtBox.sendKeys(password);
    }

    public void clickNextBtn() {
        WebElement nxtBtn = driver.findElement(nextBtn);
        nxtBtn.click();
    }

    public void clickOnSignIn() {
        WebElement signInBtn = driver.findElement(loginBtn);
        if (signInBtn.isDisplayed())
            signInBtn.click();
    }

    public String getErrorMessage() {
        String strErrorMsg = null;
        WebElement errorMsg = driver.findElement(errorMsgTxt);
        if (errorMsg.isDisplayed() && errorMsg.isEnabled())
            strErrorMsg = errorMsg.getText();
        return strErrorMsg;
    }
}