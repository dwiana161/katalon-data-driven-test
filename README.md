# katalon-data-driven-test

Project ini dibuat menggunakan **Katalon Studio** untuk mengimplementasikan **Data-Driven Testing (DDT)** pada web https://demoqa.com/automation-practice-form.  

---

## Deskripsi
Project ini menguji skenario pengisian form dengan berbagai kombinasi data valid dan invalid yang diambil dari file data.  
Hasilnya akan diverifikasi menggunakan keyword Katalon seperti `verifyElementPresent()` atau `verifyElementNotPresent()`.

---

## Fitur Utama
- Menggunakan **Data Files** Excel untuk input test data.  
- Validasi hasil Practice Form menggunakan `verifyElementPresent()` dan `verifyElementNotPresent()`.  
- Membuat report PDF dan XML.  
- Testing dijalankan di: Chrome.

---

## Persiapan
Pastikan sudah terpasang:
- [Katalon Studio] versi terbaru 10.4.1  
- Browser Chrome
- File data untuk testing (`form_data.xlsx`)  

---

## Cara Menjalankan Tes
1. Clone repository ini:
   ```
   git clone https://github.com/username/katalon-data-driven-test.git](https://github.com/dwiana161/katalon-data-driven-test.git
   ```
2. Buka project di Katalon Studio.
3. Buka Test Suite: PracticeForm_ValidationTest.
4. Klik Run ▶️ untuk menjalankan test.
5. Lihat hasil report di folder Reports/.
