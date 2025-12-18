package org.example.prueba1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;

@RestController
public class GreetingController {
    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(defaultValue = "Mundo")String name
    ){
        System.out.println("Hola Mundo");
        System.out.println(name=new Scanner(System.in).nextLine());
        return "Hello "+name+"!";
    }
}
