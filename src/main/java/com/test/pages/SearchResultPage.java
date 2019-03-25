package com.test.pages;

import com.test.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Component("Search result")
@Scope(SCOPE_PROTOTYPE)
public class SearchResultPage implements Page {

    private WebDriver driver = DriverManager.getDriver();

    @FieldName("Close popup")
    @FindBy(xpath = "//button[@aria-label='Close']")
    WebElement closePopup;

    @FieldName("Product title")
    @FindBy(xpath = "//h3[@class='product-title']")
    private List<WebElement> productTitles;

    public SearchResultPage() {
        PageFactory.initElements(driver, this);
    }
}
