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
    <img src="https://img.shields.io/badge/Report%20Bug-red?style=for-the-badge&logo=github" alt="Reportar um bug">
  </a>
  <a href="https://github.com/AndroidCSIDE/ACSIDE/issues/new?labels=feature&template=FEATURE.yml&title=%5BFeature%5D%3A+">
    <img src="https://img.shields.io/badge/Request%20Feature-brightgreen?style=for-the-badge&logo=github" alt="Solicitar um recurso">
  </a>
  <a href="https://t.me/androidcodestudio">
    <img src="https://img.shields.io/badge/Telegram-Join%20Us-1DA1F2?style=for-the-badge&logo=telegram" alt="Entrar no Telegram">
  </a>
</p>

<p align="center">
O AndroidCS IDE é um ambiente de desenvolvimento completo, projetado para criar e gerenciar todos os tipos de projetos Android diretamente no dispositivo ou em sistemas leves. Ele oferece um fluxo de trabalho poderoso e eficiente para desenvolvedores que querem uma experiência completa de desenvolvimento Android sem os requisitos pesados das IDEs tradicionais.
</p>

<div align="center">
<table>
  <tr>
    <td><b>Para quem é</b></td>
    <td>Desenvolvedores que querem uma IDE completa no Android</td>
  </tr>
  <tr>
    <td><b>O que você pode criar</b></td>
    <td>Apps Android, bibliotecas, apps Flutter, módulos nativos</td>
  </tr>
</table>
</div>

---

> [!WARNING]
> **Use apenas downloads oficiais**
>
> Instale o AndroidCS IDE a partir de:
> - **GitHub Release** - https://github.com/AndroidCSIDE/ACSIDE/releases
>
> Evite baixar APKs de sites desconhecidos ou não oficiais, pois eles podem ter sido modificados ou ser inseguros.

---

## Recursos suportados e roteiro

### Projetos e build
* [x] Suporte a projetos Android Flutter
* [x] Suporte a projetos Gradle
* [x] JDK 17, 21
* [x] SDK Manager para instalar ferramentas de build, NDK, CMake, Flutter SDK e mais
* [x] Dependency Updater com avisos de dependências desatualizadas direto nos seus arquivos de build

### Editor e suporte a linguagens
* [x] Realce de sintaxe TextMate
* [x] Servidores de linguagem (cada um pode ser ativado ou desativado individualmente):
  * [x] Java Language Server - de [georgewfraser](https://github.com/georgewfraser)
  * [x] Kotlin Language Server - de [nullij](https://github.com/nullij)
  * [x] XML Language Server
  * [x] Dart Language Server *(disponível após instalar o Flutter SDK)*
  * [x] Python Language Server *(instalável via plugins)*
  * [x] Bash Language Server *(instalável via plugins)*
  * [x] Clang Language Server *(instalável via plugins)*
  * [x] Pacote de servidores de linguagem web *(instalável via plugins)*
* [x] Recursos de LSP suportados:
  * [x] Autocompletar código
  * [x] Diagnósticos
  * [x] Hover
  * [x] Ajuda de assinatura (Signature Help)
  * [x] Ir para a definição
  * [x] Correções rápidas (Code Actions)
  * [x] Formatação de código
  * [x] Dicas embutidas (Inlay Hints)
  * [x] Suporte a Jetpack Compose
* [x] Alternância de recursos por servidor para ativar ou desativar capacidades individuais de cada servidor de linguagem
* [x] Configuração de opções JVM personalizadas para os servidores de linguagem Kotlin e Java

### Pré-visualizações
* [x] Sistema de pré-visualização real do Jetpack Compose
* [x] Sistema de pré-visualização real de layouts XML
* [x] Sistema de pré-visualização instantânea de apps Flutter

### Git
* [x] Fluxo de trabalho Git guiado, com integração do repositório passo a passo
* [x] Gerenciador seguro de credenciais com suporte a vários remotos
* [x] Resolução de conflitos de merge com controles para aceitar as alterações locais, aceitar as alterações recebidas ou cancelar
* [x] Gaveta de Source Control redesenhada com visualização de diff embutida

### IA e extensibilidade
* [x] Agente de IA com suporte a Model Context Protocol (MCP)
* [x] Modo de aprovação de edições para revisar, aceitar ou rejeitar as alterações propostas pelo agente
* [x] Sistema de plugins

### Terminal e depuração
* [x] Terminal baseado em pacotes do Termux *(o PRoot ainda pode ser instalado via PRoot-Distro)*
* [x] Depuração via ADB com pareamento sem fio, suporte a USB-OTG e logcat via ADB ou Shizuku
* [x] Plugin Logger injetado nos projetos durante builds de depuração para uma captura de logs mais rápida e confiável

### Personalização
* [x] Visual Windows 11 Fluent 2
* [x] Visual Google Material
* [x] Disponível em inglês, árabe, russo, persa, hebraico, turco e chinês simplificado, entre outros...

Mais recursos estão planejados e serão adicionados no futuro. Fique ligado!

---

## Limitações

- O AndroidCS IDE (ACSIDE) pode falhar ao compilar projetos antigos que usam AGP 8.x.x ou inferior. Recomendamos fortemente atualizar seu projeto para a versão mais recente do Android Gradle Plugin (AGP) para ter a melhor compatibilidade.

---

## 📌 Status

Este projeto está em desenvolvimento ativo. Feedback e sugestões são sempre bem-vindos.

### Sobre o código-fonte

A IDE é atualmente de código fechado para permitir iteração e desenvolvimento mais rápidos. Quando o projeto alcançar um estado estável, partes do código-fonte serão abertas.

### Transparência e privacidade de rede

O ACSIDE é de código fechado por enquanto, então você não precisa acreditar na minha palavra sobre o que ele faz na rede.

- **Sem telemetria.** Sem análises, sem rastreamento de uso e sem relatórios de falha silenciosos. Se a IDE travar, você verá uma tela de falha com um botão "Enviar relatório" que abre o navegador em uma issue do GitHub pré-preenchida. Nada é enviado a menos que você envie.
- **Agente de IA:** você usa suas próprias chaves de API. As requisições vão diretamente do seu dispositivo para o servidor do modelo que você escolheu, de ponta a ponta, e nunca passam pelos meus servidores.
- **Atualizações e plugins** vêm de repositórios abertos no GitHub: [`updater.json`](https://github.com/AndroidCSIDE/ACSIDE/blob/main/others/updater/updater.json) e [androidcs-plugins](https://github.com/AndroidCSIDE/androidcs-plugins).

Não confie em mim, verifique: execute o [Reqable](https://reqable.com/) ou qualquer monitor de rede para Android e veja com quais hosts a IDE se comunica. Você só deve ver o GitHub, repositórios de pacotes e SDK e o provedor de IA que você configurou. Se vir qualquer outra coisa, abra uma issue.
