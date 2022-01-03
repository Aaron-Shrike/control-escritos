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
public class Libro extends Escrito {
    private String editorial;
    private String autores[];
    private int paginas;

    public Libro() {
        super();
        this.editorial = "";
        this.autores = null;
        this.paginas = 0;
    }

    public Libro(String codigo, String titulo, int año, String editorial, String[] autores, int paginas) {
        super(codigo, titulo, año);
        this.editorial = editorial;
        this.autores = autores;
        this.paginas = paginas;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String[] getAutores() {
        return autores;
    }

    public void setAutores(String[] autores) {
        this.autores = autores;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    @Override
    public String presentarDetalle() {
        String texto = "";
        
        texto += "Codigo: " + getCodigo() + 
                "\nTitulo: " + getTitulo() + 
                "\nEditorial: " + editorial + 
                "\nAño public.:" + getAño() + 
                "\nAutores: ";
        
        for (String i : autores) {
            texto += i + " ";
        }
        
        texto += "\nNum. paginas: " + paginas + "\n";
        
        return texto;
    }

    @Override
    public String presentarLineal() {
        String texto = "";
        
        texto += getCodigo() + "\t" + getTitulo() + "\t" + editorial + "\t" + getAño() + "\t";
        
        for (String i : autores) {
            texto += i + " ";
        }
        
        texto += "\t" + paginas;
        
        return texto;
    }
}    
