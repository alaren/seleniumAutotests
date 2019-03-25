package com.test;

import com.test.Steps.Steps;
import com.test.pages.Page;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TestSteps {

	private Steps steps = new Steps();

	private WebDriver driver = Util.driver;

	private static HashMap<String, String> pages = new HashMap<String, String>();

	static {
		pages.put("https://www.wiley.com/en-us", "Main");
		pages.put("https://www.wiley.com/en-us/students", "Students");
		pages.put("https://www.wiley.com/en-us/subjects", "Subjects");
	}

	@When("^открыта главная страница")
	public void moveTo() throws Throwable {
		driver.get("https://www.wiley.com/en-us");
	}

	@When("^выполнено нажатие на кнопку '(.*)'")
	public void clickToElement(String name) throws Throwable {
		WebElement element = steps.getElementByNameAndPage(name, getPage());
		Util.clickOnElement(element, name);
	}

	@When("^ссылка '(.*)' отображается на странице")
	public void isElementVisible(String name) throws Throwable {
		WebElement element = steps.getElementByNameAndPage(name, getPage());
		Util.checkElementIsVisible(element, name);
	}

	@When("^выполнено нажатие на кнопку '(.*)' если она видима")
	public void clickOnElementIfVisible(String name) throws Throwable {
		WebElement element = steps.getElementByNameAndPage(name, getPage());
		steps.clickOnElementIfVisible(element, name);
	}

	@When("^выполнено нажатие на элемент выпадающего списка '(.*)' с текстом '(.*)'")
	public void clickOnElementIfVisible(String dropList, String item) throws Throwable {
		steps.clickOnElementInDropList(dropList, item, getPage());
	}

	@When("^выпадающий список '(.*)' содержит '(.*)' элементов")
	public void checkIfDroplistContainsNumberOfElements(String name, int number) throws Throwable {
		List<WebElement> elements = steps.getElementListByNameAndPage(name, getPage());
		steps.checkIsDroplistContainsNumberOfelements(elements, number);
	}

	@When("^подождать '(.*)' секунд")
	public void wait(int sec) throws Throwable {
		Util.wait(sec);
	}

	@When("^навести курсор на '(.*)'")
	public void moveToElement(String name) throws Throwable {
		WebElement element = steps.getElementByNameAndPage(name, getPage());
		Util.moveToElement(element);
	}

	@When("^навести курсор на элемент выпадающего списка '(.*)' с текстом '(.*)'")
	public void moveToElementInDropList(String dropList, String text) throws Throwable {
		List<WebElement> elements = steps.getElementListByNameAndPage(dropList, getPage());
		steps.moveToDropListElementByName(elements, text);
	}

	@When("^выпадающий список '(.*)' содержит следующие значения:")
	public void wait(String name, List<String> examples) throws Throwable {
		List<WebElement> elements = steps.getElementListByNameAndPage(name, getPage());
		for (String s:examples) {
			if (!isElementListContainsValue(elements, s)) {
				throw new AssertionError(String.format("Выпадающий список %s не содержит элемент %s", name, s));
			}
			System.out.println(String.format("Выпадающий список %s содержит элемент %s", name, s));
		}
	}

	@When("^ссылка '(.*)' содержит аттрибут '(.*)' со значением '(.*)'")
	public void moveToElement(String elementName, String attr, String attrValue) throws Throwable {
		WebElement element = steps.getElementByNameAndPage(elementName, getPage());
		steps.checkIfElementContainsAttributeWithValue(element, attr, attrValue);
	}

	@When("^текущий url равен '(.*)'")
	public void currentUrlIs(String url) throws Throwable {
		steps.checkCurrentUrl(url);
	}

	@When("^ввести в поле '(.*)' текст '(.*)'")
	public void sendTextToField(String fieldName, String text) throws Throwable {
		WebElement element = steps.getElementByNameAndPage(fieldName, getPage());
		steps.sendTextToField(element, text);
	}

	@When("^названия всех элементов в списке '(.*)' должны начинаться с '(.*)'")
	public void allElementsInListMustStartsFromText(String listName, String text) throws Throwable {
		List<WebElement> element = steps.getElementListByNameAndPage(listName, getPage());
		steps.checkAllElementsInListStartsWithText(element, text.toLowerCase());
	}

	@When("^названия всех элементов в списке '(.*)' должны содержать '(.*)'")
	public void allElementsInListMustContainText(String listName, String text) throws Throwable {
		List<WebElement> element = steps.getElementListByNameAndPage(listName, getPage());
		steps.checkAllElementsInListContainText(element, text.toLowerCase());
	}


	private Page getPage() {
		String pageName = pages.get(driver.getCurrentUrl());
		return steps.getPageByName(pageName);
	}

	private void clickOnElement(String name) {
		WebElement element = steps.getElementByNameAndPage(name, getPage());
		Util.checkElementIsVisible(element, name);
		element.click();
	}

	private boolean isElementListContainsValue(List<WebElement> list, String value) {
		for (WebElement e:list) {
			if (e.getText().equals(value)) {
				return true;
			}
		}
		return false;
	}
}
