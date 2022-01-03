/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cap_datos;

import cap_logica.Escrito;
import cap_logica.Libro;
import cap_logica.Revista;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Sh
 */
public class ListaEscritos {
    private static ArrayList<Escrito> datos = new ArrayList<>();
    
    public static void agregar(Escrito obj){
        datos.add(obj);
    }
    
    public static ArrayList<Escrito> obtener(){
        return datos;
    }
    
    public static Escrito buscarLibro(String codigo){
        Iterator<Escrito> it;
        
        it = datos.iterator();
        while(it.hasNext()){
            Escrito e = it.next();
            
            if(e instanceof Libro){
                if(e.getCodigo().equalsIgnoreCase(codigo)){
                    return e;
                }
            }
        }
        
        return null;
    }
    
    public static Escrito buscarRevista(String codigo){
        Iterator<Escrito> it;
        
        it = datos.iterator();
        while(it.hasNext()){
            Escrito e = it.next();
            
            if(e instanceof Revista){
                if(e.getCodigo().equalsIgnoreCase(codigo)){
                    return e;
                }
            }
        }
        
        return null;
    }
    
    public static ArrayList<Libro> listaLibrosPorEditorial(String editorial){
        ArrayList<Libro> libros = new ArrayList<>();
        Iterator<Escrito> it;
        
        it = datos.iterator();
        while(it.hasNext()){
            Escrito e = it.next();
            
            if(e instanceof Libro){
                if(((Libro) e).getEditorial().equalsIgnoreCase(editorial)){
                    libros.add((Libro) e);
                }
            }
        }
        
        return libros;
    }
    
    public static ArrayList<Revista> listaRevistasEspecializadas(){
        ArrayList<Revista> revista = new ArrayList<>();
        Iterator<Escrito> it;
        
        it = datos.iterator();
        while(it.hasNext()){
            Escrito e = it.next();
            
            if(e instanceof Revista){
                if(((Revista) e).isEspecialidad() && ((Revista) e).getArticulos() > 30){
                    revista.add((Revista) e);
                }
            }
        }
        
        return revista;
    }
    
    public static ArrayList<Libro> listaLibrosActuales(){
        ArrayList<Libro> libros = new ArrayList<>();
        Iterator<Escrito> it;
        
        it = datos.iterator();
        while(it.hasNext()){
            Escrito e = it.next();
            
            if(e instanceof Libro){
                if(e.getAño() == 2019 && ((Libro) e).getPaginas() >= 150){
                    libros.add((Libro) e);
                }
            }
        }
        
        return libros;
    }
    
    public static int[] cantidadLibrosRevistas(){
        Iterator<Escrito> it;
        int contador[] = new int[2];
        
        it = datos.iterator();
        while(it.hasNext()){
            Escrito e = it.next();
            
            if(e.getAño() > 2013){
                if(e instanceof Libro){
                    contador[0]++;
                }
                
                if(e instanceof Revista){
                    contador[1]++;
                }     
            }  
        }
        
        return contador;
    }
    
    public static ArrayList<Libro> listaLibrosAutores(){
        ArrayList<Libro> libros = new ArrayList<>();
        Iterator<Escrito> it;
        
        it = datos.iterator();
        while(it.hasNext()){
            Escrito e = it.next();
            
            if(e instanceof Libro){
                if(((Libro) e).getAutores().length >= 3){
                    libros.add((Libro) e);
                }
            }
        }
        
        return libros;
    }
}
