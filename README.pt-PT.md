<p align="center">
<picture>
  <source media="(prefers-color-scheme: light)" srcset="assets/art/acsart-light.png">
  <source media="(prefers-color-scheme: dark)" srcset="assets/art/acsart-dark.png">
  <img src="assets/art/acsart-dark.png" alt="ACSIDE logo" width="1920">
</picture>
</p>

<h1 align="center">ACSIDE</h1>

<p align="center">
<img src="https://img.shields.io/github/v/release/AndroidCSIDE/ACSIDE?include_prereleases&amp;label=latest%20release" alt="Última versão">
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
    <img src="https://img.shields.io/badge/Report%20Bug-red?style=for-the-badge&logo=github" alt="Reportar um erro">
  </a>
  <a href="https://github.com/AndroidCSIDE/ACSIDE/issues/new?labels=feature&template=FEATURE.yml&title=%5BFeature%5D%3A+">
    <img src="https://img.shields.io/badge/Request%20Feature-brightgreen?style=for-the-badge&logo=github" alt="Pedir uma funcionalidade">
  </a>
  <a href="https://t.me/androidcodestudio">
    <img src="https://img.shields.io/badge/Telegram-Join%20Us-1DA1F2?style=for-the-badge&logo=telegram" alt="Juntar-se ao Telegram">
  </a>
</p>

<p align="center">
O AndroidCS IDE é um ambiente de desenvolvimento completo, concebido para criar e gerir todos os tipos de projetos Android diretamente no dispositivo ou em sistemas ligeiros. Oferece um fluxo de trabalho poderoso e eficiente para programadores que querem uma experiência completa de desenvolvimento Android sem os requisitos pesados dos IDE tradicionais.
</p>

<div align="center">
<table>
  <tr>
    <td><b>Para quem é</b></td>
    <td>Programadores que querem um IDE completo no Android</td>
  </tr>
  <tr>
    <td><b>O que pode criar</b></td>
    <td>Aplicações Android, bibliotecas, aplicações Flutter, módulos nativos</td>
  </tr>
</table>
</div>

---

> [!WARNING]
> **Utilize apenas as transferências oficiais**
>
> Instale o AndroidCS IDE a partir de:
> - **GitHub Release** - https://github.com/AndroidCSIDE/ACSIDE/releases
>
> Evite descarregar APK de sites desconhecidos ou não oficiais, pois podem ter sido modificados ou ser inseguros.

---

## Funcionalidades suportadas e roteiro

### Projetos e compilação
* [x] Suporte para projetos Android Flutter
* [x] Suporte para projetos Gradle
* [x] JDK 17, 21
* [x] SDK Manager para instalar ferramentas de compilação, NDK, CMake, Flutter SDK e muito mais
* [x] Dependency Updater com avisos de dependências desatualizadas diretamente nos seus ficheiros de compilação

### Editor e suporte de linguagens
* [x] Realce de sintaxe TextMate
* [x] Servidores de linguagem (cada um pode ser ativado ou desativado individualmente):
  * [x] Java Language Server - de [georgewfraser](https://github.com/georgewfraser)
  * [x] Kotlin Language Server - de [nullij](https://github.com/nullij)
  * [x] XML Language Server
  * [x] Dart Language Server *(disponível após instalar o Flutter SDK)*
  * [x] Python Language Server *(instalável através de plugins)*
  * [x] Bash Language Server *(instalável através de plugins)*
  * [x] Clang Language Server *(instalável através de plugins)*
  * [x] Pacote de servidores de linguagem web *(instalável através de plugins)*
* [x] Capacidades LSP suportadas:
  * [x] Conclusão de código
  * [x] Diagnósticos
  * [x] Hover
  * [x] Ajuda de assinatura (Signature Help)
  * [x] Ir para a definição
  * [x] Correções rápidas (Code Actions)
  * [x] Formatação de código
  * [x] Sugestões em linha (Inlay Hints)
  * [x] Suporte para Jetpack Compose
* [x] Interruptores de funcionalidades por servidor para ativar ou desativar capacidades individuais de cada servidor de linguagem
* [x] Configuração de opções JVM personalizadas para os servidores de linguagem Kotlin e Java

### Pré-visualizações
* [x] Sistema de pré-visualização real do Jetpack Compose
* [x] Sistema de pré-visualização real de layouts XML
* [x] Sistema de pré-visualização instantânea de aplicações Flutter

### Git
* [x] Fluxo de trabalho Git guiado, com integração do repositório passo a passo
* [x] Gestor seguro de credenciais com suporte para vários remotos
* [x] Resolução de conflitos de merge com controlos para aceitar as alterações locais, aceitar as alterações recebidas ou cancelar
* [x] Painel de Source Control redesenhado com visualização de diff em linha

### IA e extensibilidade
* [x] Agente de IA com suporte para Model Context Protocol (MCP)
* [x] Modo de aprovação de edições para rever, aceitar ou rejeitar as alterações propostas pelo agente
* [x] Sistema de plugins

### Terminal e depuração
* [x] Terminal baseado em pacotes Termux *(o PRoot ainda pode ser instalado através do PRoot-Distro)*
* [x] Depuração via ADB com emparelhamento sem fios, suporte para USB-OTG e logcat via ADB ou Shizuku
* [x] Plugin Logger injetado nos projetos durante as compilações de depuração para uma captura de registos mais rápida e fiável

### Personalização
* [x] Aspeto Windows 11 Fluent 2
* [x] Aspeto Google Material
* [x] Disponível em inglês, árabe, russo, persa, hebraico, turco e chinês simplificado, entre outros...

Estão planeadas mais funcionalidades que serão adicionadas no futuro. Fique atento!

---

## Limitações

- O AndroidCS IDE (ACSIDE) pode falhar ao compilar projetos antigos que usem AGP 8.x.x ou inferior. Recomenda-se vivamente que atualize o seu projeto para a versão mais recente do Android Gradle Plugin (AGP) para obter a melhor compatibilidade.

---

## 📌 Estado

Este projeto está em desenvolvimento ativo. Comentários e sugestões são sempre bem-vindos.

### Sobre o código-fonte

O IDE tem atualmente código fechado para permitir uma iteração e um desenvolvimento mais rápidos. Quando o projeto atingir um estado estável, algumas partes do código-fonte serão abertas.

### Transparência e privacidade de rede

O ACSIDE tem código fechado por agora, por isso não tem de acreditar na minha palavra sobre o que ele faz na rede.

- **Sem telemetria.** Sem análises, sem monitorização de utilização e sem relatórios de falhas silenciosos. Se o IDE falhar, verá um ecrã de falha com um botão «Enviar relatório» que abre o navegador numa issue do GitHub pré-preenchida. Nada é enviado a menos que o envie.
- **Agente de IA:** utiliza as suas próprias chaves de API. Os pedidos seguem diretamente do seu dispositivo para o servidor do modelo que escolheu, de ponta a ponta, e nunca passam pelos meus servidores.
- **As atualizações e os plugins** vêm de repositórios abertos no GitHub: [`updater.json`](https://github.com/AndroidCSIDE/ACSIDE/blob/main/others/updater/updater.json) e [androidcs-plugins](https://github.com/AndroidCSIDE/androidcs-plugins).

Não confie em mim, verifique: execute o [Reqable](https://reqable.com/) ou qualquer monitor de rede para Android e veja com que hosts o IDE comunica. Só deverá ver o GitHub, repositórios de pacotes e SDK e o fornecedor de IA que configurou. Se vir mais alguma coisa, abra uma issue.
