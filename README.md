# My Calculator

My Calculator is a simple Android calculator application built using Java and the Rhino API for JavaScript execution. This calculator supports basic arithmetic operations and uses the Rhino API to evaluate expressions.

## Features:

### - Basic arithmetic operations: addition, subtraction, multiplication, and division.
### - Parentheses support for complex expressions.
### - Clear (AC) and backspace (C) functionality.
### - Support for decimal numbers.

## Usage:

- Open the application on your Android device.
- Use the buttons to input your calculations.
- Press **"="** to see the result.
- Use **"AC"** to clear the input and **"C"** to remove the last character.

## Code Overview:

### MainActivity.java:

The main activity handles user interactions and updates the display accordingly. It implements the `View.OnClickListener` interface to manage button clicks.

#### Important Methods:

- **`onCreate(Bundle savedInstanceState):`** Initializes the UI components and sets up the button listeners.
- **`assignId(View btn, int Id):`** Helper method to assign button IDs and set click listeners.
- **`onClick(View v):`** Handles the logic for button clicks, updating the display or performing calculations.
- **`getResult(String data):`** Uses the Rhino API to evaluate the arithmetic expression provided by the user.

### Rhino API Integration:

The Rhino API is used to evaluate JavaScript code within the Android application. This allows for dynamic evaluation of mathematical expressions entered by the user.

#### Dependencies:

To include the Rhino library in your project, add the following dependency to your `build.gradle` file:

```gradle
dependencies {
    implementation("com.faendir.rhino:rhino-android:1.5.2")
}
```

### Layout:

The layout is defined in the `activity_main.xml` file, which includes the display `TextView` and all the calculator buttons.

---

Thank you for using My Calculator!
