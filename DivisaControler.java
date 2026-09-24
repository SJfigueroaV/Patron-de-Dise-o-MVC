public class DivisaControler {

    private DivisaModel model;
    private DivisaView view;

    public DivisaControler(DivisaView view, DivisaModel model) {
        this.view = view;
        this.model = model;

        this.view.getBtnUSD_Col().addActionListener(e -> realizarConversion("USD_COL"));
        this.view.getBtnCol_USD().addActionListener(e -> realizarConversion("COL_USD"));
        this.view.getBtnEUR_Col().addActionListener(e -> realizarConversion("EUR_COL"));
        this.view.getBtnCol_EUR().addActionListener(e -> realizarConversion("COL_EUR"));

    }

    private void realizarConversion(String tipoOperacion) {
        try {
            String textoInput = view.getTextoDinero();

            if (textoInput.isEmpty()) {
                view.mostrarMensajeError("Por favor, ingresa una cantidada valida.");
                return;
            }

            double monto = Double.parseDouble(textoInput);
            double resultado = 0;

            switch (tipoOperacion) {
                case "USD_COL":
                    resultado = model.calcularUSD_Col(monto);
                    break;
                case "COL_USD":
                    resultado = model.calcularCol_USD(monto);
                    break;
                case "EUR_COL":
                    resultado = model.calcularEUR_Col(monto);
                    break;
                case "COL_EUR":
                    resultado = model.calcularCol_EUR(monto);
                    break;
            }

            String resultadoFormateado = String.format("%.2f", resultado);
            view.mostrarMensaje("El resultado es: " + resultadoFormateado);
            
        } catch (NumberFormatException ex) {
            view.mostrarMensajeError("Error: Debe ingresar un valor numerico valido");
        }
    }
}