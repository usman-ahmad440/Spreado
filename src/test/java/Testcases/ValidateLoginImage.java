package Testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import resourses.Base;

import java.io.IOException;

public class ValidateLoginImage extends Base
{
    public WebDriver driver;

    @BeforeTest
    public void initialize() throws IOException
    {
        driver = InitializeDriver();
        driver.get(prop.getProperty("url"));
    }

    @Test
    public void validteImage() throws IOException
    {
        LoginPage lp = new LoginPage(driver);
        Assert.assertTrue(lp.getImage().isDisplayed());
    }

    @AfterTest
    public void teardown()
    {
        driver.close();
    }
}