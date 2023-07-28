import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class create_User {

    public static void main(String[] args) throws IOException, InterruptedException {

        WebDriver driver=new ChromeDriver();
        driver.get("https://www.moyo.ua/ua/");

        driver.manage().window().maximize();

        //for registration we must click on button "Увійти"
        //to avoid problems with the language, we take another locator
        WebElement come_in = driver.findElement(By.xpath("//div[@class='header_cabinet']/div[2]"));
        come_in.click();

        String singUpPage = driver.getCurrentUrl();
        System.out.println("the current URL is: "+singUpPage);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //choose registration
        WebElement reg = driver.findElement(By.xpath("//*[@id='js-auth-modal']/div[1]/div[1]/div[2]"));
        reg.click();

        WebElement firstName = driver.findElement(By.xpath("//input[@type='text'][@name='firstname']"));
        firstName.sendKeys("фіф");
        WebElement phone = driver.findElement(By.xpath("//input[@type='text'][@name='phone']"));
        phone.sendKeys("123121141");
        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys("asd@asd.com");

        WebElement cb = driver.findElement(By.xpath("//input[@type='checkbox']"));
        boolean isSel = cb.isSelected();
        if (!isSel){
            cb.click();
        }
        WebElement regButton = driver.findElement(By.xpath("//button[@class='btn js-auth-form-submit']"));
        regButton.click();

        Thread.sleep(2000); //just for a little pause

        //take screenshot

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("src\\result-screenshot.png"));



        driver.quit();

}}
