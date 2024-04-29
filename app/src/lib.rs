use robusta_jni::bridge;

#[bridge]
mod jni {
    use robusta_jni::convert::Signature;

    #[derive(Signature)]
    #[package(com.example.basicapp)]
    struct HelloWorld;

    impl HelloWorld {
        pub extern "jni" fn special(mut input1: Vec<i32>, input2: i32) -> Vec<String> {
            input1.push(input2);
            input1.iter().map(ToString::to_string).collect()
        }
    }
}