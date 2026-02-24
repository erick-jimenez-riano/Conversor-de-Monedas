💱 Conversor de Monedas – Java 17 + API REST

Aplicación de consola desarrollada en Java 17 que consume la API pública de ExchangeRate para realizar conversiones de monedas en tiempo real.

Proyecto desarrollado aplicando principios de arquitectura limpia (Clean Architecture) y separación por capas.

🚀 Características

✅ Conversión de monedas en tiempo real

✅ Consulta de monedas disponibles desde una base específica

✅ Consumo de API externa usando HttpClient

✅ Parseo de JSON con Gson

✅ Uso seguro de API Key mediante variables de entorno

✅ Arquitectura basada en puertos y adaptadores (Hexagonal)

🧱 Arquitectura del Proyecto

El proyecto está organizado siguiendo una estructura desacoplada:

com.erick.currency
│
├── domain
│   └── port
│       └── ExchangeRatePort
│
├── infrastructure
│   └── api
│       └── ExchangeRateApiClient
│
└── ui
    └── Main
🔹 Domain

Contiene las interfaces (puertos) que definen el contrato de comunicación.

🔹 Infrastructure

Implementa la conexión con la API externa.

🔹 UI

Interfaz de consola que interactúa con el usuario.

🛠 Tecnologías Utilizadas

☕ Java 17

📦 Maven

🌐 Java HttpClient

🔁 ExchangeRate API

🧩 Gson 2.10.1

📦 Dependencias (Maven)
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.10.1</version>
</dependency>
🔑 Configuración de la API Key

La aplicación requiere una API Key de:

👉 https://www.exchangerate-api.com/

1️⃣ Crear variable de entorno

En PowerShell:

setx EXCHANGE_API_KEY "TU_API_KEY_AQUI"

Luego reiniciar la terminal o IDE.

2️⃣ Verificar que esté configurada
echo $env:EXCHANGE_API_KEY
▶️ Ejecución del Proyecto

Desde la raíz del proyecto:

mvn clean compile
mvn exec:java

O ejecutar directamente desde tu IDE.

📌 Ejemplo de Uso
Moneda origen: USD
Moneda destino: COP
Cantidad: 100

Resultado: 100 USD = 390000 COP
📚 Cómo consultar monedas disponibles

El cliente implementa el método:

Set<String> getAvailableCurrencies(String base)

Ejemplo:

Set<String> currencies = client.getAvailableCurrencies("USD");
currencies.forEach(System.out::println);
🎯 Objetivos del Proyecto

Practicar consumo de APIs REST en Java

Implementar arquitectura limpia

Manejo de variables de entorno

Parseo dinámico de JSON

Construcción de proyecto profesional con Maven

📈 Posibles Mejoras Futuras

 Agregar cache local de tasas

 Crear versión con interfaz gráfica (JavaFX)

 Convertir en API REST con Spring Boot

 Agregar pruebas unitarias con JUnit

 Dockerizar la aplicación

👨‍💻 Autor

Erick Jiménez Riaño
Ingeniero Civil & Ingeniero de Sistemas
Bucaramanga, Colombia

📧 jimenez.riano.erick@gmail.com
