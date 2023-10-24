# WeatherApp Readme

## Architecture

The WeatherApp adheres to a robust architectural pattern known as Clean Architecture, augmented by the Model-View-Intent (MVI). Clean Architecture is considered a best practice recommendation for Android app development, emphasizing a high degree of modularity and separation of concerns, as outlined in the official Android Architecture Guide [here](https://developer.android.com/topic/architecture).

The fundamental idea behind Clean Architecture is to segment the app into distinct layers, enabling a clear separation of responsibilities. The WeatherApp's architectural layers now include:

1. **Network Layer**: This layer is responsible for handling API calls through Retrofit, abstracting the complexities of network communication.

2. **Domain Layer**: Introduced as an intermediary between the Network Layer and the Use Case Layer, the Domain Layer contains the core business logic of the application. It defines the domain models, entities, and use cases, ensuring that the business rules are decoupled from network-specific details.

3. **UI Layer**: This layer encompasses the user interface elements, including Composables (if using Jetpack Compose) and ViewModels. The UI layer is responsible for rendering the user interface, handling user interactions, and presenting data to the user. Importantly, it remains oblivious to the underlying mechanisms, such as Retrofit for network calls.

This architectural structure offers several advantages, including enhanced testability, maintainability, and flexibility through the separation of concerns.

## Third-party Libraries

The WeatherApp makes use of the following third-party libraries:

1. **Dagger-Hilt**: Dagger-Hilt is employed for dependency injection, simplifying the management and injection of dependencies, which promotes clean and modular code.

2. **Retrofit**: Retrofit is used for network calls, as it is a powerful library for making HTTP requests and facilitating seamless communication with remote servers.

## Building the App

To build and run the WeatherApp, follow these steps:

1. Clone the repository to your local development environment.

2. Open the project in your preferred Android development environment, such as Android Studio.

3. Ensure that you have the necessary Android SDK and dependencies configured.

4. Build and run the app using the emulator or a physical Android device.
