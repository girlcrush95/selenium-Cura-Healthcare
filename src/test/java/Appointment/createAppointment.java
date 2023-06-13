package Appointment;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import javax.swing.*;

public class createAppointment {

    private WebDriver driver;

    @Test
        public void createAppointmentBeforeLogin(){
        ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");

        WebDriver driver;
        System.setProperty("webdriver.chrome.driver","C:\\Driverapp\\chromedriver_win32_14\\chromedriver.exe");
        driver = new ChromeDriver(chromeOptions);

        //Navigate to URL Testing
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();

        //Click Make Appointment Button
        WebElement makeAppointmentButton = driver.findElement(By.id("btn-make-appointment"));
            makeAppointmentButton.click();

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
        WebElement makeAppointmentPage = driver.findElement(By.xpath("/html/body/section/div/div/div/h2"));
            Assert.assertTrue(makeAppointmentPage.isDisplayed());

        //Select Facility
        WebElement dropdownFacility = driver.findElement(By.id("combo_facility"));
            Select facilityType = new Select(dropdownFacility);
                facilityType.selectByValue("Hongkong CURA Healthcare Center");

        //Choose Healthcare Program
        WebElement healthcareProgram = driver.findElement(By.id("radio_program_medicaid"));
        // Check if the radio button is already selected
        boolean isSelected = healthcareProgram.isSelected();
        // If the radio button is not selected, click on it
        if (!isSelected) {
            healthcareProgram.click();
        }

        //Select Visit Date
        WebElement visitDate = driver.findElement(By.id("txt_visit_date"));
        // Click on the date picker element to open the calendar
            visitDate.click();
        // Select a specific date by interacting with the calendar
        WebElement desiredDate = driver.findElement(By.xpath("/html/body/div/div[1]/table/tbody/tr[4]/td[5]"));
            desiredDate.click();
        Actions action = new Actions(driver);
            action.sendKeys(visitDate, Keys.ESCAPE).perform();

        //Enter Comment
        WebElement comment = driver.findElement(By.id("txt_comment"));
            comment.sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");

        //Click Book Appointment
        WebElement bookAppointmentButton = driver.findElement(By.id("btn-book-appointment"));
            bookAppointmentButton.click();

        //Verify Appointment Confirmation
        WebElement appointmentConfirmation = driver.findElement(By.xpath("/html/body/section/div/div/div[1]/h2"));
            Assert.assertTrue(appointmentConfirmation.isDisplayed());

        //Click Back to Homepage
        WebElement homepageButton = driver.findElement(By.xpath("/html/body/section/div/div/div[7]/p/a"));
            homepageButton.click();

        //Verify Homepage page
        WebElement homepageBack = driver.findElement(By.xpath("/html/body/header/div/h1"));
            Assert.assertTrue(homepageBack.isDisplayed());

            driver.quit();
    }

    @Test
        public  void createAppointmentAfterLogin(){
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

        //CLick Login menu
        WebElement loginMenu = driver.findElement(By.xpath("/html/body/nav/ul/li[3]/a"));
            loginMenu.click();

        //Verify Login Page
        WebElement login_page = driver.findElement(By.xpath("/html/body/section/div/div/div[1]/h2"));
            Assert.assertTrue(login_page.isDisplayed());

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
        WebElement makeAppointmentPage = driver.findElement(By.xpath("/html/body/section/div/div/div/h2"));
            Assert.assertTrue(makeAppointmentPage.isDisplayed());

        //Select Facility
        WebElement dropdownFacility = driver.findElement(By.id("combo_facility"));
            Select facilityType = new Select(dropdownFacility);
                facilityType.selectByValue("Hongkong CURA Healthcare Center");

        //Choose Healthcare Program
        WebElement healthcareProgram = driver.findElement(By.id("radio_program_medicaid"));
        // Check if the radio button is already selected
        boolean isSelected = healthcareProgram.isSelected();
        // If the radio button is not selected, click on it
        if (!isSelected) {
            healthcareProgram.click();
        }

        //Select Visit Date
        WebElement visitDate = driver.findElement(By.id("txt_visit_date"));
        // Click on the date picker element to open the calendar
        visitDate.click();
        // Select a specific date by interacting with the calendar
        WebElement desiredDate = driver.findElement(By.xpath("/html/body/div/div[1]/table/tbody/tr[4]/td[5]"));
        desiredDate.click();
        Actions action = new Actions(driver);
        action.sendKeys(visitDate, Keys.ESCAPE).perform();

        //Enter Comment
        WebElement comment = driver.findElement(By.id("txt_comment"));
            comment.sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");

        //Click Book Appointment
        WebElement bookAppointmentButton = driver.findElement(By.id("btn-book-appointment"));
            bookAppointmentButton.click();

        //Verify Appointment Confirmation
        WebElement appointmentConfirmation = driver.findElement(By.xpath("/html/body/section/div/div/div[1]/h2"));
            Assert.assertTrue(appointmentConfirmation.isDisplayed());

        //Click Back to Homepage
        WebElement homepageButton = driver.findElement(By.xpath("/html/body/section/div/div/div[7]/p/a"));
            homepageButton.click();

        //Verify Homepage page
        WebElement homepageBack = driver.findElement(By.xpath("/html/body/header/div/h1"));
            Assert.assertTrue(homepageBack.isDisplayed());

        driver.quit();
    }

