package com.test;

import com.test.Steps.Steps;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Util {

    private static Steps steps = new Steps();

    public static WebDriver driver;

    public static void checkElementIsVisible(WebElement element, String name) {
        if (isElementVisible(element)) {
            System.out.println(String.format("Элемент %s отображается на странице", name));
        } else {
            throw new AssertionError(String.format("Элемент %s не отображается на странице", name));
        }

    }

    public static void clickOnElement(WebElement element, String name) {
        checkElementIsVisible(element, name);
        element.click();
        System.out.println(String.format("Выпоглнено нажатие на %s", name));
    }

    public static boolean isElementVisible(WebElement element) {
        boolean result = false;
        try {
            result = element.isDisplayed();
        } catch (NoSuchElementException e) {
            //Если элемента нет, то он определённо не видим
        }
        return result;
    }

    public static void wait(int sec) {
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void moveToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }
}
