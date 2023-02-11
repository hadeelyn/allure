package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.qameta.allure.Step;

public class BasePage {
    protected WebDriver driver;
    private By signInButton = By.linkText("Sign in");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Clicking on Sign in button")
    public SignInPage clickSignInBtn() {
        System.out.println("clicking on sign in button");
        WebElement signInBtnElement = driver.findElement(signInButton);
        if (signInBtnElement.isDisplayed() || signInBtnElement.isEnabled())
            signInBtnElement.click();
        else
            System.out.println("Element not found");
        return new SignInPage(driver);
    }

    public void clickImagesLink() {
        // It should have a logic to click on images link
        // And it should navigate to google images page
    }

    @Step("Get page Title")
    public String getPageTitle() {
        String title = driver.getTitle();
        return title;
    }

    @Step("Verify base page Title {0}")
    public boolean verifyBasePageTitle(String title) {
        return getPageTitle().contains(title);
    }
}