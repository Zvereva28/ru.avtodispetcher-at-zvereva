package ru.avtodispetcher.at.zvereva;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DistanceFromToPage extends BaseActions{
    private static final By DISTANCE_INFORM = By.cssSelector("#totalDistance");
    private static final By TIME_INFORM = By.cssSelector("#totalTime");
    private static final By ALL_INFORM = By.cssSelector("#summaryContainer > form > p");
    private static final By CHANGE_ROUT_BUTTON = By.cssSelector("#triggerFormD > span");
    private static final By ADD_CITY_FIELD = By.cssSelector("#inter_points_field_parent > input");
    private static final By SUBMIT_BUTTON = By.cssSelector(".submit_button > input");

    //

    public DistanceFromToPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String readAllInform(){
       return driver.findElement(ALL_INFORM).getText();
    }

    public int costInform(){
        String[] allInf = driver.findElement(ALL_INFORM).getText().split(" ");
        return Integer.parseInt(allInf[allInf.length - 2]);
    }

    public boolean checkCostInform(int waitingCost){
        return costInform()== waitingCost;
    }

    public void clickChangeRoutButton(){
        click(CHANGE_ROUT_BUTTON);
    }

    public void addCityToRout(String cityName){
        scrollPage300();
        clickChangeRoutButton();
        type(cityName,ADD_CITY_FIELD);
        scrollPage300();
        click(SUBMIT_BUTTON);
        waitABit(5);

    }




}
