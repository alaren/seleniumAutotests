package com.test.pages;

import com.test.Util;
import org.apache.commons.logging.impl.AvalonLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

@Component("Education")
public class EducationPage extends AbstractPage implements Page {

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
        PageFactory.initElements(Util.driver, this);
    }
}
