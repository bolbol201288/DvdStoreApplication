package com.example.DvdStoreApplication;


import com.example.DvdStoreApplication.repository.DvdRepository;
import com.example.DvdStoreApplication.service.DvdServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DvdServiceTest {

    @Mock
    private DvdRepository dvdRepository;

    @InjectMocks
    private DvdServiceImpl dvdService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCalculateTotalPrice_withThreeBackToTheFutureDvds() {
        var titles = Arrays.asList("Back to the Future 1", "Back to the Future 2", "Back to the Future 3");
        double totalPrice = dvdService.calculateTotalPrice(titles);
        assertEquals(36.0, totalPrice);
    }

    @Test
    public void testCalculateTotalPrice_withTwoBackToTheFutureDvds() {
        var titles = Arrays.asList("Back to the Future 1", "Back to the Future 3");
        double totalPrice = dvdService.calculateTotalPrice(titles);
        assertEquals(27.0, totalPrice);
    }

    @Test
    public void testCalculateTotalPrice_withOneBackToTheFutureDvd() {
        var titles = List.of("Back to the Future 1");
        double totalPrice = dvdService.calculateTotalPrice(titles);
        assertEquals(15.0, totalPrice);
    }

    @Test
    public void testCalculateTotalPrice_withFourBackToTheFutureDvds() {
        var titles = Arrays.asList("Back to the Future 1", "Back to the Future 2", "Back to the Future 3", "Back to the Future 4");
        double totalPrice = dvdService.calculateTotalPrice(titles);
        assertEquals(48.0, totalPrice);
    }

    @Test
    public void testCalculateTotalPrice_withMixedDvds() {
        var titles = Arrays.asList("Back to the Future 1", "Back to the Future 2", "Back to the Future 3", "La chèvre");
        double totalPrice = dvdService.calculateTotalPrice(titles);
        assertEquals(56.0, totalPrice);
    }
}
