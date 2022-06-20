package gherkin.stepdefinition;


import io.cucumber.java.en.*;
import model.ModelExamples;
import utilsMetodos.Auxiliar;

import java.net.MalformedURLException;


public class ExampleSteps {

    ModelExamples model = new ModelExamples();
    Auxiliar auxiliar = new Auxiliar();

    public ExampleSteps() throws MalformedURLException {
    }
    @Given("Eu acesso o site do Google")
    public void eu_acesso_o_site_do_Google(){

        auxiliar.takeScreenshot();
    }
    @When("Eu faço uma {string}")
    public void eu_faço_uma(String busca) throws InterruptedException {
        model.BuscaGoogle(busca);
        auxiliar.takeScreenshot();
    }
    @Then("eu printo o resultado")
    public void eu_printo_o_resultado() throws InterruptedException {
        model.check();
        auxiliar.takeScreenshot();

    }
}