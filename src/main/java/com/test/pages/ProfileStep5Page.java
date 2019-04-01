package com.test.pages;

import com.test.DriverManager;
import com.test.main.FieldName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Component("Step10")
@Scope(SCOPE_PROTOTYPE)
public class ProfileStep5Page implements Page {
    private WebDriver driver = DriverManager.getDriver();

    private String tittle = "Step5";

    @FieldName("Второй документ поле")
    @FindBy(xpath = "//span[@class='select-button__text']//span[contains(text(), 'Второй документ')]")
    private WebElement document;

    @FieldName("Второй документ список")
    @FindBy(xpath = "//div[@data-for='secondaryDocument']//div[@class='popup__content']//div//div[contains(@class, 'menu-item')]")
    private List<WebElement> documentList;

    @FieldName("Доп документ поле")
    @FindBy(xpath = "//span[@class='select-button__text']//span[contains(text(), 'Дополнительный документ')]")
    private WebElement documentSecond;

    @FieldName("Доп документ список")
    @FindBy(xpath = "//div[@data-for='secondaryDocument']//div[@class='popup__content']//div//div[contains(@class, 'menu-item')]")
    private List<WebElement> documentSecondList;

    @FieldName("Справка о доходах поле")
    @FindBy(xpath = "//span[@class='select-button__text']//span[contains(text(), 'подтверждающий доход')]")
    private WebElement confirm;

    @FieldName("Справка о доходах список")
    @FindBy(xpath = "//div[@data-for='salaryDocument']//div[@class='popup__content']//div//div[contains(@class, 'menu-item')]")
    private List<WebElement> confirmList;

    @FieldName("Дополнительный доход да")
    @FindBy(xpath = "//div[contains(text(), 'У вас есть дополнительный доход')]/following-sibling::div//button//span//span[contains(text(), 'Да')]")
    private WebElement extraSalary;

    @FieldName("Размер доп дохода")
    @FindBy(xpath = "//input[@name='additionalIncome']")
    private WebElement extraSalarySum;

    @FieldName("Источник доп дохода поле")
    @FindBy(xpath = "//span[@class='select-button__text']//span[contains(text(), 'Источник дополнительного дохода')]")
    private WebElement extraSalarySource;

    @FieldName("Источник доп дохода список")
    @FindBy(xpath = "//div[@data-for='additionalIncomeType']//div[@class='popup__content']//div//div[contains(@class, 'menu-item')]")
    private List<WebElement> extraSalarySourceList;

    @FieldName("Вы получаете пенсию да")
    @FindBy(xpath = "//div[contains(text(), 'Вы получаете пенсию')]/following-sibling::div//button//span//span[contains(text(), 'Да')]")
    private WebElement pensionYes;

    @FieldName("Размер пенсии")
    @FindBy(xpath = "//input[@name='incomePension']")
    private WebElement pensionSum;

    @FieldName("Кодовое слово")
    @FindBy(xpath = "//input[@name='codeWord']")
    private WebElement codeWord;

    @FieldName("Отправить заявку")
    @FindBy(xpath = "//button[@role='button']//span[@class='button__text']")
    private WebElement next;

    @FieldName("Введите код из смс")
    @FindBy(xpath = "//div[@class='confirmation-modal__body']//div//h4")
    private WebElement smsCode;

    public ProfileStep5Page() {
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isPageLoaded() {
        System.out.println("lol");
        return DriverManager.isPageLoaded(confirm, driver);
    }

    @Override
    public String getTittle() {
        return tittle;
    }
}
