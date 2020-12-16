package com.budzin.repository;

import com.budzin.domain.TripAdvizor_object;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripAdvizor_objectRepository extends JpaRepository<TripAdvizor_object, Integer> {
}
