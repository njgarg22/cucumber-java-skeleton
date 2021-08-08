package io.cucumber.shouty;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PersonTest {
    private final Network network = mock(Network.class);

    @Test
    public void it_subscribes_to_the_network() {
        Person lucy = new Person("lucy", network);
        verify(network).subscribe(lucy);
    }

    @Test
    public void broadcasts_shouts_to_the_network() {
        Person sean = new Person("lucy", network);
        sean.shout("free bagels");
        verify(network).broadcast("free bagels");
    }

    @Test
    public void remembers_messages_heard() {
        Person lucy = new Person("lucy", network);
        lucy.hear("free bagels");
        Assertions.assertEquals(Arrays.asList("free bagels"), lucy.getMessagesHeard());
    }
}
