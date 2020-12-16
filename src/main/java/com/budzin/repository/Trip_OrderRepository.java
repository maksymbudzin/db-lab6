package com.budzin.repository;

import com.budzin.domain.Trip_Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Trip_OrderRepository extends JpaRepository<Trip_Order, Integer> {
}
