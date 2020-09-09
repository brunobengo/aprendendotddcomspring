package com.example.service;

import com.example.model.SalarioMinimo;
import com.example.repository.SalarioMinimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalarioMinimoService implements CrudService<SalarioMinimo> {

    @Autowired
    private SalarioMinimoRepository salarioMinimoRepository;

    @Override
    public <T> Object save(SalarioMinimo salarioMinimo) {
        return salarioMinimoRepository.save(salarioMinimo);
    }

    @Override
    public <T> Object findOne(Integer id) {
       return null;
    }

    @Override
    public void delete(SalarioMinimo entity) {
        salarioMinimoRepository.delete(entity);
    }

    @Override
    public <T> List<SalarioMinimo> findAll() {
        return salarioMinimoRepository.findAll();
    }

}