package com.example.FlyMile.AAscrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/AAscrapper")
@CrossOrigin(origins = "*")
public class AAscrapperController
{
    private final AAscrapperService aaScrapperService;

    @Autowired
    public AAscrapperController(AAscrapperService aaScrapperService) {
        this.aaScrapperService =  aaScrapperService;
    }

    @GetMapping
    public List<FlightDetail> getFlightDataList()
    {
        return aaScrapperService.getFlightDataList();
    }
}
