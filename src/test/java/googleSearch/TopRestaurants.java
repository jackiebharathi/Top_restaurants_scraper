package googleSearch;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Scanner;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TopRestaurants {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		//get the city name frome user
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the city name");
		String city = sc.nextLine().trim();
		
		//setup chromedriver
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//open google.com and search the string and click enter
		
		String s = "Top 10 restaurants in "+ city;
		driver.get("https://www.google.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys(s);
        Actions ac = new Actions(driver);
        ac.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
        Thread.sleep(20000);//if there is captch, manually do it before 20 seconds
        driver.findElement(By.xpath("//span[@class='Z4Cazf OSrXXb q7JKre']")).click();
        
        //store all the restaurants inside the List
        
        List<WebElement> rest = driver.findElements(By.xpath("//div[@jscontroller='AtSb']"));
        JSONObject restaurantdata = new JSONObject();
        int count = 0;
        
        //loop through each webelement(restaurant) and store the data in json object
        
        for(WebElement res : rest) {
        	try{
        		
        		String name=res.findElement(By.cssSelector("span.OSrXXb")).getText();
        		String rating= res.findElement(By.cssSelector("span.yi40Hd.YrbPuc")).getText();
        		String reviews=	res.findElement(By.cssSelector("span.RDApEe.YrbPuc")).getText();
        		
        		//System.out.println(name+rating+reviews);
        		
        		JSONObject details = new JSONObject();
        		details.put("Rating ", rating);
        		details.put("Review ", reviews);
        		
        		restaurantdata.put(name, details);
        		
        		count++;
        		if(count>10) break;
        	}
        	catch (Exception e) {
        		
        	}
        }
        
        //save JSON to file
        String fileName = city.toLowerCase().replace(" ", "_") + "_restaurants.json";
        try (FileWriter file = new FileWriter(fileName)) {
            file.write(restaurantdata.toString(4));
        }
        
        sc.close();
        Thread.sleep(2000);
		driver.quit();
	}

}
