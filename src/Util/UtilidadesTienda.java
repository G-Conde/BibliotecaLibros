package Util;

import Models.Libro;
import Service.ListaDeLibros;

import java.util.Scanner;

public class UtilidadesTienda {
    public static Integer buscaUnlibroPorid(Integer id, ListaDeLibros lista, Scanner scanner){
        for(Libro l : lista.getLista().values()){
            if(l.getId().equals(id)){
                System.out.println("INGRESA CANTIDAD DE LIBROS");
                return scanner.nextInt();
            }
        }
        return null;
    }

}
