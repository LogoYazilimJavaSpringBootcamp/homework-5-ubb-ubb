1. Spring Profile nedir? Properties ya da yml dosya formları ile isbasi uygulamasına test
   profile ekleyin.(5 Puan)

Profiller frameworkün temel özelliğidir, beanleri ayrı profillerde eşleştirmemize yarar. Örnek: test, dev, prod vs.
Sadece ihtiyacımız olan beanleri aktive etmek için kullanılır.

resources/application.yml:


```
spring:
    config:
        activate:
            on-profile: test
name: test-YAML
environment: testing
enabled: false
servers: 
    - www.abc.test.com
    - www.xyz.test.com

---
spring:
    config:
        activate:
            on-profile: prod
name: prod-YAML
environment: production
enabled: true
servers: 
    - www.abc.com
    - www.xyz.com
```

YML özelliklerini config clasına bağlamak: 

```
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class YAMLConfig {
 
    private String name;
    private String environment;
    private boolean enabled;
    private List<String> servers = new ArrayList<>();


}

```


2. SQL injection örnekleyin. Nasıl korunabiliriz?(5 Puan)

SQL Injection (SQLi), kötü niyetli SQL ifadelerini çalıştırmayı mümkün kılan bir enjeksiyon saldırısı türüdür. 
Bu ifadeler, bir web uygulamasının arkasındaki bir veritabanı sunucusunu kontrol eder. 
Saldırganlar, uygulama güvenlik önlemlerini atlamak için SQL Injection güvenlik açıklarını kullanabilir.

SQL Injection saldırılarını önlemenin tek kesin yolu, giriş doğrulaması ve hazırlanmış ifadeler içeren parametreli sorgulardır. 
Uygulama, inputu asla doğrudan kullanmamalıdır. Geliştirici,  tüm input tiplerini kontrol etmelidir. 
Productiondaki veritabanı hatalarının görünürlüğünü kapatmak gereklidir. Bu hatalar, veritabanınız hakkında bilgi edinmek için SQL Injection ile kullanılabilir.