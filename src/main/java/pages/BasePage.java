package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {

    WebDriver driver; //inicjacja webdrivera, jednak nie będziemy tutaj tworzyć jego obiektu, utworzymy go w BaseTest
    WebDriverWait wait; //inicjacja zaawansowanego waita, utworzymy tutaj jego obiekt
    Actions actions; //inicajcja klasy Acitions, jeżeli jest potrzebna, jeżeli tak, to tutaj jest najlepsze miejsce

    //tworzę konstruktor i przekazuję w nim Webdrivera którego zainicjowałem w linii #13
    //z ręki wywołuję klasę PageFactory która inicjuje elementy, tzn. będzie to robić dla PageObjectach które będą dziedziczyć po BasePage. Potrzebne to jest aby korzystać z adnotacji @FindBy
    //z ręki tworzę nowe obiekty dla "czekacza" i "akcji", aby móc to zrobić musiałem zainicjować drivera linia #9
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        actions = new Actions(driver);
    }

    //poniżej tworzę metody dla "czekaczy", będą z nich korzystać PageObjecty. Można tych metod tutaj utworzyć więcej, np. dla klasy Actions.

    public void waitForElementToBeVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
