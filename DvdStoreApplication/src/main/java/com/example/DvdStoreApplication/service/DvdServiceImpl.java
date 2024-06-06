package com.example.DvdStoreApplication.service;

import com.example.DvdStoreApplication.repository.DvdRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DvdServiceImpl implements DvdService {

    private static final double BACK_TO_THE_FUTURE_PRICE = 15.0;
    private static final double OTHER_MOVIE_PRICE = 20.0;


    private final DvdRepository dvdRepository;

    public DvdServiceImpl(DvdRepository dvdRepository) {
        this.dvdRepository = dvdRepository;
    }

    @Override
    public double calculateTotalPrice(List<String> titles) {
        // Comptage du nombre de fois que chaque titre apparaît dans la liste des titres
        Map<String, Long> movieCount = titles.stream().collect(Collectors.groupingBy(title -> title, Collectors.counting()));

        // Filtrage des titres "Back to the Future"
        Set<String> backToTheFutureTitles = movieCount.keySet().stream().filter(title -> title.startsWith("Back to the Future")).collect(Collectors.toSet());

        // Calcul du prix total pour les titres "Back to the Future"
        double backToTheFutureTotal = backToTheFutureTitles.size() * BACK_TO_THE_FUTURE_PRICE;

        // Calcul du prix total pour les autres films
        double otherMoviesTotal = (titles.size() - backToTheFutureTitles.size()) * OTHER_MOVIE_PRICE;

        // Initialisation de la variable de réduction
        double discount = 0.0;

        // Application des règles de réduction en fonction du nombre de titres "Back to the Future"
        if (backToTheFutureTitles.size() == 2) {
            discount = 0.1; // Réduction de 10 % pour 2 titres distincts
        } else if (backToTheFutureTitles.size() >= 3) {
            discount = 0.2; // Réduction de 20 % pour 3 titres distincts ou plus
        }

        // Calcul du prix total avec la réduction appliquée uniquement sur les titres "Back to the Future"
        double discountedBackToTheFutureTotal = backToTheFutureTotal * (1 - discount);

        // Calcul final du prix total
        return discountedBackToTheFutureTotal + otherMoviesTotal;
    }
}
