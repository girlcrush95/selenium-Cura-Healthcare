package Home;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class login {

     private WebDriver driver;

     @Test
        public void loginValidAccount(){

         //Open Browser
         ChromeOptions chromeOptions = new ChromeOptions();
         chromeOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");

         WebDriver driver;
         System.setProperty("webdriver.chrome.driver","C:\\Driverapp\\chromedriver_win32_14\\chromedriver.exe");
         driver = new ChromeDriver(chromeOptions);

         //Navigate to URL Testing
         driver.get("https://katalon-demo-cura.herokuapp.com/");
         driver.manage().window().maximize();

         //Click Hamburger Menu
         WebElement hamburgerMenu = driver.findElement(By.xpath("/html/body/a/i"));
         hamburgerMenu.click();

         //Click Login Menu
         WebElement loginMenu = driver.findElement(By.xpath("/html/body/nav/ul/li[3]/a"));
         loginMenu.click();

         //Verify Login Page
         WebElement loginPage = driver.findElement(By.xpath("/html/body/section/div/div/div[1]/h2"));
         Assert.assertTrue(loginPage.isDisplayed());

         //Set Username
         WebElement setUsername = driver.findElement(By.id("txt-username"));
         setUsername.sendKeys("John Doe");

         //Set Password
         WebElement setPassword = driver.findElement(By.id("txt-password"));
         setPassword.sendKeys("ThisIsNotAPassword");

         //Click login button
         WebElement loginButton = driver.findElement(By.id("btn-login"));
         loginButton.click();

         //Verify Make Appointment Page
         String expected_login = "Make Appointment";
         String actual_login = driver.getTitle();

         if(actual_login.equals(expected_login)){
          System.out.println("Login Successful");
         }
         else{
          System.out.println("Login Failed");
         }

         driver.quit();

     }

     @Test
        public void loginInvalidAccount(){

         //Open Browser
         ChromeOptions chromeOptions = new ChromeOptions();
         chromeOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");

         WebDriver driver;
         System.setProperty("webdriver.chrome.driver","C:\\Driverapp\\chromedriver_win32_14\\chromedriver.exe");
         driver = new ChromeDriver(chromeOptions);

         //Navigate to URL Testing
         driver.get("https://katalon-demo-cura.herokuapp.com/");
         driver.manage().window().maximize();

         //Click Hamburger Menu
         WebElement hamburgerMenu = driver.findElement(By.xpath("/html/body/a/i"));
         hamburgerMenu.click();

         //Click Login Menu
         WebElement loginMenu = driver.findElement(By.xpath("/html/body/nav/ul/li[3]/a"));
         loginMenu.click();

         //Verify Login Page
         WebElement loginPage = driver.findElement(By.xpath("/html/body/section/div/div/div[1]/h2"));
         Assert.assertTrue(loginPage.isDisplayed());

         //Set Username
         WebElement setUsername = driver.findElement(By.id("txt-username"));
         setUsername.sendKeys("John Doe");

         //Set Password
         WebElement setPassword = driver.findElement(By.id("txt-password"));
         setPassword.sendKeys("ThisIsPassword");

         //Click login button
         WebElement loginButton = driver.findElement(By.id("btn-login"));
         loginButton.click();

         //Verify Error Message
         WebElement errorMessageLogin = driver.findElement(By.xpath("/html/body/section/div/div/div[1]/p[2]"));
            String actualErrorMessage = errorMessageLogin.getText();

         String expectedErrorMessage = "Login failed! Please ensure the username and password are valid.";
         Assert.assertEquals(actualErrorMessage,expectedErrorMessage,"Error message doesn't match");

         driver.quit();
     }

}
