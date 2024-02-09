package sam.challenge.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Article extends BaseComponent {

    public Article(WebElement webElement) {
        super(webElement);
    }

    public void clickHeader(WebDriver webDriver) {
        WebElement header = webElement.findElement(By.tagName("header"))
                .findElement(By.tagName("a"));
        new Actions(webDriver).moveToElement(header).perform();
        header.click();
    }
}
