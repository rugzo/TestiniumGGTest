package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class basePage {

    public WebDriver driver;
    WebDriverWait wait;

    public basePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 20);
    }

    public WebElement findElementBy(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return driver.findElement(by);

    }

    public void sendKeys(By by, String value) {
        findElementBy(by).sendKeys(value);
    }

    public WebElement elementCanClickable(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
        return driver.findElement(by);
    }

    public void click(By by) {

        elementCanClickable(by).click();
    }

    public void scroolToBy(By by){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView(true)", findElementBy(by));
    }

    public List<WebElement> findElementsBy(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return driver.findElements(by);

    }

    public void waitTime(long waitMilisecond)
    {
        try{
            Thread.sleep(waitMilisecond);
        }
        catch(InterruptedException ie){

        }
    }

    public boolean isElementExist(By by) {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.MILLISECONDS);
        boolean exists = driver.findElements(by).size() != 0;
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return exists;

    }


}
