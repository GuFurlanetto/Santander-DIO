package com.digitalinnovation.one.accesspoint.service;

import com.digitalinnovation.one.accesspoint.model.WorkDay;
import com.digitalinnovation.one.accesspoint.repository.WorkDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class WorkDayService {

    final WorkDayRepository workDayRepository;

    @Autowired
    public WorkDayService(WorkDayRepository workDayRepository) {
        this.workDayRepository = workDayRepository;
    }

    public WorkDay saveWorkDay (WorkDay workDay){
        return workDayRepository.save(workDay);
    }


    @GetMapping
    public List<WorkDay> findAll() {
        return workDayRepository.findAll();
    }

    public WorkDay findById(long id) throws Exception {
        WorkDay workDayFound = workDayRepository.findById(id)
                .orElseThrow(() -> new Exception("Jornada não encontrada"));
        return workDayFound;
    }

    public void deleteById(long workDayId) {
        workDayRepository.deleteById(workDayId);
    }
}
