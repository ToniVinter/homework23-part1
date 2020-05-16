package com.fasttrackit.homeWork23part1.caseControl;

import com.fasttrackit.homeWork23part1.domain.Vacation;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Scanner;

public class CaseControl {
    private Case caseControl;
    private RestTemplate rest = new RestTemplate();
    private Scanner scanner = new Scanner(System.in);

    public void case1() {
        var case1 = rest.getForObject("http://localhost:8080/vacations", List.class);
        System.out.println("-------------------------------------------");
        System.out.println("\n" + case1);
    }

    public void case2() {
        System.out.print("Select Location: ");
        String location = scanner.nextLine();
        var case2 = rest.exchange("http://localhost:8080/vacations/location?name=" + location,
                HttpMethod.GET,
                new HttpEntity<>(null),
                new ParameterizedTypeReference<List<Vacation>>() {
                });
        System.out.println("-------------------------------------------");
        System.out.println("\n" + case2);
    }

    public void case3() {
        System.out.print("Select max price: ");
        var price = scanner.next();
        var case3 = rest.exchange("http://localhost:8080/vacations/price?value=" + price,
                HttpMethod.GET,
                new HttpEntity<>(null),
                new ParameterizedTypeReference<List<Vacation>>() {
                });
        System.out.println("-------------------------------------------");
        System.out.println("\n" + case3);
    }

    public void case4() {
        Vacation newVacation = new Vacation();
        System.out.print("Select location: ");
        newVacation.setLocation(scanner.next());
        System.out.println("Select price: ");
        newVacation.setPrice(scanner.nextInt());
        System.out.println("Select duration: ");
        newVacation.setDuration(scanner.nextInt());
        rest.postForEntity("http://localhost:8080/vacations/add",
                newVacation,
                Vacation.class);
    }

    public void case5(){
        System.out.println("Select id: ");
        var idToDelete = scanner.nextInt();
        rest.delete("http://localhost:8080/vacations?id="+idToDelete);
        System.out.println("-------------------------------------------");
        System.out.println("\n" + "Deleted! ");
    }

    public void case6(){
        System.out.println("Select id: ");
        var updateId = scanner.nextInt();
        var updateUrl = "http://localhost:8080/vacations/replace?id=" + updateId;
        System.out.println("Select location: ");
        var updateLocation = scanner.next();
        System.out.println("Select price: ");
        var updatePrice = scanner.nextInt();
        System.out.println("Select duration: ");
        var updateDuration = scanner.nextInt();
        Vacation updateVacation = new Vacation(updateLocation,updatePrice,updateDuration);
        rest.put(updateUrl,updateVacation);
    }

}
