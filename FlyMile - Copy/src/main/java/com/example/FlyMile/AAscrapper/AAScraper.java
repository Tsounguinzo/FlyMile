package com.example.FlyMile.AAscrapper;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class AAScraper
{
    private static final String BASE_URL = "https://www.aa.com/booking/search";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");



    // **************** UPDATE START : END DATE : NUMdYAS LOGIC ***********************************

    public static List<String> generateUrls(String departure, String arrival, LocalDate startDate, LocalDate endDate, int numPassengers) {
        List<String> urls = new ArrayList<>();

        // Iterate over the range from startDate to endDate
        for (LocalDate currentDate = startDate; !currentDate.isAfter(endDate); currentDate = currentDate.plusDays(1)) {
            String formattedDate = currentDate.format(DATE_FORMATTER);
            String slice = "[{\"orig\":\"" + departure + "\",\"origNearby\":false,\"dest\":\"" + arrival +
                    "\",\"destNearby\":false,\"date\":\"" + formattedDate + "\"}]";

            // Encoding the slice part of the URL
            String encodedSlice = URLEncoder.encode(slice, StandardCharsets.UTF_8);

            String url = BASE_URL + "?locale=en_US&pax=" + numPassengers +
                    "&adult=" + numPassengers + "&type=OneWay&searchType=Award&cabin=&carriers=ALL&slices=" + encodedSlice;

            urls.add(url);
        }

        return urls;
    }




}
