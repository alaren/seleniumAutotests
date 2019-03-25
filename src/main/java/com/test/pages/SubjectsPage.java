package com.test.pages;

import com.test.Util;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

@Component("Subjects")
public class SubjectsPage extends AbstractPage implements Page {

    @FieldName("Logo")
    @FindBy(xpath = "//a[@href='/en-us/']")
    private WebElement logo;

    @FieldName("Close popup")
    @FindBy(xpath = "//button[@aria-label='Close']")
    private WebElement closePopup;

    public SubjectsPage() {
        PageFactory.initElements(Util.driver, this);
    }
}
