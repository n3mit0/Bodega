package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.CountDownLatch;

/**
 *  *
 *  * @author  
 */
public class TxtFile {

    private final ArrayList<String> recuperado;
    private static final CountDownLatch contador = new CountDownLatch(1);
    private ArrayList<String> listaNuevo;
    private String lista;
    private LinkedHashMap<Integer, String> tabla;

    public TxtFile() {
        this.recuperado = new ArrayList();
        this.lista = "";
    }

    public String saveProducto(int ide, String nombre, float precio) {

        this.listaNuevo = new ArrayList();
//conversion
        String pre = String.valueOf(precio);
        String ID = String.valueOf(ide);
        listaNuevo.add(ID+":"+nombre + " = " + pre);
// Para guardar datos de presion y temperatura en un archivo en modo append
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("inventario.txt", true))) {
            int fil = listaNuevo.size(); // Número de filas
            for (int i = 0; i < fil; i++) {
                try {
                    writer.write(listaNuevo.get(i)); // Tabulador para separar los elementos
                    writer.newLine(); // Nueva línea para separar las filas
                } catch (IOException ex) {

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        contador.countDown();
        try {
            contador.await();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return "Registro guardado";
    }

    private void recuperar() throws FileNotFoundException, IOException {

//"C:\Users\julie\Downloads\Calculadora - Julieth Rojas\firstApp\Registros.txt"
// Recuperar datos desde el archivo
        try (BufferedReader reader = new BufferedReader(new FileReader(
                "\\C:\\Users\\ESTUDIANTE\\Documents\\NetBeansProjects"
                + "\\bodega\\inventario.txt\\"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                this.recuperado.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String historial() throws IOException {
        this.lista = "";
        recuperar();
        for (int i = 0; i < this.recuperado.size(); i++) {
            String nuevo = this.recuperado.get(i);
            this.lista = (this.lista + nuevo + "\n");
        }
        return this.lista;
    }
    
    public String buscar(int ide){
        String resul="";
        this.tabla = new LinkedHashMap<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(
                "\\C:\\Users\\ESTUDIANTE\\Documents\\NetBeansProjects"
                + "\\bodega\\inventario.txt\\"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length ==2){
                    int id = Integer.parseInt(partes[0]);
                    String demas = partes[1];
                    
                this.tabla.put(id,demas);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        if (this.tabla.containsKey(ide)){
            resul = "Si se encuentra en el inventario";
        }else {
            resul = "no se encuentra en el inventario";
        }
        return resul;
    }
}
