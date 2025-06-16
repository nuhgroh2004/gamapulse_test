Feature: Dosen membuat akun mahasiswa

  Background:
    Given Pengguna berada di halaman utama aplikasi
    When Pengguna klik tombol login di halaman utama
    Then Pengguna seharusnya diarahkan ke halaman login
    When Pengguna memasukkan email "dosen@ugm.ac.id"
    And Pengguna memasukkan password "ABCD1234"
    And Pengguna klik tombol submit login
    Then Pengguna seharusnya berada di halaman "http://127.0.0.1:8000/dosen/home"
    When Pengguna menekan menu create user
    Then Pengguna seharusnya berada di halaman "http://127.0.0.1:8000/dosen/create-user"

  Scenario: Gagal membuat mahasiswa karena format email salah
    When Pengguna mengisi form mahasiswa dengan data invalid email
      | email          | budi@gmail.com      |
      | password       | password123         |
      | nama           | Budi Santoso        |
      | nim            | 20/456789/TI/12345  |
      | prodi          | Teknik Informatika  |
      | tanggal_lahir  | 2000-01-01          |
      | phone          | 1234567890          |
    And Pengguna memilih role mahasiswa
    And Pengguna menekan tombol tambah user
    Then Alert gagal dengan judul "Gagal menambahkan user" seharusnya muncul
    And Pesan alert "Email harus menggunakan domain @mail.ugm.ac.id." seharusnya ditampilkan
    When Pengguna menekan tombol ok pada alert

  Scenario: Gagal membuat mahasiswa karena format password salah
    When Pengguna mengisi form mahasiswa dengan data invalid password
      | email          | budi@mail.ugm.ac.id |
      | password       | pass                |
      | nama           | Budi Santoso        |
      | nim            | 20/456789/TI/12345  |
      | prodi          | Teknik Informatika  |
      | tanggal_lahir  | 2000-01-01          |
      | phone          | 1234567890          |
    And Pengguna memilih role mahasiswa
    And Pengguna menekan tombol tambah user
    Then Alert gagal dengan judul "Gagal menambahkan user" seharusnya muncul
    And Pesan alert "Password minimal 8 karakter. (and 1 more error)" seharusnya ditampilkan
    When Pengguna menekan tombol ok pada alert

  Scenario: Gagal membuat mahasiswa karena format NIM salah
    When Pengguna mengisi form mahasiswa dengan data invalid nim
      | email          | budi@mail.ugm.ac.id |
      | password       | password123         |
      | nama           | Budi Santoso        |
      | nim            | 12345               |
      | prodi          | Teknik Informatika  |
      | tanggal_lahir  | 2000-01-01          |
      | phone          | 1234567890          |
    And Pengguna memilih role mahasiswa
    And Pengguna menekan tombol tambah user
    Then Alert gagal dengan judul "Gagal menambahkan user" seharusnya muncul
    And Pesan alert "Format NIM tidak valid. Contoh yang benar: XX/XXXXXX/AA/XXXXX." seharusnya ditampilkan
    When Pengguna menekan tombol ok pada alert

  Scenario: Gagal membuat mahasiswa karena format nomor <10 digit
    When Pengguna mengisi form mahasiswa dengan data invalid phone
      | email          | budi@mail.ugm.ac.id |
      | password       | password123         |
      | nama           | Budi Santoso        |
      | nim            | 20/456789/TI/12345  |
      | prodi          | Teknik Informatika  |
      | tanggal_lahir  | 2000-01-01          |
      | phone          | 123456789           |
    And Pengguna memilih role mahasiswa
    And Pengguna menekan tombol tambah user
    Then Alert gagal dengan judul "Gagal menambahkan user" seharusnya muncul
    And Pesan alert "Nomor telepon harus antara 10 dan 12 digit." seharusnya ditampilkan
    When Pengguna menekan tombol ok pada alert

  Scenario: Gagal membuat mahasiswa karena format nomor >10 digit
    When Pengguna mengisi form mahasiswa dengan data invalid phone
      | email          | budi@mail.ugm.ac.id |
      | password       | password123         |
      | nama           | Budi Santoso        |
      | nim            | 20/456789/TI/12345  |
      | prodi          | Teknik Informatika  |
      | tanggal_lahir  | 2000-01-01          |
      | phone          | 1234567890123       |
    And Pengguna memilih role mahasiswa
    And Pengguna menekan tombol tambah user
    Then Alert gagal dengan judul "Gagal menambahkan user" seharusnya muncul
    And Pesan alert "Nomor telepon harus antara 10 dan 12 digit." seharusnya ditampilkan
    When Pengguna menekan tombol ok pada alert

  Scenario: Gagal membuat mahasiswa karena password hanya berisi huruf
    When Pengguna mengisi form mahasiswa dengan data invalid password
      | email          | budi@mail.ugm.ac.id |
      | password       | abcdefgh            |
      | nama           | Budi Santoso        |
      | nim            | 20/456789/TI/12345  |
      | prodi          | Teknik Informatika  |
      | tanggal_lahir  | 2000-01-01          |
      | phone          | 1234567890          |
    And Pengguna memilih role mahasiswa
    And Pengguna menekan tombol tambah user
    Then Alert gagal dengan judul "Gagal menambahkan user" seharusnya muncul
    And Pesan alert "Password harus mengandung setidaknya satu huruf dan satu angka." seharusnya ditampilkan
    When Pengguna menekan tombol ok pada alert

  Scenario: Gagal membuat mahasiswa karena password hanya berisi angka
    When Pengguna mengisi form mahasiswa dengan data invalid password
      | email          | budi@mail.ugm.ac.id |
      | password       | 12345678            |
      | nama           | Budi Santoso        |
      | nim            | 20/456789/TI/12345  |
      | prodi          | Teknik Informatika  |
      | tanggal_lahir  | 2000-01-01          |
      | phone          | 1234567890          |
    And Pengguna memilih role mahasiswa
    And Pengguna menekan tombol tambah user
    Then Alert gagal dengan judul "Gagal menambahkan user" seharusnya muncul
    And Pesan alert "Password harus mengandung setidaknya satu huruf dan satu angka." seharusnya ditampilkan
    When Pengguna menekan tombol ok pada alert

  Scenario: Gagal membuat mahasiswa karena password kurang dari 8 karakter
    When Pengguna mengisi form mahasiswa dengan data invalid password
      | email          | budi@mail.ugm.ac.id |
      | password       | ABCD12            |
      | nama           | Budi Santoso        |
      | nim            | 20/456789/TI/12345  |
      | prodi          | Teknik Informatika  |
      | tanggal_lahir  | 2000-01-01          |
      | phone          | 1234567890          |
    And Pengguna memilih role mahasiswa
    And Pengguna menekan tombol tambah user
    Then Alert gagal dengan judul "Gagal menambahkan user" seharusnya muncul
    And Pesan alert "Password minimal 8 karakter." seharusnya ditampilkan
    When Pengguna menekan tombol ok pada alert

  Scenario: Berhasil membuat akun mahasiswa baru 10 digit nomor
    When Pengguna mengisi form mahasiswa dengan data valid
      | email          | budii@mail.ugm.ac.id |
      | password       | password123         |
      | nama           | Budi Santoso        |
      | nim            | 20/456789/TI/12344  |
      | prodi          | Teknik Informatika  |
      | tanggal_lahir  | 2000-01-01          |
      | phone          | 1234567899         |
    And Pengguna memilih role mahasiswa
    And Pengguna menekan tombol tambah user
    Then Alert berhasil dengan judul "User berhasil ditambahkan" seharusnya muncul
    When Pengguna menekan tombol ok pada alert
    And Pengguna menekan menu home
    And Pengguna memasukkan "Budi Santoso" pada kotak pencarian
    Then Data mahasiswa "Budi Santoso" seharusnya muncul pada tabel

  Scenario: Berhasil membuat akun mahasiswa baru 12 digit nomor
    When Pengguna mengisi form mahasiswa dengan data valid
      | email          | budiii@mail.ugm.ac.id |
      | password       | password123         |
      | nama           | Budi Santoso        |
      | nim            | 20/456789/TI/12341  |
      | prodi          | Teknik Informatika  |
      | tanggal_lahir  | 2000-01-01          |
      | phone          | 123456789013         |
    And Pengguna memilih role mahasiswa
    And Pengguna menekan tombol tambah user
    Then Alert berhasil dengan judul "User berhasil ditambahkan" seharusnya muncul
    When Pengguna menekan tombol ok pada alert
    And Pengguna menekan menu home
    And Pengguna memasukkan "Budi Santoso" pada kotak pencarian
    Then Data mahasiswa "Budi Santoso" seharusnya muncul pada tabel

  Scenario: Gagal membuat mahasiswa karena email sudah terdaftar
    When Pengguna mengisi form mahasiswa dengan data valid
      | email          | budiii@mail.ugm.ac.id |
      | password       | password123         |
      | nama           | Budi Santoso        |
      | nim            | 20/456789/TI/12341  |
      | prodi          | Teknik Informatika  |
      | tanggal_lahir  | 2000-01-01          |
      | phone          | 123456789013         |
    And Pengguna memilih role mahasiswa
    And Pengguna menekan tombol tambah user
    Then Alert gagal dengan judul "Gagal menambahkan user" seharusnya muncul
    And Pesan alert "Email sudah terdaftar. (and 1 more error)" seharusnya ditampilkan
    When Pengguna menekan tombol ok pada alert