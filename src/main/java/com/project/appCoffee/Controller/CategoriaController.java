
package com.project.appCoffee.Controller;

import com.project.appCoffee.Entity.Categoria;
import com.project.appCoffee.Service.SCategoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("categorias")
//@CrossOrigin(origins = "http://localhost:4200/")
@CrossOrigin(origins="https://coffee-app-2.web.app/")

public class CategoriaController {
    
    @Autowired
    SCategoria sCategoria;
    
    
    @GetMapping("/traerCategorias")
    public ResponseEntity<List<Categoria>> traerCategorias(){
        return new ResponseEntity(sCategoria.listaCategoria(), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Categoria> traerCategoria( @PathVariable("id") int id ){
        Categoria cate = sCategoria.traerCategoria(id).get();
        return new ResponseEntity(cate, HttpStatus.OK);

    } 
    
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarCategoria(@PathVariable("id") int id){
        sCategoria.eliminarCategoria(id);
        return new ResponseEntity("Categoria eliminada", HttpStatus.OK );
    }
    
}
