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

@Component("Subjects")
@Scope(SCOPE_PROTOTYPE)
public class SubjectsPage implements Page {

    private WebDriver driver = DriverManager.getDriver();

    @FieldName("Logo")
    @FindBy(xpath = "//a[@href='/en-us/']")
    private WebElement logo;

    @FieldName("Close popup")
    @FindBy(xpath = "//button[@aria-label='Close']")
    private WebElement closePopup;

    public SubjectsPage() {
        PageFactory.initElements(driver, this);
    }
}
