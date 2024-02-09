package sam.challenge;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sam.challenge.components.Article;
import sam.challenge.components.BaseComponent;
import sam.challenge.components.SubmitButton;
import sam.challenge.pages.BasePage;
import sam.challenge.pages.FormPage;
import sam.challenge.pages.SearchPage;

import java.util.Optional;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChallengeTest {
    WebDriver webDriver;
    String url = "https://www.samsistemas.com.ar";
    Logger logger;
    BasePage basePage;

    @BeforeEach
    public void startSession() {
        logger = Logger.getLogger(ChallengeTest.class.getName());

        // 1. Ingresar a https://www.samsistemas.com.ar

        webDriver = new ChromeDriver();
        webDriver.get(url);

        basePage = new BasePage(webDriver);
    }

    @Test
    public void searchTest() {
        // 2. Seleccionar la lupa de búsqueda y realizar la búsqueda de la palabra
        // [devops]

        SearchPage searchPage = basePage.search("devops");

        // 3. Validar con un assert que se haya ingresado correctamente al
        // apartado

        assertCurrentUrl("/?s=devops");
        logger.info("La búsqueda de la palabra [devops] se realizó correctamente");

        // 4. Imprimir la cantidad de elementos arrojados por la búsqueda

        logger.info("Cantidad de elementos arrojados: " + searchPage.getArticles().size());

        // 5. Moverse a la página 2 del resultado de búsqueda y clickear sobre el
        // cuarto artículo

        SearchPage page2 = searchPage.goToPage("2");
        Article article4 = page2.getArticles().get(3);
        BasePage articlePage = page2.clickOnArticle(article4);

        // 6. Validar con un assert que se haya ingresado correctamente

        assertCurrentUrl("/servicios-devops/automatizacion-de-pruebas/");
        logger.info("Se clickeó sobre el artículo 'Automatización de pruebas'");

        // 7. Validar con un assert la existencia de la palabra “Test Management”

        Optional<BaseComponent> optional = articlePage.findElementByText("Test Management");
        assertTrue(optional.isPresent());
        logger.info("Se validó la existencia de un elemento con el texto 'Text Management'");
    }

    @Test
    public void buttonTest() {
        // 8. Seleccionar -> Contacto -> “Trabaje con nosotros”

        FormPage formPage = basePage.gotToJobSubmissionPage();

        // 9. Validar que el botón [Enviar] se encuentre habilitado

        SubmitButton button = formPage.getSubmitButton();
        assertTrue(button.isEnabled());
        logger.info("El botón [Enviar] se encuentra habilitado");
    }

    @Test
    public void footerTest() {
        // 10. Ir hasta el footer y validar con un assert que la dirección de la
        // empresa sea la correcta “Azcuénaga 1344, piso 1º”

        String info = basePage.getFooterContactInfo();
        assertTrue(info.contains("Azcuénaga 1344, piso 1º"));
        logger.info("La dirección de la empresa es 'Azcuénaga 1344, piso 1º'");
    }

    @AfterEach
    public void closeSession() {
        webDriver.quit();
    }

    private void assertCurrentUrl(String path) {
        assertEquals(url + path, webDriver.getCurrentUrl());
    }
}