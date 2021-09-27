package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class searchPage extends basePage{

    public searchPage(WebDriver driver) {
        super(driver);
    }

    public By items = By.xpath("//article[@data-cy='product-card-item']");

    public void scroolAndClickNavigationLink(int pageNumber){
        String navPath = "//li[@data-testid='pagination-list-item']//a[@aria-label='"+pageNumber+". sayfa']";
        By nav = By.xpath(navPath);
        scroolToBy(nav);
        click(nav);
    }

    public void randomSelectProductBy() {
        Random random = new Random();
        int itemsCount = findElementsBy(items).size();
        int rand = random.nextInt(itemsCount+1);
        By selectedItem = By.xpath("(//article[@data-cy='product-card-item'])["+rand+"]");
        scroolToBy(selectedItem);
        click(selectedItem);
    }

}
