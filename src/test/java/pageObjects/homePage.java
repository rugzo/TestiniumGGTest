package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class homePage extends basePage{

    public homePage(WebDriver driver) {
        super(driver);
    }

    public String homePageUrl = "https://gittigidiyor.com";
    public String homePageTitle = "GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi";
    public By searchBox = By.xpath("//input[@data-cy='header-search-input']");
    public By searchBTN = By.xpath("//button[@data-cy='search-find-button']");
    public By closeCookieInfoBTN = By.xpath("//a//span[text() = 'Kapat']");


    public  void goToHomePage(){
        driver.get(homePageUrl);
        if(isElementExist(closeCookieInfoBTN)) click(closeCookieInfoBTN);
    }

    public void searchKeyword(String keyword){
        sendKeys(searchBox,keyword);
        click(searchBTN);
    }








}
