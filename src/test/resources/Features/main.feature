Feature: Urban Ladder Website Functionality

  Scenario: Verify Home Page Loads Successfully
    Given I open the Urban Ladder website
    Then I should see the homepage displayed correctly

  Scenario: Search for a Product
    Given I am on the Urban Ladder homepage
    When I enter "Sofa" in the search bar
    And I submit the search
    Then I should see the search results displayed

  Scenario: Filter Search Results
    Given I have searched for "Sofa"
    When I apply a filter for "Price"
    Then I should see the search results updated accordingly

  Scenario: Add a Product to the Cart
    Given I have searched for "Sofa"
    When I select a product from the search results
    And I add the product to the cart
    Then I should see the product added to the cart successfully

  #Scenario: Proceed to Checkout
    #Given I have a product in my cart
    #When I navigate to the cart
    #And I click on the "Checkout" button
    #And I enter dummy shipping details
    #Then I should proceed to the payment page successfully
