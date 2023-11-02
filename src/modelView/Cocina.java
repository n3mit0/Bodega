
package modelView;

public class Cocina extends Producto {
    private String nom;
    private Float pre;
    private int ID;

    public Cocina(int ide, String name, Float precio) {
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
