
package com.project.appCoffee.Entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Producto {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    private String nombre;
    private String descripcion;
    private double precio;
    private int existencia;
    private double valoracion;
    
    @Column(name="imagen_url")
    private String imagenUrl;

    @Column(name="id_subcategoria")
    private int idSubcategoria;
    
    @ManyToOne
    @JoinColumn(name="id_subcategoria", insertable = false, updatable = false)
    private Subcategoria subcategoria;
    
    
    
    public Producto() {
    }

    public Producto( String nombre, String descripcion, double precio, int existencia, double valoracion, String imagenUrl, int idSubcategoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.existencia = existencia;
        this.valoracion = valoracion;
        this.imagenUrl = imagenUrl;
        this.idSubcategoria = idSubcategoria;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public double getValoracion() {
        return valoracion;
    }

    public void setValoracion(double valoracion) {
        this.valoracion = valoracion;
    }
    

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public int getidSubcategoria() {
        return idSubcategoria;
    }

    public void setidSubcategoria(int idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }

    

    
    
    
    
    
    
}
