package org.example.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class DosenHomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "search")
    private WebElement searchInput;

    private By threeDotButtonLocator = By.xpath("//*[contains(@id,'mahasiswa-row')]/td[9]/div[1]/button");

    @FindBy(xpath = "//*[@id=\"mahasiswa-row-1\"]/td[9]/div[2]/div/button[2]/span")
    private WebElement permissionButton;

    // Alert elements
    @FindBy(xpath = "//*[@id=\"swal2-title\"]")
    private WebElement alertTitle;

    @FindBy(xpath = "/html/body/div/div/div[6]/button[3]")
    private WebElement alertYesButton;

    @FindBy(xpath = "/html/body/div/div/div[6]/button[1]")
    private WebElement alertOkOrNoButton;

    // Navigation
    @FindBy(xpath = "//*[@id=\"navmenu\"]/ul/li[3]/a")
    private WebElement notificationMenu;

    // Notification page elements
    @FindBy(xpath = "//*[@id=\"pending-content\"]/div/div")
    private WebElement pendingRequestContainer;

    @FindBy(xpath = "//*[@id=\"pending-content\"]/div/div/div/p[1]/span[2]")
    private WebElement studentNameInRequest;

    @FindBy(xpath = "//*[@id=\"swal2-html-container\"]")
    private WebElement alertMessage;

    public String getAlertMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOf(alertMessage));
            return alertMessage.getText();
        } catch (Exception e) {
            System.out.println("Error getting alert message: " + e.getMessage());
            e.printStackTrace();
            return "Alert message not found";
        }
    }

    public DosenHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Extended timeout
        PageFactory.initElements(driver, this);
    }

    public boolean isOnPage(String url) {
        try {
            wait.until(ExpectedConditions.urlToBe(url));
            return driver.getCurrentUrl().equals(url);
        } catch (Exception e) {
            return false;
        }
    }

    public void searchStudent(String studentName) {
        wait.until(ExpectedConditions.visibilityOf(searchInput));
        searchInput.clear();
        searchInput.sendKeys(studentName);
    }

    public void clickThreeDotButton() {
        try {
            Thread.sleep(1000);
            String directXPath = "//tr[contains(@id,'mahasiswa-row')]/td[9]/div[1]/button";
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(directXPath)));
            ((JavascriptExecutor) driver).executeScript(
                    "document.evaluate(\"" + directXPath + "\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.click();"
            );
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Error clicking three dot button: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Could not click three dot button", e);
        }
    }

    public void clickPermissionButton() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(permissionButton));
            permissionButton.click();
        } catch (Exception e) {
            try {
                Thread.sleep(1000);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", permissionButton);
            } catch (Exception ex) {
                throw new RuntimeException("Could not click permission button", ex);
            }
        }
    }

    public void clickYesButton() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(alertYesButton));
            try {
                Thread.sleep(1000);
                alertYesButton.click();
            } catch (Exception e) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", alertYesButton);
            }
            wait.until(ExpectedConditions.not(
                ExpectedConditions.textToBe(By.xpath("//*[@id=\"swal2-title\"]"), "Apa kamu yakin?")
            ));
        } catch (Exception e) {
            System.out.println("Error clicking Yes button: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public String getAlertTitle() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"swal2-title\"]")));
            WebElement freshAlertTitle = driver.findElement(By.xpath("//*[@id=\"swal2-title\"]"));
            return freshAlertTitle.getText();
        } catch (Exception e) {
            System.out.println("Error getting alert title: " + e.getMessage());
            e.printStackTrace();
            return "Alert title not found";
        }
    }

    public void clickOkOrNoButton() {
        wait.until(ExpectedConditions.elementToBeClickable(alertOkOrNoButton));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        alertOkOrNoButton.click();
    }

    public void clickNotificationMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(notificationMenu));
        notificationMenu.click();
    }

    public boolean isRequestSent() {
        try {
            wait.until(ExpectedConditions.visibilityOf(pendingRequestContainer));
            return pendingRequestContainer.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getStudentNameInRequest() {
        wait.until(ExpectedConditions.visibilityOf(studentNameInRequest));
        return studentNameInRequest.getText();
    }
}