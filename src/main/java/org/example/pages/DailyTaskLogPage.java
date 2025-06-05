package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DailyTaskLogPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "/html/body/div/div[1]/button[2]")
    private WebElement taskLogButton;

    @FindBy(xpath = "/html/body/div/div[2]/div[3]/div/div/h2")
    private WebElement timerTargetHeading;

    @FindBy(xpath = "/html/body/div/div[2]/div[3]/div/div/div[1]/div[1]/input")
    private WebElement targetInput;

    @FindBy(xpath = "/html/body/div/div[2]/div[3]/div/div/div[1]/div[1]/button")
    private WebElement addTargetButton;

    @FindBy(xpath = "/html/body/div/div[2]/div[3]/div/div/div[1]/div[2]/span")
    private WebElement targetDisplay;

    @FindBy(xpath = "/html/body/div/div[2]/div[3]/div/div/div[1]/button")
    private WebElement startButton;

    @FindBy(xpath = "/html/body/div/div[2]/div[3]/div/div/div[4]/button[1]")
    private WebElement pausePlayButton;

    @FindBy(xpath = "/html/body/div/div[2]/div[3]/div/div/div[4]/button[2]")
    private WebElement finishButton;

    @FindBy(xpath = "/html/body/div[2]/div")
    private WebElement confirmationAlert;

    @FindBy(xpath = "/html/body/div[2]/div/div[6]/button[1]")
    private WebElement yesButton;

    @FindBy(xpath = "/html/body/div[2]/div/div[6]/button[3]")
    private WebElement noButton;

    @FindBy(xpath = "//*[@id=\"swal2-title\"]")
    private WebElement successAlertTitle;

    @FindBy(xpath = "/html/body/div[2]/div/div[6]/button[1]")
    private WebElement okButton;

    @FindBy(xpath = "/html/body/div/div[2]/div[3]/div/div/div[3]/div/div")
    private WebElement timerDisplay;

    public DailyTaskLogPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        PageFactory.initElements(driver, this);
    }

    public void clickTaskLogButton() {
        wait.until(ExpectedConditions.elementToBeClickable(taskLogButton));
        taskLogButton.click();
    }

    public boolean isTimerTargetDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(timerTargetHeading));
            return timerTargetHeading.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void enterTarget(String target) {
        wait.until(ExpectedConditions.visibilityOf(targetInput));
        targetInput.clear();
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
            "arguments[0].value = arguments[1]", targetInput, target);
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
            "arguments[0].dispatchEvent(new Event('input'))", targetInput);
    }

    public void clickAddTargetButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addTargetButton));
        addTargetButton.click();
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            String alertText = driver.switchTo().alert().getText();
            System.out.println("Alert detected: " + alertText);
            driver.switchTo().alert().accept();
            return;
        } catch (Exception e) {

        }
    }

    public String getTargetDisplayText() {
        try {
            return targetDisplay.getText();
        } catch (Exception e) {
            System.out.println("Failed to find target display: " + e.getMessage());
            return "Target not found";
        }
    }

    public void clickStartButton() {
        try {
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});", startButton);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            wait.until(ExpectedConditions.elementToBeClickable(startButton));
            try {
                startButton.click();
            } catch (Exception e) {
                ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();", startButton);
            }
        } catch (Exception e) {
            System.out.println("Failed to click start button: " + e.getMessage());
            try {
                ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();", startButton);
            } catch (Exception ex) {
                System.out.println("All start button click attempts failed: " + ex.getMessage());
            }
        }
    }

    public void clickPausePlayButton() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(pausePlayButton));
            try {
                pausePlayButton.click();
            } catch (Exception e) {
                ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();", pausePlayButton);
            }
        } catch (Exception e) {
            System.out.println("Failed to click pause/play button: " + e.getMessage());
            try {
                ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();", pausePlayButton);
            } catch (Exception ex) {
                System.out.println("All pause/play click attempts failed: " + ex.getMessage());
            }
        }
    }

    public void clickFinishButton() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(finishButton));
            try {
                finishButton.click();
            } catch (Exception e) {
                ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({block: 'center'});", finishButton);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
                ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();", finishButton);
            }
        } catch (Exception e) {
            System.out.println("Failed to click finish button: " + e.getMessage());
            try {
                ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();", finishButton);
            } catch (Exception ex) {
                System.out.println("All click attempts failed: " + ex.getMessage());
            }
        }
    }

    public boolean isConfirmationAlertDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(confirmationAlert));
            return confirmationAlert.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickYesButton() {
        wait.until(ExpectedConditions.elementToBeClickable(yesButton));
        yesButton.click();
    }

    public void clickNoButton() {
        wait.until(ExpectedConditions.elementToBeClickable(noButton));
        noButton.click();
    }

    public boolean isSuccessAlertDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(successAlertTitle));
            return successAlertTitle.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOkButton() {
        wait.until(ExpectedConditions.elementToBeClickable(okButton));
        okButton.click();
    }

    public boolean isTimerStillDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(timerDisplay));
            return timerDisplay.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isOnHomePage() {
        wait.until(ExpectedConditions.urlToBe("http://127.0.0.1:8000/mahasiswa/home"));
        return driver.getCurrentUrl().equals("http://127.0.0.1:8000/mahasiswa/home");
    }
}