# Demo of Robusta and JNI on Android
This repo contains a small proof-of-concept and [guide](INSTALLATION.md) on how to use the Java Native Interface (JNI) and [Robusta](https://github.com/giovanniberti/robusta) on an Android phone. The goal is to provide a guide and example on how Robusta can be used to facilitate communication between Rust and Java/Android. 
The code in this Repo is used to create a small, dirty Android app that you can run on your phone, that uses Robusta to call a function in Rust.

## What is the JNI?
The Java Native Interface (JNI) is a framework that enables Java code running in the Java Virtual Machine (JVM) to interact with code written in other languages, particularly languages like C, C++ and Rust. The JNI allows Java programs to call functions written in native code and vice versa. It provides a set of APIs and protocols for handling communication between Java code and native code, including functions for converting data types between Java and native representations, managing references to Java objects from native code, and handling exceptions that occur in native code. You can find more details in the [JNI Docs](https://docs.oracle.com/javase/8/docs/technotes/guides/jni/spec/jniTOC.html).

## What is Robusta?
This library provides a procedural macro to make easier to write JNI-compatible code in Rust. It can perform automatic conversion of Rust-y input and output types. It takes away a lot of nitty-gritty details and complexity when using the JNI. For more details and an overview of the capabilites of Robusta, go to [Robusta's GitHub repo](https://github.com/giovanniberti/robusta).

## What is this code doing?
There is a lot of code in this repo, mainly to provide the GUI and basic functions of the app. The interesting files are [lib.rs](/app/src/lib.rs), the file containing the Rust code, [HelloWorld.java](app/src/main/java/com/example/basicapp/HelloWorld.java), the file defining the Functions implemented in Rust on the Java side, as well as the build files like [cargo.toml](app/src/Cargo.toml) and [run.sh](/app/run.sh) / [run.bat](/app/run.bat).

- [lib.rs](/app/src/lib.rs) contains the function implementations in Rust that will be used by Java. It will later be compiled into a dynamic library, from where the functions can be used in Java.
- [HelloWorld.java](app/src/main/java/com/example/basicapp/HelloWorld.java) is the other half of that interaction, providing the function definitions in Java (with the `native` tag), as well as loading the dynamic library in the first place.
- [FirstFragment.java](app/src/main/java/com/example/basicapp/FirstFragment.java) calls the native function when the button in the GUI is pressed.
- [cargo.toml](app/src/Cargo.toml) has been modified so that the Rust code actually gets compiled as a dynamic library, with the line `crate-type = ["cdylib"]`. It also has Robusta marked as a dependency.
- The [run.sh](/app/run.sh) / [run.bat](/app/run.bat) files are the ones that are executed in order to build and install the app. They first use cargo to compile the Rust code, and then compile and build the Android app. 

## Guide
Refer to [this file](INSTALLATION.md) for a basic guide on how to use the code in this Repo. It contains full instructions for all necessary prep work and actual execution of the build process of the app. It does not contain many explanations why these steps are necessary, or how the JNI or Robusta work in detail. You can find more information about that either by looking at the files in the section above, or by checking some of these links:

 - [Robusta GitHub](https://github.com/giovanniberti/robusta)
 - [Robusta Docs](https://giovanniberti.github.io/doc/robusta_jni/)
 - [JNI Docs](https://docs.oracle.com/javase/8/docs/technotes/guides/jni/spec/jniTOC.html)
 - [cargo-ndk Docs](https://docs.rs/crate/cargo-ndk/3.5.4)
 - [rust-jni-test](https://github.com/mottalli/rust-jni-test) - a similar Repo with a similar goal, although not focussed on Android specifically

## Licence
This Repo is published under the MIT Licence. For more details, check the [LICENCE file](LICENSE).

## Acknowledgements
Huge thanks to [Robusta](https://github.com/giovanniberti/robusta)! This Repo leans heavily on the general example provided with the library itself, and this Guide would not exist without that help.
