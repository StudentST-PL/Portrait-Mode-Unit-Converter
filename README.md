# Unit Converter (Length Converter) - Android App

A clean, modern Android application built with **Jetpack Compose** and **Kotlin** that converts lengths from meters into centimeters, kilometers, miles, and light years in real time.

---

## Key Features

* **Real-time Conversion:** Instant calculations as the user types, without any "Calculate" button[cite: 13].
* **Robust Input Handling:** Safe parsing (`toDoubleOrNull`) supporting both dot (`.`) and comma (`,`) decimal separators (localized keyboards) without crashing.
* **Adaptive Number Formatting:** 
  * Thousands grouping separators for large numbers (e.g., `100,000` cm).
  * Automatic fallback to scientific notation (`× 10^`) for extreme magnitudes (e.g., light-year calculations $10^{-16}$).
  * Clean initial/empty state (shows `—` instead of zeroes or error messages when the input is empty)[cite: 13].
* **Adaptive Launcher Icon:** Includes background, foreground, and monochrome layers for system-themed icons[cite: 14].
* **Unit Tests:** Automated **JUnit 4** test suite covering conversion formulas, edge-case thresholds, and empty/invalid input validation.

---

## Orientation Lock & Adaptive Layouts (Lab Question)

### *Why is `android:screenOrientation="portrait"` ignored on large screens?*
Starting with recent Android versions (`targetSdk 37`), the system completely ignores `screenOrientation` declarations on screens with a smallest width of **$\ge 600\text{dp}$** (tablets, foldables, and desktop multi-window modes)[cite: 16]. This behavior prevents broken user experiences and supports multi-tasking on large displays[cite: 16].

### *What should replace fixed orientation locking?*
Instead of hardcoding orientation restrictions, applications should build **Adaptive Layouts** using **Window Size Classes** (*Compact*, *Medium*, *Expanded*)[cite: 16, 17]. This allows a single code base to dynamically rearrange UI elements according to the available screen real estate[cite: 17].

---

## Tech Stack & Architecture

* **Language:** Kotlin
* **UI Framework:** Jetpack Compose (Material 3)
* **State Management:** `rememberSaveable` & `mutableStateOf`
* **Testing:** JUnit 4 (Unit Testing pure Kotlin functions)
* **Architecture:** Decoupled business logic (`LengthUnit` enum & `convertMeters` pure function) separated from UI views.

---

## Running Unit Tests

Run local unit tests directly from Android Studio or via Gradle CLI:

```bash
./gradlew test
