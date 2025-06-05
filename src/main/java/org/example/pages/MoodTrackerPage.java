package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MoodTrackerPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@id=\"emoji-container\"]/div/a[4]/img")
    private WebElement happyEmojiButton;
    @FindBy(xpath = "//*[@id=\"emotion-level-modal\"]/div/div[1]/button[5]")
    private WebElement intensityLevel5Button;
    @FindBy(id = "modal-ok")
    private WebElement modalOkButton;
    @FindBy(id = "modal-back")
    private WebElement modalBackButton;
    @FindBy(id = "emotion-display")
    private WebElement emotionDisplay;
    @FindBy(id = "intensity-display")
    private WebElement intensityDisplay;
    @FindBy(id = "notes")
    private WebElement notesTextarea;
    @FindBy(xpath = "/html/body/div/div/form/div[3]/button")
    private WebElement saveButton;
    @FindBy(xpath = "/html/body/div/div/form/div[3]/a")
    private WebElement backButton;
    @FindBy(xpath = "//*[@id=\"emotion-level-modal\"]/div")
    private WebElement intensityModal;
    @FindBy(css = ".alert-success")
    private WebElement successMessage;

    public MoodTrackerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public boolean isOnHomePage() {
        wait.until(ExpectedConditions.urlToBe("http://127.0.0.1:8000/mahasiswa/home"));
        return driver.getCurrentUrl().equals("http://127.0.0.1:8000/mahasiswa/home");
    }

    public void selectHappyEmoji() {
        wait.until(ExpectedConditions.elementToBeClickable(happyEmojiButton));
        happyEmojiButton.click();
    }

    public void selectIntensityLevel5() {
        wait.until(ExpectedConditions.elementToBeClickable(intensityLevel5Button));
        intensityLevel5Button.click();
    }

    public void clickModalOkButton() {
        wait.until(ExpectedConditions.elementToBeClickable(modalOkButton));
        modalOkButton.click();
    }

    public void clickModalBackButton() {
        wait.until(ExpectedConditions.elementToBeClickable(modalBackButton));
        modalBackButton.click();
    }

    public boolean isIntensityModalDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(intensityModal));
            return intensityModal.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isOnNotesPage() {
        try {
            wait.until(ExpectedConditions.urlToBe("http://127.0.0.1:8000/mahasiswa/notes"));
            return driver.getCurrentUrl().equals("http://127.0.0.1:8000/mahasiswa/notes");
        } catch (Exception e) {
            return false;
        }
    }

    public String getEmotionDisplayText() {
        wait.until(ExpectedConditions.visibilityOf(emotionDisplay));
        return emotionDisplay.getText();
    }

    public String getIntensityDisplayText() {
        wait.until(ExpectedConditions.visibilityOf(intensityDisplay));
        return intensityDisplay.getText();
    }

    public void enterNotes(String noteText) {
        wait.until(ExpectedConditions.visibilityOf(notesTextarea));
        notesTextarea.clear();
        notesTextarea.sendKeys(noteText);
    }

    public void clickSaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        saveButton.click();
    }

    public void clickBackButton() {
        wait.until(ExpectedConditions.elementToBeClickable(backButton));
        backButton.click();
    }

    public boolean isNotesSavedSuccessfully() {
        try {
            wait.until(ExpectedConditions.visibilityOf(successMessage));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}