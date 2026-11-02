<p align="center">
<picture>
  <source media="(prefers-color-scheme: light)" srcset="assets/art/acsart-light.png">
  <source media="(prefers-color-scheme: dark)" srcset="assets/art/acsart-dark.png">
  <img src="assets/art/acsart-dark.png" alt="ACSIDE logo" width="1920">
</picture>
</p>

<h1 align="center">ACSIDE</h1>

<p align="center">
<img src="https://img.shields.io/github/v/release/AndroidCSIDE/ACSIDE?include_prereleases&amp;label=latest%20release" alt="Última versión">
</p>

<p align="center">
  <a href="README.md">English</a> •
  <a href="README.ar.md">العربية</a> •
  <a href="README.ru.md">Русский</a> •
  <a href="README.zh.md">简体中文</a> •
  <a href="README.tr.md">Türkçe</a> •
  <a href="README.es.md">Español</a> •
  <a href="README.he.md">עברית</a> •
  <a href="README.fa.md">فارسی</a> •
  <a href="README.pt-BR.md">Português (Brasil)</a> •
  <a href="README.pt-PT.md">Português (Portugal)</a>
</p>

<p align="center">
  <a href="https://github.com/AndroidCSIDE/ACSIDE/issues/new?labels=bug&template=BUG.yml&title=%5BBug%5D%3A+">
    <img src="https://img.shields.io/badge/Report%20Bug-red?style=for-the-badge&logo=github" alt="Informar de un error">
  </a>
  <a href="https://github.com/AndroidCSIDE/ACSIDE/issues/new?labels=feature&template=FEATURE.yml&title=%5BFeature%5D%3A+">
    <img src="https://img.shields.io/badge/Request%20Feature-brightgreen?style=for-the-badge&logo=github" alt="Solicitar una función">
  </a>
  <a href="https://t.me/androidcodestudio">
    <img src="https://img.shields.io/badge/Telegram-Join%20Us-1DA1F2?style=for-the-badge&logo=telegram" alt="Unirse en Telegram">
  </a>
</p>

<p align="center">
AndroidCS IDE es un entorno de desarrollo completo diseñado para crear y gestionar todo tipo de proyectos Android directamente en el dispositivo o en sistemas ligeros. Ofrece un flujo de trabajo potente y eficiente para los desarrolladores que quieren una experiencia completa de desarrollo Android sin los pesados requisitos de los IDE tradicionales.
</p>

<div align="center">
<table>
  <tr>
    <td><b>Para quién es</b></td>
    <td>Desarrolladores que quieren un IDE completo en Android</td>
  </tr>
  <tr>
    <td><b>Qué puedes crear</b></td>
    <td>Apps Android, bibliotecas, apps Flutter, módulos nativos</td>
  </tr>
</table>
</div>

---

> [!WARNING]
> **Usa solo las descargas oficiales**
>
> Instala AndroidCS IDE desde:
> - **GitHub Release** - https://github.com/AndroidCSIDE/ACSIDE/releases
>
> Evita descargar APK de sitios web desconocidos o no oficiales, ya que pueden estar modificados o ser inseguros.

---

## Funciones compatibles y hoja de ruta

### Proyectos y compilación
* [x] Compatibilidad con proyectos Android Flutter
* [x] Compatibilidad con proyectos Gradle
* [x] JDK 17, 21
* [x] SDK Manager para instalar herramientas de compilación, NDK, CMake, Flutter SDK y más
* [x] Dependency Updater con avisos de dependencias desactualizadas directamente en tus archivos de compilación

