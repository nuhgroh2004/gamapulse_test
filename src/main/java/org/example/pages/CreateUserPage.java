package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateUserPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@id=\"navmenu\"]/ul/li[2]/a")
    private WebElement createUserMenu;

    @FindBy(xpath = "//*[@id=\"navmenu\"]/ul/li[1]/a")
    private WebElement homeMenu;

    @FindBy(xpath = "//*[@id=\"role-0\"]")
    private WebElement roleDropdown;

    @FindBy(xpath = "//*[@id=\"role-0\"]/option[2]")
    private WebElement mahasiswaOption;

    @FindBy(xpath = "/html/body/div/form/div[2]/button[2]")
    private WebElement submitButton;

    public CreateUserPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void clickCreateUserMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(createUserMenu));
        createUserMenu.click();
    }

    public void clickHomeMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(homeMenu));
        homeMenu.click();
    }

    public void fillForm(int index, String field, String value) {
        String id = field + "-" + index;
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        element.clear();
        element.sendKeys(value);
    }

    public void selectRoleMahasiswa() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(roleDropdown));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", roleDropdown);
            Thread.sleep(500);
            wait.until(ExpectedConditions.elementToBeClickable(mahasiswaOption));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", mahasiswaOption);
        } catch (Exception e) {
            System.out.println("Error selecting role: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Could not select role", e);
        }
    }

    public void clickSubmitButton() {
        try {
            WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/form/div[2]/button[2]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", button);
            Thread.sleep(1000);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        } catch (Exception e) {
            System.out.println("Error clicking submit button: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Could not click submit button", e);
        }
    }

    public boolean isStudentDisplayed(String name) {
        try {
            String xpath = "//td[contains(text(), '" + name + "')]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}