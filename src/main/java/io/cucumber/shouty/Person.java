package io.cucumber.shouty;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final String name;
    private List<String> messagesHeard = new ArrayList<>();
    private final Network network;

    public Person(String name, Network network) {
        this.name = name;
        this.network = network;
        network.subscribe(this);
    }

    public void moveTo(Integer distance) {
    }

    public void shout(String message) {
        network.broadcast(message);
    }

    public List<String> getMessagesHeard() {
        return messagesHeard;
    }

    public void hear(String message) {
        messagesHeard.add(message);
    }
}
