package io.cucumber.shouty;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {

    private Person sean;
    private String messageFromSean;
    private Network network;
    private Map<String, Person> people;

    @Before
    public void createNetwork() {
        network = new Network();
        people = new HashMap<>();
    }

    @Given("a person named {word}")
    public void a_person_named(String name) {
        people.put(name, new Person(name, network));
    }

    @When("Sean shouts {string}")
    public void sean_shouts(String message) {
        people.get("Sean").shout(message);
        messageFromSean = message;
    }

    @Then("Lucy hears Sean's message")
    public void lucy_hears_sean_s_message() {
        assertEquals(Arrays.asList(messageFromSean), people.get("Lucy").getMessagesHeard());
    }
}
