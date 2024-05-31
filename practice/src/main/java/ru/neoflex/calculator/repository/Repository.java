package ru.neoflex.calculator.repository;

import org.springframework.data.repository.CrudRepository;
import ru.neoflex.calculator.model.ResultOfCalculation;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Repository extends CrudRepository<ResultOfCalculation, Integer> {
    List<ResultOfCalculation> findAll();
    Optional<ResultOfCalculation> findByExpression(String expressions);
}

