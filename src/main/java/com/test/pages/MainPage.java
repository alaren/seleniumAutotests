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

@Component("Main")
@Scope(SCOPE_PROTOTYPE)
public class MainPage implements Page{

    private WebDriver driver = DriverManager.getDriver();

    @FieldName("Logo")
    @FindBy(xpath = "//a[@href='/en-us/']")
    WebElement logo;

    @FieldName("Close popup")
    @FindBy(xpath = "//button[@aria-label='Close']")
    WebElement closePopup;

    @FieldName("Search button")
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement serachButton;

    @FieldName("Who We Serve")
    @FindBy(xpath = "//a[contains(text(), 'WHO WE SERVE')]")
    private WebElement whoWeServe;

    @FieldName("Subjects")
    @FindBy(xpath = "//a[contains(text(), 'SUBJECTS')]")
    private WebElement subjects;

    @FieldName("Droplist Subjects")
    @FindBy(xpath = "//div[@id='Level1NavNode2']//ul//li[@class='dropdown-item dropdown-submenu']")
    private List<WebElement> dropListSubjects;

    @FieldName("Droplist Education")
    @FindBy(xpath = "//a[@href='/en-us/Education-c-ED00']/following::div[1]//ul//ul//li")
    private List<WebElement> subDropListEducation;

    @FieldName("About")
    @FindBy(xpath = "//a[contains(text(), 'ABOUT')]")
    private WebElement about;

    @FieldName("Droplist Who We Serve")
    @FindBy(xpath = "//div[@id='Level1NavNode1']//ul//li[@class='dropdown-item ']")
    private List<WebElement> droplistWhoWeServe;

    @FieldName("Search field")
    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchField;

    @FieldName("Suggestion block")
    @FindBy(xpath = "//aside[contains(@class, 'ui-autocomplete')]")
    private WebElement suggestionsBlock;

    @FieldName("Suggestion list")
    @FindBy(xpath = "//div[@class='search-list']//div")
    private List<WebElement> suggestionsList;

    @FieldName("Product list")
    @FindBy(xpath = "//div[@class='related-content-products']//div")
    private List<WebElement> productList;

    public MainPage() {
        PageFactory.initElements(driver, this);
    }
}
