package sam.challenge.components;

import org.openqa.selenium.WebElement;

public class SubmitButton extends BaseComponent {

    public SubmitButton(WebElement webElement) {
        super(webElement);
    }

    public boolean isEnabled() {
        return webElement.isEnabled();
    }
}
