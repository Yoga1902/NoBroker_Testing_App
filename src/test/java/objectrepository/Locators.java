package objectrepository;

import org.openqa.selenium.By;

public class Locators {
	
	//login page locator
	public static By loginButton=By.xpath("//*[@id=\"navHeader\"]/div[5]/div[2]/div[2]/div");
	public static By inputNumber=By.id("signUp-phoneNumber");
	public static By continueButton=By.id("signUpSubmit");
	public static By otpInputs = By.xpath("//input[@aria-label='Please enter verification code. Digit 1']");
}
