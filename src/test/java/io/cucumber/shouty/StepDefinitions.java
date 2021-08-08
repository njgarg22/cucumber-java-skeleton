package io.cucumber.shouty;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

public class StepDefinitions {

    private String messageFromSean;
    private Network network;
    private Map<String, Person> people;

    @Before
    public void createNetwork() {
        people = new HashMap<>();
    }

    @Given("the range is {int}")
    public void the_range_is(int range) throws Throwable {
        network = new Network(range);
    }

    @Given("a person named {word} is located at {int}")
    public void a_person_named(String name, int location) {
        people.put(name, new Person(name, location, network));
    }

    @When("Sean shouts {string}")
    public void sean_shouts(String message) {
        people.get("Sean").shout(message);
        messageFromSean = message;
    }

    @Then("Lucy should hear Sean's message")
    public void lucy_hears_sean_s_message() {
        assertEquals(Arrays.asList(messageFromSean), people.get("Lucy").getMessagesHeard());
    }

    @Then("Larry should not hear Sean's message")
    public void larry_does_not_hear_Sean_s_message() throws Throwable {
        List<String> heardByLarry = people.get("Larry").getMessagesHeard();
        assertThat(heardByLarry, not(hasItem(messageFromSean)));
    }
}
