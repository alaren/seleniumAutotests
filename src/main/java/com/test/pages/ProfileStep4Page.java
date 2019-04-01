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

@Component("Step4")
@Scope(SCOPE_PROTOTYPE)
public class ProfileStep4Page implements Page {
    private WebDriver driver = DriverManager.getDriver();

    private String tittle = "Step4";

    @FieldName("Есть ли кредиты да")
    @FindBy(xpath = "//div[h3[contains(text(), 'У вас есть кредиты в другом банке?')]]/following-sibling::div//button//span//span[contains(text(), 'Да')]")
    private WebElement otherCreditsYes;

    @FieldName("Рефинансирование да")
    @FindBy(xpath = "//div[contains(text(), 'Хотели бы вы объединить')]/following-sibling::div//button//span//span[contains(text(), 'Да')]")
    private WebElement refinanceYes;

    @FieldName("Название банка")
    @FindBy(xpath = "//input[@name='bank']")
    private WebElement bankName;

    @FieldName("Тип кредита поле")
    @FindBy(xpath = "//span[@class='select-button__text']//span[contains(text(), 'Тип кредита')]")
    private WebElement creditType;

    @FieldName("Тип кредита список")
    @FindBy(xpath = "//div[@data-for='title']//div[@class='popup__content']//div//div[contains(@class, 'menu-item')]")
    private List<WebElement> education;

    @FieldName("Сумма долга")
    @FindBy(xpath = "//input[@name='totalDebt']")
    private WebElement creditSum;

    @FieldName("Дата открытия")
    @FindBy(xpath = "//input[@name='contractConclusionDate']")
    private WebElement creditDate;

    @FieldName("Добавить")
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement add;

    @FieldName("Дополнительная сумма")
    @FindBy(xpath = "//input[@name='additionalAmount']")
    private WebElement moarMoney;

    @FieldName("Дата платежа поле")
    @FindBy(xpath = "//span[@class='select-button__text']//span[contains(text(), 'Предпочтительная дата платежа')]")
    private WebElement payDay;

    @FieldName("Дата платежа список")
    @FindBy(xpath = "//div[@data-for='paymentDay']//div[@class='popup__content']//div//div[contains(@class, 'menu-item')]")
    private List<WebElement> payDayList;

    @FieldName("Срок кредита")
    @FindBy(xpath = "//div[contains(text(), 'Срок кредита')]/following-sibling::div//span[@class='tag-button__text']")
    private List<WebElement> creditTerm;

    @FieldName("Продолжить")
    @FindBy(xpath = "//div[contains(@class, 'navigate')]//button[@role='button']//span[@class='button__text']")
    private WebElement next;

    public ProfileStep4Page() {
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isPageLoaded() {
        return DriverManager.isPageLoaded(otherCreditsYes, driver);
    }

    @Override
    public String getTittle() {
        return tittle;
    }
}
