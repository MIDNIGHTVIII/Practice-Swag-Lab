import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.Assert.assertEquals;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Keyboard.TypeOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

public class StepDefinitions {
    private static Browser browser;
    private static Page page;

    String SelectedFirstProductName = "a#item_4_title_link";
    String SelectedSecondProductName = "a#item_5_title_link";
    String SelectedFirstProductLocator = "button#add-to-cart-sauce-labs-backpack";
    String SelectedSecondProductLocator = "button#add-to-cart-sauce-labs-fleece-jacket";
    String SelectedFirstProductPriceLocator = "div.inventory_item_price";
    String SelectedSecondProductPriceLocator = "div.inventory_item_price";
    String RemoveFirstProductLocator = "button#remove-sauce-labs-backpack";
    String RemoveSecondProductLocator = "button#remove-sauce-labs-fleece-jacket";
    String yourInfoNameLocator = "input#first-name";
    String yourInfoLastnameLocator = "input#last-name";
    String yourInfoZipcodeLocator = "input#postal-code";
    String itemTotalPriceLocator = "div.summary_subtotal_label";

    @BeforeAll
    public static void beforeAll() {
        Playwright playwright = Playwright.create();
        LaunchOptions LaunchOptions = new BrowserType.LaunchOptions().setHeadless(false);
        browser = playwright.chromium().launch(LaunchOptions);
    }

    @Before
    public void before() {
        page =  browser.newPage();
    }

    @After
    public void after() {
        page.close();
    }

    @Given("user enters Swag Labs homepage")
    public void user_enters_Swag_Labs_homepage() {
        page.navigate("https://www.saucedemo.com/");
    }

    @And("user logged in successfully")
    public void user_logged_in_successfully() {
        user_login_with_username_and_password_clicking_login_button("standard_user","secret_sauce");
    }

    @And("user enters product page")
    public void user_enters_product_page() {
        user_should_nevigate_to_product_page();
    }

    @And("all product added to cart")
    public void all_product_added_to_cart() {
        user_clicking_add_all_product_to_cart();
    }

    @And("user selects two product")
    public void user_selects_two_product() {
        user_clicking_add_two_product_to_cart();
    }

    @And("user clicked on the cart icon")
    public void user_clicked_on_the_cart_icon() {
        user_clicking_cart_icon();
    }

    @And("user clicked on the checkout button")
    public void user_clicked_on_the_checkout_button() {
        user_clicking_checkout_button();
    }

    @And("user clicked continue button")
    public void user_clicked_continue_button() {
        user_fill_name_lastname_and_zipcode_and_clicking_continue("Kael", "Hook", "12345");
    }

    @And("user clicked finish button")
    public void user_clicked_finish_button() {
        user_clicking_finish_button();
    }


    @When("user input {string} and {string} to text fields")
    public void user_input_username_and_password_to_text_fields(String username, String password) {
        page.locator("input#user-name").click();
        page.keyboard().type(username, new TypeOptions().setDelay(100));
        page.locator("input#password").click();
        page.keyboard().type(password, new TypeOptions().setDelay(100));
        page.waitForTimeout(300);
    }

    @When("user login with {string} and {string} clicking login button")
    public void user_login_with_username_and_password_clicking_login_button(String username, String password) {
        page.locator("input#user-name").click();
        page.keyboard().type(username, new TypeOptions().setDelay(100));
        page.locator("input#password").click();
        page.keyboard().type(password, new TypeOptions().setDelay(100));
        page.locator("input#login-button").click();
        page.waitForTimeout(300);
    }

    @When("user login with {string} and {string} pressing Enter key")
    public void user_login_with_username_and_password_pressing_Enter_key(String username, String password) {
        page.locator("input#user-name").click();
        page.keyboard().type(username, new TypeOptions().setDelay(100));
        page.locator("input#password").click();
        page.keyboard().type(password, new TypeOptions().setDelay(100));
        page.keyboard().press("Enter");
        page.waitForTimeout(300);
    }

