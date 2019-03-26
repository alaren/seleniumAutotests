package com.test.pages;

import com.test.DriverManager;
import com.test.main.FieldName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Component("Education")
@Scope(SCOPE_PROTOTYPE)
public class EducationPage implements Page {

    private WebDriver driver = DriverManager.getDriver();

    @FieldName("Students header")
    @FindBy(xpath = "//li[contains(@class, 'active') and contains(text(), 'Students')]")
    WebElement studentsHeader;

    @FieldName("Be Your Best")
    @FindBy(xpath = "//a[contains(@href, 'nextgen')]")
    WebElement beYourBestLM;

    @FieldName("Be Inquisitive")
    @FindBy(xpath = "//a[contains(@href, 'success-programs')]")
    WebElement beInquisitiveLM;

    @FieldName("Be Smart")
    @FindBy(xpath = "//a[@href='https://www.wileyplus.com/']")
    WebElement beSmartLM;

    @FieldName("Close popup")
    @FindBy(xpath = "//button[@aria-label='Close']")
    private WebElement closePopup;

    public EducationPage() {
        PageFactory.initElements(driver, this);
    }
}
