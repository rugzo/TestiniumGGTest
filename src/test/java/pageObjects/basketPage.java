package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class basketPage extends basePage{
    public basketPage(WebDriver driver) {
        super(driver);
    }

    public By addedItemName = By.xpath("//a[@class='title-link']//h2");
    public By addedItemPrice= By.xpath("//div[@class='total-price']");
    public String storedItemName = "";
    public String storedItemPrice = "";
    public  By amountOption = By.xpath("//select[@class='amount']");
    public  By deleteProduct = By.cssSelector("a[title='Sil']");



    public  void readItemDetailsInTxt(){
        try {
            File myObj = new File("itemDetails.txt");
            Scanner myReader = new Scanner(myObj,"UTF-8");
            int line = 0;
            while (myReader.hasNextLine()) {
                if(line == 0){storedItemName = myReader.nextLine().trim();}
                if(line == 1){storedItemPrice = myReader.nextLine().trim();}
                line +=1;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public  String getBasketItemName(){
        return findElementBy(addedItemName).getText().trim();
    }

    public  String getBasketItemPrice(){
        return findElementBy(addedItemPrice).getText().trim();
    }

    public  void increaseProductCount(){
        click(amountOption);
        waitTime(1000);
        click(By.cssSelector("option[value='2']"));
        waitTime(3000);
    }

    public  boolean verifyIncreased(){
        if(getBasketItemPrice().contains(storedItemPrice)){
            return false;
        }else{
            return  true;
        }
    }

    public  void removeProduct(){
        click(deleteProduct);
    }

    public  boolean isBasketEmpty(){
        return  isElementExist(addedItemName);
    }


}
