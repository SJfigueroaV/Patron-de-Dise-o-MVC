# Ejercicio 1: Calculadora de Propina con MVC

Aplicación de escritorio en Java Swing que calcula la propina de un restaurante aplicando el patrón
Modelo-Vista-Controlador.

## Ejecutar

```bash
javac *.java && java MainApp
```

## Estructura

| Clase | Capa | Responsabilidad |
|---|---|---|
| `PropinaModel` | Modelo | Recibe el consumo y el porcentaje (10%, 15% o 20%) y calcula el valor de la propina y el total general. Valida que el consumo no sea negativo y que el porcentaje sea uno de los tres permitidos. No importa Swing. |
| `PropinaView` | Vista | Ventana con el campo de texto del consumo, el `JComboBox` de porcentaje, el botón *Liquidar* y las etiquetas de resultado. Solo muestra y avisa. |
| `PropinaController` | Controlador | Escucha el botón, valida la entrada, atrapa `NumberFormatException`, impide valores negativos, le pide el cálculo al Modelo y actualiza las etiquetas. |
| `MainApp` | — | Crea la Vista, la conecta con el Controlador y muestra la ventana. |

## Validaciones

- Campo vacío: *"Por favor ingrese el valor del consumo."*
- Texto no numérico: *"El consumo debe ser un valor numérico válido."*
- Valor negativo: *"El consumo no puede ser un valor negativo."*

Los errores se muestran con `JOptionPane`, de modo que la aplicación nunca se cierra de golpe.
Los resultados se presentan en pesos colombianos, por ejemplo `$ 115.000,00`.
