package sam.challenge.components;

import org.openqa.selenium.WebElement;

public class BaseComponent {
    protected WebElement webElement;

    public BaseComponent(WebElement webElement) {
        this.webElement = webElement;
    }

    public void click() {
        webElement.click();
    }
}
