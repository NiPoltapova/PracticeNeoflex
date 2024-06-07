package ru.neoflex.calculator.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.calculator.model.ResultOfCalculation;
import ru.neoflex.calculator.service.ServiceMinus;
import ru.neoflex.calculator.service.ServicePlus;
import ru.neoflex.calculator.util.swaggerCustomAnnotation.MinusWithoutParams;
import ru.neoflex.calculator.util.swaggerCustomAnnotation.PlusWithParams;
import ru.neoflex.calculator.util.swaggerCustomAnnotation.PlusWithoutParams;

@RestController
@RequestMapping("/plus")
@Tag( name = "PLUS", description = "СЛОЖЕНИЕ")
public class ControllerForPlus {
    private final ServicePlus service;
    @Autowired
    public ControllerForPlus( ServicePlus service)
    {
        this.service = service;
    }
    @PlusWithoutParams
    @GetMapping("")
    public ResponseEntity<String> getPlus()
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

    @PlusWithParams
    @GetMapping("/{x}/{y}")
    public ResponseEntity<String> getPlus(@PathVariable("x") Integer x, @PathVariable("y") Integer y)
    {
        ResultOfCalculation result;
        try{
            result = new ResultOfCalculation(x + " + " + y, x + y);
        }
        catch(Exception ex)
        {
            return ResponseEntity.badRequest().contentType(MediaType.APPLICATION_JSON).body("{\"Сообщение:\" : \"Внимание! Выражение введено неверно.\"}");
        }
        service.Insert(result);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(result.toString());
    }
}
