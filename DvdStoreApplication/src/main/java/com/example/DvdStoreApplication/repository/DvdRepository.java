package com.example.DvdStoreApplication.repository;

import com.example.DvdStoreApplication.model.Dvd;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DvdRepository extends JpaRepository<Dvd, Long> {
}
