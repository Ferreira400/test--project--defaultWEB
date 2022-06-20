package gherkin.hook;


import driver.AppWeb;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static driver.AppWeb.quitDriver;
import static driver.Drivers.getDriver;


public class Hook {
    public static Scenario scenario;

    @Before
    public void beforeScenario(Scenario sc) {

        AppWeb appWeb = new AppWeb();
        appWeb.setUpDriver(DriverManagerType.CHROME, AppWeb.BROWSER);
        Hook.scenario = sc;
    }

    @After
    public void afterScenario() throws InterruptedException {
        if (scenario.isFailed()) {
            // Take a screenshot...
            byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png","screenError"); // ... and embed it in the report.
        }
        String statusTest;
        if(scenario.isFailed() == true) {
            statusTest = "falhou";
        }else{
            statusTest = "passou";
        }
        quitDriver();
    }
}


