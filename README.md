# Top Restaurants Scraper

This Java program automates Google Search using **Selenium WebDriver** to extract details of the top 10 restaurants in a user-specified city. The results are saved in a `.json` file.

## 📁 Main Java File
- `TopRestaurants.java`: This is the core automation script that:
  - Accepts a city name as input
  - Performs a Google search for "Top 10 restaurants in <city>"
  - Scrapes restaurant names, ratings, and reviews
  - Saves the data to a JSON file

## 💡 Features
- Takes dynamic city input from the user.
- Scrapes restaurant data (name, rating, reviews) using Selenium.
- Handles minor exceptions gracefully.
- Outputs a JSON file named like `cityname_restaurants.json`.

## 🛠️ Tech Stack
- Java
- Selenium WebDriver
- ChromeDriver
- org.json (for building JSON objects)

## ✅ Prerequisites
- JDK 8 or above
- Selenium WebDriver library added to project
- Chrome browser installed
- ChromeDriver installed and added to system path

## 🚀 How to Run
1. Compile and run `TopRestaurants.java` from your IDE or terminal.
2. Enter the city name when prompted.
3. If CAPTCHA appears in Google, solve it manually within 20 seconds.
4. The program will extract top restaurant details and save them as:
