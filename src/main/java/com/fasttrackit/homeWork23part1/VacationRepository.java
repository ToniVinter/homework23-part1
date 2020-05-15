package com.fasttrackit.homeWork23part1;
import com.fasttrackit.homeWork23part1.domain.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VacationRepository extends JpaRepository<Vacation,Integer> {
    List<Vacation> findByLocation(String location);
    List<Vacation> findByPriceLessThan(int price);
}
