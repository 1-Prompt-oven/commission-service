package com.promptoven.commissionservice.infrastructure;

import com.promptoven.commissionservice.domain.Commission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommissionRepository extends JpaRepository<Commission, String> {
}
