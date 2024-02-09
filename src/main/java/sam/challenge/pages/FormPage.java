package sam.challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import sam.challenge.components.SubmitButton;

public class FormPage extends BasePage {

    public FormPage(WebDriver webDriver) {
        super(webDriver);
    }

    public SubmitButton getSubmitButton() {
        return new SubmitButton(webDriver.findElement(By.className("wpcf7-submit")));
    }
}
