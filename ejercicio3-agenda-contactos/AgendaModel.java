import java.util.ArrayList;

/**
 * MODELO: almacena los contactos en una lista dinámica y aplica las reglas
 * de negocio. No conoce la interfaz gráfica ni Swing.
 */
public class AgendaModel {
    private ArrayList<Contacto> contactos = new ArrayList<>();

    /**
     * Regla de negocio: el nombre y el teléfono son obligatorios.
     */
    public void agregarContacto(String nombre, String telefono) {
        if (nombre == null || nombre.trim().isEmpty() || telefono == null || telefono.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre y el teléfono son obligatorios.");
        }
        contactos.add(new Contacto(nombre.trim(), telefono.trim()));
    }

    public int cantidadContactos() {
        return contactos.size();
    }

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    /**
     * Arma el listado completo que se mostrará en pantalla, numerado y
     * con un contacto por línea.
     */
    public String obtenerListado() {
        if (contactos.isEmpty()) {
            return "La agenda está vacía.";
        }

        StringBuilder listado = new StringBuilder();
        for (int i = 0; i < contactos.size(); i++) {
            listado.append(i + 1).append(". ").append(contactos.get(i)).append("\n");
        }
        return listado.toString();
    }
}
