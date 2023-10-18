package Testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Dashboard;
import pageObjects.LoginPage;
import pageObjects.MediaCompanies;
import resourses.Base;

import java.io.IOException;

public class MediaCompanySearch extends Base
{
    public WebDriver driver;

    @BeforeTest
    public void initialize() throws IOException
    {
        driver = InitializeDriver();
        driver.get(prop.getProperty("url"));

        LoginPage lp = new LoginPage(driver);
        lp.getEmailId().sendKeys(prop.getProperty("username"));
        lp.getPassword().sendKeys(prop.getProperty("password"));
        lp.getSigninButton().click();

        Dashboard db = new Dashboard(driver);
        db.getMediaCompany().click();
    }

    @Test
    public void searchMediaCompany() throws IOException, InterruptedException {
        MediaCompanies mc = new MediaCompanies(driver);
        String searchedName = mc.splitRepresentativeName(mc.getSearchedName().getText());

        mc.getSearch().sendKeys(searchedName);
        Thread.sleep(2000);
        String validateName = mc.splitRepresentativeName(mc.getValidateName().getText());

        Assert.assertEquals(searchedName, validateName);
    }

    @AfterTest
    public void teardown()
    {
        driver.close();
    }
}

