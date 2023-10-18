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

public class ValidateEditMediaCompany extends Base
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
    public void editMediaCompany() throws IOException, InterruptedException {

        MediaCompanies mc = new MediaCompanies(driver);

        String representativeName = mc.splitRepresentativeName(mc.getValidateName().getText());
        String companyName = mc.splitCompanyName(mc.getCompanyName().getText());

        mc.getEditButton().click();

        mc.getRepresentativeNameField().clear();
        mc.getRepresentativeNameField().sendKeys(representativeName+2);

        mc.getCompanyNameField().clear();
        mc.getCompanyNameField().sendKeys(companyName+2);

        mc.getSubmitButton().click();
        mc.getCloseModalBox().click();

        Thread.sleep(2000);
        Assert.assertEquals(mc.splitRepresentativeName(mc.getValidateName().getText()),representativeName+2);
        Assert.assertEquals(mc.splitCompanyName(mc.getCompanyName().getText()),companyName+2);

        //Change name back to original
        mc.getEditButton().click();

        mc.getRepresentativeNameField().clear();
        mc.getRepresentativeNameField().sendKeys(representativeName);

        mc.getCompanyNameField().clear();
        mc.getCompanyNameField().sendKeys(companyName);

        mc.getSubmitButton().click();
    }

    @AfterTest
    public void teardown()
    {
        driver.close();
    }
}

