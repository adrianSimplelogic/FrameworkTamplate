import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.MainPageDuckDuckGo;

public class TestsHere extends BaseTest{

    MainPageDuckDuckGo mainPageDuckDuckGo; //inicjuję PageObject

    @Test
    public void someTestName() throws InterruptedException {
        mainPageDuckDuckGo = new MainPageDuckDuckGo(driver); //tworzę obiekt strony i wstrzykuję drivera


        driver.get("https://duckduckgo.com");
        mainPageDuckDuckGo.searchForDog("Dog");
//        Thread.sleep(200);
        Assert.assertTrue(driver.getCurrentUrl().contains("q=Dog"));
    }

}
