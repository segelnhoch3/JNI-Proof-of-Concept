# Installation Guide
This Guide is supposed to get you all the way from installing the appropriate IDEs to building the app yourself and running it on your phone.

## Installing Android Studio + RustRover
Android Studio is used to facilitate all Java parts, as well as installing the final app on your phone. Since Android Studio has no Rust support, it is easier to use RustRover or another IDE for that part. Installing RustRover is not strictly necessary, but it makes your life a lot easier when you are actually writing Rust code. Of course, you can use another IDE as well, though I will stick to RustRover for this guide. No matter whether you go with it, another IDE or no second IDE at all, you will need to install RustUp.

The easiest way to install both IDEs is to use the [JetBrains Toolbox](https://www.jetbrains.com/de-de/toolbox-app/), where you can install both IDEs with a single click each.
Alternatively you can also refer to the [Andriod CodeLab guide](https://developer.android.com/codelabs/basic-android-kotlin-compose-install-android-studio#0), and the [RustRover download page](https://www.jetbrains.com/rust/nextversion/).
After installing RustRover, you will need to install RustUp in order to compile Rust code. This can be done from within RustRover: After starting to create a new project, there will be a button below the toolchain location selection. Pressing it will install RustUp. Alternatively you can also install RustUp directly from [their page](https://rustup.rs/).


## First Test in Android Studio
The Goal of this section is to test Android Studio and run a "Hello World"-App on a real device. We will use a USB connection to get the app onto the device, although WiFi should also be possible.
This is just to check that Android Studio and the connection to your device are working, and is not related to the rest of the app.
- make sure that USB debugging is enabled on the phone. Refer to [this guide](https://developer.android.com/studio/debug/dev-options) if necessary
- install the proper driver for your smartphone on your PC / Laptop according to [this list](https://developer.android.com/studio/run/oem-usb#Drivers)
- Open a new project in Android Studio and select Phone/Tablet on the left and use "Empty Activity" as the template
- plug your phone into your PC / Laptop with a USB cable capable of transmitting data
- you should be able to see your phone's storage in your file explorer
- in Android Studio, go to "Running Devices" (on the top right by default), click on the plus sign and select your phone
- the screen of your phone will be mirrored inside Android Studio
- build and run your application and open it on the phone

## Further necessary tools
In order to use the Java Native Interface, and use Rust Code within our app, you will need some more tools:
- You will need the Android NDK (Native Development Kit) to build and run the project. The NDK can be installed from within Android Studio: Go to Settings > Languages & Frameworks > Android SDK > SDK Tools and select and install the NDK
- Cargo and [cargo-ndk](https://docs.rs/crate/cargo-ndk/3.5.4) are necessary to compile the Rust code in a format usable by Android. Cargo should already be installed by RustUp, cargo-ndk can be installed with `cargo install cargo-ndk`
- You will need to configure cargo further by using this command: `rustup target add aarch64-linux-android armv7-linux-androideabi i686-linux-android` (The "linux" in this command refers to the phone architecture, not your development machine. You can use this command on Windows as well)

## Building and running the project
Now you are ready to compile the project for the first time. Clone it into Android Studio, then you are ready to start.

In order to compile and run the app on your phone, execute the [run.sh](/app/run.sh) (Linux) or [run.bat](/app/run.bat) (Windows) file in /app. This will compile the Rust code into a dynamic library, which is then used by Java. After that, the script will start Gradle to build the whole project and install it on your connected device for testing.

You will need to adjust the path to the NDK inside the script, instructions for that can be found in the script itself. Running the script for the first time may take a few minutes, subsequent builds will be faster. Please note that you may get the Error "INSTALL FAILED UPDATE_INCOMPATIBLE" when trying to install the app again. Deleting the existing app on the phone and re-running the build will solve that issue.
