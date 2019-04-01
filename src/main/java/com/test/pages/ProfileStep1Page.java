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

@Component("Step1")
@Scope(SCOPE_PROTOTYPE)
public class ProfileStep1Page implements Page {
    private WebDriver driver = DriverManager.getDriver();

    private String tittle = "Step1";

    @FieldName("Срок кредита")
    @FindBy(xpath = "//div[@class='top__info']//ul//li//p[contains(text(), 'Срок кредита')]/following::h4")
    private WebElement creditTerm;

    @FieldName("Сумма")
    @FindBy(xpath = "//div[@class='top__info']//ul//li//p[contains(text(), 'Сумма')]/following::h4")
    private WebElement sum;

    @FieldName("Решение по заявке")
    @FindBy(xpath = "//div[@class='top__info']//ul//li//p[contains(text(), 'Решение по заявке')]/following::h4")
    private WebElement acceptTime;

    @FieldName("Процентная ставка")
    @FindBy(xpath = "//div[@class='top__info']//ul//li//p[contains(text(), 'Процентная ставка')]/following::h4")
    private WebElement percent;

    @FieldName("Фамилия")
    @FindBy(xpath = "//span[contains(text(), 'Фамилия')]/following::span[1]//input")
    private WebElement surname;

    @FieldName("Фамилия ошибка")
    @FindBy(xpath = "//span[contains(text(), 'Фамилия')]/following::span[2]//div")
    private WebElement surnameError;

    @FieldName("Имя")
    @FindBy(xpath = "//span[contains(text(), 'Имя')]/following::span[1]//input")
    private WebElement name;

    @FieldName("Имя ошибка")
    @FindBy(xpath = "//span[contains(text(), 'Имя')]/following::span[2]//div")
    private WebElement nameError;

    @FieldName("Отчество")
    @FindBy(xpath = "//span[contains(text(), 'Отчество')]/following::span[1]//input")
    private WebElement patronymic;

    @FieldName("Отчество ошибка")
    @FindBy(xpath = "//span[contains(text(), 'Отчество')]/following::span[2]//div")
    private WebElement patronymicError;

    @FieldName("Мобильный телефон")
    @FindBy(xpath = "//span[contains(text(), 'Мобильный телефон')]/following::span[1]//input")
    private WebElement phone;

    @FieldName("Мобильный телефон ошибка")
    @FindBy(xpath = "//span[contains(text(), 'Мобильный телефон')]/following::span[2]//div")
    private WebElement phoneError;

    @FieldName("Электронная почта")
    @FindBy(xpath = "//span[contains(text(), 'Электронная почта')]/following::span[1]//input")
    private WebElement mail;

    @FieldName("Электронная почта ошибка")
    @FindBy(xpath = "//span[contains(text(), 'Электронная почта')]/following::span[2]//div")
    private WebElement mailError;

    @FieldName("Регион работы поле")
    @FindBy(xpath = "//span[contains(text(), 'Регион работы')]/following::span[1]//input")
    private WebElement workRegionsField;

    @FieldName("Регион работы ошибка")
    @FindBy(xpath = "//span[contains(text(), 'Регион работы')]/following::span[2]//div")
    private WebElement workRegionsFieldError;

    @FieldName("Регион работы список")
    @FindBy(xpath = "//div[@class='popup__content']//div//div[contains(@class, 'menu-item')]")
    private List<WebElement> workRegionsList;

    @FieldName("Условия направления заявления ссылка")
    @FindBy(xpath = "//div[contains(@class, 'info')]//p//a")
    private WebElement termsLink;

    @FieldName("Условия направления заявления блок")
    @FindBy(xpath = "//div[contains(@class, 'popup-wrapper__popup')]")
    private WebElement termsBlock;

    @FieldName("Условия направления заявления закрыть")
    @FindBy(xpath = "//div[contains(@class, 'popup-wrapper__popup')]//button")
    private WebElement termsBlockClose;

    @FieldName("Продолжить")
    @FindBy(xpath = "//button[@role='button']//span[@class='button__text']")
    private WebElement next;

    public ProfileStep1Page() {
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isPageLoaded() {
        return DriverManager.isPageLoaded(creditTerm, driver);
    }

    @Override
    public String getTittle() {
        return tittle;
    }
}
