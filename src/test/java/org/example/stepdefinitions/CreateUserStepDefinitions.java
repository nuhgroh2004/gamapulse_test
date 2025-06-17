package org.example.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.CreateUserPage;
import org.example.pages.DosenHomePage;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateUserStepDefinitions {
    private WebDriver driver;
    private CreateUserPage createUserPage;
    private LoginStepDefinitions loginSteps;

    public CreateUserStepDefinitions(LoginStepDefinitions loginSteps) {
        this.loginSteps = loginSteps;
        this.driver = loginSteps.getDriver();
        this.createUserPage = new CreateUserPage(driver);
    }

    @When("Pengguna menekan menu create user")
    public void pengguna_menekan_menu_create_user() {
        createUserPage.clickCreateUserMenu();
    }

    @When("Pengguna menekan menu home")
    public void pengguna_menekan_menu_home() {
        createUserPage.clickHomeMenu();
    }

    @When("Pengguna mengisi form mahasiswa dengan data valid")
    public void pengguna_mengisi_form_mahasiswa_dengan_data_valid(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        createUserPage.fillForm(0, "email", data.get("email"));
        createUserPage.fillForm(0, "password", data.get("password"));
        createUserPage.fillForm(0, "name", data.get("nama"));
        createUserPage.fillForm(0, "nim", data.get("nim"));
        createUserPage.fillForm(0, "prodi", data.get("prodi"));
        createUserPage.fillForm(0, "tanggal_lahir", data.get("tanggal_lahir"));
        createUserPage.fillForm(0, "phone", data.get("phone"));
    }

    @When("Pengguna mengisi form mahasiswa dengan data berikut")
    public void pengguna_mengisi_form_mahasiswa_dengan_data_berikut(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        createUserPage.fillForm(0, "email", data.get("email"));
        createUserPage.fillForm(0, "password", data.get("password"));
        createUserPage.fillForm(0, "name", data.get("nama"));
        createUserPage.fillForm(0, "nim", data.get("nim"));
        createUserPage.fillForm(0, "prodi", data.get("prodi"));
        createUserPage.fillForm(0, "tanggal_lahir", data.get("tanggal_lahir"));
        createUserPage.fillForm(0, "phone", data.get("phone"));
    }
    @When("Pengguna mengisi form mahasiswa dengan data invalid email")
    public void pengguna_mengisi_form_mahasiswa_dengan_data_invalid_email(DataTable dataTable) {
        pengguna_mengisi_form_mahasiswa_dengan_data_valid(dataTable);
    }

    @When("Pengguna mengisi form mahasiswa dengan data invalid password")
    public void pengguna_mengisi_form_mahasiswa_dengan_data_invalid_password(DataTable dataTable) {
        pengguna_mengisi_form_mahasiswa_dengan_data_valid(dataTable);
    }

    @When("Pengguna mengisi form mahasiswa dengan data invalid nim")
    public void pengguna_mengisi_form_mahasiswa_dengan_data_invalid_nim(DataTable dataTable) {
        pengguna_mengisi_form_mahasiswa_dengan_data_valid(dataTable);
    }

    @When("Pengguna mengisi form mahasiswa dengan data invalid phone")
    public void pengguna_mengisi_form_mahasiswa_dengan_data_invalid_phone(DataTable dataTable) {
        pengguna_mengisi_form_mahasiswa_dengan_data_valid(dataTable);
    }

    @When("Pengguna memilih role mahasiswa")
    public void pengguna_memilih_role_mahasiswa() {
        createUserPage.selectRoleMahasiswa();
    }

    @When("Pengguna menekan tombol tambah user")
    public void pengguna_menekan_tombol_tambah_user() {
        createUserPage.clickSubmitButton();
    }

    @Then("Data mahasiswa {string} seharusnya muncul pada tabel")
    public void data_mahasiswa_seharusnya_muncul_pada_tabel(String name) {
        assertTrue(createUserPage.isStudentDisplayed(name));
    }

    @Then("Sistem seharusnya tidak menampilkan alert")
    public void sistemTidakMenampilkanAlert() {
        assertFalse(createUserPage.isAlertVisible());
    }

    @And("Fokus seharusnya diarahkan ke input {string}")
    public void fokusDiarahkanKeField(String fieldName) {
        assertTrue(createUserPage.isFieldFocused(fieldName));
    }
}