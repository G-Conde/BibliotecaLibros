package Service;

import Models.Libro;
import Util.Utilidades;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class ListaDeLibros {
    private LinkedHashMap<Integer, Libro> lista;

    public ListaDeLibros() {
        lista = new LinkedHashMap<>();
    }

    public void agregarUnLibro(Scanner scanner){
        Libro l = Utilidades.ingresaDatosDelLibro(scanner);
        lista.put(l.getId(),l);
        System.out.println("Se agrego correctamente "+ l.getName());
    }

    public void agregarLibros(Scanner scanner) {
        boolean opcion = false;
        int sale = 0;
        do {
            agregarUnLibro(scanner);
            sale = Utilidades.validaSalir(scanner);
            if (sale == 1) {
                opcion = true;
            }
        } while (!opcion);
    }

    public void listarLibros(){
        for(Libro l : lista.values()){
            System.out.println(l);
        }
    }

    public Libro buscaLibro(String name) {
        for (Libro l : lista.values()) {
            if (l.getName().equalsIgnoreCase(name)) {
                return l;
            }
        }
        return null;
    }

    public Libro buscaPorId(Integer id){
        for(Libro l : lista.values()){
            if(l.getId().equals(id)){
                return l;
            }
        }
        return null;
    }

    public void eliminar(Scanner scanner){
        System.out.println("Ingrese el nombre del libro a eliminar");
        String name = scanner.nextLine();
        Libro l= buscaLibro(name);
        if(l != null){
            lista.remove(l.getId());
            System.out.println("Se elimino correctamente");
        }else{
            System.out.println("No se encontro el libro con ese nombre");
        }
    }

    public void modificarUnLibro (Scanner scanner){
        System.out.println("Indique el id del libro a modificar");
        Integer busca = scanner.nextInt();
        scanner.nextLine();
        Libro l = buscaPorId(busca);
        if(l != null){
            Utilidades.modificaLibro(l,scanner);
            System.out.println("Se modifico el campo elegido del libro " + l.getName());
        }else{
            System.out.println("El libro no existe");
        }
    }
}
