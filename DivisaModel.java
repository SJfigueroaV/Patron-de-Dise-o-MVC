public class DivisaModel {

    public static final double TASA_USD = 3950.0;
    public static final double TASA_EUR = 3660.0;
    public double dinero;

    public DivisaModel(double dinero) {
        this.dinero = dinero;
    }

    public double calcularUSD_Col (double dinero) {
        return dinero * TASA_USD;
    }

    public double calcularCol_USD (double dinero) {
        return dinero / TASA_USD;
    } 

    public double calcularEUR_Col (double dinero) {
        return dinero * TASA_EUR;
    }

    public double calcularCol_EUR (double dinero) {
        return dinero / TASA_EUR;
    }

    public double getDinero() { return dinero; }
    public void setDinero(double dinero) { this.dinero = dinero; }

}