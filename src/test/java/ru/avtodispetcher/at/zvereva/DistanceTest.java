package ru.avtodispetcher.at.zvereva;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

@DisplayName("Расчет растояния между городами")
public class DistanceTest extends BaseTest {
    public static Stream<Arguments> dataForTest1() {
        return Stream.of(
                Arguments.of("расчет расстояний между городами",
                        "https://www.avtodispetcher.ru/distance/",
                        "Расчет расстояний между городами",
                        "Тула",
                        "Санкт-Петербург",
                        9,
                        46,
                        897,
                        3726,
                        "Великий Новгород",
                        966,
                        4002),
                Arguments.of("расчет расстояний между городами",
                        "https://www.avtodispetcher.ru/distance/",
                        "Расчет расстояний между городами",
                        "Волгоград",
                        "Калининград",
                        1,
                        999,
                        2180,
                        21978,
                        "Москва",
                        2251,
                        22977),
                Arguments.of("расчет расстояний между городами",
                        "https://www.avtodispetcher.ru/distance/",
                        "Расчет расстояний между городами",
                        "Краков",
                        "Саранск",
                        999,
                        1,
                        2120,
                        21179,
                        "Калининград",
                        2624,
                        26214)
        );
    }

    @Description(value = "1 Пользователь заходит на сайт Яндекс: www . yandex . ru <br>" +
            "2 Вводит в поисковую строку фразу «расчет расстояний между городами» и запускает поиск<br>" +
            "3 Среди результатов поиска пользователь ищет результат с сайта «avtodispetcher.ru»<br>" +
            "4 Найдя нужный результат с этого сайта – пользовать кликает на данном результате и переходит на сайт www.avtodispetcher.ru/distance/<br>" +
            "5 Убедившись, что открылась верная ссылка, пользователь вводит следующие значения в поля:<br>" +
            "a. Поле «Откуда» - город (1)<br>" +
            "b. Поле «Куда» - город (2)<br>" +
            "c. Поле «Расход топлива» <br>" +
            "d. Поле «Цена топлива» <br>" +
            "6. Пользователь нажимает кнопку «Рассчитать»<br>" +
            "7. Пользователь проверяет что рассчитанное расстояние и стоимость топлива <br>" +
            "соответствуют ожидаемым<br>" +
            "8 Пользователь кликает на «Изменить маршрут»<br>" +
            "9 В открывшейся форме в поле «Через города» вводит название города(3)<br>" +
            "10 Ждет минуту и снова нажимает «Рассчитать»<br>" +
            "11 Пользователь проверяет что расстояние и стоимость топлива соответствуют ожидаемым")

    @ParameterizedTest(name = "Расчет растояния между городами  с добавлением города (позитив)")
    @MethodSource("dataForTest1")
    public void positiveTest1(String textSearch,
                              String waitingURL,
                              String waitingTitle,
                              String fromCity,
                              String toCity,
                              int gasoline,
                              int gasolineCost,
                              int waitingDistance1,
                              int waitingCoast1,
                              String cityName,
                              int waitingDistance2,
                              int waitingCoast2) {
        yandexPage.home();
        yandexPage.startSearch(textSearch);
        yandexPage.goToAvtodispetcher();
        Assertions.assertTrue(distancePage.checkURL(waitingURL),
                "URL страницы не соответствует ожидаемому - " + waitingURL);
        Assertions.assertTrue(distancePage.checkTitle(waitingTitle),
                "Загаловок страницы" + waitingTitle + "  не найден");
        distancePage.calculateDistance(fromCity, toCity, gasoline, gasolineCost);
        Assertions.assertTrue(distanceFromToPage.checkDistanceInform(waitingDistance1),
                "Расстояние не соответствует ожидаемому");
        Assertions.assertTrue(distanceFromToPage.checkCostInform(waitingCoast1),
                "Стоимость топлива не сооответствует ожидаемой");
        distanceFromToPage.addCityToRout(cityName);
        Assertions.assertTrue(distanceFromToPage.checkCostInform(waitingCoast2),
                "Стоимость топлива не сооответствует ожидаемой");
        Assertions.assertTrue(distanceFromToPage.checkDistanceInform(waitingDistance2),
                "Расстояние не соответствует ожидаемому");
    }
}
