package com.ayman.quarkustesting;

import io.quarkus.test.junit.NativeImageTest;

// Run test against GraalVM native executable
@NativeImageTest
public class NativeGreetingResourceIT extends GreetingResourceTest {

    // Execute the same tests but in native mode.
}