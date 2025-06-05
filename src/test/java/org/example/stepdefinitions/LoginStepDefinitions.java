package org.example.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginStepDefinitions {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    @Given("Saya berada di halaman utama aplikasi")
    public void saya_berada_di_halaman_utama_aplikasi() {
        loginPage.navigateToHome();
    }

    @When("Saya klik tombol login di halaman utama")
    public void saya_klik_tombol_login_di_halaman_utama() {
        loginPage.clickMainPageLoginButton();
    }

    @Then("Saya seharusnya diarahkan ke halaman login")
    public void saya_seharusnya_diarahkan_ke_halaman_login() {
        assertTrue(loginPage.isOnLoginPage());
    }

    @When("Saya memasukkan email {string}")
    public void saya_memasukkan_email(String email) {
        loginPage.enterEmail(email);
    }

    @When("Saya memasukkan password {string}")
    public void saya_memasukkan_password(String password) {
        loginPage.enterPassword(password);
    }

    @When("Saya klik tombol submit login")
    public void saya_klik_tombol_submit_login() {
        loginPage.clickLoginButton();
    }

    @Then("Saya seharusnya berhasil login")
    public void saya_seharusnya_berhasil_login() {
        assertTrue(loginPage.isLoginSuccessful());
    }

    @Then("Saya seharusnya melihat pesan error login")
    public void saya_seharusnya_melihat_pesan_error_login() {
        assertTrue(loginPage.isStillOnLoginPage(), "User should remain on login page after failed login");
    }
}