package io.github.xororz.localdream.data

import android.content.Context
import java.io.File

/**
 * The DiT engine (libdit_engine.so) that runs Z-Image Turbo, FLUX.2/Klein and
 * Qwen Image 2.1.
 *
 * It ships inside the APK alongside the backend executable, so it lands in
 * nativeLibraryDir and the core dlopens it from there. Its FastRPC skels are
 * APK assets copied to the shared runtime directory by BackendService.
 */
object DitEngine {
    const val ENGINE_LIB = "libdit_engine.so"

    @Suppress("FunctionOnlyReturningConstant")
    fun isSupportedDevice(): Boolean = true

    /** Directory holding the engine, i.e. the app's native library directory. */
    fun dir(context: Context): File = File(context.applicationInfo.nativeLibraryDir)

    fun isInstalled(context: Context): Boolean = File(dir(context), ENGINE_LIB).exists()
}
