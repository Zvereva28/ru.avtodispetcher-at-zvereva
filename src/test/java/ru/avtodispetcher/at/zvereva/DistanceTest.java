package ru.avtodispetcher.at.zvereva;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class DistanceTest extends BaseTest {
    @DisplayName("Расчет растояния между городами с добавлением города (позитив)")
    @ParameterizedTest
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
                              int waitingCoast2){
        yandexPage.home();
        yandexPage.startSearch(textSearch);
        yandexPage.goToAvtodispetcher();
        distancePage.checkURL(waitingURL);
        Assertions.assertTrue(distancePage.checkTitle(waitingTitle),
                "Загаловок страницы" + waitingTitle + "не найден");
        distancePage.calculateDistance(fromCity,toCity, gasoline, gasolineCost);
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

    public static Stream<Arguments> dataForTest1(){
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
}
