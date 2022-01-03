/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cap_presentacion;

import menu.Menu;
import menu.Opcion;
import basicas.Consola;
import cap_datos.ListaEscritos;
import cap_logica.Libro;
import cap_logica.Revista;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Sh
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Consola objConsola = new Consola();
        Menu  objMenu = new Menu();
        
        int opc;
        
        defineMenu(objMenu);
        
        do{
            opc = objMenu.display();
            
            switch(opc){
                case 11:
                        Libro objL = new Libro();
                        
                        System.out.println("");
                        objL.setCodigo(objConsola.leer("Ingrese codigo : "));
                        objL.setTitulo(objConsola.leer("Ingrese titulo : "));
                        objL.setEditorial(objConsola.leer("Ingrese editorial : "));
                        objL.setAño(objConsola.leer("Ingrese año publicacion[1900-2019] : ", 1900, 2019));
                        
                            int auxCantidad = objConsola.leer("Ingrese cantidad de autores[1-100] : ", 1, 100);
                            String auxString[] = new String[auxCantidad];

                            for (int i = 0; i < auxCantidad; i++) {
                                auxString[i] = objConsola.leer("Ingrese autor "+(i+1)+" : ");
                            }
                            
                        objL.setAutores(auxString);
                        objL.setPaginas(objConsola.leer("Ingrese num paginas[1-2.000] : ", 1, 2000));
                        
                        ListaEscritos.agregar(objL);
                        
                        System.out.println("\n\t* Libro registrado");
                    break;
                case 12:
                        Revista objR = new Revista();
                        
                        System.out.println("");
                        objR.setCodigo(objConsola.leer("Ingrese codigo : "));
                        objR.setTitulo(objConsola.leer("Ingrese titulo : "));
                        objR.setEspecialidad(objConsola.pregunta("Especialidad? "));
                        objR.setArticulos(objConsola.leer("Ingrese cantidad articulos[1-50] : ", 1, 50));
                        objR.setAño(objConsola.leer("Ingrese año publicacion[1900-2019] : ", 1900, 2019));
                        objR.setNumero(objConsola.leer("Ingrese numero[0-200] : ", 0, 200));
                        
                        ListaEscritos.agregar(objR);
                        
                        System.out.println("\n\t* Revista registrada");
                    break;
                    
                case 21:
                        Libro objL1;
                        String auxCodigo;
                        
                        auxCodigo = objConsola.leer("Ingrese codigo a buscar : ");
                        objL1 = (Libro) ListaEscritos.buscarLibro(auxCodigo);
                        
                        System.out.println("");
                        
                        if(objL1 != null){
                            objL1.setCodigo(objConsola.leer("Ingrese codigo : "));
                            objL1.setTitulo(objConsola.leer("Ingrese titulo : "));
                            objL1.setEditorial(objConsola.leer("Ingrese editorial : "));
                            objL1.setAño(objConsola.leer("Ingrese año publicacion[1900-2019] : ", 1900, 2019));

                                int cantidad = objConsola.leer("Ingrese cantidad de autores[1-100] : ", 1, 100);
                                String string[] = new String[cantidad];

                                for (int i = 0; i < cantidad; i++) {
                                    string[i] = objConsola.leer("Ingrese autor "+(i+1)+" : ");
                                }

                            objL1.setAutores(string);
                            objL1.setPaginas(objConsola.leer("Ingrese num paginas[1-2.000] : ", 1, 2000));   
                        }else{
                            System.out.println("\t* Libro no encontrado");
                        }
                    break;
                case 22:
                        Revista objR1;
                        String auxCod;
                        
                        auxCod = objConsola.leer("Ingrese codigo a buscar : ");
                        objR1 = (Revista) ListaEscritos.buscarRevista(auxCod);
                        
                        System.out.println("");
                        
                        if(objR1 != null){
                            objR1.setCodigo(objConsola.leer("Ingrese codigo : "));
                            objR1.setTitulo(objConsola.leer("Ingrese titulo : "));
                            objR1.setEspecialidad(objConsola.pregunta("Especialidad? "));
                            objR1.setArticulos(objConsola.leer("Ingrese cant articulos[1-50] : ", 1, 50));
                            objR1.setAño(objConsola.leer("Ingrese año publicacion[1900-2019] : ", 1900, 2019));
                            objR1.setNumero(objConsola.leer("Ingrese numero[0-200] : ", 0, 200));   
                        }else{
                            System.out.println("\t* Revista no encontrada");
                        }
                    break;
                    
                case 31:
                        ArrayList<Libro> librosEditorial;
                        Iterator<Libro> it;
                        String auxEditorial;
                        
                        auxEditorial = objConsola.leer("Ingrese editorial a buscar : ");
                        librosEditorial = ListaEscritos.listaLibrosPorEditorial(auxEditorial);
                        
                        System.out.println("\nLISTA DE LIBROS SEGUN UNA EDITORIAL");
                        System.out.println("Codigo\tTitulo\tEditoral\tAño\t\tAutores\t\tPaginas");
                        
                        if(librosEditorial.size() > 0){
                            it = librosEditorial.iterator();
                            while(it.hasNext()){
                                Libro l = it.next();

                                System.out.println(l.presentarLineal());
                            }
                        }else{
                            System.out.println("\t* Lista vacia");
                        }
                    break;
                case 32:
                        ArrayList<Revista> revistasEspecializadas;
                        Iterator<Revista> it1;
                        
                        revistasEspecializadas = ListaEscritos.listaRevistasEspecializadas();
                        
                        System.out.println("\nLISTA DE REVISTAS ESPECIALIZADAS CON MAS DE 30 ARTICULOS");
                        System.out.println("Codigo\tTitulo\tEspecialidad\tArticulos\tAño\tNumero");
                        
                        if(revistasEspecializadas.size() > 0){
                            it1 = revistasEspecializadas.iterator();
                            while(it1.hasNext()){
                                Revista r = it1.next();

                                System.out.println(r.presentarLineal());
                            }
                        }else{
                            System.out.println("\t* Lista vacia");
                        }
                    break;
                case 33:
                        ArrayList<Libro> librosActuales;
                        Iterator<Libro> it3;
                        
                        librosActuales = ListaEscritos.listaLibrosActuales();
                        
                        System.out.println("\nLISTA DE LIBROS DEL 2019 CON 150 PAGINAS COMO MINIMO");
                        System.out.println("Codigo\tTitulo\tEditoral\tAño\t\tAutores\t\tPaginas");
                        
                        if(librosActuales.size() > 0){
                            it3 = librosActuales.iterator();
                            while(it3.hasNext()){
                                Libro l = it3.next();

                                System.out.println(l.presentarLineal());
                            }
                        }else{
                            System.out.println("\t* Lista vacia");
                        }
                    break;
                case 34:
                        int auxContador[] = ListaEscritos.cantidadLibrosRevistas();
                        
                        System.out.println("\nCANTIDAD DE LIBROS Y REVISTAS CON ANTIGUEDAD MENOR A 5 AÑOS");
                        
                        System.out.println("Libros  : " + auxContador[0]);
                        System.out.println("Revistas: " + auxContador[1]);
                    break;
                case 35:
                        ArrayList<Libro> librosAutores;
                        Iterator<Libro> it4;
                        
                        librosAutores = ListaEscritos.listaLibrosAutores();
                        
                        System.out.println("\nLISTA DE LIBROS CON 3 A MAS AUTORES");
                        System.out.println("Codigo\tTitulo\tEditoral\tAño\t\tAutores\t\tPaginas");
                        
                        if(librosAutores.size() > 0){
                            it4 = librosAutores.iterator();
                            while(it4.hasNext()){
                                Libro l = it4.next();

                                System.out.println(l.presentarLineal());
                            }
                        }else{
                            System.out.println("\t* Lista vacia");
                        }
                    break;
                
            }
        }while(opc != 99);
    }
        
    public static void defineMenu(Menu objMenu){
        objMenu.agregar(new Opcion(11,"Agregar Libro"));
        objMenu.agregar(new Opcion(12,"Agregar Revista"));
        
        objMenu.agregar(new Opcion(21,"Modificar Libro"));
        objMenu.agregar(new Opcion(22,"Modificar Revista"));
        
        objMenu.agregar(new Opcion(31,"Lista de Libros de una editorial especifica"));
        objMenu.agregar(new Opcion(32,"Lista de Revistas que sean especializadas y con mas de 30 articulos publicados"));
        objMenu.agregar(new Opcion(33,"Listado de Libros publicados este año y que tengan 150 paginas como minimo"));
        objMenu.agregar(new Opcion(34,"Mostrar la cantidad de Libros y Revistas registradas en el sistema que no tengasn una antiguedad mayor de 5 años"));
        objMenu.agregar(new Opcion(35,"Listado de Libros que tienen 3 a mas autores"));
        
        objMenu.agregar(new Opcion(99,"Salir"));
    }
    
}
