<p align="center">
<picture>
  <source media="(prefers-color-scheme: light)" srcset="assets/art/acsart-light.png">
  <source media="(prefers-color-scheme: dark)" srcset="assets/art/acsart-dark.png">
  <img src="assets/art/acsart-dark.png" alt="ACSIDE logo" width="1920">
</picture>
</p>

<h1 align="center">ACSIDE</h1>

<p align="center">
<img src="https://img.shields.io/github/v/release/AndroidCSIDE/ACSIDE?include_prereleases&amp;label=latest%20release" alt="آخر إصدار">
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
    <img src="https://img.shields.io/badge/Report%20Bug-red?style=for-the-badge&logo=github" alt="الإبلاغ عن خطأ">
  </a>
  <a href="https://github.com/AndroidCSIDE/ACSIDE/issues/new?labels=feature&template=FEATURE.yml&title=%5BFeature%5D%3A+">
    <img src="https://img.shields.io/badge/Request%20Feature-brightgreen?style=for-the-badge&logo=github" alt="طلب ميزة">
  </a>
  <a href="https://t.me/androidcodestudio">
    <img src="https://img.shields.io/badge/Telegram-Join%20Us-1DA1F2?style=for-the-badge&logo=telegram" alt="انضم إلينا على تيليجرام">
  </a>
</p>

<p align="center" dir="rtl">
AndroidCS IDE هي بيئة تطوير متكاملة مصممة لإنشاء وإدارة جميع أنواع مشاريع أندرويد مباشرةً على الجهاز أو على الأنظمة الخفيفة. توفّر سير عمل قويًا وفعّالًا في الوقت نفسه للمطورين الذين يريدون تجربة تطوير أندرويد كاملة دون المتطلبات الثقيلة لبيئات التطوير التقليدية.
</p>

<div align="center">
<table dir="rtl">
  <tr>
    <td><b>لمن هي؟</b></td>
    <td>المطورون الذين يريدون بيئة تطوير متكاملة على أندرويد</td>
  </tr>
  <tr>
    <td><b>ماذا يمكنك أن تبني؟</b></td>
    <td>تطبيقات أندرويد، مكتبات، تطبيقات Flutter، وحدات native</td>
  </tr>
</table>
</div>

<div dir="rtl">

---

> [!WARNING]
> **استخدم التنزيلات الرسمية فقط**
>
> ثبّت AndroidCS IDE من:
> - **إصدارات GitHub** - https://github.com/AndroidCSIDE/ACSIDE/releases
>
> تجنّب تنزيل ملفات APK من مواقع مجهولة أو غير رسمية، فقد تكون معدّلة أو غير آمنة.

---

## الميزات المدعومة وخارطة الطريق

### المشاريع والبناء
* [x] دعم مشاريع Android Flutter
* [x] دعم مشاريع Gradle
* [x] JDK 17 و21
* [x] مدير SDK لتثبيت أدوات البناء وNDK وCMake وFlutter SDK وغيرها
* [x] محدّث الاعتماديات (Dependency Updater) مع تنبيهات بالاعتماديات القديمة مباشرةً داخل ملفات البناء

