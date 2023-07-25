package support;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runner.RunCucumber;

import java.time.Duration;

public class Commands extends RunCucumber {

    public static void waitElementBeClickable(By element, Integer tempo) {
        WebDriverWait wait = new WebDriverWait(getDriver(), tempo);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitElementBeVisible(By element, Integer tempo) {
        WebDriverWait wait = new WebDriverWait(getDriver(), tempo);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void clickElement(By element) {
        try {
            System.out.println("###########################");
            System.out.println("Clica no elemento : " + element);
            waitElementBeClickable(element, 2000);
            //waitElementBeClickable(element, Duration.ofMillis(2000));
            getDriver().findElement(element).click();
            System.out.println("Clicou no elemento : " + element);
        } catch (Exception error) {
            System.out.println("Aconteceu um erro ao tentar clicar no elemento : " + element);
            System.out.println(error);
        }
        System.out.println("###########################");
    }

    public static void fillField(By element, String value) {
        try {
            System.out.println("###########################");
            System.out.println("Preenche o campo : " + element);
            waitElementBeClickable(element, 2000);
            //waitElementBeVisible(element, Duration.ofMillis(2000));
            getDriver().findElement(element).sendKeys(value);
            System.out.println("Preencheu o campo : " + element);
        } catch (Exception error) {
            System.out.println("Aconteceu um erro ao tentar preencher o campo : " + element);
            System.out.println(error);
        }
        System.out.println("###########################");
    }


    public static void checkMessage(By element, String expectedMessage) {
        String actualMessage = "";
        System.out.println("###########################");

        try {
            System.out.println("Valida mensagem: " + expectedMessage);
            waitElementBeClickable(element, 2000);
            //waitElementBeVisible(element, Duration.ofMillis(10000));
            actualMessage = getDriver().findElement(element).getText();
            Assert.assertEquals(expectedMessage, actualMessage);
            System.out.println("Validou mensagem: "+ expectedMessage);
        } catch (Exception error) {
            System.out.println("Aconteceu um erro ao validar mensagem: ");
            System.out.println("Mensagem esperada: " + expectedMessage);
            System.out.println("Mensagem atual: " + actualMessage);
            System.out.println(error);
        }
    }

}
