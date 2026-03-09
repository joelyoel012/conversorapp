# ConversorApp

Aplicacion de consola en Java para convertir monedas usando la API de ExchangeRate.

## Funcionalidades

- USD <-> ARS
- USD <-> BRL
- USD <-> COP
- Menu por consola con 6 opciones de conversion y salida

## Estructura del proyecto

- `src/Principal.java`: menu principal y flujo de entrada por consola.
- `src/Money.java`: logica de conversion y llamada HTTP a ExchangeRate API.
- `src/ExchangeRateApi.java`: record para mapear la respuesta JSON.

## Requisitos

- Java 11 o superior (se recomienda Java 17+)
- Libreria Gson (`gson-2.13.2.jar`)
- Conexion a internet
- API key de ExchangeRate API

## Configuracion rapida

Actualmente la API key esta en `src/Money.java` (`ApiKey`).
Si vas a publicar o compartir el proyecto, se recomienda moverla a una variable de entorno para no exponer credenciales.

## Ejecucion en IntelliJ IDEA

1. Abre la carpeta del proyecto en IntelliJ.
2. Verifica que `gson-2.13.2.jar` este agregado como dependencia del modulo.
3. Ejecuta `Principal.main()`.

## Ejecucion por terminal (Windows PowerShell)

> Ajusta la ruta del JAR de Gson segun tu equipo.

```powershell
javac -cp ".;$env:USERPROFILE\Downloads\gson-2.13.2.jar" src\*.java
java -cp ".;src;$env:USERPROFILE\Downloads\gson-2.13.2.jar" Principal
```

## Ejemplo de uso

1. Elige una opcion del menu (por ejemplo, `1` para `USD -> ARS`).
2. Ingresa el monto a convertir.
3. El programa muestra el valor convertido segun la tasa actual.

## Mejoras sugeridas

- Validar opciones fuera de rango y entradas no numericas.
- Permitir convertir varias veces sin reiniciar el programa.
- Mover la API key a variable de entorno.
- Agregar un sistema de build (`Maven` o `Gradle`) para manejar dependencias.

