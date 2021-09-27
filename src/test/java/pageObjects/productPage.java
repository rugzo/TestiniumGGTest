package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class productPage extends basePage{
    public productPage(WebDriver driver) {
        super(driver);
    }

    public By addToBasketButton = By.id("add-to-basket");
    public By itemTitle = By.id("sp-title");
    public By itemsubTitle = By.id("sp-subTitle");
    public By itemPrice = By.id("sp-price-lowPrice");
    public By goToBasketButton = By.xpath("//span[@class='basket-title']");


    public void AddtoBasketItem(){
        click(addToBasketButton);
        waitTime(3000);
    }

    public void StoreItemDetailsInTxt(){
        try {
            String title = "";
            if(isElementExist(itemsubTitle) && findElementBy(itemsubTitle).getText().trim().length()>0)
                title = findElementBy(itemsubTitle).getText().trim();
            else
                title = findElementBy(itemTitle).getText().trim();

            //FileWriter myWriter = new FileWriter("itemDetails.txt");
            OutputStreamWriter myWriter =
                    new OutputStreamWriter(new FileOutputStream("itemDetails.txt"), StandardCharsets.UTF_8);
            myWriter.write(title+"\n");
            myWriter.write(findElementBy(itemPrice).getText());
            myWriter.close();
            System.out.println("Successfully stored data.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void GoToBasket(){
        click(goToBasketButton);
    }


}
