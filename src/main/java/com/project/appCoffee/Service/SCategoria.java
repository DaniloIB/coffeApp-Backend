
package com.project.appCoffee.Service;

import com.project.appCoffee.Entity.Categoria;
import com.project.appCoffee.Repository.ICategoriaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SCategoria {
   
    @Autowired
    ICategoriaRepository iCategoriaRepository;
    
    public List<Categoria> listaCategoria(){
        return iCategoriaRepository.findAll();
    }
    
    public Optional<Categoria> traerCategoria(int id){
        return iCategoriaRepository.findById(id);
    }
    
    public void guardarCategoria(Categoria cat){
        iCategoriaRepository.save(cat);
    }
    
    public void eliminarCategoria(int id){
        iCategoriaRepository.deleteById(id);
    }
    
    public boolean existById(int id ){
        return iCategoriaRepository.existsById(id);
    }
    
    
}
