<p align="center">
<picture>
  <source media="(prefers-color-scheme: light)" srcset="assets/art/acsart-light.png">
  <source media="(prefers-color-scheme: dark)" srcset="assets/art/acsart-dark.png">
  <img src="assets/art/acsart-dark.png" alt="ACSIDE logo" width="1920">
</picture>
</p>

<h1 align="center">ACSIDE</h1>

<p align="center">
<img src="https://img.shields.io/github/v/release/AndroidCSIDE/ACSIDE?include_prereleases&amp;label=latest%20release" alt="آخرین نسخه">
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
    <img src="https://img.shields.io/badge/Report%20Bug-red?style=for-the-badge&logo=github" alt="گزارش باگ">
  </a>
  <a href="https://github.com/AndroidCSIDE/ACSIDE/issues/new?labels=feature&template=FEATURE.yml&title=%5BFeature%5D%3A+">
    <img src="https://img.shields.io/badge/Request%20Feature-brightgreen?style=for-the-badge&logo=github" alt="درخواست قابلیت">
  </a>
  <a href="https://t.me/androidcodestudio">
    <img src="https://img.shields.io/badge/Telegram-Join%20Us-1DA1F2?style=for-the-badge&logo=telegram" alt="عضویت در تلگرام">
  </a>
</p>

<p align="center" dir="rtl">
AndroidCS IDE یک محیط توسعهٔ کامل است که برای ساخت و مدیریت انواع پروژه‌های اندروید مستقیماً روی دستگاه یا روی سیستم‌های سبک طراحی شده است. این محیط برای توسعه‌دهندگانی که تجربهٔ کامل توسعهٔ اندروید را بدون نیازهای سنگین IDEهای سنتی می‌خواهند، گردش‌کاری قدرتمند و در عین حال کارآمد فراهم می‌کند.
</p>

<div align="center">
<table dir="rtl">
  <tr>
    <td><b>مناسب چه کسانی است</b></td>
    <td>توسعه‌دهندگانی که یک IDE کامل روی اندروید می‌خواهند</td>
  </tr>
  <tr>
    <td><b>چه چیزی می‌توانید بسازید</b></td>
    <td>اپلیکیشن‌های اندروید، کتابخانه‌ها، اپلیکیشن‌های Flutter، ماژول‌های نیتیو (native)</td>
  </tr>
</table>
</div>

<div dir="rtl">

---

> [!WARNING]
> **فقط از دانلودهای رسمی استفاده کنید**
>
> AndroidCS IDE را از این منبع نصب کنید:
> - **GitHub Release** - https://github.com/AndroidCSIDE/ACSIDE/releases
>
> از دانلود APK از وب‌سایت‌های ناشناس یا غیررسمی خودداری کنید، زیرا ممکن است دستکاری‌شده یا ناامن باشند.

---

## قابلیت‌های پشتیبانی‌شده و نقشهٔ راه

### پروژه‌ها و بیلد
* [x] پشتیبانی از پروژه‌های Android Flutter
* [x] پشتیبانی از پروژه‌های Gradle
* [x] JDK 17 و 21
* [x] SDK Manager برای نصب ابزارهای بیلد، NDK، CMake، Flutter SDK و موارد دیگر
* [x] Dependency Updater با اعلان وابستگی‌های قدیمی مستقیماً در فایل‌های بیلد شما

