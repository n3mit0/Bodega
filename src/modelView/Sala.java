package modelView;

/**
 *
 * @author ESTUDIANTE
 */
public class Sala extends Producto {

    private final String nom;
    private final Float pre;
    private int ID;

    public Sala(int ide, String name, Float precio) {
        this.nom = name;
        this.pre = precio;
        this.ID = ide;
    }

    @Override
    public String getNombre() {
        return this.nom;
    }

    @Override
    public Float getPrecio() {
        return this.pre;
    }

    @Override
    public int getID() {
        return this.ID;
    }
}
