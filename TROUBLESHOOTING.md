# Устранение неполадок

## Проблема: Build was configured to prefer settings repositories

### Описание ошибки:
```
Build was configured to prefer settings repositories over project repositories but repository 'Google' was added by build file 'build.gradle'
```

### Причина:
Конфликт между конфигурацией в `settings.gradle` и корневым `build.gradle`.

### Решение:

1. **Обновите корневой build.gradle:**
   Удалите блок `allprojects` из корневого `build.gradle`. Оставьте только:
   ```gradle
   plugins {
       id 'com.android.application' version '8.1.2' apply false
       id 'com.android.library' version '8.1.2' apply false
   }
   ```

2. **Обновите settings.gradle:**
   Смените `FAIL_ON_PROJECT_REPOS` на `PREFER_SETTINGS`:
   ```gradle
   dependencyResolutionManagement {
       repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
       repositories {
           google()
           mavenCentral()
       }
   }
   ```

## Проблема: SDK не найден

### Ошибка:
```
SDK location not found
```

### Решение:
1. Скопируйте `local.properties.example` в `local.properties`
2. Отредактируйте файл, указав правильный путь к Android SDK:
   - **Windows:** `sdk.dir=C\:\\Users\\YourUsername\\AppData\\Local\\Android\\Sdk`
   - **macOS:** `sdk.dir=/Users/YourUsername/Library/Android/sdk`
   - **Linux:** `sdk.dir=/home/YourUsername/Android/Sdk`

## Проблема: Gradle Wrapper не работает

### Решение:
1. Удалите папку `.gradle` из корня проекта
2. Запустите:
   ```bash
   # На Linux/Mac:
   chmod +x gradlew
   ./gradlew clean
   
   # На Windows:
   gradlew.bat clean
   ```

## Проблема: Ошибки сборки

### Решение:
1. Очистите проект:
   ```bash
   ./gradlew clean
   ```

2. Пересоберите:
   ```bash
   ./gradlew assembleDebug
   ```

## Контакты

Если проблемы продолжаются, создайте Issue в GitHub репозитории.