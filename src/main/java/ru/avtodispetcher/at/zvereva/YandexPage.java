package ru.avtodispetcher.at.zvereva;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexPage extends BaseActions {
    private static final String YANDEX_URL = "https://yandex.ru/";
    private static final By SEARCH_FIELD = By.cssSelector("#text");
    private static final By SEARCH_BUTTON = By.cssSelector(".mini-suggest__button");
    private static final By AVTODISPETCHER = By.partialLinkText("avtodispetcher.ru");

    public YandexPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void home() {
        driver.get(YANDEX_URL);
    }

    @Step("Поиск через Yandex запрос - {textSearch}")
    public void startSearch(String textSearch) {
        type(textSearch, SEARCH_FIELD);
        click(SEARCH_BUTTON);
    }

    @Step("Переход на сайт автодиспетчер")
    public void goToAvtodispetcher() {
        click(AVTODISPETCHER);
        changeWindow();
    }

}