### ویرایشگر و پشتیبانی از زبان‌ها
* [x] هایلایت نحو (syntax highlighting) با TextMate
* [x] سرورهای زبان (هرکدام را می‌توان جداگانه فعال یا غیرفعال کرد):
  * [x] Java Language Server - از [georgewfraser](https://github.com/georgewfraser)
  * [x] Kotlin Language Server - از [nullij](https://github.com/nullij)
  * [x] XML Language Server
  * [x] Dart Language Server *(پس از نصب Flutter SDK در دسترس است)*
  * [x] Python Language Server *(قابل نصب از طریق افزونه‌ها)*
  * [x] Bash Language Server *(قابل نصب از طریق افزونه‌ها)*
  * [x] Clang Language Server *(قابل نصب از طریق افزونه‌ها)*
  * [x] بستهٔ سرورهای زبان وب *(قابل نصب از طریق افزونه‌ها)*
* [x] قابلیت‌های پشتیبانی‌شدهٔ LSP:
  * [x] تکمیل کد
  * [x] عیب‌یابی (Diagnostics)
  * [x] Hover
  * [x] راهنمای امضا (Signature Help)
  * [x] رفتن به تعریف
  * [x] رفع سریع (Code Actions)
  * [x] قالب‌بندی کد
  * [x] نکات درون‌خطی (Inlay Hints)
  * [x] پشتیبانی از Jetpack Compose
* [x] کلیدهای فعال/غیرفعال‌سازی قابلیت‌ها برای هر سرور، جهت روشن یا خاموش کردن تک‌تک قابلیت‌های هر سرور زبان
* [x] پیکربندی گزینه‌های سفارشی JVM برای سرورهای زبان Kotlin و Java

### پیش‌نمایش‌ها
* [x] سیستم پیش‌نمایش واقعی Jetpack Compose
* [x] سیستم پیش‌نمایش واقعی چیدمان‌های XML
* [x] سیستم پیش‌نمایش آنی برنامه‌های Flutter

### Git
* [x] گردش‌کار هدایت‌شدهٔ Git با راه‌اندازی مرحله‌به‌مرحلهٔ مخزن
* [x] مدیر امن اعتبارنامه‌ها با پشتیبانی از چند remote
* [x] حل تعارض ادغام با گزینه‌های پذیرش تغییرات خودی، پذیرش تغییرات طرف مقابل و لغو
* [x] کشوی Source Control با طراحی جدید و نمایش diff درون‌خطی

### هوش مصنوعی و قابلیت توسعه
* [x] عامل هوش مصنوعی با پشتیبانی از Model Context Protocol (MCP)
* [x] حالت تأیید ویرایش برای بررسی، پذیرش یا رد تغییرات پیشنهادی عامل
* [x] سیستم افزونه

### ترمینال و اشکال‌زدایی
* [x] ترمینال مبتنی بر بسته‌های Termux *(PRoot را همچنان می‌توان از طریق PRoot-Distro نصب کرد)*
* [x] اشکال‌زدایی با ADB همراه با جفت‌سازی بی‌سیم، پشتیبانی از USB-OTG و logcat از طریق ADB یا Shizuku
* [x] افزونهٔ Logger که در بیلدهای دیباگ به پروژه‌ها تزریق می‌شود تا ثبت لاگ سریع‌تر و قابل‌اعتمادتر باشد

### شخصی‌سازی
* [x] ظاهر Windows 11 Fluent 2
* [x] ظاهر Google Material
* [x] در دسترس به زبان‌های انگلیسی، عربی، روسی، فارسی، عبری، ترکی و چینی ساده‌شده، و موارد بیشتر...

قابلیت‌های بیشتری برنامه‌ریزی شده و در آینده اضافه خواهند شد - با ما همراه باشید!

---

## محدودیت‌ها

- ممکن است AndroidCS IDE (ACSIDE) در بیلد پروژه‌های قدیمی که از AGP نسخهٔ 8.x.x یا پایین‌تر استفاده می‌کنند ناموفق باشد. برای بهترین سازگاری، به‌شدت توصیه می‌شود پروژهٔ خود را به آخرین نسخهٔ Android Gradle Plugin (AGP) ارتقا دهید.

---

## 📌 وضعیت

این پروژه در حال توسعهٔ فعال است. بازخورد و پیشنهادها همیشه خوش‌آمدند.

### دربارهٔ کد منبع

این IDE در حال حاضر متن‌بسته (closed source) است تا تکرار و توسعه سریع‌تر انجام شود. وقتی پروژه به وضعیت پایدار برسد، بخش‌هایی از کد منبع متن‌باز خواهد شد.

### شفافیت و حریم خصوصی شبکه

ACSIDE فعلاً متن‌بسته است، پس لازم نیست حرف مرا دربارهٔ کارهایی که روی شبکه انجام می‌دهد باور کنید.

- **بدون تله‌متری.** بدون تحلیل‌گر (analytics)، بدون ردیابی استفاده و بدون ارسال بی‌صدای گزارش خرابی. اگر IDE کرش کند، صفحهٔ خطایی با دکمهٔ «ارسال گزارش» می‌بینید که مرورگر شما را روی یک issue از پیش پرشدهٔ GitHub باز می‌کند. تا وقتی خودتان ارسال نکنید، چیزی فرستاده نمی‌شود.
- **عامل هوش مصنوعی:** کلیدهای API را خودتان وارد می‌کنید. درخواست‌ها مستقیماً از دستگاه شما به سرور مدلی که انتخاب کرده‌اید ارسال می‌شوند، سرتاسری (end to end)، و هرگز از سرورهای من عبور نمی‌کنند.
- **به‌روزرسانی‌ها و افزونه‌ها** از مخازن متن‌باز GitHub می‌آیند: [`updater.json`](https://github.com/AndroidCSIDE/ACSIDE/blob/main/others/updater/updater.json) و [androidcs-plugins](https://github.com/AndroidCSIDE/androidcs-plugins).

به من اعتماد نکنید، خودتان بررسی کنید: [Reqable](https://reqable.com/) یا هر ابزار پایش شبکهٔ اندروید را اجرا کنید و ببینید IDE با کدام هاست‌ها (hosts) ارتباط می‌گیرد. باید فقط GitHub، مخازن بسته و SDK و ارائه‌دهندهٔ هوش مصنوعی‌ای را که پیکربندی کرده‌اید ببینید. اگر چیز دیگری دیدید، لطفاً یک issue باز کنید.

</div>
