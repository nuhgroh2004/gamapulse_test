package org.example.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.DailyTaskLogPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DailyTaskLogStepDefinitions {
    private final LoginStepDefinitions loginSteps;
    private final DailyTaskLogPage taskLogPage;

    public DailyTaskLogStepDefinitions(LoginStepDefinitions loginSteps) {
        this.loginSteps = loginSteps;
        this.taskLogPage = new DailyTaskLogPage(loginSteps.getDriver());
    }

    @When("Pengguna menekan tombol task log")
    public void pengguna_menekan_tombol_task_log() {
        taskLogPage.clickTaskLogButton();
    }

    @Then("Timer Target Pengerjaan seharusnya ditampilkan")
    public void timer_target_pengerjaan_seharusnya_ditampilkan() {
        assertTrue(taskLogPage.isTimerTargetDisplayed(),
                "Timer Target Pengerjaan seharusnya ditampilkan");
    }

    @When("Pengguna menginputkan target {string}")
    public void pengguna_menginputkan_target(String target) {
        taskLogPage.enterTarget(target);
    }

    @When("Pengguna menekan tombol tambah target")
    public void pengguna_menekan_tombol_tambah_target() {
        taskLogPage.clickAddTargetButton();
    }

    @Then("Target {string} seharusnya muncul")
    public void target_seharusnya_muncul(String expectedTarget) {
        String actualTarget;
        try {
            actualTarget = taskLogPage.getTargetDisplayText();
        } catch (Exception e) {
            actualTarget = "Error: " + e.getMessage();
        }

        assertTrue(actualTarget.contains(expectedTarget) || expectedTarget.contains(actualTarget),
                "Expected target to contain '" + expectedTarget +
                        "' but found '" + actualTarget + "'");
    }

    @When("Pengguna menekan tombol mulai")
    public void pengguna_menekan_tombol_mulai() {
        taskLogPage.clickStartButton();
    }

    @When("Pengguna menunggu {int} detik")
    public void pengguna_menunggu_detik(Integer seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @When("Pengguna menekan tombol pause")
    public void pengguna_menekan_tombol_pause() {
        taskLogPage.clickPausePlayButton();
    }

    @When("Pengguna menekan tombol play")
    public void pengguna_menekan_tombol_play() {
        taskLogPage.clickPausePlayButton();
    }

    @When("Pengguna menekan tombol finish")
    public void pengguna_menekan_tombol_finish() {
        taskLogPage.clickFinishButton();
    }

    @Then("Alert konfirmasi seharusnya muncul")
    public void alert_konfirmasi_seharusnya_muncul() {
        assertTrue(taskLogPage.isConfirmationAlertDisplayed(),
                "Alert konfirmasi seharusnya muncul");
    }

    @When("Pengguna menekan tombol ya untuk menyimpan")
    public void pengguna_menekan_tombol_ya_untuk_menyimpan() {
        taskLogPage.clickYesButton();
    }

    @Then("Alert konfirmasi berhasil seharusnya muncul")
    public void alert_konfirmasi_berhasil_seharusnya_muncul() {
        assertTrue(taskLogPage.isSuccessAlertDisplayed(),
                "Alert konfirmasi berhasil seharusnya muncul");
    }

    @When("Pengguna menekan tombol ok")
    public void pengguna_menekan_tombol_ok() {
        taskLogPage.clickOkButton();
    }

    @When("Pengguna menekan tombol tidak untuk kembali")
    public void pengguna_menekan_tombol_tidak_untuk_kembali() {
        taskLogPage.clickNoButton();
    }

    @Then("Timer masih seharusnya ditampilkan")
    public void timer_masih_seharusnya_ditampilkan() {
        assertTrue(taskLogPage.isTimerStillDisplayed(),
                "Timer masih seharusnya ditampilkan");
    }

    @Then("Pengguna kembali ke halaman utama mahasiswa")
    public void pengguna_kembali_ke_halaman_utama_mahasiswa() {
        assertTrue(taskLogPage.isOnHomePage(),
                "Pengguna seharusnya kembali ke halaman home");
    }
}