package ru.appline.controller;

import org.springframework.web.bind.annotation.*;
import ru.appline.logic.Compass;

import java.util.Map;

@RestController
public class Controller {
    private static final Compass compass = Compass.getInstance();

    /*
    {
        "North": "314-358",
        "North-East": "359-43",
        "East": "44-88",
        "South-East": "89-133",
        "South": "134-178",
        "South-West": "179-223",
        "West": "224-268",
        "North-West": "269-313"
    }
    */

    //Для корректной работы необходимо вводить все 8 сторон, разделителем между градусами должен служить символ "-"
    @PostMapping(value = "/setSides", consumes = "application/json")
    public void setSides(@RequestBody Map<String, String> range){
        compass.setRange(range);
    }

    /*
    {
        "Degree": 56
    }
    */

    //Для корректной работы необходимо вводить слово "Degree" с большой буквы
    @GetMapping(value = "/getSide", consumes = "application/json", produces = "application/json")
    public String getSide(@RequestBody Map<String, Integer> degree) {
        return compass.getSide(degree.get("Degree"));
    }
}
