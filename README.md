# Add Method

## Overview
This project implements a simple Add Method in Java. The calculator can handle addition of numbers provided in a string format, with support for custom delimiters, handling negative numbers, and ignoring non-numeric inputs.

## Features
- Supports addition of numbers in a string format.
- Handles custom delimiters defined by the user.
- Ignores non-numeric inputs.
- Throws an exception for negative numbers with a descriptive message.
- Supports multiple custom delimiters of variable lengths.



### Setup and Installation

1. **Clone the repository:**

   ```bash
   https://github.com/rahul-nagvadia/Incubyte_AddMethod.git
   cd Incubyte_AddMethod
   ```

2. **Import the project into Eclipse:**
   - Open Eclipse IDE.
   - Go to **File > Import...**.
   - Select **Existing Maven Projects** under the **Maven** category.
   - Click **Next**.
   - Browse to the cloned repository directory.
   - Select the project and click **Finish**.

3. **Build the project:**
   - Right-click on the project in Eclipse.
   - Select **Run As > Maven install**.

## Usage

The main logic of the calculator is implemented in the `AddMethod` class, located in the `com.addmethod` package.

To use the calculator, you can call the `add` method with a string input:

```java
AddMethod addMethod = new AddMethod();
int sum = addMethod.add("1,2,3");
System.out.println("The sum is: " + sum); // Output: The sum is: 6
```

## Running Tests

Unit tests are provided in the `AddMethodTest` class, located in the `com.addmethod` package. The tests cover various cases, including handling of different delimiters, negative numbers, and multiple numbers.

To run the tests:

1. **From Eclipse:**
   - Right-click on the `AddMethodTest` class.
   - Select **Run As > JUnit Test**.