    @Test
        public void createAppointmentBeforeLogin_hospitalReadmission(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");

        WebDriver driver;
        System.setProperty("webdriver.chrome.driver","C:\\Driverapp\\chromedriver_win32_14\\chromedriver.exe");
        driver = new ChromeDriver(chromeOptions);

        //Navigate to URL Testing
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();

        //Click Make Appointment Button
        WebElement makeAppointmentButton = driver.findElement(By.id("btn-make-appointment"));
        makeAppointmentButton.click();

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
        WebElement makeAppointmentPage = driver.findElement(By.xpath("/html/body/section/div/div/div/h2"));
        Assert.assertTrue(makeAppointmentPage.isDisplayed());

        //Select Facility
        WebElement dropdownFacility = driver.findElement(By.id("combo_facility"));
        Select facilityType = new Select(dropdownFacility);
        facilityType.selectByValue("Hongkong CURA Healthcare Center");

        //Check the Apply for hospital readmission
        WebElement checkbox_readmission = driver.findElement(By.id("chk_hospotal_readmission"));
            checkbox_readmission.click();
            if(checkbox_readmission.isSelected()){
                System.out.println("Checkbox is Selected");
            }
            else{
                System.out.println("Checkbox is not Selected");
            }

        //Choose Healthcare Program
        WebElement healthcareProgram = driver.findElement(By.id("radio_program_medicaid"));
        // Check if the radio button is already selected
        boolean isSelected = healthcareProgram.isSelected();
        // If the radio button is not selected, click on it
        if (!isSelected) {
            healthcareProgram.click();
        }

        //Select Visit Date
        WebElement visitDate = driver.findElement(By.id("txt_visit_date"));
        // Click on the date picker element to open the calendar
        visitDate.click();
        // Select a specific date by interacting with the calendar
        WebElement desiredDate = driver.findElement(By.xpath("/html/body/div/div[1]/table/tbody/tr[4]/td[5]"));
        desiredDate.click();
        Actions action = new Actions(driver);
        action.sendKeys(visitDate, Keys.ESCAPE).perform();

        //Enter Comment
        WebElement comment = driver.findElement(By.id("txt_comment"));
            comment.sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");

        //Click Book Appointment
        WebElement bookAppointmentButton = driver.findElement(By.id("btn-book-appointment"));
            bookAppointmentButton.click();

        //Verify Appointment Confirmation
        WebElement appointmentConfirmation = driver.findElement(By.xpath("/html/body/section/div/div/div[1]/h2"));
            Assert.assertTrue(appointmentConfirmation.isDisplayed());

        //Click Back to Homepage
        WebElement homepageButton = driver.findElement(By.xpath("/html/body/section/div/div/div[7]/p/a"));
            homepageButton.click();

        //Verify Homepage page
        WebElement homepageBack = driver.findElement(By.xpath("/html/body/header/div/h1"));
            Assert.assertTrue(homepageBack.isDisplayed());

        driver.quit();
    }

