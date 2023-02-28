
package com.project.appCoffee.Service;

import com.project.appCoffee.Entity.Producto;
import com.project.appCoffee.Repository.IProductoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SProducto {
    
    @Autowired
    IProductoRepository iProductoRepository;
    
    
    public List<Producto> listaProductos(){
        return iProductoRepository.findAll();
    }
    
    public Optional<Producto> traerProducto(int id){
        return iProductoRepository.findById(id);
    }
    
    public void guardarProducto( Producto producto ){
        iProductoRepository.save(producto);
    }
    
    public void eliminarProducto(int id){
        iProductoRepository.deleteById(id);
    }    
    
    public boolean existsById(int id){
        return iProductoRepository.existsById(id);
    }
    
}
