import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase crud con las operaciones a la base de datos
 * @author cristian
 * @version 1.0
 */
public class Crud {

    /**
     * Atributos privados para la conexion de la base de datos
     */
    private Connection conn;
    private PreparedStatement pst;
    private ResultSet rs;

    /**
     * Metodo para obtener una lista de pesos de los platos de la base de datos
     * @param codigo el codigo del plato
     * @return la lista de pesos
     */
    public List<Integer> getPesoFromPlatos(String codigo){
        //preparamos la consulta
        String consulta = "select peso from composicion where codp = ?";
        //declaramos una lista de integers
        List<Integer> pesos = new ArrayList<>();

        try{
            /**
             * Explicacion:
             * 1. Estblecemos la conexion a traves del metodo que nos da la conexion
             * 2. preparamos la consulta
             * 3. establecemos el codigo
             * 4. mientras haya resultados añadimos los pesos a la lista
             * 5. devolvemos los pesos
             */
            conn = EstablecerConexion.conectar();
            pst = conn.prepareStatement(consulta);
            pst.setString(1, codigo);

            rs = pst.executeQuery();

            while(rs.next()){
                pesos.add(rs.getInt("peso"));
            }
        } catch (SQLException e) {
            System.out.println("Ups, error al consultar el peso de la tabla");
        }
        return pesos;
    }

    /**
     * Metodo para obtener una lista de grasas de los platos de la base de datos
     * @param codigo el codigo del plato
     * @return la lista de grasas
     */
    public List<Integer> getGraxaFromPlatos(String codigo){

        /**
         * Explicacion:
         * 1. Establecemos la conexion a traves del metodo que nos da la conexion
         * 2. preparamos la consulta, para esta consulta tenemos que seleccionar el cod que está en la otra tabla y seleccionamos por codigo dado
         * 3. establecemos el codigo
         * 4. mientras haya resultados añadimos los pesos a la lista
         * 5. devolvemos las grasas
         */
        String consulta = "select graxa from componentes where codc in(select codc from composicion where codp = ?);";

        List<Integer> graxas = new ArrayList<>();

        try{
            conn = EstablecerConexion.conectar();
            pst = conn.prepareStatement(consulta);

            pst.setString(1, codigo);
            rs = pst.executeQuery();

            while(rs.next()){
                graxas.add(rs.getInt("graxa"));
            }
        }catch(SQLException e){
            System.out.println("Ups, error al consultar la grasa de la tabla");
        }
        return graxas;
    }

}


