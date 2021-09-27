package steps;

import com.thoughtworks.gauge.Step;
import driver.baseTest;
import org.junit.Assert;
import pageObjects.*;


import static org.assertj.core.api.Assertions.assertThat;

public class StepImplementation extends baseTest {

    homePage homePage;
    searchPage searchPage;
    productPage productPage;
    basketPage basketPage;

    @Step("Init Test")
    public void InitTest() {
        homePage = new homePage(webDriver);
        searchPage = new searchPage(webDriver);
        productPage = new productPage(webDriver);
        basketPage = new basketPage(webDriver);

    }

    @Step("Open the Gittigidiyor homepage")
    public void open_home_page() {
        homePage.goToHomePage();
        assertThat(webDriver.getTitle()).contains(homePage.homePageTitle);
    }

    @Step("Search <keyword> in homePage")
    public void searchInHomepage(String keyword) {
        homePage.searchKeyword(keyword);
    }

    @Step("Go to <pageNumber>th page in searchPage")
    public void goTothPageInSearchpage(int pageNumber) {
        searchPage.scroolAndClickNavigationLink(pageNumber);
    }


    @Step("Check <pageNumber>th page in searchPage")
    public void checkthpage(String pageNumber) {
        Assert.assertTrue(webDriver.getCurrentUrl().contains(pageNumber));
    }

    @Step("Select random product and click")
    public void selectRandomProductAndClick() {
        searchPage.randomSelectProductBy();

    }

    @Step("Stored item name and price in txt")
    public void storedItemNameAndPriceInTxt() {
        productPage.StoreItemDetailsInTxt();
    }

    @Step("Add to Basket")
    public void addToBasket() {
        productPage.AddtoBasketItem();
    }


    @Step("Go to Basket")
    public void gotobasketinproductpage() {
        productPage.GoToBasket();
    }

    @Step("Verify stored item and added basket item")
    public void veriftStoredItemAndAddedBasketItem() {
        basketPage.readItemDetailsInTxt();
        assertThat(basketPage.storedItemName).contains(basketPage.getBasketItemName());
        assertThat(basketPage.storedItemPrice).contains(basketPage.getBasketItemPrice());

    }

    @Step("Increase the amount of product in basketPage")
    public void IncreaseAmount() {
        basketPage.increaseProductCount();
    }

    @Step("Remove item from basket")
    public void RemoveItemFromBasket() {
        basketPage.removeProduct();
    }

    @Step("Verify basket is empty")
    public void VerifyEmptyBasket() {
        Assert.assertTrue(basketPage.isBasketEmpty());
    }


    @Step("Verify increased amount")
    public void Verifyincreased() {
        Assert.assertTrue(basketPage.verifyIncreased());
    }
}
