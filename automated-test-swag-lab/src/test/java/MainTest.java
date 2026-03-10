import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;

import com.microsoft.playwright.Playwright;

public class MainTest {

    private static Browser browser;
    private static Page page;

    @BeforeClass
    public static void BeforeClass() {
        Playwright playwright = Playwright.create();
        LaunchOptions LaunchOptions = new BrowserType.LaunchOptions().setHeadless(false);
        browser = playwright.chromium().launch(LaunchOptions);
    }

    // Wind-up
    @Before
    public void before() {
        page =  browser.newPage();
    }

    // Tear-down
    @After
    public void after() {
        page.close();
    }

    @Test
    public void test() {
        page.navigate("https://www.saucedemo.com/");
        page.waitForTimeout(500);
    }

}
