package org.example.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReportPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    @FindBy(xpath = "//*[@id=\"navmenu\"]/ul/li[3]/a")
    private WebElement reportNavigationLink;

    @FindBy(id = "selectedMonth")
    private WebElement selectedMonthDropdown;

    @FindBy(xpath = "//*[@id=\"selectedMonth\"]/option[5]")
    private WebElement mayMonthOption;

    @FindBy(id = "reportType")
    private WebElement reportTypeDropdown;

    @FindBy(xpath = "//*[@id=\"reportType\"]/option[2]")
    private WebElement weeklyReportOption;

    @FindBy(xpath = "//*[@id=\"reportType\"]/option[1]")
    private WebElement monthlyReportOption;

    @FindBy(id = "selectedWeek")
    private WebElement selectedWeekDropdown;

    @FindBy(xpath = "//*[@id=\"selectedWeek\"]/option[3]")
    private WebElement week3Option;

    @FindBy(xpath = "//*[@id=\"selectedWeek\"]/option[4]")
    private WebElement week4Option;

    @FindBy(id = "tugasTab")
    private WebElement tugasTabButton;

    public ReportPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    private void safeClick(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", element);
            Thread.sleep(800);
            js.executeScript("arguments[0].click();", element);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void clickReportNavigation() {
        safeClick(reportNavigationLink);
    }

    public void scrollDown(String amount) {
        if (amount.equals("sedikit")) {
            js.executeScript("window.scrollBy(0, 100)");
        } else if (amount.equals("banyak")) {
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        }
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void scrollUp(String amount) {
        if (amount.equals("sedikit")) {
            js.executeScript("window.scrollBy(0, -100)");
        } else if (amount.equals("banyak")) {
            js.executeScript("window.scrollTo(0, 0)");
        }
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void selectMayMonth() {
        try {

            wait.until(ExpectedConditions.elementToBeClickable(selectedMonthDropdown));
            js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", selectedMonthDropdown);
            Thread.sleep(800);
            js.executeScript("arguments[0].click();", selectedMonthDropdown);

            wait.until(ExpectedConditions.elementToBeClickable(mayMonthOption));
            js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", mayMonthOption);
            Thread.sleep(800);
            js.executeScript("arguments[0].click();", mayMonthOption);

            Thread.sleep(800);

            if (!driver.getCurrentUrl().contains("month=5")) {
                String currentUrl = driver.getCurrentUrl();
                String newUrl = currentUrl.replace("month=6", "month=5");
                js.executeScript("window.location.href = arguments[0]", newUrl);
            }

            WebDriverWait extendedWait = new WebDriverWait(driver, Duration.ofSeconds(15));
            extendedWait.until(driver -> driver.getCurrentUrl().contains("month=5"));

            Thread.sleep(800);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            System.out.println("Error selecting May month: " + e.getMessage());

            String currentUrl = driver.getCurrentUrl();
            String newUrl = currentUrl.replace("month=6", "month=5");
            js.executeScript("window.location.href = arguments[0]", newUrl);
            try {
                Thread.sleep(800);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public boolean isOnReportPage(String url) {
        try {
            WebDriverWait extendedWait = new WebDriverWait(driver, Duration.ofSeconds(15));
            extendedWait.until(ExpectedConditions.urlToBe(url));
            return driver.getCurrentUrl().equals(url);
        } catch (Exception e) {
            System.out.println("URL verification failed. Expected: " + url + ", Actual: " + driver.getCurrentUrl());
            return false;
        }
    }

    public void selectWeeklyReportType() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(reportTypeDropdown));
            js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", reportTypeDropdown);
            Thread.sleep(800);
            js.executeScript("arguments[0].click();", reportTypeDropdown);
            wait.until(ExpectedConditions.elementToBeClickable(weeklyReportOption));
            Thread.sleep(800);
            js.executeScript("arguments[0].click();", weeklyReportOption);

            Thread.sleep(800);
            if (!driver.getCurrentUrl().contains("type=weekly")) {
                String currentUrl = driver.getCurrentUrl();
                String newUrl = currentUrl + (currentUrl.contains("?") ? "&" : "?") + "type=weekly";
                js.executeScript("window.location.href = arguments[0]", newUrl);
            }

            Thread.sleep(800);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void selectMonthlyReportType() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(reportTypeDropdown));
            js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", reportTypeDropdown);
            Thread.sleep(800);
            js.executeScript("arguments[0].click();", reportTypeDropdown);

            wait.until(ExpectedConditions.elementToBeClickable(monthlyReportOption));
            Thread.sleep(800);
            js.executeScript("arguments[0].click();", monthlyReportOption);

            Thread.sleep(800);

            if (driver.getCurrentUrl().contains("type=weekly")) {
                String currentUrl = driver.getCurrentUrl();
                String newUrl = currentUrl.replace("type=weekly", "type=monthly");
                js.executeScript("window.location.href = arguments[0]", newUrl);
            }

            Thread.sleep(800);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void selectWeek3() {
        try {

            if (!driver.getCurrentUrl().contains("type=weekly")) {
                String currentUrl = driver.getCurrentUrl();
                String newUrl = currentUrl + (currentUrl.contains("?") ? "&" : "?") + "type=weekly";
                js.executeScript("window.location.href = arguments[0]", newUrl);
                Thread.sleep(800);
            }

            System.out.println("Attempting week 3 selection using JavaScript...");
            js.executeScript(
                "if(document.getElementById('selectedWeek')) {" +
                "   document.getElementById('selectedWeek').value = '3';" +
                "   document.getElementById('selectedWeek').dispatchEvent(new Event('change'));" +
                "}"
            );

            Thread.sleep(800);

            try {
                WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(15));
                longWait.until(ExpectedConditions.presenceOfElementLocated(
                        org.openqa.selenium.By.id("selectedWeek")));

                longWait.until(ExpectedConditions.visibilityOf(selectedWeekDropdown));
                js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", selectedWeekDropdown);
                Thread.sleep(800);
                js.executeScript("arguments[0].click();", selectedWeekDropdown);

                longWait.until(ExpectedConditions.elementToBeClickable(week3Option));
                Thread.sleep(800);
                js.executeScript("arguments[0].click();", week3Option);
            } catch (Exception e) {
                System.out.println("UI interaction failed, using JavaScript fallback");

            }

            Thread.sleep(800);

        } catch (Exception e) {
            System.out.println("Error selecting week 3: " + e.getMessage());

            try {
                String currentUrl = driver.getCurrentUrl();
                String newUrl;
                if (currentUrl.contains("week=")) {
                    newUrl = currentUrl.replaceAll("week=[0-9]", "week=3");
                } else {
                    newUrl = currentUrl + (currentUrl.contains("?") ? "&" : "?") + "week=3";
                }
                js.executeScript("window.location.href = arguments[0]", newUrl);
                Thread.sleep(800);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void selectWeek4() {
        try {

            if (!driver.getCurrentUrl().contains("type=weekly")) {
                String currentUrl = driver.getCurrentUrl();
                String newUrl = currentUrl + (currentUrl.contains("?") ? "&" : "?") + "type=weekly";
                js.executeScript("window.location.href = arguments[0]", newUrl);
                Thread.sleep(800);
            }

            System.out.println("Attempting week 4 selection using JavaScript...");
            js.executeScript(
                "if(document.getElementById('selectedWeek')) {" +
                "   document.getElementById('selectedWeek').value = '4';" +
                "   document.getElementById('selectedWeek').dispatchEvent(new Event('change'));" +
                "}"
            );

            Thread.sleep(800);

            try {
                WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(15));
                longWait.until(ExpectedConditions.presenceOfElementLocated(
                        org.openqa.selenium.By.id("selectedWeek")));

                longWait.until(ExpectedConditions.visibilityOf(selectedWeekDropdown));
                js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", selectedWeekDropdown);
                Thread.sleep(800);
                js.executeScript("arguments[0].click();", selectedWeekDropdown);

                longWait.until(ExpectedConditions.elementToBeClickable(week4Option));
                Thread.sleep(800);
                js.executeScript("arguments[0].click();", week4Option);
            } catch (Exception e) {
                System.out.println("UI interaction failed, using JavaScript fallback");
            }

            Thread.sleep(800);

        } catch (Exception e) {
            System.out.println("Error selecting week 4: " + e.getMessage());
            try {
                String currentUrl = driver.getCurrentUrl();
                String newUrl;
                if (currentUrl.contains("week=")) {
                    newUrl = currentUrl.replaceAll("week=[0-9]", "week=4");
                } else {
                    newUrl = currentUrl + (currentUrl.contains("?") ? "&" : "?") + "week=4";
                }
                js.executeScript("window.location.href = arguments[0]", newUrl);
                Thread.sleep(800);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void clickTugasTab() {
        try {
            WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(15));
            longWait.until(ExpectedConditions.elementToBeClickable(tugasTabButton));
            js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", tugasTabButton);
            Thread.sleep(800);
            js.executeScript("arguments[0].click();", tugasTabButton);
            Thread.sleep(800);
            if (!driver.getCurrentUrl().contains("type=weekly")) {
                js.executeScript(
                    "if(document.getElementById('reportType')) {" +
                    "   document.getElementById('reportType').value = 'weekly';" +
                    "   document.getElementById('reportType').dispatchEvent(new Event('change'));" +
                    "}"
                );
            }

            Thread.sleep(800);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}