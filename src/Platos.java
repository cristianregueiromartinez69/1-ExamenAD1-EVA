import java.io.Serializable;

/**
 * Clase platos que implementa la interfaz Serializable
 *
 * @author cristian
 * @version 1.0
 */
public class Platos implements Serializable {
    //variables de clase
    private String codigop;
    private String nomep;

	/**
	 * Constructor por defecto
	 */
    public Platos() {
        this("", "");
    }

	/**
	 * Constructor parametrizado
	 * @param codigo el codigo del plato
	 * @param nome el nombre del plato
	 */
    public Platos(String codigo, String nome) {
        this.codigop = codigo;
        this.nomep = nome;
    }

	/**
	 * getter y setter de la clase
	 * @param code los atributos
	 */
    public void setCodigop(String code) {
        this.codigop = code;
    }

    public String getCodigop() {
        return codigop;
    }

    public void setNomep(String nome) {
        this.nomep = nome;
    }

    public String getNomep() {
        return nomep;
    }

    public String toString() {
        return "codigo plato : " + codigop + "\n" +
                "nome plato  : " + nomep;
    }


}
