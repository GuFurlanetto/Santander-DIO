package com.digitalinnovation.one.accesspoint.repository;

import com.digitalinnovation.one.accesspoint.model.WorkDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkDayRepository extends JpaRepository<WorkDay, Long> {

}
