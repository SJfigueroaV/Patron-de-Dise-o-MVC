import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * VISTA: construye la interfaz gráfica de usuario con Java Swing.
 * Expone métodos públicos para que el controlador pueda leerla y actualizarla.
 */
public class AgendaView extends JFrame {
    private JTextField txtNombre = new JTextField(15);
    private JTextField txtTelefono = new JTextField(15);
    private JButton btnAgregar = new JButton("Agregar Contacto");
    private JTextArea areaContactos = new JTextArea(10, 30);
    private JLabel lblTotal = new JLabel("Contactos registrados: 0");

    public AgendaView() {
        // Configuración de la ventana principal
        setTitle("Mini-Agenda de Contactos - MVC");
        setSize(480, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en pantalla

        // Zona superior: el formulario de captura
        JPanel panelFormulario = new JPanel(new GridLayout(3, 2, 10, 10));
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(15, 15, 10, 15));
        panelFormulario.add(new JLabel("Nombre:"));
        panelFormulario.add(txtNombre);
        panelFormulario.add(new JLabel("Teléfono:"));
        panelFormulario.add(txtTelefono);
        panelFormulario.add(new JLabel(""));
        panelFormulario.add(btnAgregar);

        // Zona central: el listado de contactos, dentro de una barra de desplazamiento
        areaContactos.setEditable(false); // Solo lectura: se llena desde el Modelo
        areaContactos.setText("La agenda está vacía.");
        JScrollPane scroll = new JScrollPane(areaContactos);
        scroll.setBorder(BorderFactory.createTitledBorder("Contactos"));

        JPanel panelListado = new JPanel(new BorderLayout(10, 10));
        panelListado.setBorder(BorderFactory.createEmptyBorder(0, 15, 15, 15));
        panelListado.add(scroll, BorderLayout.CENTER);
        panelListado.add(lblTotal, BorderLayout.SOUTH);

        // Añadir las dos zonas a la ventana
        add(panelFormulario, BorderLayout.NORTH);
        add(panelListado, BorderLayout.CENTER);
    }

    // Métodos Getters para que el controlador obtenga lo que escribió el usuario
    public String getTextoNombre() {
        return txtNombre.getText().trim();
    }

    public String getTextoTelefono() {
        return txtTelefono.getText().trim();
    }

    // Métodos para actualizar la pantalla
    public void mostrarListado(String listado) {
        areaContactos.setText(listado);
    }

    public void mostrarTotal(int cantidad) {
        lblTotal.setText("Contactos registrados: " + cantidad);
    }

    public void limpiarCampos() {
        txtNombre.setText("");
        txtTelefono.setText("");
        txtNombre.requestFocus();
    }

    // Método para conectar la acción del botón con el Controlador (Patrón Observer / Listener)
    public void agregarListenerBoton(ActionListener listenForAgregarBtn) {
        btnAgregar.addActionListener(listenForAgregarBtn);
    }

    // Método auxiliar para mostrar alertas de error emergentes
    public void mostrarMensajeError(String errorMsg) {
        JOptionPane.showMessageDialog(this, errorMsg, "Error de Validación", JOptionPane.ERROR_MESSAGE);
    }
}