### المحرر ودعم اللغات
* [x] تلوين الصياغة (syntax highlighting) عبر TextMate
* [x] خوادم اللغة (يمكن تفعيل أو تعطيل كل منها على حدة):
  * [x] Java Language Server - من [georgewfraser](https://github.com/georgewfraser)
  * [x] Kotlin Language Server - من [nullij](https://github.com/nullij)
  * [x] XML Language Server
  * [x] Dart Language Server *(متاح بعد تثبيت Flutter SDK)*
  * [x] Python Language Server *(قابل للتثبيت عبر الإضافات)*
  * [x] Bash Language Server *(قابل للتثبيت عبر الإضافات)*
  * [x] Clang Language Server *(قابل للتثبيت عبر الإضافات)*
  * [x] حزمة خوادم لغات الويب *(قابلة للتثبيت عبر الإضافات)*
* [x] إمكانيات LSP المدعومة:
  * [x] إكمال الشيفرة
  * [x] التشخيصات (Diagnostics)
  * [x] معلومات التمرير (Hover)
  * [x] مساعدة التوقيع (Signature Help)
  * [x] الانتقال إلى التعريف
  * [x] الإصلاحات السريعة (Code Actions)
  * [x] تنسيق الشيفرة
  * [x] التلميحات المضمّنة (Inlay Hints)
  * [x] دعم Jetpack Compose
* [x] مفاتيح تبديل لكل خادم لتفعيل أو تعطيل إمكانيات محددة في كل خادم لغة
* [x] إعداد خيارات JVM مخصصة لخادمي لغة Kotlin وJava

### المعاينات
* [x] نظام معاينة حقيقي لـ Jetpack Compose
* [x] نظام معاينة حقيقي لتخطيطات XML
* [x] نظام معاينة فورية لتطبيقات Flutter

### Git
* [x] سير عمل Git موجَّه مع إعداد المستودع خطوة بخطوة
* [x] مدير بيانات اعتماد آمن يدعم عدة مستودعات بعيدة (remotes)
* [x] حل تعارضات الدمج مع خيارات قبول التغييرات المحلية أو قبول التغييرات الواردة أو الإلغاء
* [x] درج التحكم بالمصدر (Source Control) بتصميم جديد مع عرض الفروقات (diff) داخل السطر

### الذكاء الاصطناعي وقابلية التوسعة
* [x] وكيل ذكاء اصطناعي (AI Agent) مع دعم Model Context Protocol (MCP)
* [x] وضع الموافقة على التعديلات لمراجعة التغييرات التي يقترحها الوكيل وقبولها أو رفضها
* [x] نظام إضافات (Plugins)

### الطرفية وتصحيح الأخطاء
* [x] طرفية مبنية على حزم Termux *(ويمكن تثبيت PRoot عبر PRoot-Distro)*
* [x] تصحيح الأخطاء عبر ADB مع الإقران اللاسلكي ودعم USB-OTG وعرض logcat عبر ADB أو Shizuku
* [x] إضافة Logger تُحقن في المشاريع أثناء بناءات التصحيح لالتقاط السجلات بشكل أسرع وأكثر موثوقية

### التخصيص
* [x] مظهر Windows 11 Fluent 2
* [x] مظهر Google Material
* [x] متوفر بالإنجليزية والعربية والروسية والفارسية والعبرية والتركية والصينية المبسطة، وغيرها...

ستُضاف المزيد من الميزات في المستقبل - ترقّبوا!

---

## القيود

- قد تفشل ACSIDE في بناء المشاريع القديمة التي تستخدم AGP 8.x.x أو أقل. يُنصح بشدة بترقية مشروعك إلى أحدث إصدار من Android Gradle Plugin (AGP) للحصول على أفضل توافق.

---

## 📌 الحالة

هذا المشروع قيد التطوير النشط. نرحّب دائمًا بالملاحظات والاقتراحات.

### عن الشيفرة المصدرية

بيئة التطوير مغلقة المصدر حاليًا لإتاحة تطوير وتكرار أسرع. عندما يصل المشروع إلى حالة مستقرة، سيتم فتح أجزاء من الشيفرة المصدرية.

### الشفافية وخصوصية الشبكة

ACSIDE مغلقة المصدر حاليًا، لذا لا ينبغي أن تضطر إلى تصديق كلامي بشأن ما تفعله على الشبكة.

- **بلا تتبّع (Telemetry).** لا تحليلات ولا تتبّع للاستخدام ولا إرسال صامت لتقارير الأعطال. إذا تعطّلت بيئة التطوير، تظهر لك شاشة عطل فيها زر «إرسال التقرير» يفتح المتصفح على issue معبّأة مسبقًا في GitHub. لا يُرسل أي شيء ما لم تقم أنت بإرساله.
- **وكيل الذكاء الاصطناعي:** تستخدم مفاتيح API الخاصة بك. تُرسل الطلبات مباشرةً من جهازك إلى خادم النموذج الذي اخترته، من طرف إلى طرف، ولا تمر عبر خوادمي أبدًا.
- **التحديثات والإضافات** تأتي من مستودعات GitHub مفتوحة المصدر: [`updater.json`](https://github.com/AndroidCSIDE/ACSIDE/blob/main/others/updater/updater.json) و[androidcs-plugins](https://github.com/AndroidCSIDE/androidcs-plugins).

لا تثق بي، تحقّق بنفسك: شغّل [Reqable](https://reqable.com/) أو أي أداة لمراقبة الشبكة على أندرويد وانظر إلى المضيفين (hosts) الذين تتصل بهم بيئة التطوير. ينبغي ألا ترى سوى GitHub ومستودعات الحزم والـ SDK ومزوّد الذكاء الاصطناعي الذي أعددته. إذا رأيت أي شيء آخر، فيرجى فتح issue.

</div>
