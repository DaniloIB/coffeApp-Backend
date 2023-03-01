package com.project.appCoffee.Controller;

import com.project.appCoffee.Dto.DtoProducto;
import com.project.appCoffee.Entity.Producto;
import com.project.appCoffee.Service.SProducto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("productos")
//@CrossOrigin(origins = "http://localhost:4200/")
@CrossOrigin(origins="https://coffee-app-2.web.app/")


public class ProductoController {

    @Autowired
    SProducto sProducto;

    @GetMapping("/Allproducts")
    public ResponseEntity<List<Producto>> listaProductos() {
        return new ResponseEntity(sProducto.listaProductos(), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Producto> traerProducto(@PathVariable("id") int id) {
        Producto product = sProducto.traerProducto(id).get();
        return new ResponseEntity(sProducto.traerProducto(id), HttpStatus.OK);
    }

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarProducto(@RequestBody DtoProducto dto) {
        Producto producto = new Producto(dto.getNombre(), dto.getDescripcion(), dto.getPrecio(), dto.getExistencia(), dto.getValoracion(), dto.getImagenUrl(), dto.getIdCategoria());
        sProducto.guardarProducto(producto);
        return new ResponseEntity("Producto creado correctamente.", HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarProducto(@PathVariable("id") int id,
            @RequestBody DtoProducto dtoProducto) {
        Producto newProduct = sProducto.traerProducto(id).get();
        newProduct.setNombre(dtoProducto.getNombre());
        newProduct.setDescripcion(dtoProducto.getDescripcion());
        newProduct.setPrecio(dtoProducto.getPrecio());
        newProduct.setImagenUrl(dtoProducto.getImagenUrl());
        newProduct.setExistencia(dtoProducto.getExistencia());

        return new ResponseEntity("Producto actualizado correctamente.", HttpStatus.OK);

    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable("id") int id) {
        sProducto.eliminarProducto(id);
        return new ResponseEntity("Producto eliminado correctamente.", HttpStatus.OK);

    }

}
