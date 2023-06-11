package com.bryja.samochody.repos;

import com.bryja.samochody.klasy.Samochody;
import com.bryja.samochody.klasy.SamochodySklep2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Sklep2Repository extends JpaRepository<SamochodySklep2, Long> {

}
