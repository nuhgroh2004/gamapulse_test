package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Elements on main page
    @FindBy(xpath = "//*[@id=\"hero\"]/div[2]/div/div/a")
    private WebElement mainPageLoginButton;

    // Elements on login page
    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "/html/body/section/div/div/div/form/button")
    private WebElement loginButton;

    @FindBy(css = ".alert-danger") // Assuming error uses this class
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void navigateToHome() {
        driver.get("http://127.0.0.1:8000/");
    }

    public void clickMainPageLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(mainPageLoginButton));
        mainPageLoginButton.click();
    }

    public boolean isOnLoginPage() {
        return driver.getCurrentUrl().equals("http://127.0.0.1:8000/login");
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean isLoginSuccessful() {
        try {
            wait.until(ExpectedConditions.not(
                    ExpectedConditions.urlContains("login")
            ));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isStillOnLoginPage() {
        try {
            wait.until(ExpectedConditions.urlContains("login"));
            return driver.getCurrentUrl().contains("login");
        } catch (Exception e) {
            return false;
        }
    }


}