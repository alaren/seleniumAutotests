package com.test.Steps;

import com.test.DriverManager;
import com.test.spring.SpringApp;
import com.test.main.FieldName;
import com.test.pages.Page;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Steps {

    private WebDriver driver = DriverManager.getDriver();

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void goToUrl(String url) {
        driver.get(url);
    }

    public Page getPageByName(String name) {
        return (Page) SpringApp.getContext().getBean(name);
    }

    public WebElement getElementByNameAndPage(String name, Object page) {
        return getWebElementFromObject(page, name);
    }

    public List<WebElement> getElementListByNameAndPage(String name, Object page) {
        List<WebElement> elements = new ArrayList<>();
        Class<?> validationClass = page.getClass();
        Field[] fields = validationClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.getType() == List.class) {
                field.setAccessible(true);
                if (field.getAnnotation(FieldName.class).value().equals(name)) {
                    try {
                        elements = (List<WebElement>) field.get(page);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return elements;
    }

    public List<HtmlElement> getHtmlElementListByNameAndPage(String name, Object page) {
        List<HtmlElement> elements = new ArrayList<>();
        Class<?> validationClass = page.getClass();
        Field[] fields = validationClass.getDeclaredFields();
        for (Field field:fields) {
            if (field.getType() == List.class) {
                field.setAccessible(true);
                if (field.getAnnotation(FieldName.class).value().equals(name)) {
                    try {
                        elements = (List<HtmlElement>) field.get(page);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return elements;
    }

    public void openUrl(String url) {

    }

    public WebElement getWebElementFromHtmlElement(HtmlElement element, String name) {
        return getWebElementFromObject(element, name);
    }

    public void clickOnElementIfVisible(WebElement element, String name) {
        if (isElementVisible(element)) {
            element.click();
            System.out.println(String.format("Выполнено нажатие на %s", name));
        } else {
            System.out.println(String.format("Элемент %s не видим", name));
        }
    }

    public void checkIsDroplistContainsNumberOfelements(List<WebElement> drooplist, int number) {
        if (drooplist.size() == number) {
            System.out.println(String.format("Количество элементов в списке равно %s", number));
        } else {
            throw new AssertionError(String.format("Количество элементов в списке не равно %s. \n текущее значение: %s", number, drooplist.size()));
        }
    }

    public void clickOnElementInDropList(String dropList, String item, Page page) {
        List<WebElement> elements = getElementListByNameAndPage(dropList, page);
        waitOfElementList(elements);
        for (WebElement e:elements) {
            if (e.getText().equals(item)) {
                e.click();
                return;
            }
            throw new AssertionError(String.format("В выпадающем списке %s не найдет элемент с текстом %s", dropList, item));
        }
    }

    public void checkIfElementContainsAttributeWithValue(WebElement element, String attr, String attrValue) {
        if (isElementContainsAttribute(element, attr, attrValue)) {
            System.out.println(String.format("Элемент %s содержит аттрибут %s со значением %s", element.getText(), attr, attrValue));
        } else {
            throw new AssertionError(String.format("Элемент %s не содержит аттрибут %s со значением %s", element.getText(), attr, attrValue));
        }
    }

    public void moveToDropListElementByName(List<WebElement> elements, String name) {
        WebElement element = getElementFromListByText(elements, name);
        if (element == null) {
            throw new AssertionError(String.format("В выпадающем списке не найден эллемент с текстом %s", name));
        }
        moveToElement(element);
    }

    public void checkCurrentUrl(String url) {
        if (driver.getCurrentUrl().equals(url)) {
            System.out.println(String.format("Текущий url равен %s", url));
        } else {
            throw new AssertionError(String.format("Текущий url не равен %s", url));
        }
    }

    public void sendTextToField(WebElement field, String text) {
        field.sendKeys(text);
    }

    public void checkAllElementsInListStartsWithText(List<WebElement> list, String text) {
        for (WebElement e:list) {
            if (!isElementTextStartsWithText(e, text)) {
                throw new AssertionError(String.format("Текст элемента %s не начинается с %s", e.getText(), text));
            }
        }
        System.out.println(String.format("Все элементы в списке начинаются с текста %s", text));
    }

    public void checkAllElementsInListContainText(List<WebElement> list, String text) {
        for (WebElement e:list) {
            if (!e.getText().toLowerCase().contains(text)) {
                throw new AssertionError(String.format("Текст элемента %s не содержит текст %s", e.getText(), text));
            }
        }
        System.out.println(String.format("Все элементы в списке содержат текст %s", text));
    }

    public void numberOfBlockVisibleOnPage(String blockName, int number, Page page) {
        if (getHtmlElementListByNameAndPage(blockName, page).size() != number) {
            throw new AssertionError(String.format("На странице не представлено %s блоков %s", number, blockName));
        } else {
            System.out.println(String.format("На странице представлено %s блоков %s", number, blockName));
        }
    }

    private boolean isElementTextStartsWithText(WebElement element, String text) {
        char[] elementText = element.getText().toLowerCase().toCharArray();
        char[] sendetText = text.toLowerCase().toCharArray();
        for (int i = 0; i < sendetText.length-1; i++) {
            if (elementText[i] != sendetText[i]) {
                return false;
            }
        }
        return true;
    }

    public void moveToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    public void checkElementIsClickable(WebElement element, String name) {
        try {
            element.click();
        } catch (WebDriverException e) {
            wait(5);
            try {
                element.click();
            } catch (WebDriverException e1) {
                throw new AssertionError(String.format("Эллемент %s не доступен для клика", name));
            }
        }
    }

    public void checkElementIsVisible(WebElement element, String name) {
        if (isElementVisible(element)) {
            System.out.println(String.format("Элемент %s отображается на странице", name));
        } else {
            WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
            webDriverWait.until(ExpectedConditions.visibilityOf(element));
            if (!isElementVisible(element)) {
                throw new AssertionError(String.format("Элемент %s не отображается на странице", name));
            }
        }
    }

    public void clickOnElement(WebElement element, String name) {
        checkElementIsVisible(element, name);
        checkElementIsClickable(element, name);
        System.out.println(String.format("Выпоглнено нажатие на %s", name));
    }

    public boolean isElementVisible(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            //Если элемента нет, то он определённо не видим
        }
        return false;
    }

    public void wait(int sec) {
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isElementListContainsValue(List<WebElement> list, String value) {
        for (WebElement e:list) {
            checkElementIsVisible(e, e.getText());
            if (e.getText().equals(value)) {
                return true;
            }
        }
        return false;
    }

    public void sendGet(String urlStr) {
        try {
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int code = connection.getResponseCode();
            System.out.println(String.format("Запрос %s отправлен. \n Код ответа: %s", urlStr, code));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private boolean isElementContainsAttribute(WebElement element, String attr, String attrValue) {
        return element.getAttribute(attr).equals(attrValue);
    }

    private WebElement getElementFromListByText(List<WebElement> elements, String text) {
        waitOfElementList(elements);
        for (WebElement e:elements) {
            System.out.println(e.getText());
            if (e.getText().contains(text)) {
                return e;
            }
        }
        return null;
    }

    private WebElement getWebElementFromObject(Object object, String name) {
        WebElement webElement = null;
        Class<?> validationClass = object.getClass();
        Field[] fields = validationClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.getType() == WebElement.class) {
                field.setAccessible(true);
                if (field.getAnnotation(FieldName.class).value().equals(name)) {
                    try {
                        webElement = (WebElement) field.get(object);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }

            }
        }
        return webElement;
    }

    private void waitOfElementList(List<WebElement> elements) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        try {
            webDriverWait.until(ExpectedConditions.visibilityOfAllElements(elements));
        } catch (TimeoutException e) {

        }
    }
}
