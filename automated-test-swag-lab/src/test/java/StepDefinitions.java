import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Keyboard.TypeOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.ClickOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.assertions.PageAssertions.HasURLOptions;
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

    @When("user input {string} and {string} to text fields")
    public void user_input_username_and_password_to_text_fields(String username, String password) {
        page.locator("input#user-name").click();
        page.keyboard().type(username, new TypeOptions().setDelay(500));
        page.locator("input#password").click();
        page.keyboard().type(password, new TypeOptions().setDelay(500));
        page.waitForTimeout(1000);
    }

    @When("user login with {string} and {string} clicking login button")
    public void user_login_with_username_and_password_clicking_login_button(String username, String password) {
        page.locator("input#user-name").click();
        page.keyboard().type(username, new TypeOptions().setDelay(500));
        page.locator("input#password").click();
        page.keyboard().type(password, new TypeOptions().setDelay(500));
        page.locator("input#login-button").click();
        page.waitForTimeout(500);
    }

    @When("user login with {string} and {string} pressing Enter key")
    public void user_login_with_username_and_password_pressing_Enter_key(String username, String password) {
        page.locator("input#user-name").click();
        page.keyboard().type(username, new TypeOptions().setDelay(500));
        page.locator("input#password").click();
        page.keyboard().type(password, new TypeOptions().setDelay(500));
        page.keyboard().press("Enter");
        page.waitForTimeout(500);
    }

    @When("user login with {string} and clicking login button")
    public void user_login_with_password_clicking_login_button(String password) {
        page.locator("input#password").click();
        page.keyboard().type(password, new TypeOptions().setDelay(500));
        page.locator("input#login-button").click();
        page.waitForTimeout(500);
    }

    @When("user login with {string} clicking login button")
    public void user_login_with_username_clicking_login_button(String username) {
        page.locator("input#user-name").click();
        page.keyboard().type(username, new TypeOptions().setDelay(500));
        page.locator("input#login-button").click();
        page.waitForTimeout(500);
    }

    @When("user clicking login button with both fields blank")
    public void user_clicking_login_button_with_both_fields_blank () {
        page.locator("input#login-button").click();
        page.waitForTimeout(500);
    }

    @When("user login with {string} and {string} and clicking login button")
    public void user_login_with_invalid_username_and_invalid_password(String username, String password) {
        page.locator("input#user-name").click();
        page.keyboard().type(username, new TypeOptions().setDelay(500));
        page.locator("input#password").click();
        page.keyboard().type(password, new TypeOptions().setDelay(500));
        page.locator("input#login-button").click();
        page.waitForTimeout(500);
    }

    @When("user clicking add all product to cart")
    public void user_clicking_add_all_product_to_cart() {
        page.locator("button#add-to-cart-sauce-labs-backpack").click();
        page.locator("button#add-to-cart-sauce-labs-bike-light").click();
        page.locator("button#add-to-cart-sauce-labs-bolt-t-shirt").click();
        page.locator("button#add-to-cart-sauce-labs-fleece-jacket").click();
        page.locator("button#add-to-cart-sauce-labs-onesie").click();
        page.locator("button#add-to-cart-test\\.allthethings\\(\\)-t-shirt-\\(red\\)").click();
        page.waitForTimeout(1000);
    }

    @When("user clicking add two product to cart")
    public void user_clicking_add_two_product_to_cart() {
        page.locator("button#add-to-cart-sauce-labs-backpack").click();
        page.locator("button#add-to-cart-sauce-labs-fleece-jacket").click();
        page.waitForTimeout(1000);
    }

    @When("user clicking remove all of the product in cart")
    public void user_clicking_remove_all_of_the_product_in_cart() {
        page.locator("button#remove-sauce-labs-backpack").click();
        page.locator("button#remove-sauce-labs-bike-light").click();
        page.locator("button#remove-sauce-labs-bolt-t-shirt").click();
        page.locator("button#remove-sauce-labs-fleece-jacket").click();
        page.locator("button#remove-sauce-labs-onesie").click();
        page.locator("button#remove-test\\.allthethings\\(\\)-t-shirt-\\(red\\)").click();
        page.waitForTimeout(1000);
    }

    @Then("data should display as the data that was filled")
    public void data_should_display_as_the_data_that_was_filled() {
        Locator locatorUsername = page.locator("input#user-name");
        assertThat(locatorUsername).isVisible();
        Locator locatorPassword = page.locator("input#password");
        assertThat(locatorPassword).isVisible();
        page.waitForTimeout(1000);
    }

    @Then("display should show an error message")
    public void display_should_show_an_error_message() {
        Locator locatorErrorMessage = page.locator("h3");
        assertThat(locatorErrorMessage).isVisible();
        page.waitForTimeout(1000);
    }

    @Then("user should nevigate to product page")
    public void user_should_nevigate_to_product_page() {
        page.navigate("https://www.saucedemo.com/inventory.html");
        page.waitForTimeout(1000);
    }

    @Then("Cart icon should show number of the product")
    public void Cart_icon_should_show_number_of_the_product() {
        Locator locatorCartIcon = page.locator("span.shopping_cart_badge");
        assertThat(locatorCartIcon).isVisible();
        page.waitForTimeout(1000);
    }

    @Then("Cart icon should show no product in cart")
    public void Cart_icon_should_show_no_product_in_cart() {
        Locator locatorCartIcon = page.locator("a.shopping_cart_link");
        assertThat(locatorCartIcon).isVisible();
        page.waitForTimeout(1000);
    }
}
