package Util;

import Models.Autor;
import Models.Genero;
import Models.Libro;

import java.util.Scanner;

public class Utilidades {
    public static Libro ingresaDatosDelLibro(Scanner scanner){
        Autor unAutor = datoAutor(scanner);
        System.out.println("Nombre del Libro: ");
        String name = scanner.nextLine();
        System.out.println("Genero: ");
        Genero genero = seleccionDeGenero(scanner);
        return new Libro(null, name,unAutor,genero);
    }
    public static Autor datoAutor (Scanner scanner){
        System.out.println("Nombre del autor:");
        String name = scanner.nextLine();
        System.out.println("Nacionalidad:");
        String pais = scanner.nextLine();
        return new Autor(name,pais);
    }

    public static Genero seleccionDeGenero(Scanner scanner){
        System.out.println("Seleccione el genero del libro");
        for(Genero g : Genero.values()){
            System.out.println("- "+ g.name());
        }
        while(true){
            System.out.println("Escriba el genero tal cual esta arriba");
            String input = scanner.nextLine().toUpperCase();
            try{
                return Genero.valueOf(input);// convierto en un enum el string
            }catch (IllegalArgumentException e){
                System.out.println("Genero invalido, intente de nuevo.");
            }
        }
    }

    public static int validaSalir(Scanner scanner) {
        int sale = 1;
        System.out.println("Quiere terminar? 1 = si | cualquier tecla para seguir");
        sale = scanner.nextInt();
        scanner.nextLine();
        return sale;
    }

    public static void modificaLibro(Libro l, Scanner scanner){
        int opcion =0;
        do {
            System.out.println("Que modifica del libro?");
            System.out.println("1-Nombre");
            System.out.println("2-Genero");
            System.out.println("3-Autor");
            System.out.println("0-Nada, salir..");
            // Validación de entrada: asegurarse de que sea un número
            while (!scanner.hasNextInt()) {  // Verifica si el próximo valor es un número
                System.out.println("Debe ingresar un número válido.");
                scanner.next();  // Consume la entrada no válida, no esta asignada a nada..
            }
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 1:
                    System.out.println("Nombre: ");
                    l.setName(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("Genero: ");
                    l.setGenero(seleccionDeGenero(scanner));
                    break;
                case 3:
                    l.setAutor(datoAutor(scanner));
                    break;
                case 0:
                    System.out.println("Saliendo..");
                    break;
                default:
                    System.out.println("La opcion ingresada no existe");
                    break;
            }
        }while(opcion != 0);
    }


}
