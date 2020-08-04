package com.onejava.repository;

import com.onejava.domain.UsageCostDetail;
import com.onejava.model.UsageCostResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsageCostRepository extends JpaRepository<UsageCostDetail, Integer> {
    UsageCostResponse findByTypeAndOffer(String type, String offer);
}
