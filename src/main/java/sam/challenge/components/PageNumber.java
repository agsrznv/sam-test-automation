package sam.challenge.components;

import org.openqa.selenium.WebElement;

public class PageNumber extends BaseComponent {

    public PageNumber(WebElement webElement) {
        super(webElement);
    }

    public boolean isClickable(String input) {
        return (isClassName(input) || isNumber(input)) && isNotCurrent();
    }

    private boolean isClassName(String className) {
        return webElement.getAttribute("class").contains(className);
    }

    private boolean isNumber(String number) {
        return webElement.getText().equals(number);
    }

    private boolean isNotCurrent() {
        return !webElement.getAttribute("class").contains("current");
    }
}