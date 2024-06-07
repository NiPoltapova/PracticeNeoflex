package ru.neoflex.calculator.controller;

import org.hibernate.jdbc.Expectation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import ru.neoflex.calculator.model.ResultOfCalculation;
import ru.neoflex.calculator.service.ServiceMinus;
import ru.neoflex.calculator.util.swaggerCustomAnnotation.MinusWithParams;
import ru.neoflex.calculator.util.swaggerCustomAnnotation.MinusWithoutParams;

import java.beans.Expression;

@RestController
@RequestMapping("/minus")
@Tag( name = "MINUS", description = "ВЫЧИТАНИЕ")
public class ControllerForMinus {
    private final ServiceMinus service;
    @Autowired
    public ControllerForMinus( ServiceMinus service)
    {
        this.service = service;
    }
    @MinusWithoutParams
    @GetMapping("")
    public ResponseEntity<String> getMinus()
    {
        String result = "{\"список выражений\" : [  ";
        StringBuilder sb = new StringBuilder();
        for (ResultOfCalculation a : service.getAll())
        {
            sb.append(a.toString()).append(", ");
        }
        String getAll = sb.toString();
        result += getAll.substring(0, getAll.length() > 2 ? getAll.length()-2:0);
        result += (" ] }");
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body((result));
    }

    @MinusWithParams
    @GetMapping("/{x}/{y}")
    public ResponseEntity<String> getMinus(@PathVariable("x") Integer x, @PathVariable("y") Integer y)
    {
        ResultOfCalculation result;
        try {
            result = new ResultOfCalculation( x + " - " + y, x - y);
        }
        catch(Exception exception){
            return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body("{\"Сообщение:\" : \"Внимание! Выражение введено неверно.\"}");
        }
        service.Insert(result);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(result.toString());
    }
}
