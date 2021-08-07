package io.cucumber.shouty;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {

    private Person sean;
    private Person lucy;
    private String messageFromSean;

    @Given("{person} is located {int} metre(s) from Sean")
    public void lucy_is_located_metres_from_sean(Person person, Integer distance) {
        sean = new Person("sean");
        lucy = new Person("lucy");
        lucy.moveTo(distance);
    }
    @When("Sean shouts {string}")
    public void sean_shouts(String message) {
        sean.shout(message);
        messageFromSean = message;
    }
    @Then("Lucy hears Sean's message")
    public void lucy_hears_sean_s_message() {
        assertEquals(Arrays.asList(messageFromSean), lucy.getMessagesHeard());
    }
}
