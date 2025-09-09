package objectrepository;

import org.openqa.selenium.By;

public class Locators {
	
	//login page locator
	public static By loginButton=By.xpath("//*[@id=\"navHeader\"]/div[5]/div[2]/div[2]/div");
	public static By inputNumber=By.id("signUp-phoneNumber");
	public static By continueButton=By.id("signUpSubmit");
	public static By otpInputs = By.xpath("//input[@aria-label='Please enter verification code. Digit 1']");

	public static By resendOtpLink = By.xpath("//*[@id=\"login-signup-form\"]/div[4]/div/div/div[3]/div[2]");
	public static By propertyButton= By.xpath("//*[@id=\"pypAd\"]/button");
	
	public static By propertypage= By.xpath("//*[@id=\"app\"]/div/div/div[1]/div[1]/div/div[1]/h1");
	
	public static By cityDropdown = By.xpath("//input[@placeholder='Select City']");
	public static By startPostingButton = By.xpath("//button[contains(text(),'Start Posting Your Ad For FREE')]");
	public static By propertyDetailsForm = By.xpath("//h1[contains(text(),'Property Details')]"); 
	public static By Propertypost = By.xpath("//button[contains(text(),'Post a New Property')]");


}
