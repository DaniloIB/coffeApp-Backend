
package com.project.appCoffee.Entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ventas")
public class Venta {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @Column(name="fecha_emision")
    private Date fechaEmision;
    
    @Column(name="cliente_id")
    private int clienteId;
    
    @ManyToOne
    @JoinColumn(name="cliente_id", insertable=false, updatable=false)
    private Cliente cliente;

    public Venta(int id, Date fechaEmision, int clienteId) {
        this.id = id;
        this.fechaEmision = fechaEmision;
        this.clienteId = clienteId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }
    
    
    
    
    
    
}
