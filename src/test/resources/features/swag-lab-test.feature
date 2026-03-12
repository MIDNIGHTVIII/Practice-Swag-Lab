Feature: Swag Lab Test
    Feature for Swag Lab Test

# LOGIN FUNCTION
# TC-001
    Scenario: User input data to text fields
        Given user entered Swag Labs homepage
        When user input "standard_user" and "secret_sauce" to text fields
        Then data should display as the data that was filled
# TC-002
    Scenario Outline: User log in successfully by click login
        Given user entered Swag Labs homepage
        When user login with "<username>" and "<password>" click login button
        Then user should nevigate to product page
        Examples:
        | username | password |
        | standard_user | secret_sauce |
        | visual_user | secret_sauce |
# TC-003
    Scenario Outline: User log in successfully by press Enter
        Given user entered Swag Labs homepage
        When user login with "<username>" and "<password>" press Enter key
        Then user should nevigate to product page
        Examples:
        | username | password |
        | standard_user | secret_sauce |
        | visual_user | secret_sauce |
# TC-004
    Scenario: User log in without a username
        Given user entered Swag Labs homepage
        When user login with "secret_sauce" and click login button
        Then display should show an error message
# TC-005    
    Scenario: User log in without a password
        Given user entered Swag Labs homepage
        When user login with "standard_user" click login button
        Then display should show an error message
# TC-006
    Scenario: User log in with both fields blank
        Given user entered Swag Labs homepage
        When user click login button with both fields blank
        Then display should show an error message
# TC-007
    Scenario: User log in with invalid credentials
        Given user entered Swag Labs homepage
        When user login with "user21" and "nopassword" and click login button
        Then display should show an error message
    
# PRODUCT PAGE FUNCTION
# TC-008
    Scenario: User click add all product to cart
        Given user entered Swag Labs homepage
        And user logged in successfully
        And user entered product page
        When user click add all product to cart
        Then Cart icon should show number of the product
# TC-009
    Scenario: User click add two product to cart
        Given user entered Swag Labs homepage
        And user logged in successfully
        And user entered product page
        When user click add two product to cart
        Then Cart icon should show number of the product
# TC-010
    Scenario: User click remove all product
        Given user entered Swag Labs homepage
        And user logged in successfully
        And user entered product page
        And all product added to cart
        When user click remove all of the product in cart
        Then Cart icon should show no product in cart
# TC-011
    Scenario: User click sort product by name A to Z
        Given user entered Swag Labs homepage
        And user logged in successfully
        And user entered product page
        When user click fillter button select Name A to Z
        Then the product should show by Name A to Z
# TC-012     
    Scenario: User click sort product by name Z to A
        Given user entered Swag Labs homepage
        And user logged in successfully
        And user entered product page
        When user click fillter button select Name Z to A
        Then the product should show by Name Z to A
# TC-013
    Scenario: User click sort product by price low to high
        Given user entered Swag Labs homepage
        And user logged in successfully
        And user entered product page
        When user click fillter button select price low to high
        Then the product should show by price low to high
# TC-014
    Scenario: User click sort product by price high to low
        Given user entered Swag Labs homepage
        And user logged in successfully
        And user entered product page
        When user click fillter button select price high to low
        Then the product should show by price high to low
# TC-015
    Scenario: A number of product at cart icon
        Given user entered Swag Labs homepage
        And user logged in successfully
        And user entered product page
        When user click add product to cart
        Then Cart icon should show number of the product
# TC-016
    Scenario: User click cart icon
        Given user entered Swag Labs homepage
        And user logged in successfully
        And user entered product page
        When user click cart icon
        Then user should nevigate to cart page

# CART PAGE FUNCTION
# TC-017
    Scenario: The name of product and price should match the selection form product page
        Given user entered Swag Labs homepage
        And user logged in successfully
        And user entered product page
        And user selected two product
        And user clicked on the cart icon
        Then The name of product and price should match the selection form product page
# TC-018
    Scenario: User click remove needless product
        Given user entered Swag Labs homepage
        And user logged in successfully
        And user entered product page
        And user selected two product
        And user clicked on the cart icon
        When user click remove button needless product
        Then The product should be remove
