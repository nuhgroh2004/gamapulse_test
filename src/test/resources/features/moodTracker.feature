Feature: Mood Tracker Functionality

  Scenario: Pengguna berhasil mencatat mood dengan lengkap
    Given Pengguna telah login ke sistem
    And Pengguna berada di halaman home mahasiswa
    When Pengguna memilih emoji senang
    Then Popup intensitas mood muncul
    When Pengguna memilih tingkat intensitas 5
    And Pengguna menekan tombol OK
    Then Pengguna diarahkan ke halaman input notes
    And Nilai emotion pada halaman adalah "senang"
    And Nilai intensitas pada halaman adalah 5
    When Pengguna memasukkan notes
    And Pengguna menekan tombol simpan
    Then Pencatatan mood berhasil disimpan

  Scenario: Pengguna membatalkan proses pencatatan mood pada modal intensitas
    Given Pengguna telah login ke sistem
    And Pengguna berada di halaman home mahasiswa
    When Pengguna memilih emoji senang
    Then Popup intensitas mood muncul
    When Pengguna menekan tombol kembali pada modal
    Then Pengguna tetap berada di halaman home mahasiswa

  Scenario: Pengguna membatalkan proses pencatatan mood pada halaman notes
    Given Pengguna telah login ke sistem
    And Pengguna berada di halaman home mahasiswa
    When Pengguna memilih emoji senang
    Then Popup intensitas mood muncul
    When Pengguna memilih tingkat intensitas 5
    And Pengguna menekan tombol OK
    Then Pengguna diarahkan ke halaman input notes
    When Pengguna menekan tombol kembali
    Then Pengguna kembali ke halaman home mahasiswa
