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

@Component("Step2")
@Scope(SCOPE_PROTOTYPE)
public class ProfileStep2Page implements Page {
    private WebDriver driver = DriverManager.getDriver();

    @FieldName("Серия паспорта")
    @FindBy(xpath = "//div[contains(@class, 'passport')]//input[@name='passportSeries']")
    private WebElement passportSer;

    @FieldName("Номер паспорта")
    @FindBy(xpath = "//div[contains(@class, 'passport')]//input[@name='passportNumber']")
    private WebElement passportNum;

    @FieldName("Серия номер ошибка")
    @FindBy(xpath = "//div[@class='passport__sub']")
    private WebElement passportSerNumError;

    @FieldName("Дата выдачи паспорта")
    @FindBy(xpath = "//input[@name='passportIssueDate']")
    private WebElement passportDate;

    @FieldName("Дата выдачи паспорта ошибка")
    @FindBy(xpath = "//span[contains(text(), 'Дата выдачи')]/following-sibling::span[@class='input__sub']//div")
    private WebElement passportDateError;

    @FieldName("Код подразделения")
    @FindBy(xpath = "//input[@name='passportOfficeCode']")
    private WebElement passportCode;

    @FieldName("Код подразделения ошибка")
    @FindBy(xpath = "//span[contains(text(), 'Код подразделения')]/following-sibling::span[@class='input__sub']//div")
    private WebElement passportCodeError;

    @FieldName("Кем выдан паспорт")
    @FindBy(xpath = "//textarea[@name='passportOffice']")
    private WebElement passportWho;

    @FieldName("Кем выдан паспорт ошибка")
    @FindBy(xpath = "//span[contains(text(), 'Кем выдан')]/following-sibling::span[@class='textarea__sub']//div")
    private WebElement passportWhoError;

    @FieldName("Дата рождения")
    @FindBy(xpath = "//input[@name='birthDate']")
    private WebElement dateBirth;

    @FieldName("Дата рождения ошибка")
    @FindBy(xpath = "//span[contains(text(), 'Дата рождения')]/following-sibling::span[@class='input__sub']//div")
    private WebElement dateBirthError;

    @FieldName("Место рождения")
    @FindBy(xpath = "//input[@name='passportBirthPlace']")
    private WebElement placeBirth;

    @FieldName("Место рождения ошибка")
    @FindBy(xpath = "//span[contains(text(), 'Место рождения')]/following-sibling::span[@class='input__sub']//div")
    private WebElement placeBirthError;

    @FieldName("Регион регистрации поле")
    @FindBy(xpath = "//input[@name='registrationRegionCode']")
    private WebElement regionRegistration;

    @FieldName("Регион регистрации ошибка")
    @FindBy(xpath = "//span[contains(text(), 'Регион регистрации')]/following-sibling::span[@class='input__sub']//div")
    private WebElement regionRegistrationError;

    @FieldName("Регион регистрации список")
    @FindBy(xpath = "//div[@class='popup__content']//div//div[contains(@class, 'menu-item')]")
    private List<WebElement> regionRegistrationList;

    @FieldName("Название организации")
    @FindBy(xpath = "//input[@name='workCompanyName']")
    private WebElement workName;

    @FieldName("Название организации ошибка")
    @FindBy(xpath = "//span[contains(text(), 'Название организации')]/following-sibling::span[@class='input__sub']//div")
    private WebElement workNameError;

    @FieldName("ИНН организации")
    @FindBy(xpath = "//input[@name='workInn']")
    private WebElement workInn;

    @FieldName("ИНН организации ошибка")
    @FindBy(xpath = "//span[contains(text(), 'ИНН организации')]/following-sibling::span[@class='input__sub']//div")
    private WebElement workInnError;

    @FieldName("Зарплата")
    @FindBy(xpath = "//input[@name='income']")
    private WebElement salary;

    @FieldName("Зарплата ошибка")
    @FindBy(xpath = "//span[contains(text(), 'Размер заработной')]/following-sibling::span[@class='input__sub']//div")
    private WebElement salaryError;

    @FieldName("Продолжить")
    @FindBy(xpath = "//button[@role='button']//span[@class='button__text']")
    private WebElement next;

    public ProfileStep2Page() {
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isPageLoaded() {
        return DriverManager.isPageLoaded(passportSer, driver);
    }
}
