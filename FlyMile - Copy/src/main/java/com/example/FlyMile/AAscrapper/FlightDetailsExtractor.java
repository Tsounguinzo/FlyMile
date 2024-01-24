package com.example.FlyMile.AAscrapper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;


public class FlightDetailsExtractor
{

    public static void extractFlightDetails(String html, List<FlightDetail> list) {
        Document doc = Jsoup.parse(html);

        // Assuming each flight detail is within a div with class 'grid-x grid-padding-x ng-star-inserted'
        Elements flights = doc.select(".grid-x.grid-padding-x.ng-star-inserted");
        Element dateElement = doc.selectFirst(".date");
        String dateString = doc.selectFirst(".date").text();
        Date dateNotLocal = new Date(dateString);
        Instant instant = dateNotLocal.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = instant.atZone(zoneId);
        zonedDateTime.toLocalDate();
        for (Element flight : flights) {
            FlightDetail flightDetail = new FlightDetail();

            // Extract common flight details
            flightDetail.origin = flight.select(".origin .city-code").text();
            flightDetail.date = zonedDateTime.toLocalDate();
            flightDetail.destination = flight.select(".destination .city-code").text();
            flightDetail.departureTime = flight.select(".origin .flt-times").text();
            flightDetail.arrivalTime = flight.select(".destination .flt-times").text();
            flightDetail.duration = flight.select(".duration").text();
            flightDetail.stops = flight.select(".stops").text();
            flightDetail.flightNumber = flight.select(".flight-number").text();
            flightDetail.aircraft = flight.select(".aircraft-name").text();
            flightDetail.operator = flight.select(".operated-by").text();

            // Extracting price and cabin details for each product
            Elements products = flight.select(".btn-flight, .btn-not-available");

            // Assuming the first product is 'Main', second is 'Premium Economy', 'third is 'Business', and fourth is 'First'
            for (Element product : products) {
                FlightPriceAndCabin priceAndCabin = new FlightPriceAndCabin();

                priceAndCabin.cabin = product.select(".hidden-accessible.hidden-product-type").text();
                priceAndCabin.points = product.select(".per-pax-amount").text();

                // Extract cash price and clean it
                priceAndCabin.cashPrice = product.select(".per-pax-addon").text().replace("+", "").replace("$", "").trim();


                // Assign details to the corresponding index based on the cabin class
                if (priceAndCabin.cabin.equalsIgnoreCase("Main")) {
                    flightDetail.priceAndCabin[0] = priceAndCabin;
                } else if (priceAndCabin.cabin.equalsIgnoreCase("Premium Economy")) {
                    flightDetail.priceAndCabin[1] = priceAndCabin;
                } else if (priceAndCabin.cabin.equalsIgnoreCase("Business")) {
                    flightDetail.priceAndCabin[2] = priceAndCabin;
                } else if (priceAndCabin.cabin.equalsIgnoreCase("First")) {
                    flightDetail.priceAndCabin[3] = priceAndCabin;
                }
            }

            // Add the detailed flight to the list
            list.add(flightDetail);
        }

    }


    // Set up Selenium WebDriver
    public static String fetchHtmlContent(String url) {
        // Set up Selenium WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tsoungui Nzodoumkouo\\Downloads\\FlyMile - Copy-\\FlyMile - Copy\\driver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Run in headless mode
        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get(url);
            // First, check if there is a "No flights available" message
            // Check if the "No flights available" message is present
            List<WebElement> noFlightsElements = driver.findElements(By.cssSelector("app-results-grid-desktop h2"));
            for (WebElement element : noFlightsElements) {
                if (element.getText().trim().equals("No flights available")) {
                    return null; // You may choose to return some specific content or take any other appropriate action
                }
            }

            // If there are flights available, then wait for the specific content to load
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // timeout in seconds
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".grid-x.grid-padding-x.ng-star-inserted")));

            // After the content has loaded, get the page source
            return driver.getPageSource();
        } catch (Exception e) {
           // e.printStackTrace();                                        //********************* update **************************
            return null;
        } finally {
            driver.quit(); // Ensure the driver is closed even in case of an exception
        }
    }







}