    @Test
        public void createAppointmentAfterLogin_hospitalReadmission(){
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

        //CLick Login menu
        WebElement loginMenu = driver.findElement(By.xpath("/html/body/nav/ul/li[3]/a"));
        loginMenu.click();

        //Verify Login Page
        WebElement login_page = driver.findElement(By.xpath("/html/body/section/div/div/div[1]/h2"));
            Assert.assertTrue(login_page.isDisplayed());

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
        WebElement makeAppointmentPage = driver.findElement(By.xpath("/html/body/section/div/div/div/h2"));
            Assert.assertTrue(makeAppointmentPage.isDisplayed());

        //Select Facility
        WebElement dropdownFacility = driver.findElement(By.id("combo_facility"));
        Select facilityType = new Select(dropdownFacility);
        facilityType.selectByValue("Hongkong CURA Healthcare Center");

        //Check the Apply for hospital readmission
        WebElement checkbox_readmission = driver.findElement(By.id("chk_hospotal_readmission"));
        checkbox_readmission.click();
        if(checkbox_readmission.isSelected()){
            System.out.println("Checkbox is Selected");
        }
        else{
            System.out.println("Checkbox is not Selected");
        }

        //Choose Healthcare Program
        WebElement healthcareProgram = driver.findElement(By.id("radio_program_medicaid"));
        // Check if the radio button is already selected
        boolean isSelected = healthcareProgram.isSelected();
        // If the radio button is not selected, click on it
        if (!isSelected) {
            healthcareProgram.click();
        }

        //Select Visit Date
        WebElement visitDate = driver.findElement(By.id("txt_visit_date"));
        // Click on the date picker element to open the calendar
        visitDate.click();
        // Select a specific date by interacting with the calendar
        WebElement desiredDate = driver.findElement(By.xpath("/html/body/div/div[1]/table/tbody/tr[4]/td[5]"));
        desiredDate.click();
        Actions action = new Actions(driver);
        action.sendKeys(visitDate, Keys.ESCAPE).perform();

        //Enter Comment
        WebElement comment = driver.findElement(By.id("txt_comment"));
        comment.sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");

        //Click Book Appointment
        WebElement bookAppointmentButton = driver.findElement(By.id("btn-book-appointment"));
            bookAppointmentButton.click();

        //Verify Appointment Confirmation
        WebElement appointmentConfirmation = driver.findElement(By.xpath("/html/body/section/div/div/div[1]/h2"));
            Assert.assertTrue(appointmentConfirmation.isDisplayed());

        //Click Back to Homepage
        WebElement homepageButton = driver.findElement(By.xpath("/html/body/section/div/div/div[7]/p/a"));
            homepageButton.click();

        //Verify Homepage page
        WebElement homepageBack = driver.findElement(By.xpath("/html/body/header/div/h1"));
            Assert.assertTrue(homepageBack.isDisplayed());

        driver.quit();
    }

    @Test
        public void createAppointmentBeforeLogin_emptyData(){
        ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");

        WebDriver driver;
        System.setProperty("webdriver.chrome.driver","C:\\Driverapp\\chromedriver_win32_14\\chromedriver.exe");
            driver = new ChromeDriver(chromeOptions);

        //Navigate to URL Testing
        driver.get("https://katalon-demo-cura.herokuapp.com/");
            driver.manage().window().maximize();

        //Click Make Appointment Button
        WebElement makeAppointmentButton = driver.findElement(By.id("btn-make-appointment"));
            makeAppointmentButton.click();

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
        WebElement makeAppointmentPage = driver.findElement(By.xpath("/html/body/section/div/div/div/h2"));
            Assert.assertTrue(makeAppointmentPage.isDisplayed());

        //Click Book Appointment
        WebElement bookAppointmentButton = driver.findElement(By.id("btn-book-appointment"));
            bookAppointmentButton.click();

        String expected_book = "Appointment Confirmation";
        String actual_book = driver.getTitle();

        if(actual_book.equals(expected_book)){
            System.out.println("Booking successful");
        }
        else{
            System.out.println("Booking Failed");
        }

        driver.quit();

    }
    @Test
        public void createAppointmentAfterLogin_emptyData(){
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

        //CLick Login menu
        WebElement loginMenu = driver.findElement(By.xpath("/html/body/nav/ul/li[3]/a"));
            loginMenu.click();

        //Verify Login Page
        WebElement login_page = driver.findElement(By.xpath("/html/body/section/div/div/div[1]/h2"));
            Assert.assertTrue(login_page.isDisplayed());

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
        WebElement makeAppointmentPage = driver.findElement(By.xpath("/html/body/section/div/div/div/h2"));
            Assert.assertTrue(makeAppointmentPage.isDisplayed());

        //Click Book Appointment
        WebElement bookAppointmentButton = driver.findElement(By.id("btn-book-appointment"));
            bookAppointmentButton.click();

        String expected_book = "Appointment Confirmation";
        String actual_book = driver.getTitle();

        if(actual_book.equals(expected_book)){
            System.out.println("Booking successful");
        }
        else{
            System.out.println("Booking Failed");
        }

        driver.quit();

    }
}
