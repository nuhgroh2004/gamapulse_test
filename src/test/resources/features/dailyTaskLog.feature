Feature: Daily Task Log Functionality

  Scenario: Pengguna menggunakan timer task log
    Given Pengguna telah login ke sistem
    And Pengguna berada di halaman home mahasiswa
    When Pengguna menekan tombol task log
    Then Timer Target Pengerjaan seharusnya ditampilkan
    When Pengguna menginputkan target "01:30"
    And Pengguna menekan tombol tambah target
    Then Target "01:30:00" seharusnya muncul
    When Pengguna menekan tombol mulai
    And Pengguna menunggu 5 detik
    And Pengguna menekan tombol pause
    And Pengguna menunggu 2 detik
    And Pengguna menekan tombol play
    And Pengguna menunggu 5 detik
    And Pengguna menekan tombol finish
    Then Alert konfirmasi seharusnya muncul
    When Pengguna menekan tombol ya untuk menyimpan
    Then Alert konfirmasi berhasil seharusnya muncul
    When Pengguna menekan tombol ok
    Then Pengguna kembali ke halaman utama mahasiswa

  Scenario: Pengguna membatalkan penyimpanan task log
    Given Pengguna telah login ke sistem
    And Pengguna berada di halaman home mahasiswa
    When Pengguna menekan tombol task log
    Then Timer Target Pengerjaan seharusnya ditampilkan
    When Pengguna menginputkan target "01:30"
    And Pengguna menekan tombol tambah target
    Then Target "01:30:00" seharusnya muncul
    When Pengguna menekan tombol mulai
    And Pengguna menunggu 5 detik
    And Pengguna menekan tombol finish
    Then Alert konfirmasi seharusnya muncul
    When Pengguna menekan tombol tidak untuk kembali
    Then Timer masih seharusnya ditampilkan