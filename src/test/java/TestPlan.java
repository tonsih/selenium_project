import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestPlan {
    static ChromeOptions options = new ChromeOptions().addArguments("incognito");
    private static final WebDriver driver = new ChromeDriver(options);

    @BeforeSuite
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
    }

    @Test(testName = "Open Youtube")
    public static void openYoutube(){
        driver.get("https://www.youtube.com/");
        new ElementsAndActions(driver);
    }

    @Test(testName = "Go to Youtube and accept all", dependsOnMethods = "openYoutube")
    public static void acceptAll(){
        ElementsAndActions elementsAndActions = new ElementsAndActions(driver);
        elementsAndActions.waitForCookies();
        elementsAndActions.acceptCookies();
    }

    @Test(testName = "Find cute sloths", dependsOnMethods = "acceptAll")
    public static void findCuteSloths(){
        ElementsAndActions elementsAndActions = new ElementsAndActions(driver);
        elementsAndActions.waitForSearchBar();
        elementsAndActions.typeSearchText();
        elementsAndActions.submitSearch();
    }

    @AfterSuite
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
    //    driver.close();
    }
}