package DevOpsAssignment;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Dev {
	WebDriver driver;

	@Parameters({"bname"})
	@Test
	public void Amazon(String bname) throws URISyntaxException, InterruptedException, MalformedURLException {
	  
		// Define the Selenium Grid Hub URL
		URL url = new URI("http://localhost:4444").toURL();
	  
		// Browser selection using .equals() for string comparison
		if (bname.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			driver = new RemoteWebDriver(url, options);
			System.out.println("Connected to Chrome");
		  
		} else if (bname.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			driver = new RemoteWebDriver(url, options);
			System.out.println("Connected to Firefox");
		  
		} else if (bname.equalsIgnoreCase("edge")) {
			EdgeOptions options = new EdgeOptions();
			driver = new RemoteWebDriver(url, options);
			System.out.println("Connected to Edge");
		  
		} else {
			System.out.println("Browser not supported.");
			return;
		}
		Thread.sleep(10000);  // Wait for the page to load

		// Simple test: open Amazon and print the title
		driver.get("https://www.amazon.in");
		Thread.sleep(5000);  // Wait for the page to load

		// Print the current page title
		System.out.println("Current title: " + driver.getTitle());
		System.out.println("Execution Success!");

		// Close the browser
		driver.quit();
	}
}
