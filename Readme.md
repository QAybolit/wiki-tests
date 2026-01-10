
# Проект по автоматизации тестовых сценариев для сайта [Wikipedia](https://ru.wikipedia.org/wiki/%D0%97%D0%B0%D0%B3%D0%BB%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0) <img width="30" alt="Yadro" src="media/icons/Wikipedia-logo.svg">


## **Содержание:**

* [Технологии и инструменты](#star-технологии-и-инструменты)

* [Реализованные проверки](#open_file_folder-реализованные-проверки)

* [Запуск из терминала](#computer-запуск-из-терминала)

* [Сборка в Jenkins](#-сборка-в-jenkins)

* [Allure отчет](#-allure-отчет)

* [Интеграция с Allure TestOps](#-интеграция-с-allure-testops)

* [Уведомление в Telegram при помощи бота](#-уведомление-в-telegram-при-помощи-бота)

* [Примеры видео выполнения тестов на Selenoid](#-примеры-видео-выполнения-тестов-на-selenoid)  
  <br>


---
## :star: Технологии и инструменты:

<p>
<a href="https://www.jetbrains.com/idea/"><img width="45" alt="IntelliJ IDEA" src="media/icons/Idea.svg"></a>
<a href="https://www.java.com/ru/"><img width="45" alt="Java" src="media/icons/java.svg"></a>
<a href="https://junit.org/"><img width="45" alt="JUnit5" src="media/icons/Junit5.svg"></a>
<a href="https://ru.selenide.org/"><img width="45" alt="Selenide" src="media/icons/Selenide.svg"></a>
<a href="https://allurereport.org/"><img width="45" alt="Allure" src="media/icons/Allure.svg"></a>
<a href="https://gradle.org/"><img width="45" alt="Gradle" src="media/icons/gradle-original.svg"></a>
<a href="https://www.jenkins.io/"><img width="45" alt="Jenkins" src="media/icons/jenkins.svg"></a>
<a href="https://aerokube.com/selenoid/latest/"><img width="45" alt="Selenoid" src="media/icons/Selenoid.svg"></a>
<a href="https://qameta.io/"><img width="45" alt="Allure_TO" src="media/icons/Allure_TO.svg"></a>
</p>  
<br>


---
## :open_file_folder: Реализованные проверки:

- Проверка работы кнопок меню: "Содержание", "Избранные статьи", "Текущие события"
- Поиск статей через строку поиска и через страницу поиска. 

Для обеспечения большего покрытия для тестирования поиска используются параметризованные тесты (аннотация @ParameterizedTest, передача данных в тест через @MethodSource и @CsvSource)
  <br>


---
## :computer: Запуск из терминала:

### Локальный запуск

Для локального запуска тестов используйте следующую команду:
```
./gradlew clean local-test
```

---

### Запуск на Selenoid

Для запуска тестов удаленно на Selenoid используйте команду, где в параметр remoteUrl передается URL селеноида с кредами для доступа:
```
./gradlew clean remote-test -DremoteUrl=URL_SELENOID
```

---
## <img width="25" alt="Jenkins" src="media/icons/jenkins.svg"> [Сборка в Jenkins:](https://jenkins.autotests.cloud/job/wiki-tests-kholomkina)

<img alt="Сборка в Jenkins" src="media/images/jenkins.png">  
<br>

---
## <img width="25" alt="Allure" src="media/icons/Allure.svg"> [Allure отчет:](https://jenkins.autotests.cloud/job/wiki-tests-kholomkina/5/allure/)

**Overview:**

<img alt="Allure отчет" src="media/images/allure.png">
<br><br>

**Tests:**

<img alt="Allure отчет: тесты" src="media/images/allure-tests.png">  
<br>


---
## <img width="25" alt="AllureTestOps" src="media/icons/Allure_TO.svg"> [Интеграция с Allure TestOps:](https://allure.autotests.cloud/project/5058/test-cases/41965?treeId=9886)

**Тест-кейсы:**

<img alt="Интеграция с Allure TestOps" src="media/images/AllureTestOps.png">
<br><br>

**Отображение параметризации в тест-кейсе:**

<img alt="Отображение параметризации в тест-кейсе" src="media/images/параметризация.png">  
<br>

**Dashboard прогонов:**

<img alt="Интеграция с Allure TestOps: прогоны" src="media/images/AllureTestOps-прогоны.png">  
<br>


---
## <img width="25" alt="telegram" src="media/icons/telegram.svg"> Уведомление в Telegram при помощи бота:

<img alt="Интеграция с Telegram" src="media/images/telegram.png">
<br>


---
## <img width="25" alt="Selenoid" src="media/icons/Selenoid.svg"> Примеры видео выполнения тестов на Selenoid:

<img alt="BrowserStack video" src="media/gifs/wiki-selenoid.gif"> 