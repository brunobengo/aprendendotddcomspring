package com.example.repository;
import com.example.model.SalarioMinimo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SalarioMinimoRepository extends JpaRepository<SalarioMinimo, Integer> {

}