package com.example.FlyMile.AAscrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserAgent
{
    private static boolean alternateOSboolean = true;
    private static final int MAX_USER_AGENTS = 100;
    private static final List<String> userAgents = new ArrayList<>(MAX_USER_AGENTS);

    // Use a static initializer block to populate the userAgents list
    static {
        for (int i = 0; i < MAX_USER_AGENTS; i++) {
            userAgents.add(generateRandomUserAgent());
        }
    }

    public static String generateRandomUserAgent()
    {
        String userAgent = "";
        if (alternateOSboolean) {
            // Generate a random user agent for macOS
            userAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_" + (int)(Math.random() * 10) + "_"
                    + (int)(Math.random() * 10) + "_" + (int)(Math.random() * 10)
                    + ") AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0." + (int)(Math.random() * 100)
                    + "." + (int)(Math.random() * 100) + " Safari/537.36";
            alternateOSboolean = !alternateOSboolean;
        } else if (alternateOSboolean) {
            // Generate a random user agent for Windows
            userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0."
                    + (int)(Math.random() * 100) + "." + (int)(Math.random() * 100) + " Safari/537.36";
            alternateOSboolean = !alternateOSboolean;
        }
        return userAgent;
    }
    protected static String getRandomUserAgent()
    {
        Random rand = new Random();
        int randomIndex = rand.nextInt(MAX_USER_AGENTS);
        return userAgents.get(randomIndex);
    }




}