### Editor y compatibilidad con lenguajes
* [x] Resaltado de sintaxis TextMate
* [x] Servidores de lenguaje (cada uno se puede activar o desactivar por separado):
  * [x] Java Language Server - de [georgewfraser](https://github.com/georgewfraser)
  * [x] Kotlin Language Server - de [nullij](https://github.com/nullij)
  * [x] XML Language Server
  * [x] Dart Language Server *(disponible tras instalar el Flutter SDK)*
  * [x] Python Language Server *(instalable mediante plugins)*
  * [x] Bash Language Server *(instalable mediante plugins)*
  * [x] Clang Language Server *(instalable mediante plugins)*
  * [x] Paquete de servidores de lenguaje web *(instalable mediante plugins)*
* [x] Capacidades LSP compatibles:
  * [x] Autocompletado de código
  * [x] Diagnósticos
  * [x] Hover
  * [x] Ayuda de firma (Signature Help)
  * [x] Ir a la definición
  * [x] Correcciones rápidas (Code Actions)
  * [x] Formateo de código
  * [x] Sugerencias en línea (Inlay Hints)
  * [x] Compatibilidad con Jetpack Compose
* [x] Interruptores de funciones por servidor para activar o desactivar capacidades individuales de cada servidor de lenguaje
* [x] Configuración de opciones JVM personalizadas para los servidores de lenguaje de Kotlin y Java

### Vistas previas
* [x] Sistema de vista previa real de Jetpack Compose
* [x] Sistema de vista previa real de diseños XML
* [x] Sistema de vista previa instantánea de apps Flutter

### Git
* [x] Flujo de trabajo de Git guiado, con incorporación del repositorio paso a paso
* [x] Gestor seguro de credenciales con soporte para varios remotos
* [x] Resolución de conflictos de fusión con controles para aceptar los cambios propios, aceptar los ajenos o cancelar
* [x] Panel de Source Control rediseñado con visualización de diferencias en línea

### IA y extensibilidad
* [x] Agente de IA con compatibilidad con Model Context Protocol (MCP)
* [x] Modo de aprobación de ediciones para revisar, aceptar o rechazar los cambios propuestos por el agente
* [x] Sistema de plugins

### Terminal y depuración
* [x] Terminal basada en Termux Packages *(PRoot se puede seguir instalando mediante PRoot-Distro)*
* [x] Depuración con ADB con emparejamiento inalámbrico, compatibilidad con USB-OTG y logcat mediante ADB o Shizuku
* [x] Plugin Logger que se inyecta en los proyectos durante las compilaciones de depuración para capturar los registros de forma más rápida y fiable

### Personalización
* [x] Aspecto Windows 11 Fluent 2
* [x] Aspecto Google Material
* [x] Disponible en inglés, árabe, ruso, persa, hebreo, turco y chino simplificado, y más...

Se planean más funciones que se añadirán en el futuro. ¡Estate atento!

---

## Limitaciones

- AndroidCS IDE (ACSIDE) puede fallar al compilar proyectos antiguos que usen AGP 8.x.x o inferior. Se recomienda encarecidamente actualizar tu proyecto a la última versión del Android Gradle Plugin (AGP) para lograr la mejor compatibilidad.

---

## 📌 Estado

Este proyecto está en desarrollo activo. Los comentarios y sugerencias siempre son bienvenidos.

### Sobre el código fuente

El IDE es actualmente de código cerrado para permitir una iteración y un desarrollo más rápidos. Cuando el proyecto alcance un estado estable, se publicarán como código abierto algunas partes del código fuente.

### Transparencia y privacidad de red

ACSIDE es de código cerrado por ahora, así que no deberías tener que fiarte de mi palabra sobre lo que hace en la red.

- **Sin telemetría.** Sin analíticas, sin seguimiento de uso y sin informes de fallos silenciosos. Si el IDE se cierra inesperadamente, verás una pantalla de error con un botón «Enviar informe» que abre tu navegador con un issue de GitHub rellenado previamente. No se envía nada a menos que lo envíes tú.
- **Agente de IA:** tú aportas tus propias claves de API. Las solicitudes van directamente desde tu dispositivo al servidor del modelo que elijas, de extremo a extremo, y nunca pasan por mis servidores.
- **Las actualizaciones y los plugins** provienen de repositorios abiertos de GitHub: [`updater.json`](https://github.com/AndroidCSIDE/ACSIDE/blob/main/others/updater/updater.json) y [androidcs-plugins](https://github.com/AndroidCSIDE/androidcs-plugins).

No confíes en mí, compruébalo: ejecuta [Reqable](https://reqable.com/) o cualquier monitor de red para Android y mira con qué hosts se conecta el IDE. Solo deberías ver GitHub, repositorios de paquetes y SDK, y el proveedor de IA que hayas configurado. Si ves algo más, abre un issue.
