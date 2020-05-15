package com.fasttrackit.homeWork23part1.service;

import com.fasttrackit.homeWork23part1.VacationNotFound;
import com.fasttrackit.homeWork23part1.VacationRepository;
import com.fasttrackit.homeWork23part1.domain.Vacation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacationService {

    private final VacationRepository repository;

    public VacationService(VacationRepository repository) {
        this.repository = repository;
    }

    public List<Vacation> getAllVacations() {
        return repository.findAll();
    }

    public Vacation getVacationById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new VacationNotFound("Vacation not found"));
    }

    public void addVacation(Vacation vacation) {
        repository.save(vacation);
    }

    public void deleteVacation(int id) {
        repository.deleteById(id);
    }

    public void replaceVacation(int id, Vacation vacation) {

        Vacation replacedVacation = repository.findById(id)
                .orElseThrow(() -> new VacationNotFound("Vacation not found"));

        replacedVacation.setDuration(vacation.getDuration());
        replacedVacation.setLocation(vacation.getLocation());
        replacedVacation.setPrice(vacation.getPrice());
        repository.save(replacedVacation);


    }

    public List<Vacation> getVacationByLocation(String location){
        return repository.findByLocation(location);
    }

    public List<Vacation> getWithPriceLowerThan(int price){
        return repository.findByPriceLessThan(price);
    }
}
