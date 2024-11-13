import java.util.ArrayList;
import java.util.List;

/**
 * Clase main donde ejecutamos el programa
 * @author cristian
 * 2version 1.0
 */
public class Main {
    public static void main(String[] args) {


        //objetos de las clases para acceder a distintos metodos
        LecturaEscrituraFichero lef = new LecturaEscrituraFichero();
        Crud crud = new Crud();
        Formula formula = new Formula();

        //path donde está el archivo de platos para leer
        String path = "/home/accesodatos/Escritorio/compartidaAD/Examen1AD/platoss";

        //creamos una lista igual al metodo que devuelve una lista despues de leer el fichero de platos
        List<Platos> platosList = lef.getPlatosFromFichero(path);


        /**
         * Creamos 4 listas que equivales a una consulta que devuelve:
         * El peso y la grasa del primer plato
         * el peso y la grasa del segundo plato
         */
        List<Integer> pesoPlato1 = crud.getPesoFromPlatos("p1");
        List<Integer> pesoPlato2 = crud.getPesoFromPlatos("p2");

        List<Integer> graxaPlato1 = crud.getGraxaFromPlatos("p1");
        List<Integer> graxaPlato2 = crud.getGraxaFromPlatos("p2");


        //declaramos 2 variableas con la grasa total aplicando la fórmula
        int graxaTotalPlato1 = formula.calcularGraxaTotalPlatos(graxaPlato1, pesoPlato1);
        int graxaTotalPlato2 = formula.calcularGraxaTotalPlatos(graxaPlato2, pesoPlato2);

        //creamos una lista de grasas para imprimir despues el resultado
        List<Integer> listaGraxas = new ArrayList<>();

        listaGraxas.add(graxaTotalPlato1);
        listaGraxas.add(graxaTotalPlato2);

        //metodo que imprime el resultado
        formula.getDatosFromPlatos(platosList, listaGraxas);












    }
}