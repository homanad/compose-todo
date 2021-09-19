object Libs {

    object Android {
        private const val gradleVersion = "7.0.2"

        const val gradlePlugin = "com.android.tools.build:gradle:$gradleVersion"
    }

    object Kotlin {
        private const val version = "1.5.21"

        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    }

    object Google {
        object Material {
            private const val version = "1.4.0"

            val components by lazy { "com.google.android.material:material:$version" }
        }
    }

    object Coroutines {
        private const val version = "1.5.1"

        val core by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version" }
        val android by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version" }
        val test by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version" }
    }

    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:1.6.0"

        object Compose {
            const val version = "1.0.1"

            val ui by lazy { "androidx.compose.ui:ui:${version}" }
            val material by lazy { "androidx.compose.material:material:${version}" }
            val toolingPreview by lazy { "androidx.compose.ui:ui-tooling-preview:$version" }
            val tooling by lazy { "androidx.compose.ui:ui-tooling:${version}" }

            object Test {
                val uiJUnit by lazy { "androidx.compose.ui:ui-test-junit4:$version" }
            }
        }

        object Activity {
            val activityCompose by lazy { "androidx.activity:activity-compose:1.3.1" }
        }

        object Lifecycle {
            val lifeCycleRuntime by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1" }
        }

        object Room {
            private val version = "2.3.0"

            val roomRuntime by lazy { "androidx.room:room-runtime:$version" }

            // To use Kotlin annotation processing tool (kapt)
            // To use Kotlin Symbolic Processing (KSP)
            val roomCompiler by lazy { "androidx.room:room-compiler:$version" }

            // optional - Kotlin Extensions and Coroutines support for Room
            val roomKtx by lazy { "androidx.room:room-ktx:$version" }

            object Test {
                val roomTest by lazy { "androidx.room:room-testing:$version" }
            }
        }

        object Test {
            private const val version = "1.4.0"

            val core by lazy { "androidx.test:core:$version" }
            val archCore by lazy { "androidx.arch.core:core-testing:2.1.0" }

            object Ext {
                private const val version = "1.1.3"

                val junitKtx by lazy { "androidx.test.ext:junit-ktx:$version" }
                val junit by lazy { "androidx.test.ext:junit:$version" }
            }

            val espressoCore by lazy { "androidx.test.espresso:espresso-core:3.4.0" }
        }
    }

    object Test {
        private const val nhaarn_mockito_version = "2.2.0"

        val nhaarnMockito by lazy { "com.nhaarman.mockitokotlin2:mockito-kotlin:$nhaarn_mockito_version" }
    }

    object JUnit {
        private const val version = "4.13"

        val junit by lazy { "junit:junit:$version" }
    }
}