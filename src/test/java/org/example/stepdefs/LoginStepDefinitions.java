// src/test/java/org/example/stepdefs/LoginStepDefinitions.java
package org.example.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginStepDefinitions {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

//    @After
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

    @Given("Saya berada di halaman utama")
    public void saya_berada_di_halaman_utama() {
        driver.get("http://127.0.0.1:8000/");
    }

    @When("Saya mengklik tombol login")
    public void saya_mengklik_tombol_login() {
        WebElement loginButton = wait.until(
            ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"hero\"]/div[2]/div/div/a")));
        loginButton.click();
    }

    @Then("Saya akan diarahkan ke halaman login")
    public void saya_akan_diarahkan_ke_halaman_login() {
        wait.until(ExpectedConditions.urlToBe("http://127.0.0.1:8000/login"));
        assertEquals("http://127.0.0.1:8000/login", driver.getCurrentUrl());
    }

    @When("Saya memasukkan {string} sebagai email")
    public void saya_memasukkan_sebagai_email(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        emailField.clear();
        emailField.sendKeys(email);
    }

    @When("Saya memasukkan {string} sebagai password")
    public void saya_memasukkan_sebagai_password(String password) {
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    @When("Saya mengklik tombol submit login")
    public void saya_mengklik_tombol_submit_login() {
        WebElement submitButton = driver.findElement(By.xpath("/html/body/section/div/div/div/form/button"));
        submitButton.click();
    }

    @Then("Saya berhasil masuk ke sistem")
    public void saya_berhasil_masuk_ke_sistem() {
        wait.until(ExpectedConditions.urlToBe("http://127.0.0.1:8000/mahasiswa/home"));
        assertEquals("http://127.0.0.1:8000/mahasiswa/home", driver.getCurrentUrl(),
                "Pengguna harus diarahkan ke halaman mahasiswa home setelah berhasil login");
    }


}