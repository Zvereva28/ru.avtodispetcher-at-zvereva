package ru.avtodispetcher.at.zvereva;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class BaseActions {
    WebDriver driver;
    WebDriverWait wait;

    public BaseActions(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void type(String text, By by) {
        if (isElementPresent(by)) {
            WebElement element = driver.findElement(by);
            element.clear();
            element.sendKeys(text);}
        else System.out.println("элемент " + by.toString() + " не найден");
    }

    public void click(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(by))).click();
    }
    public static void waitABit(int sec) {
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void changeWindow(){
        String s = driver.getWindowHandle();
        for (String tab : driver.getWindowHandles()) {
            if (!(s.equals(tab))) {
                driver.switchTo().window(tab);
                break;
            }
        }
    }

    public boolean isElementPresent(By by) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public void scrollPage300() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 300)");
    }
    @Step("Проверка загруски страницы - {waitingURL}")
    public boolean checkURL(String waitingURL){
        return driver.getCurrentUrl().equals(waitingURL);
    }

    @Step("Проверка заголовка страницы - {waitingTitle}")
    public boolean checkTitle(String waitingTitle){
        return driver.getTitle().toLowerCase().equals(waitingTitle.toLowerCase());
    }
}
