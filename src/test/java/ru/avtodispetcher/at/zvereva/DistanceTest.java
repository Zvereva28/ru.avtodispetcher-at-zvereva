package ru.avtodispetcher.at.zvereva;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.sql.Driver;

public class DistanceTest extends BaseTest {
    @DisplayName("Расчет растояния с изменениями (позитив)")
    @Test
    public void positiveTest1(){
        yandexPage.home();
        yandexPage.startSearch("расчет расстояний между городами");
        yandexPage.goToAvtodispetcher();
        Assertions.assertTrue(distancePage.checkTitlePage("Расстояние между городами"),
                "Загаловок страницы" + "Расстояние между городами" + "не найден");
        //driver.get("https://www.avtodispetcher.ru/distance/");
        distancePage.calculateDistance("Тула","Санкт-Петербург");
        System.out.println(distanceFromToPage.readAllInform());
        System.out.println(distanceFromToPage.costInform());
        Assertions.assertTrue(distanceFromToPage.checkCostInform(3726),
                "Стоимость топлива не сооответствует ожидаемой");
        distanceFromToPage.addCityToRout("Великий Новгород");





    }
}
