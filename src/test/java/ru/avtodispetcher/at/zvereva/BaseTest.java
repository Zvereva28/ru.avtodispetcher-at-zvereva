package ru.avtodispetcher.at.zvereva;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;
    protected WebDriverWait wait;
    protected YandexPage yandexPage;
    protected DistancePage distancePage;
    protected DistanceFromToPage distanceFromToPage;


    @BeforeEach
    public void init() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);

        wait = new WebDriverWait(driver, 3);
        yandexPage = new YandexPage(driver, wait);
        distancePage = new DistancePage(driver, wait);
        distanceFromToPage = new DistanceFromToPage(driver, wait);

    }

    @AfterEach
    public void shutdown() {
        driver.quit();
    }
}
