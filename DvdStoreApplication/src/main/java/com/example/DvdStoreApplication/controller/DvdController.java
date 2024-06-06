package com.example.DvdStoreApplication.controller;


import com.example.DvdStoreApplication.Dto.PurchaseDto;
import com.example.DvdStoreApplication.service.DvdService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dvds")
@CrossOrigin ("*")
public class DvdController {

    private final DvdService dvdService;

    public DvdController(DvdService dvdService) {
        this.dvdService = dvdService;
    }

    @PostMapping("/calculate")
    public double calculateTotalPrice(@RequestBody PurchaseDto purchaseDto) {
        System.out.println("Received titles: " + purchaseDto.getTitles());
        return dvdService.calculateTotalPrice(purchaseDto.getTitles());
    }
}
