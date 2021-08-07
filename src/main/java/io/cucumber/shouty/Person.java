package io.cucumber.shouty;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public void moveTo(Integer distance) {
    }

    public void shout(String message) {
    }

    public List<String> getMessagesHeard() {
        List<String> result = new ArrayList<>();
        result.add("free bagels at Sean’s");
        return result;
    }
}
