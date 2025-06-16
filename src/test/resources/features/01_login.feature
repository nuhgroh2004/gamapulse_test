Feature: Login Functionality

  Scenario: Login berhasil dengan kredensial valid
    Given Saya berada di halaman utama aplikasi
    When Saya klik tombol login di halaman utama
    Then Saya seharusnya diarahkan ke halaman login
    When Saya memasukkan email "mahasiswa@mail.ugm.ac.id"
    And Saya memasukkan password "ABCD1234"
    And Saya klik tombol submit login
    Then Saya seharusnya berhasil login

  Scenario: Login gagal dengan password tidak valid
    Given Saya berada di halaman utama aplikasi
    When Saya klik tombol login di halaman utama
    Then Saya seharusnya diarahkan ke halaman login
    When Saya memasukkan email "mahasiswa@mail.ugm.ac.id"
    And Saya memasukkan password "passwordSalah"
    And Saya klik tombol submit login
    Then Saya seharusnya melihat pesan error login