package com.sid.dao;

import com.sid.entities.Village;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VillageRepository extends JpaRepository<Village, Long> {
}
