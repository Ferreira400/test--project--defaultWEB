package utilsMetodos;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.testcontainers.shaded.org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;

import static driver.Drivers.getDriver;
import static gherkin.hook.Hook.scenario;

public class Auxiliar {
    static WebDriver driver;
    public Auxiliar() throws MalformedURLException {
        this.driver = getDriver();
    }

//    @Attachment(value = "Screenshot", type = "image/png")
//    public byte[] screenshot() {
//        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//    }
    public static void takeScreenshot(){
        byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png","Evidencia");
    }
}

