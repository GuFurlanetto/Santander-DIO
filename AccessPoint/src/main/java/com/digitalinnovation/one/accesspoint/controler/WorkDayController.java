package com.digitalinnovation.one.accesspoint.controler;

import com.digitalinnovation.one.accesspoint.model.WorkDay;
import com.digitalinnovation.one.accesspoint.service.WorkDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jornada")
public class WorkDayController {


    @Autowired
    WorkDayService workDayService;

    @PostMapping
    public WorkDay createWorkDay(@RequestBody WorkDay workDay){
        return workDayService.saveWorkDay(workDay);
    }

    @GetMapping
    public List<WorkDay> getWorkDayList(){
        return workDayService.findAll();
    }

    @GetMapping("/{workDayId}")
    public WorkDay getWorkDayById(@PathVariable("workDayId") long workDayId) throws Exception {
        return workDayService.findById(workDayId);
    }

    @PostMapping
    public WorkDay updateWorkDay(@RequestBody WorkDay workDay){
        return workDayService.saveWorkDay(workDay);
    }

    public void deleteWorkDayBy(@PathVariable("workDayId") long workDayId) throws Exception {
        workDayService.deleteById(workDayId);
    }


}
