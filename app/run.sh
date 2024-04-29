#This script builds the rust library as specified in the cargo.toml, and then runs gradle to build and install the app on the phone

# Setting environment variable so that the NDK can be used
# you may need to adjust this for your own machine
export ANDROID_NDK_HOME=/home/segelnhoch3/Android/Sdk/ndk/27.0.11718014

cd src || exit
echo
echo building rust
echo
cargo ndk -t armeabi-v7a -t arm64-v8a -o main/jniLibs build
cd ..

cd ..
echo
echo -----------------------------------------------------------------------------------------------
echo building apk
./gradlew -D java.library.path=app/src/target/x86_64-linux-android/debug installDebug