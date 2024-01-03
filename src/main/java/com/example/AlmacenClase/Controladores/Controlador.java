package com.example.AlmacenClase.Controladores;

import com.example.AlmacenClase.Entidades.Empleado;
import com.example.AlmacenClase.Entidades.Entradas;
import com.example.AlmacenClase.Entidades.Inventario;
import com.example.AlmacenClase.Entidades.Salidas;
import com.example.AlmacenClase.Repositorios.RepositorioEmpleado;
import com.example.AlmacenClase.Repositorios.RepositorioEntradas;
import com.example.AlmacenClase.Repositorios.RepositorioInventario;
import com.example.AlmacenClase.Repositorios.RepositorioSalidas;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/PapeleriaClase")
public class Controlador {

    @Autowired
    RepositorioEmpleado sUsuario;
    @Autowired
    RepositorioInventario sProducto;
    @Autowired
    RepositorioEntradas sEntradas;
    @Autowired
    RepositorioSalidas sSalidas;

    //LOGIN***********************************************************************************************************
    @GetMapping("/login")
    public boolean validarLogin(String usuario, String contrasena) {
        boolean validacion = false;
        for (int i = 0; i < sUsuario.findAll().size(); i++) {
            if (sUsuario.findAll().get(i).getUsuario().equals(usuario)
                    && sUsuario.findAll().get(i).getContrasena().equals(contrasena)) {
                return validacion = true;
            }
        }
        return validacion;
    }

    @GetMapping("/empleado/perfil")
    public int getUnEmpleadoLogin(String usuario, String contrasena) {
        int id = 0;
        for (int i = 0; i < sUsuario.findAll().size(); i++) {
            if (sUsuario.findAll().get(i).getUsuario().equals(usuario)
                    && sUsuario.findAll().get(i).getContrasena().equals(contrasena)) {
                id = sUsuario.findAll().get(i).getIdempleado();
            }
        }
        return id;
    }

    //puesto
    @GetMapping("/puesto")
    public boolean esAdministrador(String usuario, String contrasena) {
        boolean puesto = false;
        for (int i = 0; i < sUsuario.findAll().size(); i++) {
            if (sUsuario.findAll().get(i).getUsuario().equals(usuario)
                    && sUsuario.findAll().get(i).getContrasena().equals(contrasena)) {
                if (sUsuario.findAll().get(i).getPuestoempleado().equals("Administrador")) {
                    return puesto = true;
                }
            }
        }
        return puesto;
    }

    //EMPLEADOS********************************************************************************************************
    @GetMapping("/empleado")
    public List<Empleado> getTodosLosEmpleados() {
        return sUsuario.findAll();
    }

    @GetMapping("/empleado/id")
    public Optional<Empleado> getUnEmpleado(int id) {
        return sUsuario.findById(id);
    }

    @PostMapping("/empleado")
    public List<Empleado> postInsertarEmpleado(@RequestBody Empleado a1) {
        sUsuario.save(a1);
        return sUsuario.findAll();

    }

    @PutMapping("/empleado")
    public List<Empleado> putActualizarEmpleado(@RequestBody Empleado a1) {
        sUsuario.save(a1);
        return sUsuario.findAll();
    }

    @DeleteMapping("/empleado/id")
    public List<Empleado> deleteEmpleado(int id) {
        Empleado a = sUsuario.getReferenceById(id);
        sUsuario.delete(a);
        return sUsuario.findAll();
    }

    //INVENTARIO*********************************************************************************************************
    @GetMapping("/producto")
    public List<Inventario> getTodosLosProductos() {
        return sProducto.findAll();
    }

    /*@GetMapping("/producto/sku")
    public Inventario getUnProducto(String sku) {
        int id = 0;
        for (int i = 0; i < sProducto.findAll().size(); i++) {
            if (sProducto.findAll().get(i).getSku().equals(sku)) {
                id = i;
            }
        }
        return sProducto.findAll().get(id);
    }*/
    @GetMapping("/producto/sku")
    public int getBuscarProducto(String sku) {
        int id = 0;
        for (int i = 0; i < sProducto.findAll().size(); i++) {
            if (sProducto.findAll().get(i).getSku().equals(sku)) {
                id = sProducto.findAll().get(i).getIdproducto();
            }
        }
        return id;
    }

    @GetMapping("/producto/id")
    public Optional<Inventario> getUnProducto(int id) {
        return sProducto.findById(id);
    }

    @PostMapping("/producto")
    public List<Inventario> postInsertarProducto(@RequestBody Inventario a1) {
        sProducto.save(a1);
        return sProducto.findAll();

    }

    @PutMapping("/producto")
    public List<Inventario> putActualizarProducto(@RequestBody Inventario a1) {
        sProducto.save(a1);
        return sProducto.findAll();
    }

    @DeleteMapping("/producto/id")
    public List<Inventario> deleteProducto(int id) {
        Inventario a = sProducto.getReferenceById(id);
        sProducto.delete(a);
        return sProducto.findAll();
    }

    //ENTRADAS*********************************************************************************************************
    @GetMapping("/entradas")
    public List<Entradas> getTodosLasEntradas() {
        return sEntradas.findAll();
    }

    @PostMapping("/entradas/agregar")
    public List<Entradas> postInsertarEntradas(@RequestBody Entradas a1) {
        sEntradas.save(a1);
        return sEntradas.findAll();
    }

    @DeleteMapping("/entradas/eliminartodas")
    public List<Entradas> deleteEntradas(String sku) {
        int id = 0;
        for (int i = 0; i < sEntradas.findAll().size(); i++) {
            if (sEntradas.findAll().get(i).getSku().equals(sku)) {
                id = sEntradas.findAll().get(i).getId();
                Entradas a = sEntradas.getReferenceById(id);
                sEntradas.delete(a);
            }
        }
        return sEntradas.findAll();
    }
    @DeleteMapping("/entradas/eliminaruna")
    public List<Entradas> deleteEntrada(int id) {
        Entradas a = sEntradas.getReferenceById(id);
        sEntradas.delete(a);
        return sEntradas.findAll();
    }

    //ENTRADAS*********************************************************************************************************
    @GetMapping("/salidas")
    public List<Salidas> getTodosLasSalidas() {
        return sSalidas.findAll();
    }

    @PostMapping("/salidas/agregar")
    public List<Salidas> postInsertarSalidas(@RequestBody Salidas a1) {
        sSalidas.save(a1);
        return sSalidas.findAll();

    }
    @DeleteMapping("/salidas/eliminartodas")
    public List<Salidas> deleteSalidas(String sku) {
        int id = 0;
        for (int i = 0; i < sSalidas.findAll().size(); i++) {
            if (sSalidas.findAll().get(i).getSku().equals(sku)) {
                id = sSalidas.findAll().get(i).getId();
                Salidas a = sSalidas.getReferenceById(id);
                sSalidas.delete(a);
            }
        }
        return sSalidas.findAll();
    }
    @DeleteMapping("/salidas/eliminaruna")
    public List<Salidas> deleteSalida(int id) {
        Salidas a = sSalidas.getReferenceById(id);
        sSalidas.delete(a);
        return sSalidas.findAll();
    }
}
