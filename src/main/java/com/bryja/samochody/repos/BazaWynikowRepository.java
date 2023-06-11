package com.bryja.samochody.repos;

import com.bryja.samochody.klasy.BazaWynikow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BazaWynikowRepository extends JpaRepository<BazaWynikow, Long> {


}
