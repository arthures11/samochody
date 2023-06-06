package com.bryja.samochody.repos;

import com.bryja.samochody.klasy.Samochody;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface SamochodyRepository extends JpaRepository<Samochody, Long> {


}
