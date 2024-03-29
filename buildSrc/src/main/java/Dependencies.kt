/**
 * Created by ijays on 2021/1/5.
 */
object ApplicationId {
    const val id = "com.ijays.composeit"
}

object Config {
    const val compileSDK = 31
    const val targetSDk = 31
    const val minSDK = 21
}

object Versions {
    const val kotlin = "1.6.10"
    const val jetpackCompose = "1.1.0"
}

object Androidx {
    const val coreKtx = "androidx.core:core-ktx:1.6.0"
    const val appcompat = "androidx.appcompat:appcompat:1.3.1"
    const val material = "com.google.android.material:material:1.4.0"
    const val lifecycleKtx = "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"
    const val livedataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:2.3.1"
    const val activityKtx = "androidx.activity:activity-ktx:1.3.1"

    const val composeUI = "androidx.compose.ui:ui:${Versions.jetpackCompose}"
    const val composeUITooling = "androidx.compose.ui:ui-tooling:${Versions.jetpackCompose}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.jetpackCompose}"
    const val composeLiveData =
        "androidx.compose.runtime:runtime-livedata:${Versions.jetpackCompose}"
    const val activityCompose = "androidx.activity:activity-compose:1.3.1"
    const val composeConstraintLayout =
        "androidx.constraintlayout:constraintlayout-compose:1.0.0-rc01"

}

object Libraries {
    const val agp = "com.android.tools.build:gradle:7.0.3"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    const val coilCompose = "io.coil-kt:coil-compose:1.3.0"


}