package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.testng.Assert;


public class LoginPage {
    public WebDriver driver;
    By email = By.xpath("//input[@name='email']");
    By password = By.xpath("//input[@name='password']");
    By signInButton = By.xpath("//button[@type='submit']");
    By forgetPassword = By.xpath("//div[@class='small']");
    By title = By.xpath("//div[@class='sign-in-box']/h1");
    By image = By.xpath("//img[@class='signIn-img']");
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement getEmailId()
    {
        return driver.findElement(email);
    }

    public WebElement getPassword()
    {
        return driver.findElement(password);
    }

    public WebElement getSigninButton()
    {
        return driver.findElement(signInButton);
    }

    public WebElement getForgetPassword()
    {
        return driver.findElement(forgetPassword);
    }

    public WebElement getTitle()
    {
        return driver.findElement(title);
    }

    public WebElement getImage()
    {
        return driver.findElement(image);
    }

}
