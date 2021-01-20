/**
 * Created by ijays on 2021/1/5.
 */
object ApplicationId {
    const val id = "com.ijays.composeit"
}

object Versions {
    const val kotlin = "1.4.21"
    const val jetpackCompose = "1.0.0-alpha10"

}

object Androidx {
    const val coreKtx = "androidx.core:core-ktx:1.3.2"
    const val appcompat = "androidx.appcompat:appcompat:1.2.0"
    const val material = "com.google.android.material:material:1.2.1"
    const val lifecycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:2.3.0-alpha06"
}

object Libraries {
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    const val composeUI = "androidx.compose.ui:ui:${Versions.jetpackCompose}"
    const val composeUITooling = "androidx.compose.ui:ui-tooling:${Versions.jetpackCompose}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.jetpackCompose}"

}