/**
 * MODELO: almacena los datos y la lógica de negocio pura.
 * No conoce la interfaz gráfica ni Swing.
 */
public class PropinaModel {
    private double consumo;
    private int porcentaje;

    public PropinaModel(double consumo, int porcentaje) {
        if (consumo < 0) {
            throw new IllegalArgumentException("El consumo no puede ser negativo.");
        }
        if (porcentaje != 10 && porcentaje != 15 && porcentaje != 20) {
            throw new IllegalArgumentException("El porcentaje de propina debe ser 10, 15 o 20.");
        }
        this.consumo = consumo;
        this.porcentaje = porcentaje;
    }

    // Regla de negocio: el valor monetario de la propina
    public double calcularPropina() {
        return consumo * porcentaje / 100.0;
    }

    // Regla de negocio: el total general a pagar
    public double calcularTotal() {
        return consumo + calcularPropina();
    }

    // Getters y Setters
    public double getConsumo() { return consumo; }
    public void setConsumo(double consumo) { this.consumo = consumo; }

    public int getPorcentaje() { return porcentaje; }
    public void setPorcentaje(int porcentaje) { this.porcentaje = porcentaje; }
}
