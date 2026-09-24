# Taller: Patrón de Diseño Modelo-Vista-Controlador (MVC)

Fundamentos de Diseño de Software
Programa Ciencias de la Computación e Inteligencia Artificial
Escuela de Ciencias Exactas e Ingeniería — Universidad Sergio Arboleda

Aplicaciones de escritorio en Java Swing que aplican el patrón MVC, y las preguntas de reflexión del
taller.

## Contenido

| Carpeta | Punto del taller |
|---|---|
| [`ejercicio1-calculadora-propina/`](ejercicio1-calculadora-propina/) | Ejercicio 1: Calculadora de Propina con MVC |
| `ejercicio2-conversor-monedas/` | Ejercicio 2: Conversor de Monedas Seguro |
| [`ejercicio3-agenda-contactos/`](ejercicio3-agenda-contactos/) | Ejercicio 3: Mini-Agenda de Contactos con `ArrayList` |
| [`punto4-preguntas-de-reflexion/`](punto4-preguntas-de-reflexion/) | Preguntas de Reflexión y Pensamiento Crítico |

## Requisitos

Un JDK (Java 8 o superior). No se necesitan librerías externas: Java Swing viene incluido en el JDK.

## Ejecutar

Cada ejercicio se compila y se ejecuta por separado:

```bash
cd ejercicio1-calculadora-propina && javac *.java && java MainApp
cd ejercicio2-conversor-monedas   && javac *.java && java MainApp
cd ejercicio3-agenda-contactos    && javac *.java && java MainApp
```

## El patrón aplicado

En los dos ejercicios se respetan las tres reglas del patrón:

- **El Modelo** guarda los datos y las reglas de negocio, y no contiene una sola línea de Swing.
- **La Vista** solo muestra información y avisa de los eventos; no calcula ni decide.
- **El Controlador** escucha a la Vista, valida la entrada del usuario, le pide el trabajo al Modelo y
  actualiza la pantalla con el resultado.
