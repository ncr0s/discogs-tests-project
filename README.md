# Final project with automated tests for web, api and mobile
## 	Table of content

> ➠ [Project general information](#project-general-information)
>
> ➠ [Running tests from a terminal](#running-tests-from-a-terminal)
>
> ➠ [Running tests in Jenkins](#-running-tests-in-jenkins)
>
> ➠ [Allure Report on test results](#-allure-report-on-test-results)
>
> ➠ [Tests as documentation in Allure Test Ops](#-tests-as-documentation-in-allure-test-ops)
>
> ➠ [Telegram notifications using a bot](#-telegram-notifications-using-a-bot)
>
> ➠ [Discogs website UI tests](#discogs-website-ui-tests)
>
> ➠ [Discogs covered functionality](#discogs-covered-functionality)
>
> ➠ [UI tests technology stack](#ui-tests-technology-stack)
>
> ➠ [An example of running test in Selenoid](#-an-example-of-running-test-in-selenoid)

[//]: # (> ➠ [Api сервис Dummy]&#40;#api-сервис-dummy&#41;)

[//]: # (>)

[//]: # (> ➠ [Покрытый функционал api сервиса Dummy]&#40;#покрытый-функционал-api-сервиса-dummy&#41;)

[//]: # (>)

[//]: # (> ➠ [Технологический стек API]&#40;#технологический-стек-api&#41;)

[//]: # (>)

[//]: # (> ➠ [Мобильное приложение Ozon]&#40;#мобильное-приложение-ozon&#41;)

[//]: # (>)

[//]: # (> ➠ [Покрытый функционал мобильного приложения Ozon]&#40;#покрытый-функционал-мобильного-приложения-ozon&#41;)

[//]: # (>)

[//]: # (> ➠ [Технологический стек Mobile]&#40;#технологический-стек-mobile&#41;)

[//]: # (>)

[//]: # (> ➠ [Пример запуска теста в Browserstack]&#40;#-пример-запуска-теста-в-browserstack&#41;)

##  Project general information

### Launching tests from a terminal

### Local launch of tests

#### Local launch of tests using parameters from property file

```
gradle clean test -Denv={property file from the ./test/resources}
```

#### Local launch of tests using parameters from property file test

```
gradle clean test
```

#### Description of parameters for running tests

> -Dtag <code>test tag to run</code>
>
> -Dthreads <code>number of threads to run the tests</code>
>
> -DwebBrowserName <code>browser name</code>
>
> -DwebBrowserVersion <code>browser version</code>
>
> -webBaseUrl <code>url of the testing stand</code>
>
> -DwebBrowserSize <code>browser resolution</code>
>
> -DwebPageLoadTimeout <code>page load timeout</code>
>
> -DwebTimeout <code>timeout for loading the page element</code>
>
> -DwebIsRemote <code>running tests locally or via a remote service</code>
>
> -DwebRemoteUrl <code>url of the remote service</code>

[//]: # (>)

[//]: # (> -DmobilePlatform <code>выбор платформы для запуска мобильных тестов&#40;локально или в Browserstack&#41;</code>)

[//]: # (>)

[//]: # (> -DbuildName <code>имя билда, используется для опознования запущенного билда в browserstack</code>)

[//]: # (>)

[//]: # (> -DandroidVersion <code>версия android для browserstack</code>)

[//]: # (>)

[//]: # (> -DandroidDevice <code>имя android девайса для browserstack</code>)

[//]: # (>)

[//]: # (> -DandroidApp <code>идентификатор приложения, загруженного в browserstack</code>)

### Remote launch of tests

#### Remote launch of tests via parameter transfer

```
gradle clean test 
-Denv=test 
-Dtag= 
-Dthreads= 
-DwebIsRemote=true 
-DwebRemoteUrl=https://selenoid.cloud 
-DwebBaseUrl=https://www.saucedemo.com 
-DwebBrowserSize=1920x1080 
-DwebBrowserName=chrome 
-DwebBrowserVersion=100.0 
-DmobilePlatform=browserstack 
"-DandroidDevice=Google Pixel 3" 
-DandroidVersion=9.0 
-DbuildName=C16_Mamalazer_24
```

#### Remote launch of tests via prepared property file

> Создаём property файл с необходимыми параметрами и кладём его в <code>test.resources</code>
>
> Запускаем тесты, используя созданный property файл
>
> <code>gradle clean test -Denv={имя файла}</code>

##### File example
```
browserName=chrome
browserVersion=108
baseUrl=https://www.google.com
browserSize=1920x1080
pageLoadTimeout=10000
timeout=10000
headless=false
isRemote=true
remoteUrl=https://selenoid.autotests.cloud
```

## <img src="images/logo/jenkins.svg" title="Jenkins" width="4%"/> Running tests in Jenkins

> A parameterised build is used to run the tests

[//]: # (<p align="center">)
[//]: # (<img title="Jenkins" src="images/screens/jenkins.png">)
[//]: # (</p>)

## <img src="images/logo/allureReport.svg" title="allureReport" width="4%"/> Allure Report on test results

[//]: # (<p align="center">)
[//]: # (<img title="Allure_main" src="images/screens/Allure_main.png">)
[//]: # (</p>)

### <img src="images/logo/allureReport.svg" title="Allure_Report" width="4%"/> Grouping of tests according to the functionality being tested

[//]: # (<p align="center">)
[//]: # (<img title="Allure_suits" src="images/screens/Allure_suits.png">)
[//]: # (</p>)

### <img src="images/logo/allureReport.svg" title="Allure_Report" width="4%"/> The main dashboard

[//]: # (<p align="center">)
[//]: # (<img title="Allure_dashboard" src="images/screens/Allure_dashboard.png">)
[//]: # (</p>)

### <img src="images/logo/allureTestOps.svg" title="Allure_testops" width="4%"/> Tests as documentation in Allure Test Ops

[//]: # (<p align="center">)
[//]: # (<img title="Allure_testops" src="images/screens/Allure_testops.png">)
[//]: # (</p>)

## <img src="images/logo/telegram.svg" title="Telegram" width="4%"/> Telegram notifications using a bot

> Once the build is complete, a special <code>Telegram</code> bot automatically processes and sends a message with a report of the run

[//]: # (<p align="center">)
[//]: # (<img title="Telegram_notifications" src="images/screens/Telegram_notifications.png">)
[//]: # (</p>)

##  Discogs website UI tests

###  Discogs covered functionality

> Created <code>UI</code> tests:

- [x] Test 1
- [x] Test 2
- [x] Test 3
- [x] Test 4

### UI tests technology stack

<p align="center">
<img width="6%" title="Java" src="images/logo/java.svg">
<img width="6%" title="Gradle" src="images/logo/gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/jUnit5.svg">
<img width="6%" title="Selenide" src="images/logo/selenide.svg">
<img width="6%" title="Allure Report" src="images/logo/allureReport.svg">
<img width="6%" title="Allure Test Ops" src="images/logo/allureTestOps.svg">
<img width="6%" title="Jenkins" src="images/logo/jenkins.svg">
<img width="6%" title="Selenoid" src="images/logo/selenoid.svg">
</p>

### test in this subproject wrote on <code>Java</code> with <code>JUnit 5</code> and <code>Selenide</code>.
>
> <code>Gradle</code> is used for project building
>
> <code>Allure Report</code> generates a report on test runs
> 
> <code>Allure Test Ops</code> is used as test management system
>
> <code>Jenkins</code> runs tests remotely
>
> <code>Selenoid</code> performs browser launches in <code>Docker</code> containers

## <img width="4%" title="Selenoid" src="images/logo/selenoid.svg"> An example of running test in Selenoid

> Each test in the report is accompanied by a video of test run. For example

[//]: # (<p align="center">)
[//]: # (<img title="Selenoid_gif" src="images/gifs/Selenoid.gif">)
[//]: # (</p>)

[//]: # (##  Api сервис Dummy)
[//]: # ()
[//]: # (###  Покрытый функционал api сервиса Dummy)
[//]: # ()
[//]: # (> Разработаны автотесты на <code>Api сервис</code>.)
[//]: # (### Api)
[//]: # ()
[//]: # (- [x] Получение списка пользователей)
[//]: # (- [x] Создание нового пользователя)
[//]: # (- [x] Изменение пользователя)
[//]: # (- [x] Удаление пользователя)
[//]: # (- [x] Получение списка постов)
[//]: # (- [x] Создание нового поста)
[//]: # (- [x] Изменение поста)
[//]: # (- [x] Удаление поста)
[//]: # (- [x] Проверка всех постов пользователя)
[//]: # (- [x] Получение постов по тегу)
[//]: # (- [x] Получение списка коментов)
[//]: # (- [x] Добавление комента к посту)
[//]: # (- [x] Получение списка коментов пользователя)
[//]: # (- [x] Удаление комента)
[//]: # ()
[//]: # (### Технологический стек API)
[//]: # ()
[//]: # (<p align="center">)
[//]: # (<img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg">)
[//]: # (<img width="6%" title="Java" src="images/logo/Java.svg">)
[//]: # (<img width="6%" title="Rest Assured" src="images/logo/Rest_Assured.png">)
[//]: # (<img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg">)
[//]: # (<img width="6%" title="Allure Test Ops" src="images/logo/Allure_Test_Ops.svg">)
[//]: # (<img width="6%" title="Gradle" src="images/logo/Gradle.svg">)
[//]: # (<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">)
[//]: # (<img width="6%" title="GitHub" src="images/logo/GitHub.svg">)
[//]: # (<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">)
[//]: # (<img width="6%" title="Telegram" src="images/logo/Telegram.svg">)
[//]: # (</p>)
[//]: # ()
[//]: # (### В данном подпроекте автотесты написаны на <code>Java</code> с использованием <code>Rest Assured</code> для Api-тестов.)
[//]: # (>)
[//]: # (> <code>Rest Assured</code> выполняет роль обёртки над http клиентом.)
[//]: # (>)
[//]: # (> <code>Allure Report</code> формирует отчет о запуске тестов.)
[//]: # (>)
[//]: # (> Для автоматизированной сборки проекта используется <code>Gradle</code>.)
[//]: # (>)
[//]: # (> В качестве библиотеки для модульного тестирования используется <code>JUnit 5</code>.)
[//]: # (>)
[//]: # (> <code>Jenkins</code> выполняет запуск тестов.)
[//]: # (>)
[//]: # (> После завершения прогона отправляются уведомления с помощью бота в <code>Telegram</code>.)
[//]: # ()
[//]: # (## Мобильное приложение Ozon)
[//]: # ()
[//]: # (### Покрытый функционал мобильного приложения Ozon)
[//]: # ()
[//]: # (> Разработаны автотесты для мобильного приложения Ozon.)
[//]: # ()
[//]: # (- [x] Проверка страницы 'Корзина')
[//]: # (- [x] Добавление товара в корзину)
[//]: # (- [x] Проверка категорий на странице каталога)
[//]: # (- [x] Изменение региона доставки)
[//]: # (- [x] Проверка страницы 'Скидки')
[//]: # (- [x] Поиск товара и добавление в корзину)
[//]: # ()
[//]: # (### Технологический стек Mobile)
[//]: # ()
[//]: # (<p align="center">)
[//]: # (<img width="6%" title="Java" src="images/logo/java.svg">)
[//]: # (<img width="6%" title="Selenide" src="images/logo/selenide.svg">)
[//]: # (<img width="6%" title="Android Studio" src="images/logo/androidstudio.svg">)
[//]: # (<img width="6%" title="Appium" src="images/logo/appium.svg">)
[//]: # (<img width="6%" title="Appium Inspector" src="images/logo/appium_inspector.png">)
[//]: # (<img width="6%" title="Browserstack" src="images/logo/browserstack.svg">)
[//]: # (<img width="6%" title="Allure Report" src="images/logo/allureReport.svg">)
[//]: # (<img width="6%" title="Allure Test Ops" src="images/logo/Allure_Test_Ops.svg">)
[//]: # (<img width="6%" title="Gradle" src="images/logo/gradle.svg">)
[//]: # (<img width="6%" title="JUnit5" src="images/logo/jUnit5.svg">)
[//]: # (<img width="6%" title="GitHub" src="images/logo/gitHub.svg">)
[//]: # (<img width="6%" title="Jenkins" src="images/logo/jenkins.svg">)
[//]: # (</p>)
[//]: # ()
[//]: # (### В данном подпроекте автотесты написаны на <code>Java</code> с использованием <code>Selenide и Appium</code>.)
[//]: # (>)
[//]: # (> <code>Selenide и Appium</code> используются для управления мобильным устройством с помощью веб драйвера.)
[//]: # (>)
[//]: # (> Тесты можно запускать как локально&#40;с помощью Android studio и эмулятора мобильного устройства&#41;, так и с помощью сервиса Browserstack, предоставляющего доступ к ферме с реальными мобильными устройствами)
[//]: # (>)
[//]: # (> <code>Allure Report</code> формирует отчет о запуске тестов.)
[//]: # (>)
[//]: # (> Для автоматизированной сборки проекта используется <code>Gradle</code>.)
[//]: # (>)
[//]: # (> В качестве библиотеки для модульного тестирования используется <code>JUnit 5</code>.)
[//]: # (>)
[//]: # (> <code>Jenkins</code> выполняет запуск тестов.)
[//]: # (>)
[//]: # (> После завершения прогона отправляются уведомления с помощью бота в <code>Telegram</code>.)
[//]: # ()
[//]: # (## <img width="4%" title="BrowserStack" src="images/logo/browserstack.svg"> Пример запуска теста в Browserstack)
[//]: # ()
[//]: # (> К каждому тесту в отчете прилагается видео и различные логи. Одно из таких видео представлено ниже.)
[//]: # ()
[//]: # (<p align="center">)
[//]: # (<img title="Browserstack_gif" src="images/gifs/Browserstack_gif.gif">)
[//]: # (</p></p>)