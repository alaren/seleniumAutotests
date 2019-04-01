package com.test;

import com.test.Steps.Steps;
import com.test.pages.Page;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TestSteps {

	private Steps steps = new Steps();

	private static HashMap<String, String> pages = new HashMap<String, String>();

	static {
		pages.put("https://anketa.alfabank.ru/alfaform-refpil/step1", "Step1");
		pages.put("https://anketa.alfabank.ru/alfaform-refpil/step2", "Step2");
		pages.put("https://anketa.alfabank.ru/alfaform-refpil/step3", "Step3");
		pages.put("https://anketa.alfabank.ru/alfaform-refpil/step4", "Step4");
		pages.put("https://anketa.alfabank.ru/alfaform-refpil/step5", "Step10");
	}

	@When("^открыта анкета")
	public void moveTo() {
		steps.goToUrl("https://anketa.alfabank.ru/alfaform-refpil/step1");
	}

	@When("^страница загружена")
	public void isPageLoaded() {
		if (getPage().isPageLoaded()) {
			System.out.println("Cтраница загружена");
			System.out.println(getPage().getTittle());
		} else {
			throw new AssertionError("Страница не загружена");
		}

	}

	@When("^выполнено нажатие на элемент '(.*)'")
	public void clickToElement(String name) {
		WebElement element = steps.getElementByNameAndPage(name, getPage());
		steps.clickOnElement(element, name);
	}

	@When("^поле '(.*)' содержит текст '(.*)'")
	public void isElementVisible(String name, String text) {
		WebElement element = steps.getElementByNameAndPage(name, getPage());
		steps.checkElementContainsText(element, text);
	}

	@When("^элемент '(.*)' отображается на странице")
	public void isElementVisible(String name) {
		WebElement element = steps.getElementByNameAndPage(name, getPage());
		steps.checkElementIsVisible(element, name);
	}

	@When("^элемент '(.*)' не отображается на странице")
	public void isElementNotVisible(String name) {
		WebElement element = steps.getElementByNameAndPage(name, getPage());
		steps.checkElementIsNotVisible(element, name);
	}

	@When("^выполнено нажатие на элемент '(.*)' если он видим")
	public void clickOnElementIfVisible(String name) {
		WebElement element = steps.getElementByNameAndPage(name, getPage());
		steps.clickOnElementIfVisible(element, name);
	}

	@When("^выполнено нажатие на элемент списка '(.*)' с текстом '(.*)'")
	public void clickOnElementIfVisible(String dropList, String item) {
		steps.clickOnElementInDropList(dropList, item, getPage());
	}

	@When("^выполнено нажатие на '(.*)' элемент списка '(.*)'")
	public void clickOnElementInListByNumber(int item, String dropList) {
		steps.clickOnElementInDropListByNumber(dropList, item, getPage());
	}

	@When("^список '(.*)' содержит '(.*)' элемента")
	public void checkIfDroplistContainsNumberOfElements(String name, int number) {
		List<WebElement> elements = steps.getElementListByNameAndPage(name, getPage());
		steps.checkIsDroplistContainsNumberOfelements(elements, number);
	}

	@When("^подождать '(.*)' секунд")
	public void wait(int sec) {
		steps.wait(sec);
	}

	@When("^навести курсор на '(.*)'")
	public void moveToElement(String name) {
		WebElement element = steps.getElementByNameAndPage(name, getPage());
		steps.moveToElement(element);
	}

	@When("^навести курсор на элемент списка '(.*)' с текстом '(.*)'")
	public void moveToElementInDropList(String dropList, String text) {
		List<WebElement> elements = steps.getElementListByNameAndPage(dropList, getPage());
		steps.moveToDropListElementByName(elements, text);
	}

	@When("^список '(.*)' содержит следующие значения:")
	public void wait(String name, List<String> examples) {
		List<WebElement> elements = steps.getElementListByNameAndPage(name, getPage());
		for (String s:examples) {
			if (!steps.isElementListContainsValue(elements, s)) {
				throw new AssertionError(String.format("Выпадающий список %s не содержит элемент %s", name, s));
			}
			System.out.println(String.format("Выпадающий список %s содержит элемент %s", name, s));
		}
	}

	@When("^элемент '(.*)' содержит аттрибут '(.*)' со значением '(.*)'")
	public void moveToElement(String elementName, String attr, String attrValue) {
		WebElement element = steps.getElementByNameAndPage(elementName, getPage());
		steps.checkIfElementContainsAttributeWithValue(element, attr, attrValue);
	}

	@When("^текущий url равен '(.*)'")
	public void currentUrlIs(String url) {
		steps.checkCurrentUrl(url);
	}

	@When("^ввести в поле '(.*)' текст '(.*)'")
	public void sendTextToField(String fieldName, String text) {
		WebElement element = steps.getElementByNameAndPage(fieldName, getPage());
		steps.sendTextToField(element, text);
	}

	@When("^названия всех элементов в списке '(.*)' должны начинаться с '(.*)'")
	public void allElementsInListMustStartsFromText(String listName, String text) {
		List<WebElement> element = steps.getElementListByNameAndPage(listName, getPage());
		steps.checkAllElementsInListStartsWithText(element, text.toLowerCase());
	}

	@When("^названия всех элементов в списке '(.*)' должны содержать '(.*)'")
	public void allElementsInListMustContainText(String listName, String text) {
		List<WebElement> element = steps.getElementListByNameAndPage(listName, getPage());
		steps.checkAllElementsInListContainText(element, text.toLowerCase());
	}

	@When("^на странице представлено '(.*)' блоков '(.*)'")
	public void numberOfhtmlElementsVisible(int number, String blockName) {
		steps.numberOfBlockVisibleOnPage(blockName, number, getPage());
	}

    @When("^отправить GET запрос '(.*)'")
    public void sendGet(String url) {
        steps.sendGet(url);
    }

	@When("^создать файл '(.*)' и заполнить его '(.*)' значениями")
	public void createFile(String fileName, int nums) {
		steps.createFile(fileName, nums);
	}

	@When("^прочитать файл '(.*)' и вывести значения на экран")
	public void readFile(String fileName) {
		steps.readFile(fileName);
	}

	@When("^получить факториал числа '(.*)' и вывести значение на экран")
	public void getFactorial(int num) {
		steps.getFactorial(num);
	}

	@When("^debug")
	public void debug() {
		System.out.println();
	}




	private Page getPage() {
		String url = steps.getUrl();
		if (url.contains("search")){
			url = url.split("pq")[0];
		}
		return steps.getPageByName(pages.get(url));
	}
}
