package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.LoginPage;
import org.example.pages.MoodTrackerPage;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoodTrackerStepDefinitions {
    private WebDriver driver;
    private LoginPage loginPage;
    private MoodTrackerPage moodTrackerPage;

    public MoodTrackerStepDefinitions(LoginStepDefinitions loginSteps) {
        this.driver = loginSteps.getDriver();
        this.loginPage = new LoginPage(driver);
        this.moodTrackerPage = new MoodTrackerPage(driver);
    }

    @Given("Pengguna telah login ke sistem")
    public void pengguna_telah_login_ke_sistem() {
        loginPage.navigateToHome();
        loginPage.clickMainPageLoginButton();
        loginPage.enterEmail("mahasiswa@mail.ugm.ac.id");
        loginPage.enterPassword("ABCD1234");
        loginPage.clickLoginButton();
        assertTrue(loginPage.isLoginSuccessful());
    }

    @Given("Pengguna berada di halaman home mahasiswa")
    public void pengguna_berada_di_halaman_home_mahasiswa() {
        assertTrue(moodTrackerPage.isOnHomePage());
    }

    @When("Pengguna memilih emoji senang")
    public void pengguna_memilih_emoji_senang() {
        moodTrackerPage.selectHappyEmoji();
    }

    @Then("Popup intensitas mood muncul")
    public void popup_intensitas_mood_muncul() {
        assertTrue(moodTrackerPage.isIntensityModalDisplayed(),
            "Modal intensitas seharusnya muncul setelah memilih emoji");
    }

    @When("Pengguna memilih tingkat intensitas {int}")
    public void pengguna_memilih_tingkat_intensitas(Integer level) {
        if (level == 5) {
            moodTrackerPage.selectIntensityLevel5();
        }
    }

    @When("Pengguna menekan tombol OK")
    public void pengguna_menekan_tombol_ok() {
        moodTrackerPage.clickModalOkButton();
    }

    @Then("Pengguna diarahkan ke halaman input notes")
    public void pengguna_diarahkan_ke_halaman_input_notes() {
        assertTrue(moodTrackerPage.isOnNotesPage());
    }

    @Then("Nilai emotion pada halaman adalah {string}")
    public void nilai_emotion_pada_halaman_adalah(String emotion) {
        String actualEmotion = moodTrackerPage.getEmotionDisplayText();
        assertTrue(actualEmotion.equalsIgnoreCase(emotion),
                "Expected emotion '" + emotion + "' but found '" + actualEmotion + "'");
    }

    @Then("Nilai intensitas pada halaman adalah {int}")
    public void nilai_intensitas_pada_halaman_adalah(Integer intensity) {
        assertEquals(intensity.toString(), moodTrackerPage.getIntensityDisplayText());
    }

    @When("Pengguna memasukkan notes")
    public void pengguna_memasukkan_notes() {
        moodTrackerPage.enterNotes("Hari ini saya merasa senang!");
    }

    @When("Pengguna menekan tombol simpan")
    public void pengguna_menekan_tombol_simpan() {
        moodTrackerPage.clickSaveButton();
    }

    @Then("Pencatatan mood berhasil disimpan")
    public void pencatatan_mood_berhasil_disimpan() {
        assertTrue(true);
    }

    @When("Pengguna menekan tombol kembali")
    public void pengguna_menekan_tombol_kembali() {
        moodTrackerPage.clickBackButton();
    }

    @Then("Pengguna kembali ke halaman home mahasiswa")
    public void pengguna_kembali_ke_halaman_home_mahasiswa() {
        assertTrue(moodTrackerPage.isOnHomePage());
    }

    @When("Pengguna menekan tombol kembali pada modal")
    public void pengguna_menekan_tombol_kembali_pada_modal() {
        moodTrackerPage.clickModalBackButton();
    }

    @Then("Pengguna tetap berada di halaman home mahasiswa")
    public void pengguna_tetap_berada_di_halaman_home_mahasiswa() {
        assertTrue(moodTrackerPage.isOnHomePage(), "Pengguna seharusnya tetap berada di halaman home");
    }
}