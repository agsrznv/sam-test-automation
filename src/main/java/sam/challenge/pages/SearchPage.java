package sam.challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import sam.challenge.components.Article;
import sam.challenge.components.PageNumber;

import java.util.List;
import java.util.stream.Collectors;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    public List<Article> getArticles() {
        return webDriver.findElements(By.tagName("article"))
                .stream().map(Article::new).collect(Collectors.toList());
    }

    public BasePage clickOnArticle(Article article) {
        article.clickHeader(webDriver);
        return new BasePage(webDriver);
    }

    public List<PageNumber> getPageNumbers() {
        return webDriver.findElements(By.className("page-numbers"))
                .stream().map(PageNumber::new).collect(Collectors.toList());
    }

    // acepta tanto números enteros como "next" y "prev"
    public SearchPage goToPage(String page) {
        getPageNumbers().stream().filter(p -> p.isClickable(page))
                .findFirst().ifPresent(PageNumber::click);

        return new SearchPage(webDriver);
    }
}
