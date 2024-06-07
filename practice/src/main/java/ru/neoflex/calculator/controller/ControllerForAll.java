package ru.neoflex.calculator.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.calculator.model.ResultOfCalculation;
import ru.neoflex.calculator.service.ServiceMinus;
import ru.neoflex.calculator.service.ServicePlus;
import ru.neoflex.calculator.util.swaggerCustomAnnotation.AllWithoutParams;

@RestController
@RequestMapping("/all")
@Tag(name = "ALL", description = "ВСЕ ОПЕРАЦИИ (\"+\" , \"-\" )")
public class ControllerForAll {
    private final ServicePlus servicePlus;
    private final ServiceMinus serviceMinus;
    @Autowired
    public ControllerForAll(ServicePlus servicePlus, ServiceMinus serviceMinus) {
        this.servicePlus = servicePlus;
        this.serviceMinus = serviceMinus;
    }

    @AllWithoutParams
    @GetMapping("")
    public ResponseEntity<String> calculate()
    {
        String jSONresult = "{\"список выражений\" : [ ";
        StringBuilder sb = new StringBuilder();
        for(ResultOfCalculation a : servicePlus.getAll())
        {
            sb.append(a.toString()).append(", ");
        }
        String getAll = sb.toString();
        jSONresult += getAll.substring(0, getAll.length() > 2 ? getAll.length() - 2 : 0);
        sb = new StringBuilder();
        for(ResultOfCalculation a : serviceMinus.getAll())
        {
            sb.append(a.toString()).append(", ");
        }
        getAll = sb.toString();
        jSONresult += (getAll.length() > 2 && jSONresult.length() > 20? ", " : "");
        jSONresult += getAll.substring(0, getAll.length() > 2 ? getAll.length() - 2 : 0);
        jSONresult += (" ] }");
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(jSONresult);
    }
}