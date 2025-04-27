package Models;

import java.util.Objects;

public class Autor {
    private String nombre;
    private String nacionalidad;

    public Autor (String nombre, String nacionalidad){
        this.nombre=nombre;
        this.nacionalidad=nacionalidad;
    }

    @Override
    public String toString() {
        return "Datos de Autor:" +
                "nombre:'" + nombre + '\'' +
                ", nacionalidad:'" + nacionalidad + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        Autor otro = (Autor) o;
        return nombre != null && otro.nombre != null && nombre.equalsIgnoreCase(otro.nombre) && nacionalidad.equalsIgnoreCase(otro.nacionalidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre == null ? null : nombre.toLowerCase(),nacionalidad);
    }
}
