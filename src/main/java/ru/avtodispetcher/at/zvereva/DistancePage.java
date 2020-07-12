package ru.avtodispetcher.at.zvereva;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DistancePage extends BaseActions {
    private static final By TITLE = By.cssSelector("h1#pageTitle");
    private static final By FROM_FIELD = By.cssSelector("#from_field_parent > input");
    private static final By TO_FIELD = By.cssSelector("#to_field_parent > input");
    private static final By SUBMIT_BUTTON = By.cssSelector(".submit_button > input");
    private static final By FUEL_RATE_FIELD = By.cssSelector("div.float_block:nth-child(1) > label > input");
    private static final By FUEL_PRICE_FIELD = By.cssSelector("div.float_block:nth-child(2) > label > input");

    public DistancePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Step("Расчет стоимости и дистанции из города {fromCity} в город {toCity},  " +
            "при расходе бензина {gasoline}, при стоимости бензина {gasolineCost}")
    public void calculateDistance(String fromCity,
                                  String toCity,
                                  Integer gasoline,
                                  Integer gasolineCost){
        type(fromCity,FROM_FIELD);
        type(toCity,TO_FIELD);
        scrollPage300();

        type(gasoline.toString(),FUEL_RATE_FIELD);
        type(gasolineCost.toString(),FUEL_PRICE_FIELD);
        click(SUBMIT_BUTTON);
    }
}
