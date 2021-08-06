package io.cucumber.shouty;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
    @Given("Lucy is located {int} metres from Sean")
    public void lucy_is_located_metres_from_sean(Integer distance) {
        System.out.println(distance);
        throw new io.cucumber.java.PendingException();
    }
    @When("Sean shouts {string}")
    public void sean_shouts(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Lucy hears Sean's message")
    public void lucy_hears_sean_s_message() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
