package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPageDuckDuckGo extends BasePage{

    //po utworzeniu klasy PageObjectu dodaję dziedziczenie po BasePage, IDE wymusza utworzenie konstruktora z parametrem "super". Nie piszę go z ręki, IDE samo to generuje

    public MainPageDuckDuckGo(WebDriver driver) {
        super(driver);
    }

    //następnie wyszukuję sobie lokatory z pomocą @FindBy
    //jeżeli w testach chcę się odniść bezpośrednio do lokatorów, to muszę tutaj utworzyć gettert/settery, lub (ale mniej profesjonalnie) mogę zmienić modyfikator dostępu z 'private' na 'public'

    @FindBy(css = "#search_form_input_homepage")
    private WebElement searchBar;

    public void searchForDog(String text){
        waitForElementToBeVisible(searchBar); //to tutaj jest niepotrzebne ale chciałem pokazać jak upychać waity kiedy ich potrzebujemy
        searchBar.sendKeys(text);
        searchBar.submit();
    }
}
