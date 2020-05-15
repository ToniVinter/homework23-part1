package com.fasttrackit.homeWork23part1;

import com.fasttrackit.homeWork23part1.domain.Vacation;
import com.fasttrackit.homeWork23part1.service.VacationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("vacations")
public class VacationController {
    private final VacationService service;

    public VacationController(VacationService serivce) {
        this.service = serivce;
    }

    @GetMapping
    public List<Vacation> getAllVacations(){
        return service.getAllVacations();
    }

    @GetMapping("{id}")
    public Vacation getVacationById(@PathVariable  int id){
        return service.getVacationById(id);
    }

    @GetMapping(value = "/location", params = "name")
    public List<Vacation> getVacationByLocation(@RequestParam(required = false) String name){
        return service.getVacationByLocation(name);
    }

    @GetMapping(value = "/price",params = "value")
    public List<Vacation> getWithPriceLowerThan(@RequestParam(required = false) int value){
        return service.getWithPriceLowerThan(value);
    }

    @PostMapping("/add")
    public void addVacation(@RequestBody Vacation vacation){
        service.addVacation(vacation);
    }

    @PostMapping(value = "/replace", params = "id")
    public void replaceVacation(@RequestParam(required = false) int id,@RequestBody Vacation vacation){
        service.replaceVacation(id,vacation);
    }

    @DeleteMapping(params = "id")
    public void deleteVacation(@RequestParam int id){
        service.deleteVacation(id);
    }
}
