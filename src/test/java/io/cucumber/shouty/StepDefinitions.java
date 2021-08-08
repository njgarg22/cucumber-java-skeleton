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
    private Network network = new Network();

    @Given("Lucy is located {int} metre(s) from Sean")
    public void lucy_is_located_metres_from_sean(Integer distance) {
        Network network = new Network();
        sean = new Person("sean", network);
        lucy = new Person("lucy", network);
        lucy.moveTo(distance);
    }

    @Given("a person named Lucy")
    public void a_person_named_lucy() {
        lucy = new Person("lucy", network);
    }
    @Given("a person named Sean")
    public void a_person_named_sean() {
        sean = new Person("sean", network);
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
