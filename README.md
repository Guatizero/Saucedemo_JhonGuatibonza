# 🛒 SauceDemo - Automatización de Pruebas con Serenity BDD

![Java](https://img.shields.io/badge/Java-17+-orange)
![Serenity BDD](https://img.shields.io/badge/Serenity%20BDD-4.2.1-blue)
![Gradle](https://img.shields.io/badge/Gradle-Wrapper-green)
![Cucumber](https://img.shields.io/badge/Cucumber-7.16.1-brightgreen)

Este proyecto implementa pruebas automatizadas end-to-end para la plataforma [SauceDemo](https://www.saucedemo.com/) utilizando **Serenity BDD** con **Screenplay Pattern**, **Cucumber** y **Gradle**. 

## 📋 Tabla de Contenidos

- [🚀 Características](#-características)
- [🏗️ Arquitectura del Proyecto](#️-arquitectura-del-proyecto)
- [📁 Estructura de Directorios](#-estructura-de-directorios)
- [⚙️ Configuración e Instalación](#️-configuración-e-instalación)
- [🎯 Ejecución de Pruebas](#-ejecución-de-pruebas)
- [📊 Reportes](#-reportes)
- [🎭 Screenplay Pattern](#-screenplay-pattern)
- [🧪 Escenarios de Prueba](#-escenarios-de-prueba)
- [📸 Capturas de Pantalla](#-capturas-de-pantalla)
- [🔧 Configuración Avanzada](#-configuración-avanzada)
- [🤝 Contribuir](#-contribuir)

## 🚀 Características

- ✅ **Screenplay Pattern** para pruebas más legibles y mantenibles
- ✅ **Cucumber BDD** con escenarios en español
- ✅ **Serenity BDD** para reportes detallados con screenshots
- ✅ **Gradle** como herramienta de build
- ✅ **Java 17+** como lenguaje base
- ✅ **WebDriver** integrado para automatización web
- ✅ **Limpieza automática** de carpeta target en cada ejecución
- ✅ **Page Object Model** mejorado con Targets

## 🏗️ Arquitectura del Proyecto

Este proyecto sigue el patrón **Screenplay** de Serenity BDD, que organiza el código en:

```
Actor (Usuario) → realiza → Tasks (Tareas) → usando → Interactions (Interacciones) → sobre → UserInterfaces (Elementos UI)
                ↓
           puede hacer → Questions (Preguntas) → para validar estados
```

## 📁 Estructura de Directorios

```
saucedemo/
├── 📄 build.gradle                 # Configuración de dependencias y plugins
├── 📄 gradlew / gradlew.bat       # Wrapper de Gradle
├── 📄 serenity.properties         # Configuración de Serenity
├── 📄 settings.gradle             # Configuración del proyecto
├── 📁 src/test/java/
│   ├── 📁 interactions/           # Interacciones Screenplay personalizadas
│   ├── 📁 models/                 # Modelos de datos (DTOs)
│   ├── 📁 questions/              # Preguntas para validaciones
│   ├── 📁 runners/                # Runners de Cucumber
│   ├── 📁 stepdefinitions/        # Definiciones de pasos Gherkin
│   ├── 📁 tasks/                  # Tareas de negocio (Actions)
│   ├── 📁 userinterfaces/         # Page Objects con Targets
│   └── 📁 utils/                  # Utilidades y helpers
├── 📁 src/test/resources/
│   ├── 📁 features/               # Archivos .feature de Cucumber
│   └── 📄 serenity.conf          # Configuración adicional
└── 📁 target/site/serenity/       # Reportes generados (auto-generado)
```

## ⚙️ Configuración e Instalación

### Prerrequisitos

- **Java 17+** instalado y configurado
- **Git** para clonar el repositorio
- **Chrome** o **Firefox** instalado (para WebDriver)

### Instalación

1. **Clonar el repositorio:**
   ```bash
   git clone <url-del-repositorio>
   cd saucedemo
   ```

2. **Verificar Java:**
   ```bash
   java -version
   # Debe mostrar Java 17 o superior
   ```

3. **Dar permisos al wrapper de Gradle (en Linux/Mac):**
   ```bash
   chmod +x gradlew
   ```

## 🎯 Ejecución de Pruebas

### Comandos Básicos

```bash
# Ejecutar todas las pruebas (limpia target automáticamente)
gradlew clean test

# Solo ejecutar pruebas sin limpiar
gradlew test

# Generar reportes
gradlew test aggregate

# Ejecutar con un navegador específico
gradlew test -Dwebdriver.driver=chrome
gradlew test -Dwebdriver.driver=firefox
```

### Ejecución por Tags (si se implementan)

```bash
# Ejecutar solo pruebas de compra
gradlew test -Dcucumber.filter.tags="@purchase"

# Ejecutar pruebas de smoke
gradlew test -Dcucumber.filter.tags="@smoke"
```

## 📊 Reportes

Después de ejecutar las pruebas, los reportes se generan automáticamente:

- **📍 Ubicación:** `target/site/serenity/index.html`
- **📱 Responsive:** Los reportes son responsivos y se ven bien en móviles
- **📸 Screenshots:** Incluye capturas automáticas en cada paso
- **📈 Métricas:** Estadísticas detalladas de ejecución

### Abrir Reportes

```bash
# En Windows
start target/site/serenity/index.html

# En Linux/Mac
open target/site/serenity/index.html
```

## 🎭 Screenplay Pattern

### Componentes Principales

#### 🎭 **Actors (Actores)**
```java
// Representa al usuario que interactúa con la aplicación
Actor usuario = Actor.named("Usuario")
    .can(BrowseTheWeb.with(driver));
```

#### 🎯 **Tasks (Tareas)**
```java
// Acciones de alto nivel que realiza el usuario
public class AddProduct implements Task {
    public static AddProduct toCart(String productName) {
        return new AddProduct(productName);
    }
    
    @Override
    public <T extends Actor> void performAs(T actor) {
        // Implementación de la tarea
    }
}
```

#### 🖱️ **Interactions (Interacciones)**
```java
// Acciones atómicas sobre elementos
Click.on(ItemPage.ADD_ITEM_BUTTON)
Enter.theValue(username).into(LoginPage.USERNAME_FIELD)
```

#### 🏠 **UserInterfaces (Interfaces de Usuario)**
```java
public class ItemPage {
    public static Target ADD_ITEM_BUTTON = Target.the("add item button")
        .locatedBy("//*[@id='add-to-cart']");
    
    public static Target BACK_TO_PRODUCTS_BUTTON = Target.the("back to products button")
        .locatedBy("//*[@id='back-to-products']");
}
```

#### ❓ **Questions (Preguntas)**
```java
// Para hacer validaciones
public class TheMessage implements Question<String> {
    public static Question<String> displayed() {
        return new TheMessage();
    }
    
    @Override
    public String answeredBy(Actor actor) {
        return Text.of(ConfirmationPage.MESSAGE).viewedBy(actor).asString();
    }
}
```

## 🧪 Escenarios de Prueba

### Escenario Principal: Compra Exitosa

```gherkin
# language: es
Característica: Flujo de compra exitosa en SauceDemo
  Como usuario de SauceDemo
  Quiero poder realizar una compra exitosa
  Para obtener los productos que deseo

  Escenario: Compra exitosa de dos productos
    Dado Que el usuario ingresa a la página de SauceDemo
    Y Se autentica con el usuario "standard_user" y la contraseña "secret_sauce"
    Cuando Agrega dos productos al carrito "Sauce Labs Bike Light" e "Sauce Labs Backpack"
    Y Continua con la compra y los datos "Jon", "Pérez", "11000456"
    Entonces se visualiza el mensaje de confirmación "Thank you for your order!"
```

### Productos Disponibles para Pruebas

- 🚴 **Sauce Labs Bike Light**
- 🎒 **Sauce Labs Backpack**
- 👕 **Sauce Labs Bolt T-Shirt**
- 🧥 **Sauce Labs Fleece Jacket**
- 👕 **Sauce Labs Onesie**
- 👕 **Test.allTheThings() T-Shirt (Red)**

## 📸 Capturas de Pantalla

Serenity BDD toma capturas automáticamente:

- ✅ **En cada paso** del escenario
- ✅ **En errores** para debugging
- ✅ **En assertions** para validaciones
- ✅ **Disponibles en el reporte** HTML

### Forzar Capturas Personalizadas

```java
// En una Task o Step Definition
TakeScreenshot.as("nombre_de_la_captura").performAs(actor);
```

## 🔧 Configuración Avanzada

### serenity.properties

```properties
# Configuración del WebDriver
webdriver.driver=chrome
webdriver.autodownload=true
chrome.switches=--disable-web-security,--disable-features=VizDisplayCompositor

# Timeouts
webdriver.timeouts.implicitlywait=5000
webdriver.wait.for.timeout=10000

# Reportes
serenity.report.encoding=UTF-8
serenity.logging=VERBOSE
```

### serenity.conf

```hocon
environments {
  default {
    webdriver.base.url = "https://www.saucedemo.com"
  }
  
  chrome {
    webdriver.driver = chrome
  }
  
  firefox {
    webdriver.driver = firefox
  }
}
```

### Variables de Entorno

```bash
# Establecer navegador
export WEBDRIVER_DRIVER=chrome

# Establecer URL base
export WEBDRIVER_BASE_URL=https://www.saucedemo.com

# Modo headless
export CHROME_OPTIONS="--headless"
```

## 🚨 Solución de Problemas Comunes

### Error: "Actor cannot browse the web"
```java
// ✅ Solución: Asegurar que el actor tenga la habilidad
usuario.can(BrowseTheWeb.with(webDriver));
```

### Error: "The of() method is not supported for By-type Targets"
```java
// ❌ Incorrecto
Target.the("elemento").located(By.id("id")).of(producto)

// ✅ Correcto
Target.the("elemento").locatedBy("#id")
```

### Error: Carpeta target no se limpia
```java
// ✅ Ya configurado en build.gradle
clean.doLast {
    delete 'target'
}
```

## 🤝 Contribuir

1. **Fork** del proyecto
2. **Crear** una rama feature (`git checkout -b feature/nueva-funcionalidad`)
3. **Commit** los cambios (`git commit -am 'Agregar nueva funcionalidad'`)
4. **Push** a la rama (`git push origin feature/nueva-funcionalidad`)
5. **Crear** un Pull Request

### Estándares de Código

- ✅ **Nombres descriptivos** para clases y métodos
- ✅ **Comentarios** en inglés para código, español para documentación
- ✅ **Page Objects** bien organizados
- ✅ **Tasks reutilizables**
- ✅ **Un solo propósito** por Task/Question

## 📞 Soporte

Para dudas, problemas o sugerencias:

- 📧 **Email:** [email del equipo]
- 🐛 **Issues:** Crear un issue en GitHub
- 📚 **Documentación:** [Serenity BDD Docs](https://serenity-bdd.info/)

---

## 📄 Licencia

Este proyecto está bajo la licencia MIT. Ver archivo `LICENSE` para más detalles.

---

**¡Felices pruebas! 🚀**
