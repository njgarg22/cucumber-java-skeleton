Feature: Hear Shout

  Shouty allows users to "hear" other users "shouts" as long as they are close enough to each other.

  To do:
  - only shout to people within a certain distance

  Rule: Shouts can be heard by other users
    Scenario: Listener is within range
      Given Lucy is located 15 metres from Sean
      When Sean shouts "free bagels at Sean’s"
      Then Lucy hears Sean's message

    Scenario: Listener hears a different message
      Given Lucy is located 15 metres from Sean
      When Sean shouts "free coffee"
      Then Lucy hears Sean's message