package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.DosenHomePage;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PermissionRequestStepDefinitions {
    private WebDriver driver;
    private DosenHomePage dosenHomePage;
    private LoginPage loginPage;
    private LoginStepDefinitions loginSteps;
    private DailyTaskLogStepDefinitions taskLogSteps;

    public PermissionRequestStepDefinitions(LoginStepDefinitions loginSteps, DailyTaskLogStepDefinitions taskLogSteps) {
        this.loginSteps = loginSteps;
        this.taskLogSteps = taskLogSteps;
        this.driver = loginSteps.getDriver();
        this.dosenHomePage = new DosenHomePage(driver);
        this.loginPage = new LoginPage(driver);
    }

    @Given("Pengguna berada di halaman utama aplikasi")
    public void pengguna_berada_di_halaman_utama_aplikasi() {
        loginPage.navigateToHome();
    }

    @When("Pengguna klik tombol login di halaman utama")
    public void pengguna_klik_tombol_login_di_halaman_utama() {
        loginPage.clickMainPageLoginButton();
    }

    @Then("Pengguna seharusnya diarahkan ke halaman login")
    public void pengguna_seharusnya_diarahkan_ke_halaman_login() {
        assertTrue(loginPage.isOnLoginPage());
    }

    @When("Pengguna memasukkan email {string}")
    public void pengguna_memasukkan_email(String email) {
        loginPage.enterEmail(email);
    }

    @When("Pengguna memasukkan password {string}")
    public void pengguna_memasukkan_password(String password) {
        loginPage.enterPassword(password);
    }

    @When("Pengguna klik tombol submit login")
    public void pengguna_klik_tombol_submit_login() {
        loginPage.clickLoginButton();
    }

    // Existing step definitions
    @Then("Pengguna seharusnya berada di halaman {string}")
    public void pengguna_seharusnya_berada_di_halaman(String url) {
        assertTrue(dosenHomePage.isOnPage(url), "User should be on page " + url);
    }

    @When("Pengguna memasukkan {string} pada kotak pencarian")
    public void pengguna_memasukkan_pada_kotak_pencarian(String searchTerm) {
        dosenHomePage.searchStudent(searchTerm);
    }

    @When("Pengguna menekan tombol titik tiga pada baris mahasiswa")
    public void pengguna_menekan_tombol_titik_tiga() {
        dosenHomePage.clickThreeDotButton();
    }

    @When("Pengguna menekan tombol izin")
    public void pengguna_menekan_tombol_izin() {
        dosenHomePage.clickPermissionButton();
    }

    @Then("Alert konfirmasi dengan judul {string} seharusnya muncul")
    public void alert_konfirmasi_dengan_judul_seharusnya_muncul(String expectedTitle) {
        assertEquals(expectedTitle, dosenHomePage.getAlertTitle());
    }

    @When("Pengguna menekan tombol ya pada alert")
    public void pengguna_menekan_tombol_ya_pada_alert() {
        dosenHomePage.clickYesButton();
    }

    @Then("Alert berhasil dengan judul {string} seharusnya muncul")
    public void alert_berhasil_dengan_judul_seharusnya_muncul(String expectedTitle) {
        assertEquals(expectedTitle, dosenHomePage.getAlertTitle());
    }

    @When("Pengguna menekan tombol ok pada alert")
    public void pengguna_menekan_tombol_ok_pada_alert() {
        dosenHomePage.clickOkOrNoButton();
    }

    @When("Pengguna menekan menu notifikasi")
    public void pengguna_menekan_menu_notifikasi() {
        dosenHomePage.clickNotificationMenu();
    }

    @Then("Permintaan izin untuk {string} seharusnya terkirim")
    public void permintaan_izin_seharusnya_terkirim(String expectedStudentName) {
        assertTrue(dosenHomePage.isRequestSent(), "Permission request should be sent");
        assertEquals(expectedStudentName, dosenHomePage.getStudentNameInRequest());
    }

    @When("Pengguna menekan tombol tidak pada alert")
    public void pengguna_menekan_tombol_tidak_pada_alert() {
        dosenHomePage.clickOkOrNoButton();
    }

    @Then("Alert batal dengan judul {string} seharusnya muncul")
    public void alert_batal_dengan_judul_seharusnya_muncul(String expectedTitle) {
        assertEquals(expectedTitle, dosenHomePage.getAlertTitle());
    }

    @Then("Alert gagal dengan judul {string} seharusnya muncul")
    public void alert_gagal_dengan_judul_seharusnya_muncul(String expectedTitle) {
        assertEquals(expectedTitle, dosenHomePage.getAlertTitle());
    }

    @Then("Pesan alert {string} seharusnya ditampilkan")
    public void pesan_alert_seharusnya_ditampilkan(String expectedMessage) {
        assertEquals(expectedMessage, dosenHomePage.getAlertMessage());
    }
}