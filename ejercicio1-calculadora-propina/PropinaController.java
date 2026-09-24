import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * CONTROLADOR: escucha a la Vista, procesa los datos usando el Modelo
 * y actualiza la pantalla con la respuesta.
 */
public class PropinaController {
    private PropinaView vista;
    private NumberFormat formatoPesos = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("es-CO"));

    public PropinaController(PropinaView vista) {
        this.vista = vista;

        // Le indicamos a la vista que cuando hagan clic en el botón, ejecute nuestro método interno
        this.vista.agregarListenerBoton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesarLiquidacion();
            }
        });
    }

    private void procesarLiquidacion() {
        try {
            // 1. Extraer los datos desde la Vista
            String textoConsumo = vista.getTextoConsumo();
            int porcentaje = vista.getPorcentajeSeleccionado();

            // 2. Validaciones básicas de entrada
            if (textoConsumo.isEmpty()) {
                vista.mostrarMensajeError("Por favor ingrese el valor del consumo.");
                vista.limpiarResultados();
                return;
            }

            double consumo = Double.parseDouble(textoConsumo);

            // No se permiten valores negativos
            if (consumo < 0) {
                vista.mostrarMensajeError("El consumo no puede ser un valor negativo.");
                vista.limpiarResultados();
                return;
            }

            // 3. Crear el objeto del Modelo con los datos limpios
            PropinaModel liquidacion = new PropinaModel(consumo, porcentaje);

            // 4. Pedirle al Modelo que ejecute la lógica de negocio
            double valorPropina = liquidacion.calcularPropina();
            double totalAPagar = liquidacion.calcularTotal();

            // 5. Enviar el resultado de vuelta a la Vista para que el usuario lo vea
            vista.mostrarPropina("Propina (" + porcentaje + "%): " + formatoPesos.format(valorPropina));
            vista.mostrarTotal("Total a pagar: " + formatoPesos.format(totalAPagar));

        } catch (NumberFormatException ex) {
            vista.mostrarMensajeError("El consumo debe ser un valor numérico válido.");
            vista.limpiarResultados();
        }
    }
}
