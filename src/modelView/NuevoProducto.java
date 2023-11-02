
package modelView;

/**
 *
 * @author ESTUDIANTE
 */
public class NuevoProducto {
    private Cocina productoCocina;
    private Sala productoSala;

    public void saveCocina(int ide, String nombre, Float pre){
        productoCocina= new Cocina(ide,nombre,pre);
    }
    
    public void saveSala(int ide, String nombre, Float pre){
        productoSala= new Sala(ide,nombre,pre);
        
    }
    
}