    @When("user login with {string} and clicking login button")
    public void user_login_with_password_clicking_login_button(String password) {
        page.locator("input#password").click();
        page.keyboard().type(password, new TypeOptions().setDelay(100));
        page.locator("input#login-button").click();
        page.waitForTimeout(300);
    }

    @When("user login with {string} clicking login button")
    public void user_login_with_username_clicking_login_button(String username) {
        page.locator("input#user-name").click();
        page.keyboard().type(username, new TypeOptions().setDelay(100));
        page.locator("input#login-button").click();
        page.waitForTimeout(300);
    }

    @When("user clicking login button with both fields blank")
    public void user_clicking_login_button_with_both_fields_blank () {
        page.locator("input#login-button").click();
        page.waitForTimeout(300);
    }

    @When("user login with {string} and {string} and clicking login button")
    public void user_login_with_invalid_username_and_invalid_password(String username, String password) {
        page.locator("input#user-name").click();
        page.keyboard().type(username, new TypeOptions().setDelay(500));
        page.locator("input#password").click();
        page.keyboard().type(password, new TypeOptions().setDelay(500));
        page.locator("input#login-button").click();
        page.waitForTimeout(300);
    }

    @When("user clicking add all product to cart")
    public void user_clicking_add_all_product_to_cart() {
        page.locator("button#add-to-cart-sauce-labs-backpack").click();
        page.locator("button#add-to-cart-sauce-labs-bike-light").click();
        page.locator("button#add-to-cart-sauce-labs-bolt-t-shirt").click();
        page.locator("button#add-to-cart-sauce-labs-fleece-jacket").click();
        page.locator("button#add-to-cart-sauce-labs-onesie").click();
        page.locator("button#add-to-cart-test\\.allthethings\\(\\)-t-shirt-\\(red\\)").click();
        page.waitForTimeout(300);
    }

    @When("user clicking add two product to cart")
    public void user_clicking_add_two_product_to_cart() {
        page.locator(SelectedFirstProductLocator).click();
        page.locator(SelectedSecondProductLocator).click();
        page.waitForTimeout(300);
    }

    @When("user clicking remove all of the product in cart")
    public void user_clicking_remove_all_of_the_product_in_cart() {
        page.locator("button#remove-sauce-labs-backpack").click();
        page.locator("button#remove-sauce-labs-bike-light").click();
        page.locator("button#remove-sauce-labs-bolt-t-shirt").click();
        page.locator("button#remove-sauce-labs-fleece-jacket").click();
        page.locator("button#remove-sauce-labs-onesie").click();
        page.locator("button#remove-test\\.allthethings\\(\\)-t-shirt-\\(red\\)").click();
        page.waitForTimeout(300);
    }

    @When("user clicking fillter button select Name A to Z")
    public void user_clicking_fillter_button_select_Name_A_to_Z() {
        page.locator("select.product_sort_container").click();
        page.selectOption("select.product_sort_container", "az");
    }

    @When("user clicking fillter button select Name Z to A")
    public void user_clicking_fillter_button_select_Name_Z_to_A() {
        page.locator("select.product_sort_container").click();
        page.selectOption("select.product_sort_container", "za");
    }

    @When("user clicking fillter button select price low to high")
    public void user_clicking_fillter_button_select_price_low_to_high() {
        page.locator("select.product_sort_container").click();
        page.selectOption("select.product_sort_container", "lohi");
    }

    @When("user clicking fillter button select price high to low")
    public void user_clicking_fillter_button_select_price_high_to_low() {
        page.locator("select.product_sort_container").click();
        page.selectOption("select.product_sort_container", "hilo");
    }

    @When("user clicking add product to cart")
    public void user_clicking_add_product_to_cart() {
        page.locator("button#add-to-cart-sauce-labs-backpack").click();
        page.waitForTimeout(300);
    }

    @When("user clicking cart icon")
    public void user_clicking_cart_icon() {
        page.locator("a.shopping_cart_link").click();
        page.waitForTimeout(300);
    }

    @When("user clicking remove button needless product")
    public void user_clicking_remove_button_needless_product() {
        page.locator(RemoveSecondProductLocator).click();
    }

