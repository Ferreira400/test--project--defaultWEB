package model;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pageobject.ExamplePO;
import pageobject.ExamplesResultadoPO;
import java.net.MalformedURLException;

import static utils.Auxiliar.getElementIfVisible;

public class ModelExamples {
    WebDriver driver;
    ExamplePO examplePO =new ExamplePO();
    ExamplesResultadoPO examplesResultadoPO = new ExamplesResultadoPO();

    public ModelExamples() throws MalformedURLException {
    }

    public void BuscaGoogle(String busca) throws InterruptedException {
        getElementIfVisible(By.name(examplePO.campoTextoGoogle), 10).sendKeys(busca, Keys.ENTER);

    }
    public void check() throws InterruptedException {
        String valorNome =getElementIfVisible(By.cssSelector(examplesResultadoPO.resultadoPesquisa),15).getText();
        Assert.assertEquals("Banco PAN", valorNome);
    }



}
