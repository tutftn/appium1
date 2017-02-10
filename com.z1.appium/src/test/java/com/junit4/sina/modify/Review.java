package com.junit4.sina.modify;

import org.openqa.selenium.WebElement;

import io.appium.java_client.pagefactory.Widget;

public abstract class Review extends Widget {

    protected Review(WebElement element) {
        super(element);
    }

    public abstract String title();

    public abstract String score();

    public abstract String info();

    public abstract Object getPoster();
}
