<p align="center">
<picture>
  <source media="(prefers-color-scheme: light)" srcset="assets/art/acsart-light.png">
  <source media="(prefers-color-scheme: dark)" srcset="assets/art/acsart-dark.png">
  <img src="assets/art/acsart-dark.png" alt="ACSIDE logo" width="1920">
</picture>
</p>

<h1 align="center">ACSIDE</h1>

<p align="center">
<img src="https://img.shields.io/github/v/release/AndroidCSIDE/ACSIDE?include_prereleases&amp;label=latest%20release" alt="Son sürüm">
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
    <img src="https://img.shields.io/badge/Report%20Bug-red?style=for-the-badge&logo=github" alt="Hata bildir">
  </a>
  <a href="https://github.com/AndroidCSIDE/ACSIDE/issues/new?labels=feature&template=FEATURE.yml&title=%5BFeature%5D%3A+">
    <img src="https://img.shields.io/badge/Request%20Feature-brightgreen?style=for-the-badge&logo=github" alt="Özellik iste">
  </a>
  <a href="https://t.me/androidcodestudio">
    <img src="https://img.shields.io/badge/Telegram-Join%20Us-1DA1F2?style=for-the-badge&logo=telegram" alt="Telegram'a katıl">
  </a>
</p>

<p align="center">
AndroidCS IDE, her türden Android projesini doğrudan cihaz üzerinde veya hafif sistemlerde oluşturmak ve yönetmek için tasarlanmış, tam özellikli bir geliştirme ortamıdır. Geleneksel IDE'lerin ağır gereksinimleri olmadan eksiksiz bir Android geliştirme deneyimi isteyen geliştiriciler için güçlü ve verimli bir iş akışı sunar.
</p>

<div align="center">
<table>
  <tr>
    <td><b>Kimler için</b></td>
    <td>Android üzerinde tam bir IDE isteyen geliştiriciler</td>
  </tr>
  <tr>
    <td><b>Neler geliştirebilirsiniz</b></td>
    <td>Android uygulamaları, kütüphaneler, Flutter uygulamaları, yerel (native) modüller</td>
  </tr>
</table>
</div>

---

> [!WARNING]
> **Yalnızca resmi indirmeleri kullanın**
>
> AndroidCS IDE'yi şuradan yükleyin:
> - **GitHub Release** - https://github.com/AndroidCSIDE/ACSIDE/releases
>
> Bilinmeyen veya gayriresmi web sitelerinden APK indirmekten kaçının; değiştirilmiş veya güvensiz olabilirler.

---

## Desteklenen Özellikler ve Yol Haritası

### Projeler ve Derleme
* [x] Android Flutter proje desteği
* [x] Gradle proje desteği
* [x] JDK 17, 21
* [x] Derleme araçlarını, NDK'yı, CMake'i, Flutter SDK'yı ve daha fazlasını kurmak için SDK Manager
* [x] Derleme dosyalarınızda doğrudan güncel olmayan bağımlılıkları bildiren Dependency Updater

