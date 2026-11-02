<p align="center">
<picture>
  <source media="(prefers-color-scheme: light)" srcset="assets/art/acsart-light.png">
  <source media="(prefers-color-scheme: dark)" srcset="assets/art/acsart-dark.png">
  <img src="assets/art/acsart-dark.png" alt="ACSIDE logo" width="1920">
</picture>
</p>

<h1 align="center">ACSIDE</h1>

<p align="center">
<img src="https://img.shields.io/github/v/release/AndroidCSIDE/ACSIDE?include_prereleases&amp;label=latest%20release" alt="הגרסה האחרונה">
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
    <img src="https://img.shields.io/badge/Report%20Bug-red?style=for-the-badge&logo=github" alt="דיווח על באג">
  </a>
  <a href="https://github.com/AndroidCSIDE/ACSIDE/issues/new?labels=feature&template=FEATURE.yml&title=%5BFeature%5D%3A+">
    <img src="https://img.shields.io/badge/Request%20Feature-brightgreen?style=for-the-badge&logo=github" alt="בקשת יכולת חדשה">
  </a>
  <a href="https://t.me/androidcodestudio">
    <img src="https://img.shields.io/badge/Telegram-Join%20Us-1DA1F2?style=for-the-badge&logo=telegram" alt="הצטרפו בטלגרם">
  </a>
</p>

<p align="center" dir="rtl">
AndroidCS IDE היא סביבת פיתוח מלאה שנועדה ליצור ולנהל כל סוג של פרויקטי אנדרואיד ישירות על המכשיר או במערכות קלות. היא מספקת תהליך עבודה חזק ויעיל למפתחים שרוצים חוויית פיתוח אנדרואיד מלאה ללא הדרישות הכבדות של סביבות פיתוח מסורתיות.
</p>

<div align="center">
<table dir="rtl">
  <tr>
    <td><b>למי זה מיועד</b></td>
    <td>מפתחים שרוצים סביבת פיתוח מלאה באנדרואיד</td>
  </tr>
  <tr>
    <td><b>מה אפשר לבנות</b></td>
    <td>אפליקציות אנדרואיד, ספריות, אפליקציות Flutter, מודולים נייטיב (native)</td>
  </tr>
</table>
</div>

<div dir="rtl">

---

> [!WARNING]
> **השתמשו בהורדות הרשמיות בלבד**
>
> התקינו את AndroidCS IDE מ:
> - **GitHub Release** - https://github.com/AndroidCSIDE/ACSIDE/releases
>
> הימנעו מהורדת קובצי APK מאתרים לא מוכרים או לא רשמיים, מכיוון שהם עלולים להיות ערוכים או לא בטוחים.

---

## יכולות נתמכות ומפת דרכים

### פרויקטים ובנייה
* [x] תמיכה בפרויקטי Android Flutter
* [x] תמיכה בפרויקטי Gradle
* [x] JDK 17, 21
* [x] SDK Manager להתקנת כלי בנייה, NDK, CMake, Flutter SDK ועוד
* [x] Dependency Updater עם התראות על תלויות מיושנות ישירות בקובצי הבנייה שלכם

