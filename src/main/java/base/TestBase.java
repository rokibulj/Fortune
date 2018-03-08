package base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestBase extends SauceLabs{
	
	@BeforeSuite
	public void setUp() {
		setDriver();
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void sampleTest() {
		System.out.println(driver.getTitle());
	}

}
