package sam.challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import sam.challenge.components.BaseComponent;

import java.util.Optional;

public class BasePage {
    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public SearchPage search(String query) {
        WebElement magnifier = webDriver.findElement(By.className("icon-magnifier"));
        magnifier.click();

        WebElement searchForm = webDriver.findElement(By.id("ocean-search-form-1"));
        searchForm.clear();
        searchForm.sendKeys(query);
        searchForm.submit();

        return new SearchPage(webDriver);
    }

    public FormPage gotToJobSubmissionPage() {
        WebElement contacto = webDriver.findElement(By.id("menu-item-107"));
        new Actions(webDriver).moveToElement(contacto).perform();
        contacto.findElement(By.id("menu-item-108")).click();
        return new FormPage(webDriver);
    }

    public Optional<BaseComponent> findElementByText(String text) {
        try {
            return Optional.of(new BaseComponent(webDriver.findElement(By.xpath(
                    String.format("//*[contains (text(), '%s')]", text)
            ))));
        } catch (NoSuchElementException e) {
            return Optional.empty();
        }
    }

    public String getFooterContactInfo() {
        return webDriver.findElement(By.id("custom_html-2")).getText();
    }
}
