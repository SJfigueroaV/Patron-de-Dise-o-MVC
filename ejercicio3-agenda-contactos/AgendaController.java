import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * CONTROLADOR: escucha a la Vista, guarda los datos en el Modelo
 * y refresca la pantalla con la lista actualizada.
 */
public class AgendaController {
    private AgendaView vista;
    private AgendaModel modelo;

    public AgendaController(AgendaView vista, AgendaModel modelo) {
        this.vista = vista;
        this.modelo = modelo;

        // Le indicamos a la vista que cuando hagan clic en el botón, ejecute nuestro método interno
        this.vista.agregarListenerBoton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesarAgregarContacto();
            }
        });
    }

    private void procesarAgregarContacto() {
        // 1. Extraer los datos desde la Vista
        String nombre = vista.getTextoNombre();
        String telefono = vista.getTextoTelefono();

        // 2. Validaciones básicas de entrada
        if (nombre.isEmpty() || telefono.isEmpty()) {
            vista.mostrarMensajeError("Por favor complete el nombre y el teléfono.");
            return;
        }

        try {
            // 3. Pedirle al Modelo que guarde el contacto en el ArrayList
            modelo.agregarContacto(nombre, telefono);

            // 4. Refrescar la pantalla con el listado completo, sin perder los anteriores
            vista.mostrarListado(modelo.obtenerListado());
            vista.mostrarTotal(modelo.cantidadContactos());

            // 5. Dejar el formulario listo para el siguiente contacto
            vista.limpiarCampos();

        } catch (IllegalArgumentException ex) {
            vista.mostrarMensajeError(ex.getMessage());
        }
    }
}
