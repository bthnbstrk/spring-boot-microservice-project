# Java Mikroservis Uygulaması

#### Proje üç temel mikroservisten oluşmakta, auth, user, config. Auth mikroservisi kullanıcı kayıt ve login endpointlerini örnekler. Kayıt endpointi çalışması sonrası, open feign yolu ile user mikroservisine çağrıda bulunur. Auth mikroservisi postgresql gerektirir. User mikroservisi üç temel fonksiyona sahiptir, kayıt etmek, tüm kullanıcıları dönmek ve Redis örneklemek amaçlı basit bir upperCase return eden fonksiyon, config mikroservisi auth ve user mikroservisleri için application.yml dosyalarını servis eder, proje içerisinde github üzerinde private olarak paylaşmış olduğum projeden bu config dosyaları alınır.

## PostgreSQL, Redis, MongoDB, Spring Boot, Spring Cloud, Open Feign 


## Mimari

<img src="https://github.com/bthnbstrk/spring-boot-microservice-project/blob/main/java-project.png" />