### Editör ve Dil Desteği
* [x] TextMate sözdizimi vurgulama
* [x] Dil sunucuları (her biri ayrı ayrı etkinleştirilebilir veya devre dışı bırakılabilir):
  * [x] Java Language Server - [georgewfraser](https://github.com/georgewfraser) tarafından
  * [x] Kotlin Language Server - [nullij](https://github.com/nullij) tarafından
  * [x] XML Language Server
  * [x] Dart Language Server *(Flutter SDK kurulduktan sonra kullanılabilir)*
  * [x] Python Language Server *(eklentiler aracılığıyla kurulabilir)*
  * [x] Bash Language Server *(eklentiler aracılığıyla kurulabilir)*
  * [x] Clang Language Server *(eklentiler aracılığıyla kurulabilir)*
  * [x] Web dil sunucuları paketi *(eklentiler aracılığıyla kurulabilir)*
* [x] Desteklenen LSP yetenekleri:
  * [x] Kod Tamamlama
  * [x] Tanılama (Diagnostics)
  * [x] Hover
  * [x] İmza Yardımı (Signature Help)
  * [x] Tanıma Git (Go to Definition)
  * [x] Hızlı Düzeltmeler (Code Actions)
  * [x] Kod Biçimlendirme
  * [x] Satır İçi İpuçları (Inlay Hints)
  * [x] Jetpack Compose desteği
* [x] Her dil sunucusunun yeteneklerini tek tek açıp kapatabilmek için sunucu başına özellik anahtarları
* [x] Kotlin ve Java dil sunucuları için özel JVM seçenekleri yapılandırması

### Önizlemeler
* [x] Gerçek Jetpack Compose önizleme sistemi
* [x] Gerçek XML düzen önizleme sistemi
* [x] Flutter uygulamaları için anında önizleme sistemi

### Git
* [x] Adım adım depo kurulumuyla yönlendirmeli Git iş akışı
* [x] Birden fazla uzak depoyu (remote) destekleyen güvenli kimlik bilgisi yöneticisi
* [x] Kendi değişikliklerini kabul et, karşı tarafın değişikliklerini kabul et ve iptal et seçenekleriyle birleştirme çakışması çözümü
* [x] Satır içi diff görüntülemeli yeniden tasarlanmış Source Control çekmecesi

### Yapay Zekâ ve Genişletilebilirlik
* [x] Model Context Protocol (MCP) destekli Yapay Zekâ Ajanı
* [x] Ajanın önerdiği değişiklikleri inceleme, kabul etme veya reddetme için düzenleme onay modu
* [x] Eklenti sistemi

### Terminal ve Hata Ayıklama
* [x] Termux Packages ile çalışan terminal *(PRoot yine de PRoot-Distro ile kurulabilir)*
* [x] Kablosuz eşleştirme, USB-OTG desteği ve ADB veya Shizuku üzerinden logcat ile ADB hata ayıklama
* [x] Daha hızlı ve güvenilir günlük yakalama için hata ayıklama derlemeleri sırasında projelere eklenen Logger eklentisi

### Özelleştirme
* [x] Windows 11 Fluent 2 görünümü
* [x] Google Material görünümü
* [x] İngilizce, Arapça, Rusça, Farsça, İbranice, Türkçe ve Basitleştirilmiş Çince başta olmak üzere birçok dilde kullanılabilir...

Daha fazla özellik planlanmaktadır ve ileride eklenecektir - takipte kalın!

---

## Sınırlamalar

- AndroidCS IDE (ACSIDE), AGP 8.x.x veya altını kullanan eski projeleri derlemekte başarısız olabilir. En iyi uyumluluk için projenizi en son Android Gradle Plugin (AGP) sürümüne yükseltmeniz önemle tavsiye edilir.

---

## 📌 Durum

Bu proje aktif olarak geliştirilmektedir. Geri bildirim ve öneriler her zaman memnuniyetle karşılanır.

### Kaynak Kodu Hakkında

IDE şu anda daha hızlı iterasyon ve geliştirme için kapalı kaynaklıdır. Proje kararlı bir duruma ulaştığında, kaynak kodun bazı bölümleri açık kaynak olarak yayımlanacaktır.

### Şeffaflık ve Ağ Gizliliği

ACSIDE şimdilik kapalı kaynaklı, bu yüzden ağda ne yaptığına dair sözüme güvenmek zorunda kalmamalısınız.

- **Telemetri yok.** Analitik yok, kullanım takibi yok, sessiz çökme raporu yok. IDE çökerse, tarayıcınızı önceden doldurulmuş bir GitHub issue'suna yönlendiren "Rapor gönder" düğmesine sahip bir çökme ekranı görürsünüz. Siz göndermedikçe hiçbir şey gönderilmez.
- **Yapay Zekâ Ajanı:** Kendi API anahtarlarınızı kullanırsınız. İstekler doğrudan cihazınızdan seçtiğiniz model sunucusuna, uçtan uca iletilir ve benim sunucularımdan asla geçmez.
- **Güncellemeler ve eklentiler** açık GitHub depolarından gelir: [`updater.json`](https://github.com/AndroidCSIDE/ACSIDE/blob/main/others/updater/updater.json) ve [androidcs-plugins](https://github.com/AndroidCSIDE/androidcs-plugins).

Bana güvenmeyin, kontrol edin: [Reqable](https://reqable.com/) veya herhangi bir Android ağ izleme aracını çalıştırın ve IDE'nin hangi sunucularla (host) iletişim kurduğuna bakın. Yalnızca GitHub'ı, paket ve SDK depolarını ve yapılandırdığınız yapay zekâ sağlayıcısını görmelisiniz. Başka bir şey görürseniz lütfen bir issue açın.
