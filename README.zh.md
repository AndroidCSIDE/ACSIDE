<p align="center">
<picture>
  <source media="(prefers-color-scheme: light)" srcset="assets/art/acsart-light.png">
  <source media="(prefers-color-scheme: dark)" srcset="assets/art/acsart-dark.png">
  <img src="assets/art/acsart-dark.png" alt="ACSIDE logo" width="1920">
</picture>
</p>

<h1 align="center">ACSIDE</h1>

<p align="center">
<img src="https://img.shields.io/github/v/release/AndroidCSIDE/ACSIDE?include_prereleases&amp;label=latest%20release" alt="最新版本">
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
    <img src="https://img.shields.io/badge/Report%20Bug-red?style=for-the-badge&logo=github" alt="报告 Bug">
  </a>
  <a href="https://github.com/AndroidCSIDE/ACSIDE/issues/new?labels=feature&template=FEATURE.yml&title=%5BFeature%5D%3A+">
    <img src="https://img.shields.io/badge/Request%20Feature-brightgreen?style=for-the-badge&logo=github" alt="请求新功能">
  </a>
  <a href="https://t.me/androidcodestudio">
    <img src="https://img.shields.io/badge/Telegram-Join%20Us-1DA1F2?style=for-the-badge&logo=telegram" alt="加入 Telegram">
  </a>
</p>

<p align="center">
AndroidCS IDE 是一款功能完备的开发环境，专为直接在设备上或轻量级系统上创建和管理各类 Android 项目而设计。它为希望获得完整 Android 开发体验、又不想承受传统 IDE 高配置要求的开发者，提供了强大而高效的工作流程。
</p>

<div align="center">
<table>
  <tr>
    <td><b>适用人群</b></td>
    <td>希望在 Android 上使用完整 IDE 的开发者</td>
  </tr>
  <tr>
    <td><b>可以构建什么</b></td>
    <td>Android 应用、库、Flutter 应用、原生模块</td>
  </tr>
</table>
</div>

---

> [!WARNING]
> **请仅使用官方下载渠道**
>
> 请从以下渠道安装 AndroidCS IDE：
> - **GitHub Release** - https://github.com/AndroidCSIDE/ACSIDE/releases
>
> 请避免从未知或非官方网站下载 APK，它们可能已被篡改或不安全。

---

## 支持的功能与路线图

### 项目与构建
* [x] 支持 Android Flutter 项目
* [x] 支持 Gradle 项目
* [x] JDK 17、21
* [x] SDK Manager，可安装构建工具、NDK、CMake、Flutter SDK 等
* [x] 依赖更新器（Dependency Updater），直接在构建文件中提示过时的依赖

### 编辑器与语言支持
* [x] TextMate 语法高亮
* [x] 语言服务器（可分别启用或禁用）：
  * [x] Java Language Server - 来自 [georgewfraser](https://github.com/georgewfraser)
  * [x] Kotlin Language Server - 来自 [nullij](https://github.com/nullij)
  * [x] XML Language Server
  * [x] Dart Language Server *（安装 Flutter SDK 后可用）*
  * [x] Python Language Server *（可通过插件安装）*
  * [x] Bash Language Server *（可通过插件安装）*
  * [x] Clang Language Server *（可通过插件安装）*
  * [x] Web 语言服务器合集 *（可通过插件安装）*
* [x] 支持的 LSP 功能：
  * [x] 代码补全
  * [x] 诊断
  * [x] 悬停提示（Hover）
  * [x] 签名帮助
  * [x] 跳转到定义
  * [x] 快速修复（Code Actions）
  * [x] 代码格式化
  * [x] 内嵌提示（Inlay Hints）
  * [x] 支持 Jetpack Compose
* [x] 每个服务器独立的功能开关，可分别启用或禁用各语言服务器的单项功能
* [x] 可为 Kotlin 和 Java 语言服务器自定义 JVM 选项

### 预览
* [x] Jetpack Compose 真实预览系统
* [x] XML 布局真实预览系统
* [x] Flutter 应用即时预览系统

### Git
* [x] 引导式 Git 工作流，分步完成仓库初始化
* [x] 安全的凭据管理器，支持多个远程仓库
* [x] 合并冲突解决，支持接受本地更改、接受传入更改和中止操作
* [x] 重新设计的源代码管理抽屉，支持内联差异查看

### AI 与扩展性
* [x] 支持模型上下文协议（Model Context Protocol，MCP）的 AI 代理
* [x] 编辑审批模式，可审查、接受或拒绝代理提出的更改
* [x] 插件系统

### 终端与调试
* [x] 基于 Termux 软件包的终端 *（仍可通过 PRoot-Distro 安装 PRoot）*
* [x] ADB 调试，支持无线配对、USB-OTG，并可通过 ADB 或 Shizuku 查看 logcat
* [x] Logger 插件，在调试构建期间注入项目，实现更快、更可靠的日志捕获

### 个性化
* [x] Windows 11 Fluent 2 风格
* [x] Google Material 风格
* [x] 支持英语、阿拉伯语、俄语、波斯语、希伯来语、土耳其语和简体中文等多种语言……

更多功能正在计划中，敬请期待！

---

## 限制

- AndroidCS IDE（ACSIDE）可能无法构建使用 AGP 8.x.x 或更低版本的旧项目。强烈建议将项目升级到最新的 Android Gradle Plugin（AGP）版本，以获得最佳兼容性。

---

## 📌 状态

本项目正在积极开发中，欢迎随时提出反馈和建议。

### 关于源代码

IDE 目前为闭源，以便更快地迭代和开发。待项目进入稳定状态后，部分源代码将会开源。

### 透明度与网络隐私

ACSIDE 目前是闭源的，所以你不必仅凭我的一面之词来相信它在网络上做了什么。

- **无遥测。** 没有分析，没有使用情况追踪，也没有静默的崩溃上报。如果 IDE 崩溃，你会看到一个崩溃界面，上面有“发送报告”按钮，点击后会在浏览器中打开预填好的 GitHub issue。除非你自己提交，否则不会发送任何内容。
- **AI 代理：** 你需要自行提供 API 密钥。请求直接从你的设备发送到你所选的模型服务器，端到端传输，绝不会经过我的服务器。
- **更新和插件** 来自公开的 GitHub 仓库：[`updater.json`](https://github.com/AndroidCSIDE/ACSIDE/blob/main/others/updater/updater.json) 和 [androidcs-plugins](https://github.com/AndroidCSIDE/androidcs-plugins)。

不必信我，自己验证：运行 [Reqable](https://reqable.com/) 或任何 Android 网络监控工具，查看 IDE 连接了哪些主机。你应该只会看到 GitHub、软件包和 SDK 仓库，以及你配置的 AI 服务提供商。如果你发现其他内容，请提交 issue。
