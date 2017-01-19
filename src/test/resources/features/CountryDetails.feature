Feature: World countries API
  As a user
  I want to be able see various country details

  @first
  Scenario: Get country details from capital city reference
    Given i retrieve a country
    Then i should be able to see the details

  Scenario: Sample test case
    Given i retrieve a country

  @last
  Scenario: Another sample test case
    Given i retrieve a country
