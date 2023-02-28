package com.project.appCoffee.Controller;

import com.project.appCoffee.Dto.DtoCliente;
import com.project.appCoffee.Entity.Cliente;
import com.project.appCoffee.Service.SCliente;
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
@RequestMapping("/clientes")
//@CrossOrigin(origins = "http://localhost:4200/")
@CrossOrigin(origins = "https://coffeapp-187c9.web.app")

public class ClienteController {

    @Autowired
    SCliente sCliente;

    @GetMapping("/allClientes")
    public ResponseEntity<List<Cliente>> findAllClientes() {
        return new ResponseEntity(sCliente.findAllClientes(), HttpStatus.OK);
    }

    @PostMapping("/saveCliente")
    public ResponseEntity saveCliente(@RequestBody DtoCliente dtoC) {
        Cliente newCliente = new Cliente(dtoC.getId(), dtoC.getNombre(), dtoC.getApellido(), dtoC.getEmail(), dtoC.getTelefono());
        sCliente.saveCliente(newCliente);
        return new ResponseEntity("Producto creado correctamente", HttpStatus.OK);
    }

    @PutMapping("/detail/{id}")
    public ResponseEntity updateCliente(@PathVariable("id") int id, @RequestBody DtoCliente dto) {

        Cliente cliente = sCliente.getOneCliente(id).get();
        cliente.setNombre(dto.getNombre());
        cliente.setApellido(dto.getApellido());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefono(dto.getTelefono());

        return new ResponseEntity("Cliente actualizado correctamente", HttpStatus.OK);
    }

    @DeleteMapping("/deleteCliente")
    public ResponseEntity deleteCliente(int id) {
        sCliente.deleteCliente(id);
        return new ResponseEntity("Cliente eliminado correctamente", HttpStatus.OK);
    }

}
