package Service;

import Models.Libro;
import Util.UtilidadesTienda;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Tienda {
    private ListaDeLibros lista;
    private Map<Integer,Integer> stock;

    public Tienda(ListaDeLibros lista) {
        this.lista = lista;
        this.stock = new HashMap<>();
    }

    public void actualizaStock(Scanner scanner){
        System.out.println("Id del libro a actualizar");
        int idBuscado = scanner.nextInt();
        scanner.nextLine();
        Integer cantidad = UtilidadesTienda.buscaUnlibroPorid(idBuscado,lista,scanner);
        if(cantidad==null){
            System.out.println("no se encontro el libro en la coleccion");
        }else {
            stock.put(idBuscado,cantidad);
            System.out.println("Se Actualizo el stock");
        }
    }

    public void venta(Scanner scanner){
        System.out.println("Indique el id del libro a vender");
        int id = scanner.nextInt();
        scanner.nextLine();
        Integer stockActual = stock.get(id);
        System.out.println("Indique los libros a vender");
        int cant= scanner.nextInt();
        if(stockActual != null && cant >= stockActual){
          stock.put(id,stockActual - cant);
            System.out.println("Se realizo la operacion con exito");
        }else{
            System.out.println("No hay cantidad para realizar esa venta");
            System.out.println("cantidad actual"+ stockActual);
        }
    }
}
