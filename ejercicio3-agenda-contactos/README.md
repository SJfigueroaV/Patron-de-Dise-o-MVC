# Ejercicio 3: Mini-Agenda de Contactos con ArrayList

Aplicación de escritorio en Java Swing que almacena contactos (nombre y teléfono) en un
`ArrayList<Contacto>` alojado en el Modelo, aplicando el patrón Modelo-Vista-Controlador.

## Ejecutar

```bash
javac *.java && java MainApp
```

## Estructura

| Clase | Capa | Responsabilidad |
|---|---|---|
| `Contacto` | Entidad | Nombre y teléfono de un contacto. |
| `AgendaModel` | Modelo | Guarda los contactos en un `ArrayList<Contacto>`, valida que el nombre y el teléfono no estén vacíos y arma el listado numerado que se muestra en pantalla. No importa Swing. |
| `AgendaView` | Vista | Ventana con los campos Nombre y Teléfono, el botón *Agregar Contacto*, un `JTextArea` de solo lectura dentro de un `JScrollPane` y el contador de contactos. |
| `AgendaController` | Controlador | Escucha el botón, valida los campos, instancia el contacto en el Modelo y refresca la pantalla con la lista completa actualizada. |
| `MainApp` | — | Crea la Vista y el Modelo, los conecta con el Controlador y muestra la ventana. |

## Detalle importante

Al agregar un contacto nuevo **no se pierden los anteriores**: el Controlador vuelve a pedirle al Modelo
el listado completo (`obtenerListado()`) y repinta el `JTextArea` entero. La lista vive en el Modelo, no
en la pantalla.
