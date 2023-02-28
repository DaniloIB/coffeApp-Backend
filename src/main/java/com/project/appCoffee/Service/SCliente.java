package com.project.appCoffee.Service;

import com.project.appCoffee.Entity.Cliente;
import com.project.appCoffee.Repository.IClienteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SCliente {
    
    @Autowired
    IClienteRepository iClienteRepository;
    
    public List<Cliente> findAllClientes(){
       return iClienteRepository.findAll();
    }
    
    public Optional<Cliente> getOneCliente(int id){
        return iClienteRepository.findById(id);
    }
    
    public void saveCliente(Cliente c){
        iClienteRepository.save(c);
    }
    
    public void deleteCliente(int id){
        iClienteRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iClienteRepository.existsById(id);
    }
    
    
}
