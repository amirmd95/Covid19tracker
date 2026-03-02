package com.covid19.tracker.repository;

import com.covid19.tracker.model.GlobalStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GlobalStatsRepository extends JpaRepository<GlobalStats, Long> {

    Optional<GlobalStats> findFirstByOrderByUpdatedAtDesc();
}

