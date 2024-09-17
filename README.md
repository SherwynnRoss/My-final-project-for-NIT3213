# Final Project for NIT3213

### Instructions



To build a mobile application, we first need the following:
- Tools: Android Studio
- Programming Language: Kotlin

Android Studio is the official Integrated Development Environment (IDE) for developing Android applications, created by Google. 
It is based on IntelliJ IDEA, a widely used Java IDE, and is designed specifically for Android app development. 
It provides developers with powerful tools, a flexible development environment, and advanced features like code refactoring, debugging, 
and performance profiling, making it an essential tool for Android developers.

Kotlin is a modern, statically typed programming language that is fully interoperable with Java, the original language for Android development. 
Kotlin was introduced by JetBrains in 2011 and officially adopted by Google in 2017 as a preferred language for Android development, alongside Java.
Kotlin simplifies writing Android apps by offering concise syntax, better readability, and safety features, such as null safety and coroutines for asynchronous programming.

With Android studio, before creating a project, you are able to choose different kind of progamming language before setting it up, including Kotlin.

#How to install android studio?

**Step1**:
Go to 'Download Android Studio & App Tools' via google

**Step2**: 
In the website, click the 'Download Android Studio/Flamingo', ensure u you accept the 'Terms & Conditions' before installing it. On Mac, it lets you have tje option to choose between
Intel or Processor Chip, depending on the Mac you are using. Make sure you are downloading the 64x bit.

**Step3**: 
 One it's finished downloading, Open the app and click next and install. It will take awhile for AndroidStudio to set up.

 **Step4**:

 Once it's done, just click next and select Standard, then click next. After that, it asks you on how to select the UI theme, click the default one.
 Press next twice and make sure u accept all Terms & Conditions.

 Once that's done, AndroidStudio would start downloading all of it's components. Click finish, and your AndroidStudio is now up and running.

### How to build the project?
Once the tools have been installed, we can get started with the steps on building the app.

**Step 1**: Create a new project and select "Empty Views Activity". Then name your file whatever you want to name it (e.g. Final App). Ensure the location is saved in the AndroidStudio projects directory, and the build configuration is Kotlin DSL. <br>

**Step 2**: After creating the project, create your own Kotlin class/file.
Make sure the following dependencies are included
```kt
implementation "com.squareup.retrofit2:retrofit:2.9.0"
implementation "com.squareup.retrofit2:retrofit:converter-gson:2.9.0"
implementation "org.jetbrains. kotlinx:kotlinx-coroutines-android:1.6.4"
implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:1.6.0"
```
This is to implement the retrofit and coroutines dependencies when createing this certain project app.

To know if you want to run a virtual app, first ensure that your Emulator is running well. You can either choose the existing device manager to run your application,
or you can create a new file.

Select `Run 'app'` on top of your AndroidStudio's screen to start displaying a virtual device of the android, it will be shown on the right side of your AndroidStudio windows, and display a 
digital phone. And depending on what you implement on your Main_Activity, which is located in ur folder `com.example.<your project's name>`, whatever code you implement there, and whatever
you design on your `activity_main.xml`, located on the layout folder, It will also be displayed there in the virtual app itself.



