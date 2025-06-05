
Feature: Fungsionalitas Login
  Sebagai pengguna
  Saya ingin mengakses akun saya melalui halaman login
  Agar saya dapat menggunakan fitur-fitur sistem

  Scenario: Login berhasil dengan kredensial yang valid
    Given Saya berada di halaman utama
    When Saya mengklik tombol login
    Then Saya akan diarahkan ke halaman login
    When Saya memasukkan "mahasiswa@mail.ugm.ac.id" sebagai email
    And Saya memasukkan "ABCD1234" sebagai password
    And Saya mengklik tombol submit login
    Then Saya berhasil masuk ke sistem