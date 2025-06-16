Feature: Mengirim permintaan izin sebagai dosen

  Scenario: Dosen mengirim permintaan izin ke mahasiswa dengan konfirmasi
    Given Pengguna berada di halaman utama aplikasi
    When Pengguna klik tombol login di halaman utama
    Then Pengguna seharusnya diarahkan ke halaman login
    When Pengguna memasukkan email "dosen@ugm.ac.id"
    And Pengguna memasukkan password "ABCD1234"
    And Pengguna klik tombol submit login
    Then Pengguna seharusnya berada di halaman "http://127.0.0.1:8000/dosen/home"
    When Pengguna memasukkan "Mahasiswa1" pada kotak pencarian
    And Pengguna menunggu 1 detik
    And Pengguna menekan tombol titik tiga pada baris mahasiswa
    And Pengguna menekan tombol izin
    Then Alert konfirmasi dengan judul "Apa kamu yakin?" seharusnya muncul
    When Pengguna menekan tombol ya pada alert
    Then Alert berhasil dengan judul "Berhasil!" seharusnya muncul
    When Pengguna menekan tombol ok pada alert
    And Pengguna menekan menu notifikasi
    Then Pengguna seharusnya berada di halaman "http://127.0.0.1:8000/dosen/notifikasi"
    And Permintaan izin untuk "Mahasiswa1" seharusnya terkirim

  Scenario: Dosen membatalkan permintaan izin ke mahasiswa
    Given Pengguna berada di halaman utama aplikasi
    When Pengguna klik tombol login di halaman utama
    Then Pengguna seharusnya diarahkan ke halaman login
    When Pengguna memasukkan email "dosen@ugm.ac.id"
    And Pengguna memasukkan password "ABCD1234"
    And Pengguna klik tombol submit login
    Then Pengguna seharusnya berada di halaman "http://127.0.0.1:8000/dosen/home"
    When Pengguna memasukkan "Mahasiswa1" pada kotak pencarian
    And Pengguna menunggu 1 detik
    And Pengguna menekan tombol titik tiga pada baris mahasiswa
    And Pengguna menekan tombol izin
    Then Alert konfirmasi dengan judul "Apa kamu yakin?" seharusnya muncul
    When Pengguna menekan tombol tidak pada alert
    Then Alert batal dengan judul "Dibatalkan" seharusnya muncul
    When Pengguna menekan tombol ok pada alert

  Scenario: Dosen gagal mengirim permintaan izin karena sudah memiliki permintaan yang belum diproses
    Given Pengguna berada di halaman utama aplikasi
    When Pengguna klik tombol login di halaman utama
    Then Pengguna seharusnya diarahkan ke halaman login
    When Pengguna memasukkan email "dosen@ugm.ac.id"
    And Pengguna memasukkan password "ABCD1234"
    And Pengguna klik tombol submit login
    Then Pengguna seharusnya berada di halaman "http://127.0.0.1:8000/dosen/home"
    When Pengguna memasukkan "Mahasiswa1" pada kotak pencarian
    And Pengguna menunggu 1 detik
    And Pengguna menekan tombol titik tiga pada baris mahasiswa
    And Pengguna menekan tombol izin
    Then Alert konfirmasi dengan judul "Apa kamu yakin?" seharusnya muncul
    When Pengguna menekan tombol ya pada alert
    Then Alert gagal dengan judul "Gagal" seharusnya muncul
    And Pesan alert "Anda sudah memiliki permintaan izin yang belum diproses." seharusnya ditampilkan
    When Pengguna menekan tombol ok pada alert

