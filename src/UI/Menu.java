package UI;

import Models.Libro;
import Service.ListaDeLibros;

import java.util.Scanner;

public class Menu {
    private ListaDeLibros lista;
    private Scanner scanner;

    public Menu() {
        lista = new ListaDeLibros();
        scanner = new Scanner(System.in);
    }

    public void mostraMenu (){
        int opcion = 0;
        System.out.println("\n");
        System.out.println("                                            Menu principal : Biblioteca Smart");
        System.out.println("\n");
        do {
            System.out.println("Seleccione una opcion de la lista");
            System.out.println("1-Agregar libros a su lista");
            System.out.println("2-Modificar un libro de su Coleccion de libros");
            System.out.println("3-Eiminar un libro de la Coleccion");
            System.out.println("4-Consulta de libro en Coleccion");
            System.out.println("5-Listar Coleccion");
            System.out.println("0-Salir");
            System.out.println("\n");

            while(!scanner.hasNextInt()){
                System.out.println("ingrese un numero");
                scanner.nextInt();
            }
            opcion =scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 1 :
                    lista.agregarUnLibro(scanner);
                    break;
                case 2:
                    lista.modificarUnLibro(scanner);
                    break;
                case 3:
                    lista.eliminar(scanner);
                    break;
                case 4:
                    System.out.println("Ingrese el nombre del libro");
                    Libro libroBuscado = lista.buscaLibro(scanner.nextLine());  // Buscar libro
                    if (libroBuscado != null) {
                        System.out.println("Libro encontrado: " + libroBuscado);
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                    break;
                case 5:
                    lista.listarLibros();
                    break;
                case 0:
                    System.out.println("saliendo..");
                default:
                    System.out.println("La opcion no existe en el menu");
                    break;
            }
        }while (opcion !=0);
        scanner.close();
    }
}
