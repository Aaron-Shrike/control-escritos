/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cap_logica;

/**
 *
 * @author Sh
 */
public class Revista extends Escrito {
    private boolean especialidad;
    private int articulos;
    private int numero;

    public Revista() {
        super();
        this.especialidad = false;
        this.articulos = 0;
        this.numero = 0;
    }

    public Revista(boolean especialidad, int articulos, int numero, String codigo, String titulo, int año) {
        super(codigo, titulo, año);
        this.especialidad = especialidad;
        this.articulos = articulos;
        this.numero = numero;
    }

    public boolean isEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(boolean especialidad) {
        this.especialidad = especialidad;
    }

    public int getArticulos() {
        return articulos;
    }

    public void setArticulos(int articulos) {
        this.articulos = articulos;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String presentarDetalle() {
        return "Codigo: " + getCodigo() + 
                "\nTitulo: " + getTitulo() + 
                "\nEspecialidad: " + especialidad + 
                "\nCant. Artuculos: " + articulos + 
                "\nAño public.: " + getAño() + 
                "\nNumero: " + numero + "\n";
    }

    @Override
    public String presentarLineal() {
        return getCodigo() + "\t" + getTitulo() + "\t" + especialidad + "\t" + articulos + "\t" + getAño() + "\t" + numero;
    }

    
}
