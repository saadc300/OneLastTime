@Test
Feature: Login to Retail Website
 

  
  Scenario: Retail website Login test
    Given user is on Retail website
    When user click on  Myaccount
    And user click on Login option
    And user enter userName 'saad@test.com' and password 'test1234'
    And user click on Login Button
    Then user should be logged in to Myaccount dashboard
    

 
  Scenario Outline: Retail website Login test with muliple accounts 
    Given user is on Retail website
    When user click on  Myaccount
    And user click on Login option
    And user enter userName '<userName>' and password '<password>'
    And user click on Login Button
    Then user should be logged in to Myaccount dashboard

    Examples: 
      | userName | password | 
      | saad@test.com |test1234 |
      |saad1@test.com |test1234|


