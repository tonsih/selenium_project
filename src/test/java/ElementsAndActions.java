import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsAndActions extends PageObject{

    private final String videoToFind = "cute sloth";

    // This element gets updated as the page refreshes once the cookies are
    // accepted. Therefore it must be called again, just before using it. See
    // "waitForSearchBar".
    @FindBy(name = "search_query")
    private WebElement searchField;

    @FindBy(id = "search-icon-legacy")
    private WebElement submitButton;

    @FindBy(css = "[aria-label='Godkänn att cookies och annan data används för" +
            " de ändamål som beskrivs']")
    private WebElement cookiesOk;

    public ElementsAndActions(WebDriver driver) {
        super(driver);
    }

    public void waitForCookies(){
        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.elementToBeClickable(cookiesOk));
    }

    public void acceptCookies(){
        this.cookiesOk.click();
    }

    public void waitForSearchBar(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
    //    wait.until(ExpectedConditions.elementToBeClickable(searchField));
        wait.until(ExpectedConditions.elementToBeClickable(By.name(
            "search_query")));
    }


    public void typeSearchText(){
        this.searchField.sendKeys(videoToFind);
    //    driver.findElement(By.name("search_query")).sendKeys("Selenium");
    }

    public void submitSearch(){
        this.submitButton.click();
    }
}