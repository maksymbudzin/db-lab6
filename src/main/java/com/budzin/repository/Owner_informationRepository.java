package com.budzin.repository;

import com.budzin.domain.Owner_information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Owner_informationRepository extends JpaRepository<Owner_information, Integer> {
}
