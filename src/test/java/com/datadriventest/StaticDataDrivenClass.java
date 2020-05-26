package com.datadriventest;

import com.mavconfig.excel.utility.Xls_Reader;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class StaticDataDrivenClass

{
    WebDriver driver;
    POMClass pomClass;
    WebElement waitElement;
    Xls_Reader dataReader;
    String firstName,lastName,phone,email,address1,address2,city,state,postalCode,country,userName,password,confirmPassword;

    @BeforeTest
    @Parameters({"browser"})
    void browserSetup(String browser)
    {
        if (browser.equals("Chrome"))
        {
            ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
            driver = new ChromeDriver();
        }

        else if (browser.equals("Firefox"))
        {
            FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
            driver = new FirefoxDriver();

        }
    }

    @BeforeClass
    @Parameters({"url"})
    void launchURL(String url)
    {
        System.out.println(url);

        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(url);
    }

    @Test(priority = 2)
    void goToRegPage()
    {
        waitElement = driver.findElement(By.linkText("REGISTER"));
        waitforVisiblity(driver, waitElement,15);

        if (waitElement.isDisplayed())
        {
            pomClass = new POMClass(driver);

            pomClass.goToRegLink();
        }
    }

    @Test(priority = 1)
    void getExcelData()
    {
        dataReader = new Xls_Reader("C:\\Backup\\Selenium - Workspace\\IdeaProjects\\MavenSeleniumConfig\\src\\test\\java\\com\\testdata\\testData.xlsx");

        firstName = dataReader.getCellData("RegData","firstname",2);
        System.out.println("The first name is " +firstName);

         lastName = dataReader.getCellData("RegData","lastname",2);
         System.out.println("The last name is  : " +lastName);
         phone = dataReader.getCellData("RegData","phone",2);
         System.out.println("The Phone Number  : " +phone);
         email = dataReader.getCellData("RegData","email",2);
         System.out.println("The email address is  : " +email);
         address1 = dataReader.getCellData("RegData","Address1",2);
         System.out.println("The First Address Line is  : " +address1);
         address2 = dataReader.getCellData("RegData","Address2",2);
         System.out.println("The Second Address Line is  : " +address2);
         city = dataReader.getCellData("RegData","city",2);
         System.out.println("The City is  : " +city);
         state = dataReader.getCellData("RegData","state",2);
         System.out.println("The State is  : " +state);
         postalCode = dataReader.getCellData("RegData","postalcode",2);
         System.out.println("The postal code is  : " +postalCode);
         country = dataReader.getCellData("RegData","country",2);
         System.out.println("The Country is  : " +country);
         userName = dataReader.getCellData("RegData","username",2);
         System.out.println("The Username is  : " +userName);
         password = dataReader.getCellData("RegData","password",2);
         System.out.println("The password is  : " +password);
         confirmPassword = dataReader.getCellData("RegData","confirmpassword",2);
         System.out.println("The confirm password is  : " +confirmPassword);
    }

    @Test(priority = 3)
    void fillTheForm()
    {
        pomClass.setFirstName(firstName);
        pomClass.setLastName(lastName);
        pomClass.setPhone(phone);
        pomClass.setEmail(email);
        pomClass.setAddressFirstLine(address1);
        pomClass.setAddressSecondLine(address2);
        pomClass.setCity(city);
        pomClass.setState(state);
        pomClass.setPostalCode(postalCode);
        pomClass.setCountry(country);
        pomClass.setUserName(userName);
        pomClass.setPassword(password);
        pomClass.setConfirmPassword(confirmPassword);
        pomClass.clickRegBtn();

    }

    @Test(priority = 4)
    void completeRegn()
    {
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        if (driver.getPageSource().contains("Thank you for registering"))
        {
            System.out.println("Tests are Successfully executed!!!!, All Tests are passed");
        }
        else
        {
            System.out.println("Something Went Wrong!!!");
        }
    }


    @AfterClass
    void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    private void waitforVisiblity(WebDriver driver, WebElement element, int timeout)
    {
        new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(element));
    }


}
