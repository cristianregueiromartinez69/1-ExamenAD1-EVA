import java.util.List;

/**
 * Clase con la formula de calcula de la grasa total
 * @author cristian
 * @version 1.0
 */
public class Formula {

    /**
     * Formula para calcular la grasa total del plato
     * @param graxaParcialList una lista de grasas parciales
     * @param pesosList una lista con el peso
     * @return la grasa del plato
     */
    public int calcularGraxaTotalPlatos(List<Integer> graxaParcialList, List<Integer> pesosList){
        int graxaTotal = 0;
        int graxaParcial = 0;

        for(int i = 0; i < graxaParcialList.size(); i++){
            graxaParcial = pesosList.get(i)/100*graxaParcialList.get(i);
            graxaTotal += graxaParcial;
        }
        return graxaTotal;
    }

    /**
     * Metodo final para mostrar el resultado del examen
     * @param platosList una lista de platos que viene del fichero
     * @param graxaTotalList la lista de grasas totales
     */
    public void getDatosFromPlatos(List<Platos> platosList, List<Integer> graxaTotalList){
        for(int i = 0; i < graxaTotalList.size(); i++){
            System.out.println(platosList.get(i));
            System.out.println("Graxa total: " + graxaTotalList.get(i));
            System.out.println();
        }
    }




}

