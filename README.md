# ru.avtodispetcher-at-zvereva
# Проект автоматизации тестирования сайта avtodispetcher.ru

Домашнее задание на позицию QA Automation

# Чтобы запустить тесты и просмотреть отчет соберите проект командой:

```mvn
mvn clean test allure:serve
```

# Библиотеки:

 - selenium-java
 
 - junit-jupiter
  
 - allure-junit5


# Сценарий для автоматизации:

    1. Пользователь заходит на сайт Яндекс: www . yandex . ru
    2. Вводит в поисковую строку фразу «расчет расстояний между городами» и запускает поиск
    3. Среди результатов поиска пользователь ищет результат с сайта «avtodispetcher.ru»
    4.Найдя нужный результат с этого сайта – пользовать кликает на данном результате и переходит на сайт www.avtodispetcher.ru/distance/
    5.Убедившись, что открылась верная ссылка, пользователь вводит следующие значения в поля:
    a.Поле «Откуда» - «Тула»
    b.Поле «Куда» - «Санкт-Петербург»
    c.Поле «Расход топлива» - «9»
    d.Поле «Цена топлива» - «46»
    6.Пользователь нажимает кнопку «Рассчитать»
    7.Пользователь проверяет что рассчитанное расстояние = 897 км, а стоимость топлива = 3726 руб.
    8.Пользователь кликает на «Изменить маршрут»
    9.В открывшейся форме в поле «Через города» вводит «Великий Новгород»
    10.Ждет минуту и снова нажимает «Рассчитать»
    11.Пользователь проверяет что расстояние теперь = 966 км, а стоимость топлива = 4002 руб.
