# Preguntas de Reflexión y Pensamiento Crítico

## 1. Arquitectura

**Enunciado:** si un programador novato decide escribir la fórmula matemática del cálculo de la edad
directamente dentro de un botón en la clase de la Vista (`PersonaView`), ¿qué principio de diseño
fundamental de la programación orientada a objetos está rompiendo y por qué es una mala práctica
empresarial?

### Principio de diseño violado

- **Principio de Responsabilidad Única (SRP):** establece que una clase debe tener una sola razón para
  cambiar. La clase `PersonaView` debe responder únicamente a la presentación gráfica e interacción del
  usuario, no al procesamiento ni cálculo de la lógica de negocio.
- **Separación de Responsabilidades (SoC) / Arquitectura MVC:** se vulnera el patrón
  Modelo-Vista-Controlador al incrustar reglas del Modelo (o negocio) directamente dentro de la Vista.

### Por qué es una mala práctica empresarial

- **Reutilización nula:** si otra parte del sistema (como un reporte, una API o un proceso en lote)
  necesita calcular la edad, la fórmula tendría que duplicarse en lugar de reutilizarse desde una lógica
  centralizada.
- **Mantenibilidad y costo:** si la regla para calcular la edad cambia (por ejemplo, considerando zonas
  horarias o leyes particulares), se debe buscar y actualizar el código en la interfaz gráfica, lo cual
  incrementa el riesgo de introducir errores inesperados y eleva los costos de mantenimiento.
- **Dificultad de testabilidad:** las pruebas unitarias automatizadas no pueden validar el cálculo
  matemático de forma aislada sin levantar la interfaz gráfica o instanciar componentes UI.

## 2. Desacoplamiento

**Enunciado:** ¿qué ventajas ofrece el hecho de que el Modelo no contenga ninguna instrucción relacionada
con bibliotecas gráficas de Swing? ¿Cómo facilitaría esto si la empresa decide migrar la interfaz de
escritorio a una aplicación web en el futuro?

### Ventajas de un Modelo independiente de bibliotecas gráficas (como Swing)

- **Portabilidad:** la lógica del dominio y los datos son completamente independientes del entorno de
  presentación, permitiendo su ejecución en consola, servidor o entornos móviles.
- **Facilidad de pruebas unitarias:** permite probar exhaustivamente la lógica de negocio mediante pruebas
  automatizadas (como JUnit) de forma rápida y sin necesidad de renderizar componentes gráficos.
- **Mantenimiento limpio:** modificar la apariencia o los componentes de la interfaz no afectará las
  reglas del negocio ni la integridad de los datos.

### Facilidad ante una migración a una aplicación web

- Al no tener dependencias de bibliotecas de escritorio como Swing, el Modelo se puede conservar intacto
  en el backend de la nueva arquitectura web.
- La empresa solo requeriría reemplazar la capa visual (`PersonaView` en Swing) por una interfaz web
  (HTML/CSS/JavaScript o frameworks como React/Angular) y exponer los métodos del Modelo a través de un
  Controlador o servicio API (REST/GraphQL), ahorrando desarrollo, tiempo y reduciendo el riesgo de bugs
  en las reglas de negocio.
