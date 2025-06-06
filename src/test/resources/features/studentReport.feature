Feature: Mahasiswa melihat report

  Scenario: Mahasiswa mengakses dan memfilter laporan
    Given Pengguna berada di halaman utama aplikasi
    When Pengguna klik tombol login di halaman utama
    Then Pengguna seharusnya diarahkan ke halaman login
    When Pengguna memasukkan email "mahasiswa@mail.ugm.ac.id"
    And Pengguna memasukkan password "ABCD1234"
    And Pengguna klik tombol submit login
    Then Pengguna seharusnya berada di halaman "http://127.0.0.1:8000/mahasiswa/home"
    When Pengguna menekan menu navigasi laporan
    Then Pengguna seharusnya berada di halaman "http://127.0.0.1:8000/mahasiswa/report?month=6&year=2025"
    When Pengguna melakukan scroll sedikit ke bawah
    And Pengguna memilih bulan Mei
    Then Pengguna seharusnya berada di halaman "http://127.0.0.1:8000/mahasiswa/report?month=5&year=2025"
    When Pengguna melakukan scroll sedikit ke bawah
    And Pengguna memilih tipe laporan mingguan
    And Pengguna memilih minggu ke-3
    And Pengguna melakukan scroll ke bawah sampai mentok
    And Pengguna menunggu 2 detik
    And Pengguna melakukan scroll ke atas sampai mentok
    And Pengguna menekan tab tugas
    And Pengguna memilih minggu ke-4
    And Pengguna memilih tipe laporan bulanan