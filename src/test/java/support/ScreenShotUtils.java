package support;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static runner.RunBase.getDriver;

public class ScreenShotUtils {

    @After
    public static void afterScenario(Scenario scenario) {
        System.out.println(" =================== ");
        System.out.println("Teste que está sendo executado: " + scenario.getName());
        System.out.println("Status: " + scenario.getStatus());
        System.out.println("Tag: " + scenario.getSourceTagNames());
        System.out.println(" =================== ");

        if(scenario.isFailed()){
            //tirar print da tela
            ScreenShotUtils.addScreenShotOnScenario(scenario);
        }
    }

    public static void addScreenShotOnScenario(Scenario scenario) {
        byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");
    }

}
