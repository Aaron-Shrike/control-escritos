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
public abstract class Escrito implements Presentable{
    private String codigo;
    private String titulo;
    private int año;

    public Escrito() {
        this.codigo = "";
        this.titulo = "";
        this.año = 0;
    }

    public Escrito(String codigo, String titulo, int año) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.año = año;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }
}
