package com.example.FlyMile.AAscrapper;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.example.FlyMile.AAscrapper.AAScraper.generateUrls;
import static com.example.FlyMile.AAscrapper.FlightDetailsExtractor.extractFlightDetails;
import static com.example.FlyMile.AAscrapper.FlightDetailsExtractor.fetchHtmlContent;

@Component
public class AAscrapperService
{

    public List<FlightDetail> getFlightDataList()
    {
        String departure = "yul";
        String arrival = "bey";
        LocalDate startDate = LocalDate.of(2024, 3, 6);
        LocalDate endDate = LocalDate.of(2024, 3, 6 );
        int numPassengers = 1;

        List<String> urls = generateUrls(departure, arrival, startDate, endDate, numPassengers);
        List<FlightDetail> FlightListForRange = new ArrayList<>();


        for(String url : urls)
        {
            System.out.println(url);
            String htmlContent = fetchHtmlContent(url);
            if (htmlContent != null)
            {
                extractFlightDetails(htmlContent, FlightListForRange);

            }
        }
        return FlightListForRange;

    }
}
