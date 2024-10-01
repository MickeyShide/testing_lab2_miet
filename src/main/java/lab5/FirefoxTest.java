package lab5;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.concurrent.*;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FirefoxTest {
    private static final WebDriver driver = new FirefoxDriver();

    @SuppressWarnings("deprecation")
    @BeforeClass
    public static void setup() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://miet.ru/");
    }

    @AfterClass
    public static void logOut() {
        driver.quit();
    }

    @Test
    public void searchBarInputTest() {
        driver.get("https://miet.ru/search");
//-------------------------------------------------------------------------
        assertDoesNotThrow(() -> {
            WebElement searchBarInput = driver.findElement(By.className("search-bar__input"));
            searchBarInput.sendKeys("dzkfmgdfsg");
            searchBarInput.sendKeys(Keys.ENTER);
        });
//-------------------------------------------------------------------------
        assertThrows(NoSuchElementException.class,
                () -> {
                    driver.get("https://miet.ru/search?q=dzkfmgdfsg");
                    driver.findElement(By.className("result-list__news"));
                });
//-------------------------------------------------------------------------
        driver.get("https://miet.ru/search");
        assertDoesNotThrow(() -> {
            WebElement searchBarInput = driver.findElement(By.className("search-bar__input"));
            searchBarInput.sendKeys("Кожухов");
            searchBarInput.sendKeys(Keys.ENTER);
        });
//-------------------------------------------------------------------------
        driver.get("https://miet.ru/search?q=Кожухов");
        assertDoesNotThrow(() -> {
            driver.findElement(By.className("result-list__news"));
        });
//-------------------------------------------------------------------------
        boolean inEmpty = false;
        List<WebElement> divElements = driver.findElements(By.cssSelector("div.news-list__item-title"));
        for (WebElement div : divElements) {
            String text = div.getText();
            if (!text.isEmpty()) {
                System.out.println("Element with text found: " + text);
            } else {
                System.out.println("Element without text found");
                inEmpty = true;
            }
        }
        Assert.assertFalse(inEmpty);
//-------------------------------------------------------------------------
        assertDoesNotThrow(() -> {
            driver.findElement(By.linkText("Люди")).click();
        });
//-------------------------------------------------------------------------
        assertDoesNotThrow(() -> {
            driver.findElement(By.linkText("Кожухов Игорь Борисович")).click();
        });
//-------------------------------------------------------------------------
    }

    @Test
    public void doUserLogin() {
        assertDoesNotThrow(() -> {
            driver.get("https://miet.ru/");
            WebElement loginButton = driver.findElement(By.cssSelector(".header-nav__list-additional__container.link"));
            loginButton.click();
            driver.get("https://account.miet.ru/login?backurl=https%3A%2F%2Fmiet.ru");
            WebElement loginField = driver.findElement(By.id("inputLogin"));
            loginField.sendKeys("ЛОГИН");
            WebElement passwordField = driver.findElement(By.id("inputPassword"));
            passwordField.sendKeys("ПАРОЛЬ");
            loginButton = driver.findElement(By.cssSelector(".button.blue.big-padding"));
            loginButton.click();
        });
        assertThrows(NoSuchElementException.class,
                () -> {
                    driver.get("https://miet.ru/");
                    driver.findElement(By.cssSelector(".header-nav__list-additional__container.link"));
                });
    }
}