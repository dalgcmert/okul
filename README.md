Okul Yönetim Sistemi
Basit bir okul yönetim sistemi API’si.
Öğrenciler, dersler ve notların yönetilebildiği; Java’nın temel, ileri ve modern konularını kapsayan bir örnek uygulama.

Amaç
Bu proje, Java dersinde işlenen aşağıdaki konuları uygulamalı olarak göstermek için geliştirilmiştir:

Temel Java & OOP

Spring Boot ile web programlama (API)

Veritabanı bağlantısı (H2)

Java 8 (Lambda, Streams)

Generic programlama

Multithread programlama

Sıralama algoritmaları

Popüler framework ve kütüphaneler (Spring Boot, Maven/Gradle)

Kullanılan Teknolojiler
Java 17

Spring Boot

Spring Data JPA

H2 (in-memory database)

Maven/Gradle

Lombok (opsiyonel)

Çalıştırma
Local çalıştırmak için:
bash
Kopyala
Düzenle
./mvnw spring-boot:run
veya

bash
Kopyala
Düzenle
./gradlew bootRun
Uygulama http://localhost:8080 adresinde çalışır.
Veritabanı in-memory olduğu için her başlatmada sıfırlanır.

API Endpointleri
Öğrenciler
Method	URL	Açıklama
GET	/students	Tüm öğrencileri getir
POST	/students	Yeni öğrenci ekle
GET	/students/top	En başarılı öğrenciyi getir
GET	/students/sorted	Öğrencileri ortalamaya göre sırala
GET	/students/allWrapped	Generic wrapper ile getir
GET	/students/async	Multithread ile asenkron getir

Dersler
Method	URL	Açıklama
GET	/courses	Tüm dersleri getir
POST	/courses	Yeni ders ekle

Notlar
Method	URL	Açıklama
POST	/grades	Yeni not ekle
GET	/grades/student/{id}	Belirli öğrencinin notlarını getir

Test JSON Örnekleri
Öğrenci ekleme:
json
Kopyala
Düzenle
{
  "name": "Ali Veli"
}
Ders ekleme:
json
Kopyala
Düzenle
{
  "name": "Matematik"
}
Not ekleme:
json
Kopyala
Düzenle
{
  "student": { "id": 1 },
  "course": { "id": 1 },
  "score": 95
}
Gereksinimleri Karşıladığı Konular
Temel Java Tekrarları
İleri Java konuları
Java 8 Lambda & Streams
OOP & Koleksiyonlar
Sıralama algoritması
Generic programlama
Multithread programlama
Veritabanı bağlantısı (H2)
J2EE temelleri & API
Spring Boot & Maven

GitHub Repo
https://github.com/dalgcmert/okul
