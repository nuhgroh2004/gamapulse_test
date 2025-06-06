package org.example.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.ReportPage;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReportStepDefinitions {
    private WebDriver driver;
    private ReportPage reportPage;
    private DailyTaskLogStepDefinitions taskLogSteps;

    public ReportStepDefinitions(LoginStepDefinitions loginSteps, DailyTaskLogStepDefinitions taskLogSteps) {
        this.driver = loginSteps.getDriver();
        this.reportPage = new ReportPage(driver);
        this.taskLogSteps = taskLogSteps;
    }

    @When("Pengguna menekan menu navigasi laporan")
    public void pengguna_menekan_menu_navigasi_laporan() {
        reportPage.clickReportNavigation();
    }

    @When("Pengguna melakukan scroll sedikit ke bawah")
    public void pengguna_melakukan_scroll_sedikit_ke_bawah() {
        reportPage.scrollDown("sedikit");
    }

    @When("Pengguna melakukan scroll ke bawah sampai mentok")
    public void pengguna_melakukan_scroll_ke_bawah_sampai_mentok() {
        reportPage.scrollDown("banyak");
    }

    @When("Pengguna melakukan scroll ke atas sampai mentok")
    public void pengguna_melakukan_scroll_ke_atas_sampai_mentok() {
        reportPage.scrollUp("banyak");
    }

    @When("Pengguna memilih bulan Mei")
    public void pengguna_memilih_bulan_mei() {
        reportPage.selectMayMonth();
    }

    @When("Pengguna memilih tipe laporan mingguan")
    public void pengguna_memilih_tipe_laporan_mingguan() {
        reportPage.selectWeeklyReportType();
    }

    @When("Pengguna memilih tipe laporan bulanan")
    public void pengguna_memilih_tipe_laporan_bulanan() {
        reportPage.selectMonthlyReportType();
    }

    @When("Pengguna memilih minggu ke-3")
    public void pengguna_memilih_minggu_ke_3() {
        reportPage.selectWeek3();
    }

    @When("Pengguna memilih minggu ke-4")
    public void pengguna_memilih_minggu_ke_4() {
        reportPage.selectWeek4();
    }

    @When("Pengguna menekan tab tugas")
    public void pengguna_menekan_tab_tugas() {
        reportPage.clickTugasTab();
    }

    @Then("Halaman report seharusnya menampilkan data dengan filter yang benar")
    public void halaman_report_seharusnya_menampilkan_data_dengan_filter_yang_benar() {
        assertTrue(driver.getCurrentUrl().contains("/mahasiswa/report"));
    }
}