    @When("user clicking Continue Shopping button")
    public void user_clicking_Continue_Shopping_button() {
        page.locator("button#continue-shopping").click();
    }

    @When("user clicking checkout button")
    public void user_clicking_checkout_button() {
        page.locator("button#checkout").click();
    }

    @When("user clicking cancel button")
    public void user_clicking_cancel_button() {
        page.locator("button#cancel").click();
    }

    @When("user fill {string} name {string} lastname and {string} zipcode and clicking continue")
    public void user_fill_name_lastname_and_zipcode_and_clicking_continue(String Name, String Lastname, String Zipcode) {
        page.locator(yourInfoNameLocator).click();
        page.keyboard().type(Name, new TypeOptions().setDelay(100));
        page.locator(yourInfoLastnameLocator).click();
        page.keyboard().type(Lastname, new TypeOptions().setDelay(100));
        page.locator(yourInfoZipcodeLocator).click();
        page.keyboard().type(Zipcode, new TypeOptions().setDelay(100));
        page.locator("input#continue.submit-button").click();
    }

    @When("user fill some {string} name or {string} lastname or {string} zipcode and clicking continue")
    public void user_fill_some_name_or_lastname_or_zipcode_and_clicking_continue(String Name, String Lastname, String Zipcode) {
        page.locator(yourInfoNameLocator).click();
        page.keyboard().type(Name, new TypeOptions().setDelay(100));
        page.locator(yourInfoLastnameLocator).click();
        page.keyboard().type(Lastname, new TypeOptions().setDelay(100));
        page.locator(yourInfoZipcodeLocator).click();
        page.keyboard().type(Zipcode, new TypeOptions().setDelay(100));
        page.locator("input#continue.submit-button").click();
    }

    @When("user dose not fill information and clicking continue")
    public void user_dose_not_fill_information_and_clicking_continue() {
        page.locator("input#continue.submit-button").click();
    }

    @When("user clicking cancel button checkout overview page")
    public void user_clicking_cancel_button_checkout_overview_page() {
        page.locator("button#cancel").click();
    }

    @When("user clicking finish button")
    public void user_clicking_finish_button() {
        page.locator("button#finish").click();
    }

    @When("user clicking Back Home button")
    public void user_clicking_Back_Home_button() {
        page.locator("button#back-to-products").click();
    }

    @Then("data should display as the data that was filled")
    public void data_should_display_as_the_data_that_was_filled() {
        Locator locatorUsername = page.locator("input#user-name");
        assertThat(locatorUsername).isVisible();
        Locator locatorPassword = page.locator("input#password");
        assertThat(locatorPassword).isVisible();
        page.waitForTimeout(300);
    }

    @Then("display should show an error message")
    public void display_should_show_an_error_message() {
        Locator locatorErrorMessage = page.locator("h3");
        assertThat(locatorErrorMessage).isVisible();
        page.waitForTimeout(300);
    }

    @Then("user should nevigate to product page")
    public void user_should_nevigate_to_product_page() {
        assertThat(page).hasURL("https://www.saucedemo.com/inventory.html");
        page.waitForTimeout(300);
    }

    @Then("Cart icon should show number of the product")
    public void Cart_icon_should_show_number_of_the_product() {
        Locator locatorCartIcon = page.locator("span.shopping_cart_badge");
        assertThat(locatorCartIcon).isVisible();
        page.waitForTimeout(300);
    }

    @Then("Cart icon should show no product in cart")
    public void Cart_icon_should_show_no_product_in_cart() {
        Locator locatorCartIcon = page.locator("span.shopping_cart_badge");
        assertThat(locatorCartIcon).isHidden();
        page.waitForTimeout(300);
    }

    @Then("the product should show by Name A to Z")
    public void the_product_should_show_by_Name_A_to_Z() {
        Locator locatorFirstProduct = page.locator("a#item_4_title_link");
        assertThat(locatorFirstProduct).isVisible();
        Locator locatorLastProduct = page.locator("a#item_3_title_link");
        assertThat(locatorLastProduct).isVisible();
    }

