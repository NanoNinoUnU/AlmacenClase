/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.AlmacenClase.Repositorios;

import com.example.AlmacenClase.Entidades.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author danny
 */
public interface RepositorioInventario extends JpaRepository<Inventario,Integer>{
    
}
