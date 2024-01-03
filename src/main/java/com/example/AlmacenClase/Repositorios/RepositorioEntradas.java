package com.example.AlmacenClase.Repositorios;

import com.example.AlmacenClase.Entidades.Entradas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioEntradas extends JpaRepository<Entradas,Integer>{
    
}