### עורך ותמיכה בשפות
* [x] הדגשת תחביר TextMate
* [x] שרתי שפה (ניתן להפעיל או לכבות כל אחד בנפרד):
  * [x] Java Language Server - מאת [georgewfraser](https://github.com/georgewfraser)
  * [x] Kotlin Language Server - מאת [nullij](https://github.com/nullij)
  * [x] XML Language Server
  * [x] Dart Language Server *(זמין לאחר התקנת Flutter SDK)*
  * [x] Python Language Server *(ניתן להתקנה באמצעות תוספים)*
  * [x] Bash Language Server *(ניתן להתקנה באמצעות תוספים)*
  * [x] Clang Language Server *(ניתן להתקנה באמצעות תוספים)*
  * [x] חבילת שרתי שפה לווב *(ניתנת להתקנה באמצעות תוספים)*
* [x] יכולות LSP נתמכות:
  * [x] השלמת קוד
  * [x] אבחון (Diagnostics)
  * [x] Hover
  * [x] עזרה בחתימות (Signature Help)
  * [x] מעבר להגדרה
  * [x] תיקונים מהירים (Code Actions)
  * [x] עיצוב קוד
  * [x] רמזים מוטבעים (Inlay Hints)
  * [x] תמיכה ב-Jetpack Compose
* [x] מתגי יכולות לכל שרת, להפעלה או לכיבוי של יכולות בודדות בכל שרת שפה
* [x] הגדרת אפשרויות JVM מותאמות אישית עבור שרתי השפה של Kotlin ו-Java

### תצוגות מקדימות
* [x] מערכת תצוגה מקדימה אמיתית ל-Jetpack Compose
* [x] מערכת תצוגה מקדימה אמיתית לפריסות XML
* [x] מערכת תצוגה מקדימה מיידית לאפליקציות Flutter

### Git
* [x] תהליך עבודה מונחה עם Git והטמעת מאגר צעד אחר צעד
* [x] מנהל פרטי גישה מאובטח עם תמיכה בריבוי remotes
* [x] פתרון קונפליקטים במיזוג עם אפשרויות לקבל את השינויים שלנו, לקבל את השינויים שלהם או לבטל
* [x] מגירת Source Control בעיצוב מחודש עם הצגת diff בתוך השורה

### בינה מלאכותית והרחבה
* [x] סוכן בינה מלאכותית עם תמיכה ב-Model Context Protocol (MCP)
* [x] מצב אישור עריכות לבדיקה, אישור או דחייה של השינויים שהסוכן מציע
* [x] מערכת תוספים

### טרמינל וניפוי שגיאות
* [x] טרמינל המבוסס על חבילות Termux *(עדיין ניתן להתקין PRoot באמצעות PRoot-Distro)*
* [x] ניפוי שגיאות באמצעות ADB עם צימוד אלחוטי, תמיכה ב-USB-OTG ו-logcat דרך ADB או Shizuku
* [x] תוסף Logger המוזרק לפרויקטים בבניות דיבוג ללכידת לוגים מהירה ואמינה יותר

### התאמה אישית
* [x] מראה Windows 11 Fluent 2
* [x] מראה Google Material
* [x] זמין באנגלית, ערבית, רוסית, פרסית, עברית, טורקית וסינית מפושטת, ועוד...

עוד יכולות מתוכננות ויתווספו בעתיד - הישארו מעודכנים!

---

## מגבלות

- ייתכן ש-AndroidCS IDE (ACSIDE) ייכשל בבניית פרויקטים ישנים שמשתמשים ב-AGP בגרסה 8.x.x ומטה. מומלץ בחום לשדרג את הפרויקט שלכם לגרסה האחרונה של Android Gradle Plugin (AGP) לתאימות הטובה ביותר.

---

## 📌 סטטוס

הפרויקט נמצא בפיתוח פעיל. משוב והצעות תמיד יתקבלו בברכה.

### על קוד המקור

סביבת הפיתוח היא כרגע בקוד סגור כדי לאפשר איטרציה ופיתוח מהירים יותר. כשהפרויקט יגיע למצב יציב, חלקים מקוד המקור ייפתחו.

### שקיפות ופרטיות ברשת

ACSIDE היא כרגע בקוד סגור, ולכן אתם לא צריכים להאמין לי על מילי בנוגע למה שהיא עושה ברשת.

- **ללא טלמטריה.** ללא אנליטיקה, ללא מעקב שימוש וללא דיווח שקט על קריסות. אם סביבת הפיתוח קורסת, יוצג מסך קריסה עם כפתור "שליחת דיווח" שפותח את הדפדפן על issue מוכן מראש ב-GitHub. שום דבר לא נשלח אלא אם תשלחו אותו בעצמכם.
- **סוכן ה-AI:** אתם מביאים מפתחות API משלכם. הבקשות עוברות ישירות מהמכשיר שלכם לשרת המודל שבחרתם, מקצה לקצה, ולעולם לא דרך השרתים שלי.
- **עדכונים ותוספים** מגיעים ממאגרי GitHub פתוחים: [`updater.json`](https://github.com/AndroidCSIDE/ACSIDE/blob/main/others/updater/updater.json) ו-[androidcs-plugins](https://github.com/AndroidCSIDE/androidcs-plugins).

אל תאמינו לי, תבדקו: הריצו את [Reqable](https://reqable.com/) או כל כלי ניטור רשת לאנדרואיד ובדקו לאילו מארחים (hosts) סביבת הפיתוח פונה. אתם אמורים לראות רק את GitHub, מאגרי חבילות ו-SDK וספק ה-AI שהגדרתם. אם אתם רואים משהו אחר, אנא פתחו issue.

</div>
