package com.test.Steps;

import com.test.DriverManager;
import com.test.Util;
import com.test.SpringApp;
import com.test.pages.FieldName;
import com.test.pages.Page;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Component
public class Steps {

    public Page getPageByName(String name) {
        return (Page) SpringApp.getContext().getBean(name);
    }

    public WebElement getElementByNameAndPage(String name, Object page) {
        WebElement webElement = null;
        Class<?> validationClass = page.getClass();
        Field[] fields = validationClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.getType() == WebElement.class) {
                field.setAccessible(true);
                if (field.getAnnotation(FieldName.class).value().equals(name)) {
                    try {
                        webElement = (WebElement) field.get(page);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }

            }
        }
        return webElement;
    }

    public List<WebElement> getElementListByNameAndPage(String name, Object page) {
        List<WebElement> elements = new ArrayList<>();
        WebElement webElement = null;
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

    public void clickOnElementIfVisible(WebElement element, String name) {
        if (Util.isElementVisible(element)) {
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
        Util.moveToElement(element);
    }

    public void checkCurrentUrl(String url) {
        if (Util.driver.getCurrentUrl().equals(url)) {
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

    private boolean isElementContainsAttribute(WebElement element, String attr, String attrValue) {
        return element.getAttribute(attr).equals(attrValue);
    }

    private WebElement getElementFromListByText(List<WebElement> elements, String text) {
        for (WebElement e:elements) {
            System.out.println(e.getText());
            if (e.getText().contains(text)) {
                return e;
            }
        }
        return null;
    }
}
