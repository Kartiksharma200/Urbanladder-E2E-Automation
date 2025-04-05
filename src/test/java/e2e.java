import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class e2e {
	
	WebDriver driver;
	
	
	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://www.urbanladder.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@Test (priority = 1)
	public void verifyHomePage() {
		WebElement tittle = driver.findElement(By.xpath("//figure[@class='header__topBar_logo']//*[name()='svg']"));
		//By Compare Logo of the Home Page is Displayed
		if(tittle.isDisplayed()) {
			System.out.println("<--------Verify Home Page--------->");
		}else {
			System.out.println("<--------Failed to verify home page-------->");
		}
		
		String homepage = driver.getTitle();
		System.out.println(homepage);
		//Match Tittle Text By assert 
		Assert.assertTrue(homepage.contains("Home - Urban Ladder"), "HomePage Tittle is not match");
	}
	
	@Test(priority = 2, dependsOnMethods = "verifyHomePage")
	public void addToCartSofa() throws InterruptedException {
		//Search Bar
		WebElement searchBar = driver.findElement(By.xpath("//input[@id='search']"));
		searchBar.sendKeys("Sofa");
		
		//Enter On Fabric sofa sets
		driver.findElement(By.xpath("//header[@id='header']//div[5]")).click();
		
		//Add three sofa
		WebElement sofa = driver.findElement(By.xpath("//img[@title='Nelson Fabric Sofa Set - Grey & Maroon']"));
		Assert.assertTrue(sofa.isDisplayed(), "Sofa not present");	
		sofa.click();
		
		WebElement sofaName = driver.findElement(By.xpath("//h1[@class='page-heading product-title no-margin']"));
		if(sofaName.isDisplayed()) {
			System.out.println("<---------Name is Visible--------->");
		}else {
			System.out.println("<---------Name not visible--------->");
		}
		
		WebElement sofaRate = driver.findElement(By.xpath("//div[@class='price final']"));
		String sofaPrice = sofaRate.getText();
		System.out.println(sofaPrice);
		Thread.sleep(3000);
		
	}
	
	
	@Test(priority = 3, dependsOnMethods = "addToCartSofa")
	public void addToCartRecliner() throws InterruptedException {
		
		driver.findElement(By.xpath("//figure[@class='header__topBar_logo']//*[name()='svg']")).click();
		WebElement searchBar = driver.findElement(By.xpath("//input[@id='search']"));
		searchBar.sendKeys("Recliner");
		
		Thread.sleep(3000);
		//Click on Recliner chair
		driver.findElement(By.xpath("//div[@class='tt-dataset tt-dataset-suggestions']//div[1]")).click();
		
		//Add 5 reclineer
		driver.findElement(By.xpath("//img[@title='Recliner Chair Furniture Emila Two Seater Motorized Fabric Recliner in Grey']")).click();
		
		String AccUrl = driver.getCurrentUrl();
		String ExpUrl = "https://www.urbanladder.com/products/emila-recliner-3-seater-color-blue?sku=FNSFRS51GY11152&src=room";
		
		Assert.assertEquals(AccUrl, ExpUrl);
		
		//Click On Add To Wish List
		driver.findElement(By.xpath("//div[@id='product_action_241387']//span[@class='icofont icofont-heart_outline_thick wishicon']")).click();
		
		//Select Colour
		driver.findElement(By.xpath("//span[normalize-space()='Blue']")).click();
		
		//Select Size 3
		driver.findElement(By.xpath("//span[normalize-space()='Three']")).click();
		
		//Print Price
		WebElement reclinerPrice = driver.findElement(By.xpath("//div[@id='buy_details_126069']//div[contains(@class,'price discounted-price')][contains(text(),'₹1,08,611')]"));
		String price = reclinerPrice.getText();
		
		System.out.println(price);
		
	}
	
	
	@AfterTest
	public void teardown() {
		driver.close();
	}

}
