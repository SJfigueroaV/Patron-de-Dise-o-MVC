import javax.swing.*;
import java.awt.*;

public class DivisaView extends JFrame {

    private JTextField txtDinero = new JTextField(8);
    private JButton USD_Col = new JButton("Dolar a Pesos Col");
    private JButton Col_USD = new JButton("Pesos Col a Dolar");
    private JButton EUR_Col = new JButton("Euros a Pesos Col");
    private JButton Col_EUR = new JButton("Pesos Col a Euros");

    public DivisaView() {
        
        setTitle("Divisa");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(10, 10, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel etiqueta = new JLabel("Ingresa el dinero a cambiar");
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(etiqueta);
        panel.add(txtDinero);

        panel.add(USD_Col);
        panel.add(Col_USD);
        panel.add(EUR_Col);
        panel.add(Col_EUR);

        add(panel);
    }

    public String getTextoDinero() { 
        return txtDinero.getText().trim();
    }

    public JButton getBtnUSD_Col() { return USD_Col; }
    public JButton getBtnCol_USD() { return Col_USD; }
    public JButton getBtnEUR_Col() { return EUR_Col; }
    public JButton getBtnCol_EUR() { return Col_EUR; }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void mostrarMensajeError(String errorMsg) {
        JOptionPane.showMessageDialog(this, errorMsg, "Error de validacion", JOptionPane.ERROR_MESSAGE);
    }
}