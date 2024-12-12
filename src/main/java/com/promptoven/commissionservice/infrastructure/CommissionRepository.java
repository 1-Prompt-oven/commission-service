package com.promptoven.commissionservice.infrastructure;

import com.promptoven.commissionservice.domain.Commission;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommissionRepository extends JpaRepository<Commission, String> {
    Optional<Commission> findByClientUuidOrCreatorUuid(String clientUuid, String creatorUuid);

    List<Commission> findByClientUuidOrCreatorUuid(String clientUuid, String creatorUuid, Sort sort);

    Optional<Commission> findByCommissionUuid(String commissionUuid);
}
