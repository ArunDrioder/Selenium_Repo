package com.datadriventest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class POMClass
{
    WebDriver driver;


    public POMClass(WebDriver webDriver)
    {
        driver = webDriver;
    }

    By regLink = By.linkText("REGISTER");
    By firstName = By.xpath("//input[@name='firstName']");
    By lastName = By.name("lastName");
    By phone = By.name("phone");
    By addressFirstLine = By.name("address1");
    By addressSecondLine = By.name("address2");
    By city = By.name("city");
    By state = By.name("state");
    By postalCode = By.name("postalCode");
    By country = By.name("country");
    By email = By.name("userName");
    By userName = By.name("email");
    By password = By.name("password");
    By confirmPassword = By.name("confirmPassword");
    By regSubmit = By.name("register");

    public void goToRegLink()
    {
        driver.findElement(regLink).click();
    }


    public void setFirstName(String fname)
    {
        driver.findElement(firstName).sendKeys(fname);
    }

    public void setLastName(String lname)
    {
        driver.findElement(lastName).sendKeys(lname);
    }

    public void setPhone(String phoneNo)
    {
        driver.findElement(phone).sendKeys(phoneNo);
    }

    public void setAddressFirstLine(String firstAddress)
    {
        driver.findElement(addressFirstLine).sendKeys(firstAddress);
    }

    public void setAddressSecondLine(String secondAddress)
    {
        driver.findElement(addressSecondLine).sendKeys(secondAddress);
    }

    public void setCity(String cityString)
    {
        driver.findElement(city).sendKeys(cityString);
    }

    public void setState(String stateString)
    {
        driver.findElement(state).sendKeys(stateString);
    }

    public void setPostalCode(String code)
    {
        driver.findElement(postalCode).sendKeys(code);
    }

    public void setCountry(String countryString)
    {
        WebElement countryDD = driver.findElement(country);
        Select dropDown = new Select(countryDD);
        dropDown.selectByVisibleText(countryString);
    }

    public void setEmail(String emailAddress)
    {
        driver.findElement(email).sendKeys(emailAddress);
    }

    public void setUserName(String username)
    {
        driver.findElement(userName).sendKeys(username);
    }

    public void setPassword(String passwordString)
    {
        driver.findElement(password).sendKeys(passwordString);
    }

    public void setConfirmPassword(String confPassword)
    {
        driver.findElement(confirmPassword).sendKeys(confPassword);
    }

    public void clickRegBtn()
    {
        driver.findElement(regSubmit).click();
    }







}
