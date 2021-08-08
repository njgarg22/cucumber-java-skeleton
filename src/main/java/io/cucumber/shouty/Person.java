package io.cucumber.shouty;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final String name;
    private final int location;
    private List<String> messagesHeard = new ArrayList<>();
    private final Network network;

    public Person(String name, int location, Network network) {
        this.name = name;
        this.location = location;
        this.network = network;
        network.subscribe(this);
    }

    public void shout(String message) {
        network.broadcast(message, getLocation());
    }

    public List<String> getMessagesHeard() {
        return messagesHeard;
    }

    public void hear(String message) {
        messagesHeard.add(message);
    }

    public int getLocation() {
        return location;
    }
}
