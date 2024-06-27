Feature: Validation of Schedule a Demo Form

  Background: 
    Given user Open Practo page
    And user click on For corparates dropdown
    And Click on Health and wellness plan
    And Enter the name
    And Enter the Organization name
    And selects the organization size
    And select the Interested in option

  Scenario Outline: Login-button Disabled
    When user enter the contact number as "<phone number>"
    And user enter the email id as "<email id>"
    But Login button should be Disabeld

    Examples: 
      | phone number | email id          |
      |   9600351227 | vigneshkumar.avk  |
      |  96000351227 | vignesh@gmail.com |
      |  96003512277 | vignesh.com       |

  Scenario Outline: Login-button enabled
    When user enter the contact number as "<phone number>"
    And user enter the email id as "<email id>"
    Then Login button should be enabeld
     Examples: 
      | phone number | email id          |
      |   9600351227 | vignesh@gmail.com |
      
