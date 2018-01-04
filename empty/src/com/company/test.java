package com.company;

        import org.junit.Assert;
        import org.junit.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.remote.server.SystemClock;
        import org.openqa.selenium.support.ui.Select;

public class test {

    @Test
    public void test1(){
        System.setProperty("webdriver.chrome.driver","ChromeDriver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.navigate().to("http://www.practiceselenium.com/practice-form.html");
        driver.findElement(By.name("firstname")).sendKeys("abcd");
        driver.findElement(By.name("lastname")).sendKeys("user");
        driver.findElement(By.id("sex-1")).click();
        driver.findElement(By.id("exp-2")).click();
        driver.findElement(By.id("datepicker")).sendKeys("9/1/2018");
        driver.findElement(By.id("tea2")).click();
        driver.findElement(By.id("tool-1")).click();

        Select dropdown=new Select(driver.findElement(By.id("continents")));
        dropdown.selectByIndex(1);

        Select dropdown2=new Select(driver.findElement(By.id("selenium_commands")));
        dropdown2.selectByIndex(2);

        driver.findElement(By.id("submit")).click();

        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "http://www.practiceselenium.com/welcome.html?firstname=abcd&lastname=user&sex=Female&exp=3&RedTea=Red+Tea&tool=Harmless+Addiction&continents=Europe&selenium_commands=Switch+Commands&submit=" );

        Boolean isPresent= driver.findElement(By.linkText("seleniumframework.com")).isDisplayed();
        Assert.assertTrue("Link not present" , isPresent);
    }
}

