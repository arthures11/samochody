package com.bryja.samochody.repos;

import com.bryja.samochody.klasy.Samochody;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Sklep1Repository extends JpaRepository<Samochody, Long> {

}
