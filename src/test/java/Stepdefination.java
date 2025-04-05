import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefination {
	
	WebDriver driver;

	@Given("I open the Urban Ladder website")
	public void i_open_the_urban_ladder_website() {
	    driver = new ChromeDriver();
	    driver.get("https://www.urbanladder.com/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    
	}

	@Then("I should see the homepage displayed correctly")
	public void i_should_see_the_homepage_displayed_correctly() {
	    WebElement tittle = driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M20.28 46.')]"));
	    if(tittle.isDisplayed()) {
	    	System.out.println("<----------Verify Homepage Successful------------>");
	    }else {
	    	System.out.println("<----------Failed to verify Homepage--------->");
	    }
	    driver.close();
	}

	@Given("I am on the Urban Ladder homepage")
	public void i_am_on_the_urban_ladder_homepage() {
		driver = new ChromeDriver();
	    driver.get("https://www.urbanladder.com/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("I enter {string} in the search bar")
	public void i_enter_in_the_search_bar(String string) throws InterruptedException {
	    WebElement searchBar = driver.findElement(By.xpath("//input[@id='search']"));
	    searchBar.sendKeys("Sofa");
	    Thread.sleep(2000);
	    
	    
	}

	@When("I submit the search")
	public void i_submit_the_search() {
		driver.findElement(By.xpath("//div[@class='header__topBar']//div[2]")).click();
	}

	@Then("I should see the search results displayed")
	public void i_should_see_the_search_results_displayed() {
		WebElement sofa = driver.findElement(By.xpath("//img[@title='Weston Half Leather Sofa (Licorice Italian Leather)']"));
	    if(sofa.isDisplayed()) {
	    	System.out.println("<----------Successful Verify Sofa---------->");
	    }else {
	    	System.out.println("<----------Failed to search sofa----------->");
	    }
	    driver.close();
	}

	@Given("I have searched for {string}")
	public void i_have_searched_for(String string) {
		driver = new ChromeDriver();
		driver.get("https://www.urbanladder.com/products/search?utf8=%E2%9C%93&keywords=sofa");
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("I apply a filter for {string}")
	public void i_apply_a_filter_for(String string) {
	    driver.findElement(By.xpath("//div[normalize-space()='Category']")).click();
	    driver.findElement(By.xpath("//input[@id='filters_primary_category_Leather_Sofa_Sets']")).click();
	}

	@Then("I should see the search results updated accordingly")
	public void i_should_see_the_search_results_updated_accordingly() {
	    WebElement verifyfiltersofa = driver.findElement(By.xpath("//img[@title='Weston Half Leather Sofa (Wine Italian Leather)']"));
	    if(verifyfiltersofa.isDisplayed()) {
	    	System.out.println("<----------Apply filter Successful---------->");
	    }else {
	    	System.out.println("<---------failed to apply filter--------->");
	    }
	}

	@When("I select a product from the search results")
	public void i_select_a_product_from_the_search_results() throws InterruptedException {
		WebElement verifyfiltersofa = driver.findElement(By.xpath("//img[@title='Weston Half Leather Sofa (Wine Italian Leather)']"));
		verifyfiltersofa.click();
		Thread.sleep(2000);
	}

	@When("I add the product to the cart")
	public void i_add_the_product_to_the_cart() {
	    driver.findElement(By.xpath("//button[@id='add-to-cart-button']")).click();
	}

	@Then("I should see the product added to the cart successfully")
	public void i_should_see_the_product_added_to_the_cart_successfully() {
	    String accUrl = driver.getCurrentUrl();
	    String expUrl = "https://www.urbanladder.com/cart";
	    if(accUrl.equals(expUrl)) {
	    	System.out.println("<-----------Successful Add product to cart---------->");
	    }else {
	    	System.out.println("<----------Failed to add product to cart---------->");
	    }
	    driver.close();
	}

	

}
