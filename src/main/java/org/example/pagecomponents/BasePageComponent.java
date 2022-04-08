package org.example.pagecomponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePageComponent {

    protected WebDriver driver;

    public BasePageComponent(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
