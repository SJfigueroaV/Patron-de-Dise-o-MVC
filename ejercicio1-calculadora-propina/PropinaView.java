import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * VISTA: construye la interfaz gráfica de usuario con Java Swing.
 * Expone métodos públicos para que el controlador pueda leerla y actualizarla.
 */
public class PropinaView extends JFrame {
    private JTextField txtConsumo = new JTextField(12);
    private JComboBox<Integer> cmbPorcentaje = new JComboBox<>(new Integer[] { 10, 15, 20 });
    private JButton btnLiquidar = new JButton("Liquidar");
    private JLabel lblPropina = new JLabel("Propina: $0");
    private JLabel lblTotal = new JLabel("Total a pagar: $0");

    public PropinaView() {
        // Configuración de la ventana principal
        setTitle("Calculadora de Propina - MVC");
        setSize(430, 240);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar en pantalla

        // Usar un panel con diseño de cuadrícula (Grid)
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Agregar elementos visuales al panel
        panel.add(new JLabel("Valor del consumo:"));
        panel.add(txtConsumo);

        panel.add(new JLabel("Porcentaje de propina:"));
        panel.add(cmbPorcentaje);

        panel.add(new JLabel(""));
        panel.add(btnLiquidar);

        panel.add(new JLabel("Propina:"));
        panel.add(lblPropina);

        panel.add(new JLabel("Total:"));
        panel.add(lblTotal);

        // Añadir el panel a la ventana
        add(panel);
    }

    // Métodos Getters para que el controlador obtenga lo que eligió el usuario
    public String getTextoConsumo() {
        return txtConsumo.getText().trim();
    }

    public int getPorcentajeSeleccionado() {
        return (int) cmbPorcentaje.getSelectedItem();
    }

    // Métodos para actualizar las etiquetas de resultado en la pantalla
    public void mostrarPropina(String valorPropina) {
        lblPropina.setText(valorPropina);
    }

    public void mostrarTotal(String valorTotal) {
        lblTotal.setText(valorTotal);
    }

    public void limpiarResultados() {
        lblPropina.setText("Propina: $0");
        lblTotal.setText("Total a pagar: $0");
    }

    // Método para conectar la acción del botón con el Controlador (Patrón Observer / Listener)
    public void agregarListenerBoton(ActionListener listenForLiquidarBtn) {
        btnLiquidar.addActionListener(listenForLiquidarBtn);
    }

    // Método auxiliar para mostrar alertas de error emergentes
    public void mostrarMensajeError(String errorMsg) {
        JOptionPane.showMessageDialog(this, errorMsg, "Error de Validación", JOptionPane.ERROR_MESSAGE);
    }
}
