package Models;

import java.util.Objects;

public class Libro {
    private Integer id;
    private String name;
    private Autor autor;
    private Genero genero;

    public Libro(Integer id, String name, Autor autor, Genero genero) {
        this.id = id;
        this.name = name;
        this.autor=autor;
        this.genero = genero;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", autor=" + autor +
                ", genero=" + genero +
                '}';
    }

    @Override
    public boolean equals(Object o) {
    if(o == this) return true;
    if(o == null || o.getClass() != this.getClass()) return false;
    Libro otro = (Libro) o;
    return name != null && otro.name != null && otro.name.equalsIgnoreCase(name) && otro.id.equals(id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name == null ? null : name.toLowerCase(),id);
    }
}