# TC-019
    Scenario: User click Continue Shopping to get back to product page
        Given user entered Swag Labs homepage
        And user logged in successfully
        And user entered product page
        And user selected two product
        And user clicked on the cart icon
        When user click Continue Shopping button
        Then user should nevigate to product page
# TC-020
    Scenario: User click checkout button
        Given user entered Swag Labs homepage
        And user logged in successfully
        And user entered product page
        And user selected two product
        And user clicked on the cart icon
        When user click checkout button
        Then user should nevigate to checkout Information page

# CHECKOUT INFORMATION PAGE FUNCTION
# TC-021
    Scenario: user click Cancel button
        Given user entered Swag Labs homepage
        And user logged in successfully
        And user entered product page
        And user selected two product
        And user clicked on the cart icon
        And user clicked on the checkout button
        When user click cancel button
        Then user should nevigate to cart page
# TC-022
    Scenario: user field all information and click continue button
        Given user entered Swag Labs homepage
        And user logged in successfully
        And user entered product page
        And user selected two product
        And user clicked on the cart icon
        And user clicked on the checkout button
        When user fill "Kael" name "Hook" lastname and "12345" zipcode and click continue
        Then user should nevagate to checkout overview page
# TC-023
    Scenario Outline: user field some information and click continue button
        Given user entered Swag Labs homepage
        And user logged in successfully
        And user entered product page
        And user selected two product
        And user clicked on the cart icon
        And user clicked on the checkout button
        When user fill some "<firstname>" name or "<lastname>" lastname or "<zipcode>" zipcode and click continue
        Then display should show an error message
        Examples:
        | firstname | lastname | zipcode |
        | Kael |  |  |
        | Kael | Hook |  |
        | Kael |  | 12345 |
        |  |  | 12345 |
# TC-024
    Scenario: user dosen't field information and click continue button
        Given user entered Swag Labs homepage
        And user logged in successfully
        And user entered product page
        And user selected two product
        And user clicked on the cart icon
        And user clicked on the checkout button
        When user dose not fill information and click continue
        Then display should show an error message

#CHECKOUT OVERVIEW PAGE FUNCTION
# TC-025
    Scenario: The name of product and price should match the selection form product page
        Given user entered Swag Labs homepage
        And user logged in successfully
        And user entered product page
        And user selected two product
        And user clicked on the cart icon
        And user clicked on the checkout button
        And user clicked continue button
        Then The name of product and price should match the selection form product page
# TC-026
    Scenario: user check total product price
        Given user entered Swag Labs homepage
        And user logged in successfully
        And user entered product page
        And user selected two product
        And user clicked on the cart icon
        And user clicked on the checkout button
        And user clicked continue button
        Then total product price should correctly calculate
# TC-027
    Scenario: user click cancel button
        Given user entered Swag Labs homepage
        And user logged in successfully
        And user entered product page
        And user selected two product
        And user clicked on the cart icon
        And user clicked on the checkout button
        And user clicked continue button
        When user click cancel button checkout overview page
        Then user should nevagate to product page
# TC-028
    Scenario: user click finish button
        Given user entered Swag Labs homepage
        And user logged in successfully
        And user entered product page
        And user selected two product
        And user clicked on the cart icon
        And user clicked on the checkout button
        And user clicked continue button
        When user click finish button
        Then user should nevagate to the checkout complete page

#CHECKOUT COMPLETE PAGE FUNCTION
# TC-029
    Scenario: the cart icon number should be removed
        Given user entered Swag Labs homepage
        And user logged in successfully
        And user entered product page
        And user selected two product
        And user clicked on the cart icon
        And user clicked on the checkout button
        And user clicked continue button
        And user clicked finish button
        Then the cart icon number should be removed
# TC-030
    Scenario: Checkout status should show Complete!
        Given user entered Swag Labs homepage
        And user logged in successfully
        And user entered product page
        And user selected two product
        And user clicked on the cart icon
        And user clicked on the checkout button
        And user clicked continue button
        And user clicked finish button
        Then checkout status should show Complete
# TC-031
    Scenario: user click Back Home button
        Given user entered Swag Labs homepage
        And user logged in successfully
        And user entered product page
        And user selected two product
        And user clicked on the cart icon
        And user clicked on the checkout button
        And user clicked continue button
        And user clicked finish button
        When user click Back Home button
        Then user should navigate back to the product page