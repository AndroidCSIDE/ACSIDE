<h1 align="center" style="font-size: 20px;">
  AndroidCS IDE
</h1>
<p align="center">
<img src="https://img.shields.io/github/v/release/AndroidCSIDE/ACSIDE?include_prereleases&amp;label=latest%20release" alt="Latest release">
</p>

<p align="center">
  <a href="https://github.com/AndroidCSIDE/ACSIDE/issues/new?labels=bug&template=BUG.yml&title=%5BBug%5D%3A+">
    <img src="https://img.shields.io/badge/Report%20Bug-red?style=for-the-badge&logo=github" alt="Report a bug">
  </a>
  <a href="https://github.com/AndroidCSIDE/ACSIDE/issues/new?labels=feature&template=FEATURE.yml&title=%5BFeature%5D%3A+">
    <img src="https://img.shields.io/badge/Request%20Feature-brightgreen?style=for-the-badge&logo=github" alt="Request a feature">
  </a>
  <a href="https://t.me/androidcodestudio">
    <img src="https://img.shields.io/badge/Telegram-Join%20Us-1DA1F2?style=for-the-badge&logo=telegram" alt="Join on Telegram">
  </a>
</p>

<p align="center">
AndroidCS IDE is a full-featured development environment designed for creating and managing all types of Android projects directly on-device or on lightweight systems. It provides a powerful yet efficient workflow for developers who want a complete Android development experience without the heavy requirements of traditional IDEs.
</p>

***

> [!WARNING]
> **Use official downloads only**
> Install AndroidCS IDE from:
> - **GitHub Release** - https://github.com/AndroidCSIDE/ACSIDE/releases  
> - **ApkPure** - https://apkpure.com/p/com.nullij.androidcodestudio  
> Avoid downloading APKs from unknown or unofficial websites, as they may be modified or unsafe.
---

## Supported Features & Roadmap

* [x] Android Flutter project support
* [x] Gradle project support
* [x] JDK 17, 21 *(JDK 8, 11, 22, and others are untested)*
* [x] Terminal with Ubuntu environment & Termux-X11 support
* [x] SDK Manager for installing build tools, Flutter SDK, and more
* [x] Language servers:
  * [x] Java Language Server — from [georgewfraser](https://github.com/georgewfraser)
  * [x] Kotlin Language Server — from [JetBrains / Kotlin LSP](https://github.com/Kotlin/kotlin-lsp)
  * [x] Python Language Server *(installable via plugins)*
  * [x] Bash Language Server *(installable via plugins)*
  * [x] Dart Language Server *(available after installing the Flutter SDK)*
  * [ ] XML Language Server *(coming soon)*
* **Supported LSP capabilities:**
    * [x] Go to Definition
    * [x] Code Formatting
    * [x] Kotlin Diagnostics
    * [x] Jetpack Compose support
* [x] Jetpack Compose preview system
* [x] Flutter app instant preview system
* [x] AI Agent with Model Context Protocol (MCP) support
* [x] Plugin system
* [x] TextMate syntax highlighting

More features are planned and will be added in the future — stay tuned!

---

## Limitations

AndroidCS IDE may fail to build older projects that use AGP 7.x.x or below. It is strongly recommended to upgrade your project to the latest Android Gradle Plugin (AGP) version for the best compatibility.

---

## 📌 Status

This project is under active development. Feedback and suggestions are always welcome.

### About the Source Code

The IDE is currently closed source to allow for faster iteration and development. Once the project reaches a stable state, parts of the source code will be open-sourced.
