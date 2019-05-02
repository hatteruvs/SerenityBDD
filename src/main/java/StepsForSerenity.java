import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static junit.framework.TestCase.assertTrue;

public class StepsForSerenity {

    public HomePage homePage;
    public WebDriver webDriver;
    public ComputerPage computerPage;
    public String siteHomePage = "https://pn.com.ua/";
    @Step("Given the user visits the page(0)")
    public void a_user_visits_a_page(String homePage)
    {
        this.siteHomePage = homePage;
    }
    @Step("When the user add products to compare(0)")
    public void the_user_adds_product_to_compare() throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\hatteruvs\\Downloads\\chromedriver_win32\\chromedriver.exe");
        webDriver = new ChromeDriver();
        homePage = new HomePage(webDriver);
        webDriver.get(siteHomePage);
        computerPage = homePage.choiceComputerCategory();
    }
    @Step("Then the user sees (0) how much products have been added")
    public void the_user_can_see_number_of_products(String numberOfGoods)
    {
        System.out.println("nmb: " + computerPage.getNumberOfGoods());
        assertTrue(computerPage.getNumberOfGoods().equals(numberOfGoods));
        webDriver.quit();
    }

}
