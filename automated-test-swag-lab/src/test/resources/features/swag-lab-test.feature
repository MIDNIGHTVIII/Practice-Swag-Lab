Feature: Swag Lab Test
    Feature for Swag Lab Test

# LOGIN FUNCTION
# TC-001
    Scenario: User input data to text fields
        Given user enters Swag Labs homepage
        When user input "standard_user" and "secret_sauce" to text fields
        Then data should display as the data that was filled
# TC-002
    Scenario Outline: User logged in successfully by click login
        Given user enters Swag Labs homepage
        When user login with "<username>" and "<password>" clicking login button
        Then user should nevigate to product page
        Examples:
        | username | password |
        | standard_user | secret_sauce |
        | visual_user | secret_sauce |
# TC-003
    Scenario Outline: User logged in successfully by press Enter
        Given user enters Swag Labs homepage
        When user login with "<username>" and "<password>" pressing Enter key
        Then user should nevigate to product page
        Examples:
        | username | password |
        | standard_user | secret_sauce |
        | visual_user | secret_sauce |
# TC-004
    Scenario: User logged in without a username
        Given user enters Swag Labs homepage
        When user login with "secret_sauce" and clicking login button
        Then display should show an error message
# TC-005    
    Scenario: User logged in without a password
        Given user enters Swag Labs homepage
        When user login with "standard_user" clicking login button
        Then display should show an error message
# TC-006
    Scenario: User logged in with both fields blank
        Given user enters Swag Labs homepage
        When user clicking login button with both fields blank
        Then display should show an error message
# TC-007
    Scenario: User logged in with invalid credentials
        Given user enters Swag Labs homepage
        When user login with "user21" and "nopassword" and clicking login button
        Then display should show an error message
    
# PRODUCT PAGE FUNCTION
# TC-008
    Scenario: User clicked add all product to cart
        Given user enters Swag Labs homepage
        And user logged in successfully
        And user enters product page
        When user clicking add all product to cart
        Then Cart icon should show number of the product
# TC-009
    Scenario: User clicked add two product to cart
        Given user enters Swag Labs homepage
        And user logged in successfully
        And user enters product page
        When user clicking add two product to cart
        Then Cart icon should show number of the product
# TC-010
    Scenario: User clicked remove all product
        Given user enters Swag Labs homepage
        And user logged in successfully
        And user enters product page
        And all product added to cart
        When user clicking remove all of the product in cart
        Then Cart icon should show no product in cart
# # TC-011
#     Scenario: User clicked sort product by name A to Z
#         Given user enters Swag Labs homepage
#         And user logged in successfully
#         And user enters product page
#         When user clicking fillter button select Name A to Z
#         Then the product should show by name A to Z
# # TC-012     
#     Scenario: User clicked sort product by name Z to A
#         Given user enters Swag Labs homepage
#         And user logged in successfully
#         And user enters product page
#         When user clicking fillter button select name Z to A
#         Then the product should show by Name Z to A
# # TC-013
#     Scenario: User clicked sort product by price low to high
#         Given user enters Swag Labs homepage
#         And user logged in successfully
#         And user enters product page
#         When user clicking fillter button select price low to high
#         Then the product should show by price low to high
# # TC-014
#     Scenario: User clicked sort product by price high to low
#         Given user enters Swag Labs homepage
#         And user logged in successfully
#         And user enters product page
#         When user clicking fillter button select price high to low
#         Then the product should show by price high to low
# # TC-015
#     Scenario: A number of product at cart icon
#         Given user enters Swag Labs homepage
#         And user logged in successfully
#         And user enters product page
#         When user clicking add product to cart
#         Then cart icon should show a number of product that had been added to cart
# # TC-016
#     Scenario: User clicked cart icon
#         Given user enters Swag Labs homepage
#         And user logged in successfully
#         And user enters product page
#         When user clicking cart icon
#         Then user should nevigate to cart page

# # CART PAGE FUNCTION
# # TC-017
#     Scenario: The name of product and price should match the selection form product page
#         Given user enters Swag Labs homepage
#         And user logged in successfully
#         And user enters product page
#         And user selects 2 items
#         And user clicks on the cart icon
#         Then The name of product and price should match the selection form product page
# # TC-018
#     Scenario: User clicking remove needless product
#         Given user enters Swag Labs homepage
#         And user logged in successfully
#         And user enters product page
#         And user selects 2 items
#         And user clicks on the cart icon
#         When user clicking remove button needless product
#         Then The product should been remove
# # TC-019
#     Scenario: User clicking Continue Shopping to get back to product page
#         Given user enters Swag Labs homepage
#         And user logged in successfully
#         And user enters product page
#         And user selects 2 items
#         And user clicks on the cart icon
#         When user clicking Continue Shopping button
#         Then The product should been remove
# # TC-020
#     Scenario: User clicking checkout button
#         Given user enters Swag Labs homepage
#         And user logged in successfully
#         And user enters product page
#         And user selects 2 items
#         And user clicks on the cart icon
#         When user clicking checkout button
#         Then user should nevigate to checkout Information page

