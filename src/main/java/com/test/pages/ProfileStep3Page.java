package com.test.pages;

import com.test.DriverManager;
import com.test.main.FieldName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Component("Step3")
@Scope(SCOPE_PROTOTYPE)
public class ProfileStep3Page implements Page {
    private WebDriver driver = DriverManager.getDriver();

    private String tittle = "Step3";

    @FieldName("Дата устройства")
    @FindBy(xpath = "//input[@name='workStartDate']")
    private WebElement workFrom;

    @FieldName("Должность")
    @FindBy(xpath = "//input[@name='workPost']")
    private WebElement position;

    @FieldName("Должность список")
    @FindBy(xpath = "//div[@data-for='workPost']//div[@class='popup__content']//div//div[contains(@class, 'menu-item')]")
    private List<WebElement> positionList;

    @FieldName("Рабочий телефон")
    @FindBy(xpath = "//input[@name='workPhone']")
    private WebElement workPhone;

    @FieldName("Образование поле")
    @FindBy(xpath = "//span[@class='select-button__text']//span[contains(text(), 'Образование')]")
    private WebElement education;

    @FieldName("Образование список")
    @FindBy(xpath = "//div[@data-for='education']//div[@class='popup__content']//div//div[contains(@class, 'menu-item')]")
    private List<WebElement> educationList;

    @FieldName("Семейное положение поле")
    @FindBy(xpath = "//span[@class='select-button__text']//span[contains(text(), 'Укажите')]")
    private WebElement family;

    @FieldName("Семейное положение список")
    @FindBy(xpath = "//div[@data-for='maritalStatus']//div[@class='popup__content']//div//div[contains(@class, 'menu-item')]")
    private List<WebElement> familyList;

    @FieldName("Кем приходится контактное лицо поле")
    @FindBy(xpath = "//span[@class='select-button__text']//span[contains(text(), 'Кем вам')]")
    private WebElement contact;

    @FieldName("Кем приходится контактное лицо список")
    @FindBy(xpath = "//div[@data-for='contactType']//div[@class='popup__content']//div//div[contains(@class, 'menu-item')]")
    private List<WebElement> contactList;

    @FieldName("Фамилия контакта")
    @FindBy(xpath = "//input[@name='contactLastName']")
    private WebElement contactLastName;

    @FieldName("Имя контакта")
    @FindBy(xpath = "//input[@name='contactFirstName']")
    private WebElement contactName;

    @FieldName("Отчество контакта")
    @FindBy(xpath = "//input[@name='contactMiddleName']")
    private WebElement contactPatronymic;

    @FieldName("Телефон контакта")
    @FindBy(xpath = "//input[@name='contactMobilePhone']")
    private WebElement contactPhone;

    @FieldName("Продолжить")
    @FindBy(xpath = "//button[@role='button']//span[@class='button__text']")
    private WebElement next;

    public ProfileStep3Page() {
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isPageLoaded() {
        return DriverManager.isPageLoaded(workFrom, driver);
    }

    @Override
    public String getTittle() {
        return tittle;
    }
}
