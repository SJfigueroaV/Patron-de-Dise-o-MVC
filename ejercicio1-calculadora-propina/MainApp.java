import javax.swing.SwingUtilities;

/**
 * CLASE PRINCIPAL: inicializa los componentes de la arquitectura MVC y los vincula.
 */
public class MainApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Creamos la Vista (La Pantalla)
                PropinaView vista = new PropinaView();

                // Creamos el Controlador y le pasamos la Vista
                new PropinaController(vista);

                // Hacemos visible la ventana
                vista.setVisible(true);
            }
        });
    }
}
