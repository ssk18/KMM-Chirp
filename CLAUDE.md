# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Chirp is a Kotlin Multiplatform project using Compose Multiplatform, targeting Android and iOS platforms. The project uses shared UI code across platforms with platform-specific entry points.

## Architecture

- **Package**: `com.ssk.chirp`
- **Multiplatform Structure**:
  - `composeApp/src/commonMain/kotlin`: Shared code for all targets
  - `composeApp/src/androidMain/kotlin`: Android-specific code
  - `composeApp/src/iosMain/kotlin`: iOS-specific code
- **UI Framework**: Compose Multiplatform with Material3
- **Build System**: Gradle with Kotlin DSL and version catalogs

## Key Build Commands

### Android Development
```bash
# Build debug APK
./gradlew :composeApp:assembleDebug

# Build release APK
./gradlew :composeApp:assembleRelease

# Install debug build on device/emulator
./gradlew :composeApp:installDebug

# Run tests
./gradlew :composeApp:testDebugUnitTest
```

### iOS Development
- Open `iosApp` directory in Xcode to build and run iOS app
- The Kotlin code compiles to a static framework named "ComposeApp"

### General Commands
```bash
# Clean build
./gradlew clean

# Build all targets
./gradlew build

# Run common tests
./gradlew :composeApp:testCommon
```

## Project Structure

- Root `build.gradle.kts`: Plugin management only
- `composeApp/build.gradle.kts`: Main module configuration with multiplatform setup
- `gradle/libs.versions.toml`: Version catalog managing all dependencies
- `settings.gradle.kts`: Project structure and repository configuration

## Development Configuration

- **Target SDK**: 36
- **Min SDK**: 24
- **Compile SDK**: 36
- **Java Version**: 11
- **Kotlin**: 2.2.20
- **Compose Multiplatform**: 1.9.0

## Platform-Specific Notes

### Android
- Main entry point: `MainActivity.kt` which hosts the shared `App()` composable
- Uses Activity Compose for integration
- Edge-to-edge display enabled

### iOS
- iOS targets: `iosArm64` and `iosSimulatorArm64`
- Framework name: "ComposeApp" (static framework)
- Entry point: `MainViewController.kt`

## Dependencies

Key shared dependencies managed in `commonMain`:
- Compose runtime, foundation, material3, UI
- Lifecycle ViewModel and Runtime Compose
- Compose resources and UI tooling preview

Tests use `kotlin-test` library in `commonTest`.