    @Then("the product should show by Name Z to A")
    public void the_product_should_show_by_Name_Z_to_A() {
        Locator locatorFirstProduct = page.locator("a#item_3_title_link");
        assertThat(locatorFirstProduct).isVisible();
        Locator locatorLastProduct = page.locator("a#item_4_title_link");
        assertThat(locatorLastProduct).isVisible();
    }

    @Then("the product should show by price low to high")
    public void the_product_should_show_by_price_low_to_high() {
        Locator locatorFirstProduct = page.locator("a#item_2_title_link");
        assertThat(locatorFirstProduct).isVisible();
        Locator locatorLastProduct = page.locator("a#item_5_title_link");
        assertThat(locatorLastProduct).isVisible();
    }

    @Then("the product should show by price high to low")
    public void the_product_should_show_by_price_high_to_low() {
        Locator locatorFirstProduct = page.locator("a#item_5_title_link");
        assertThat(locatorFirstProduct).isVisible();
        Locator locatorLastProduct = page.locator("a#item_2_title_link");
        assertThat(locatorLastProduct).isVisible();
    }

    @Then("user should nevigate to cart page")
    public void user_should_nevigate_to_cart_page() {
        assertThat(page).hasURL("https://www.saucedemo.com/cart.html");
        page.waitForTimeout(300);
    }

    @Then("The name of product and price should match the selection form product page")
    public void The_name_of_product_and_price_should_match_the_selection_form_product_page() {
        assertThat(page.locator(SelectedFirstProductName)).isVisible();
        assertThat(page.locator(SelectedSecondProductName)).isVisible();
    }

    @Then("The product should been remove")
    public void The_product_should_been_remove() {
        assertThat(page.locator(SelectedSecondProductLocator)).isHidden();
        page.waitForTimeout(300);
    }

    @Then("user should nevigate to checkout Information page")
    public void user_should_nevigate_to_checkout_Information_page() {
        assertThat(page).hasURL("https://www.saucedemo.com/checkout-step-one.html");
        page.waitForTimeout(300);
    }

    @Then("user should nevagate to checkout overview page")
    public void user_should_nevigate_to_checkout_overview_page() {
        assertThat(page).hasURL("https://www.saucedemo.com/checkout-step-two.html");
        page.waitForTimeout(300);
    }

    @Then("total product price should correctly calculate")
    public void total_product_price_should_correctly_calculate() {
        String SelectedFirstProductPrice = page.locator(SelectedFirstProductPriceLocator).nth(0).textContent().replace("$", "");
        String SelectedSecondProductPrice = page.locator(SelectedSecondProductPriceLocator).nth(1).textContent().replace("$", "");
        double itemTotalPrice = Double.parseDouble(page.locator(itemTotalPriceLocator).textContent().replace("Item total: $", ""));
        double productTotalPrice = Double.parseDouble(SelectedFirstProductPrice) + Double.parseDouble(SelectedSecondProductPrice);
        assertEquals(productTotalPrice, itemTotalPrice,0);
    }

    @Then("user should nevagate to product page")
    public void user_should_nevagate_to_product_page() {
        assertThat(page).hasURL("https://www.saucedemo.com/inventory.html");
        page.waitForTimeout(300);
    }

    @Then("user should nevagate to the checkout complete page")
    public void user_should_nevagate_to_the_checkout_complete_page() {
        assertThat(page).hasURL("https://www.saucedemo.com/checkout-complete.html");
        page.waitForTimeout(300);
    }

    @Then("the cart icon number should be removed")
    public void the_cart_icon_number_should_be_removed() {
        assertThat(page.locator("span.shopping_cart_badge")).isHidden();
        page.waitForTimeout(300);
    }

    @Then("checkout status should show Complete")
    public void checkout_status_should_show_Complete() {
        String webStatusText = page.locator("span.title").textContent();
        String ExpectStatusText = "Checkout: Complete!";
        assertEquals(ExpectStatusText, webStatusText);
        page.waitForTimeout(300);
    }

    @Then("user should navigate back to the product page")
    public void user_should_navigate_back_to_the_product_page() {
        assertThat(page).hasURL("https://www.saucedemo.com/inventory.html");
    }
}