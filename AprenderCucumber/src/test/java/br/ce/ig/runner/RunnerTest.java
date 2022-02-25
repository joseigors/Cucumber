package br.ce.ig.runner;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
				features = "src/test/resources/features/InserirConta.feature",
				glue = "br.ce.ig.Steps",
				tags = {"~@ignore"},
				plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
				monochrome = true,
				snippets = SnippetType.CAMELCASE,
				dryRun = false,
				strict = false
		)
public class RunnerTest {
	
	@BeforeClass
	public static void reset() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://seubarriga.wcaquino.me");
		driver.findElement(By.id("email")).sendKeys("a@a");
		driver.findElement(By.id("senha")).sendKeys("a");
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.linkText("reset")).click();
		
	}

}
