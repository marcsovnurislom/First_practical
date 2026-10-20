# Applier — Login & Registration Android App

My first practical Android project, written in **Kotlin**. A simple app with
registration, login and a greeting screen. The interface is in Uzbek.

![Kotlin](https://img.shields.io/badge/Kotlin-1.4-7F52FF?logo=kotlin&logoColor=white)
![Android](https://img.shields.io/badge/Android-API%2016%2B-3DDC84?logo=android&logoColor=white)

## Features

- **Registration**: name, login, password and password confirmation
- **Login**: checks the entered login and password against the saved account
- **Greeting screen**: shows "Salom, &lt;name&gt;" after a successful login
- **Validation** with Snackbar messages for empty fields, mismatched passwords
  and a wrong login or password
- Account data is stored locally with `SharedPreferences`

## Screens

| Screen             | File                    | What it does                           |
|--------------------|-------------------------|----------------------------------------|
| Login (start)      | `MainActivity.kt`       | Log in or go to registration           |
| Registration       | `RegisterActivity.kt`   | Create an account and save it          |
| Greeting           | `HelloActivity.kt`      | Welcome message with the user's name   |

## Getting started

1. Clone the repository:
   ```bash
   git clone https://github.com/marcsovnurislom/First_practical.git
   ```
2. Open the folder in **Android Studio**.
3. Wait for Gradle sync, then run the app on an emulator or a device.

> The project uses Android Gradle Plugin 4.1 and Gradle 6.5, which need **JDK 11** or
> older. Newer versions of Android Studio may offer to upgrade the build setup.

## Project structure

```
First_practical/
├── app/
│   └── src/main/
│       ├── java/com/example/applier/   # Activities and the User model
│       ├── res/layout/                 # Screen layouts
│       └── AndroidManifest.xml
├── build.gradle
└── settings.gradle
```

## Note

This is a learning project. The password is saved as plain text in
`SharedPreferences`, which is fine for practice but not for a real app.
A real app should keep accounts on a server, or at least store only a
password hash.
