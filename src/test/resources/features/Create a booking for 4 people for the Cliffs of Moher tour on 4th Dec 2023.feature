Feature: Create a booking for 4 people with status Invoice to be paid for the Cliffs of Moher tour on 4th Dec 2023

  Scenario: Verify User is able to rreate a booking for 4 people for the Cliffs of Moher tour
    Given User is able to Login successfully
    When User creates a new booking
    Then booking should be created successfully

