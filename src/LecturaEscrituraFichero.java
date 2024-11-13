import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de lectura y escritura de fichero
 * @author cristian
 * @version 1.0
 */
public class LecturaEscrituraFichero {

    /**
     * Metodo que lee de un fichero serializable y recoge una lista de objetos tipo Platos
     * @param path el path del archivo
     * @return la lista de latos
     */
    public List<Platos> getPlatosFromFichero(String path) {
        //declaramos una lista de platos
        List<Platos> platosList = new ArrayList<>();

        //Creamos un objeto de tipo File
        File file = new File(path);
        //preguntamos si existe y si es así llamamos al metodo que añade platos a la lista
        if(file.exists()) {
            addPlatosFromFile(file, platosList);
        }
        //devolvemos los platos
        return platosList;
    }

    /**
     * Metodo que lee de un fichero y añade platos del fichero
     * @param file el archivo serializado
     * @param platosList la lista de platos
     */
    private void addPlatosFromFile(File file, List<Platos> platosList) {
        try{
            /**
             * Explicación:
             * 1. declaramos un objeto vacío
             * 2. leemos del fichero
             * 3. mientras el fichero no de null leemos los objetos
             * 4. los añadimos a la lista
             * 5. capturamos posibles excepciones
             */
            Platos platos;
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            while((platos = (Platos) ois.readObject()) != null) {
                platosList.add(platos);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ups, no se pudo encontrar en el fichero platos");
        } catch (IOException e) {
            System.out.println("");
        } catch (ClassNotFoundException e) {
            System.out.println("Ups, no se encontró la clase platos");
        }
    }
}
