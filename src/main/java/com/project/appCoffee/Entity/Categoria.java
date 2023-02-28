package com.project.appCoffee.Entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categorias")
public class Categoria {
   
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String nombre;
    
    @OneToMany(mappedBy="categoria")
    private List<Subcategoria> subcategoria;
    
    public Categoria() {
    }

    
    public Categoria(int id, String nombre, List<Subcategoria> subcategoria) {
        this.id = id;
        this.nombre = nombre;
        this.subcategoria = subcategoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Subcategoria> getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(List<Subcategoria> subcategoria) {
        this.subcategoria = subcategoria;
    }
    
    
    
    
    
    
}
