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

    @Given("Lucy is located {int} metre(s) from Sean")
    public void lucy_is_located_metres_from_sean(Integer distance) {
        Network network = new Network();
        sean = new Person("sean", network);
        lucy = new Person("lucy", network);
        lucy.moveTo(distance);
    }

    @Given("a person named Lucy")
    public void a_person_named_lucy() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("a person named Sean")
    public void a_person_named_sean() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
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
