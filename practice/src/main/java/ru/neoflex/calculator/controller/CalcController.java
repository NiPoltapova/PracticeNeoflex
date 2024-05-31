package ru.neoflex.calculator.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.calculator.model.ResultOfCalculation;
import ru.neoflex.calculator.repository.Repository;

@RestController
public class CalcController {
    @Autowired
    private Repository repository;

    @GetMapping("/plus/{x}/{y}")
    public ResultOfCalculation plus(@PathVariable("x") Integer x,
                                    @PathVariable("y") Integer y) {
        ResultOfCalculation result;
        result = new ResultOfCalculation(null, x.toString()+" + " + y.toString(), x+y);
        if (repository.findByExpression(x.toString()+" + " + y.toString()).isEmpty()) {
            repository.save(result);
        }
        return repository.findByExpression(x.toString()+" + " + y.toString()).get();
    }

    @GetMapping("/minus/{x}/{y}")
    public ResponseEntity<String> minus(@PathVariable("x") String x,
                                       @PathVariable("y") String y) {
        try {
            return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN).body("" + (Integer.parseInt(x) - Integer.parseInt(y)));
        }
        catch(Exception e) {
            return ResponseEntity.badRequest().contentType(MediaType.TEXT_PLAIN).body("Incorrect input parameters.");
        }
    }
}