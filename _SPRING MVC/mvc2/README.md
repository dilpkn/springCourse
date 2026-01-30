<img width="980" height="732" alt="image" src="https://github.com/user-attachments/assets/6604de42-8a35-41fa-bc1b-cc2202757a16" />

необходимые зависимости в пом файле:
spring-core
spring-context
spring-web
spring-webmvc(версии 5.2.1.RELEASE)
thymeleaf-spring5(версия 3.0.11.RELEASE)

ДЛЯ ЧЕГО НУЖЕН web.xml
томкат считывает из web.xml, и мы можем описать то, что хотим, чтобы сервер делал
в данном случае, чтобы все http-запросы перенаправлял на dispetcherServlet. и когда запрос будет попадать в  таком порядке, сначала на сервер потом на сервлет, он будет попаддать в спринг мвс приложение
на этом уроке будет курировать сервер на .xml в следующем на джава-коде