# # CHECKOUT INFORMATION PAGE FUNCTION
# # TC-021
#     Scenario: user clicking Cancel button
#         Given user enters Swag Labs homepage
#         And user logged in successfully
#         And user enters product page
#         And user selects 2 items
#         And user clicks on the cart icon
#         And user clicks on the checkout button
#         When user clicking cancel button
#         Then user should nevigate to cart page
# # TC-022
#     Scenario: user field all information and click continue button
#         Given user enters Swag Labs homepage
#         And user logged in successfully
#         And user enters product page
#         And user selects 2 items
#         And user clicks on the cart icon
#         And user clicks on the checkout button
#         When user fill "Kael" name, "Hook" lastname and "12345" zipcode and clicking continue
#         Then user should nevagate to checkout overview page
# # TC-023
#     Scenario Outline: user field some information and click continue button
#         Given user enters Swag Labs homepage
#         And user logged in successfully
#         And user enters product page
#         And user selects 2 items
#         And user clicks on the cart icon
#         And user clicks on the checkout button
#         When user fill "<firstname>" name, "<lastname>" lastname and "<zipcode>" zipcode and clicking continue
#         Then user should show an error message
#         Examples:
#         | firstname | lastname | zipcode |
#         | Kael |  |  |
#         | Kael | Hook |  |
#         | Kael |  | 12345 |
#         |  |  | 12345 |
# # TC-024
#     Scenario: user dosen't field information and click continue button
#         Given user enters Swag Labs homepage
#         And user logged in successfully
#         And user enters product page
#         And user selects 2 items
#         And user clicks on the cart icon
#         And user clicks on the checkout button
#         When user dosen't fill information and clicking continue
#         Then user should show an error message

# # CHECKOUT OVERVIEW PAGE FUNCTION
# # TC-025
#     Scenario: The name of product and price should match the selection form product page
#         Given user enters Swag Labs homepage
#         And user logged in successfully
#         And user enters product page
#         And user selects 2 items
#         And user clicks on the cart icon
#         And user clicks on the checkout button
#         And user clicks continue button
#         Then The name of product and price should match the selection form product page
# # TC-026
#     Scenario: user checking total product price
#         Given user enters Swag Labs homepage
#         And user logged in successfully
#         And user enters product page
#         And user selects 2 items
#         And user clicks on the cart icon
#         And user clicks on the checkout button
#         And user clicks continue button
#         Then product price should correctly calculate the total, tax, and grand total
# # TC-027
#     Scenario: user clicking cancel button
#         Given user enters Swag Labs homepage
#         And user logged in successfully
#         And user enters product page
#         And user selects 2 items
#         And user clicks on the cart icon
#         And user clicks on the checkout button
#         And user clicks continue button
#         When user clicking cancel button
#         Then user should nevagate to product page
# # TC-028
#     Scenario: user clicking finish button
#         Given user enters Swag Labs homepage
#         And user logged in successfully
#         And user enters product page
#         And user selects 2 items
#         And user clicks on the cart icon
#         And user clicks on the checkout button
#         And user clicks continue button
#         When user clicking finish button
#         Then user should nevagate to the checkout complete page

# #CHECKOUT COMPLETE PAGE FUNCTION
# # TC-029
#     Scenario: the cart icon number should be removed
#         Given user enters Swag Labs homepage
#         And user logged in successfully
#         And user enters product page
#         And user selects 2 items
#         And user clicks on the cart icon
#         And user clicks on the checkout button
#         And user clicks continue button
#         And user clicking finish button
#         Then the cart icon number should be removed
# # TC-030
#     Scenario: Checkout status should show Complete!
#         Given user enters Swag Labs homepage
#         And user logged in successfully
#         And user enters product page
#         And user selects 2 items
#         And user clicks on the cart icon
#         And user clicks on the checkout button
#         And user clicks continue button
#         And user clicking finish button
#         Then checkout status should show "Complete!"
# # TC-031
#     Scenario: user clicking Back Home button
#         Given user enters Swag Labs homepage
#         And user logged in successfully
#         And user enters product page
#         And user selects 2 items
#         And user clicks on the cart icon
#         And user clicks on the checkout button
#         And user clicks continue button
#         And user clicking finish button
#         When user clicking Back Home button
#         Then user should navigate back to the product page