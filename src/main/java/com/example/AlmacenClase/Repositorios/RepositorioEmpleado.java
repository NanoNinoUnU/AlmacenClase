/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.AlmacenClase.Repositorios;

import com.example.AlmacenClase.Entidades.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author danny
 */
@Repository

public interface RepositorioEmpleado extends JpaRepository<Empleado,Integer>{
    
}
