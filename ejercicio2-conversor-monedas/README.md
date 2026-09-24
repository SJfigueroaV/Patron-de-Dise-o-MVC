# Ejercicio 2: Conversor de Monedas Seguro

> Carpeta reservada para el desarrollo de este punto. Sube aquí los archivos `.java`.

## Enunciado

Diseña un conversor de divisas (Pesos Colombianos COP a Dólares USD y Euros EUR) utilizando Swing bajo el
patrón Modelo-Vista-Controlador.

## Requerimientos

- Utiliza constantes globales con `public static final double TASA_USD = 3950.0;` dentro del Modelo.
- Si el usuario ingresa letras en lugar de números en el cuadro de texto, el Controlador debe capturar la
  excepción (`NumberFormatException`) y mostrar una alerta gráfica controlada (`JOptionPane`), evitando
  que la aplicación se cierre de golpe.

## Estructura sugerida

Para mantener la misma organización de los otros ejercicios del repositorio:

| Archivo | Capa | Responsabilidad |
|---|---|---|
| `ConversorModel.java` | Modelo | Las constantes de las tasas y la conversión de pesos a dólares y euros. Sin importar Swing. |
| `ConversorView.java` | Vista | La ventana: campo de texto del monto, botón de convertir y etiquetas de resultado. |
| `ConversorController.java` | Controlador | Escucha el botón, valida la entrada, captura `NumberFormatException` y actualiza la pantalla. |
| `MainApp.java` | — | Crea la Vista, la conecta con el Controlador y muestra la ventana. |

## Ejecutar

```bash
javac *.java && java MainApp
```
