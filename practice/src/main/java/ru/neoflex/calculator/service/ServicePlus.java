package ru.neoflex.calculator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.neoflex.calculator.model.ResultOfCalculation;
import ru.neoflex.calculator.repository.Repository;

import java.util.List;

@Service
public class ServicePlus {

    private final Repository repository;
    @Autowired
    public ServicePlus(Repository repository) {
        this.repository = repository;
    }

    public List<ResultOfCalculation> getAll()
    {
        return repository.getAllByExpressionContains("+");
    }

    public boolean Insert(ResultOfCalculation result)
    {
        try{
            repository.save(result);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
