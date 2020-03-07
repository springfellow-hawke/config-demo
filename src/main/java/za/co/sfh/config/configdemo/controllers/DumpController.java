package za.co.sfh.config.configdemo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class DumpController {

    @Value("${demo.value1}")
    private String value1;

    @Value("${demo.value2}")
    private String value2;

    @GetMapping("/prop")
    public ResponseEntity dump(){
        return  ResponseEntity.ok(value1);
    }

    @GetMapping("/prop/{name}")
    public ResponseEntity displaySpecificProperty(@PathVariable String name){

        String propValue = "Not set";
        switch(name){
            case "value1":
                propValue = value1;
                break;
            case "value2":
                propValue = value2;
                break;
            default:
                propValue = "not found";
        }
        return ResponseEntity.ok(propValue);
    }
}
