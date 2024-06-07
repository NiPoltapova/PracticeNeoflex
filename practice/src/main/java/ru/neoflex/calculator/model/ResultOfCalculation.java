package ru.neoflex.calculator.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ResultOfCalculation")
public class ResultOfCalculation {

    @Id
    @Column(name = "expression")
    private String expression;

    @Column(name = "result")
    private Integer result;

    @Override
    public String toString(){
        String output = "{ \"выражение\": \"" + expression + "\", \"результат\": " + result+" }";
        return output;
    }
}
