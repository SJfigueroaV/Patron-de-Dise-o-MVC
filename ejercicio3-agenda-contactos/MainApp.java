import javax.swing.SwingUtilities;

/**
 * CLASE PRINCIPAL: inicializa los componentes de la arquitectura MVC y los vincula.
 */
public class MainApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Creamos la Vista (La Pantalla) y el Modelo (Los Datos)
                AgendaView vista = new AgendaView();
                AgendaModel modelo = new AgendaModel();

                // Creamos el Controlador y le pasamos la Vista y el Modelo
                new AgendaController(vista, modelo);

                // Hacemos visible la ventana
                vista.setVisible(true);
            }
        });
    }
}
