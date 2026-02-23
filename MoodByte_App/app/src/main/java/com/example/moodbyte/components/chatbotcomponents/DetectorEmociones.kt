package com.example.moodbyte.components.chatbotcomponents

import ai.onnxruntime.OnnxTensor
import ai.onnxruntime.OrtEnvironment
import ai.onnxruntime.OrtSession
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import java.nio.FloatBuffer
import java.util.*
import androidx.core.graphics.scale

class DetectorEmociones(context: Context) {

    private val env: OrtEnvironment = OrtEnvironment.getEnvironment()
    private val session: OrtSession

    private val emociones = arrayOf(
        "Enfadado",
        "Asco",
        "Miedo",
        "Feliz",
        "Triste",
        "Sorpresa",
        "Neutral"
    )

    init {
        val modelo = context.assets.open("emotion-ferplus-8.onnx").readBytes()
        session = env.createSession(modelo, OrtSession.SessionOptions())
    }

    fun detectar(bitmapOriginal: Bitmap): String {
        val resized = Bitmap.createScaledBitmap(bitmapOriginal, 64, 64, true)
            .copy(Bitmap.Config.ARGB_8888, false)

        val pixels = IntArray(64 * 64)
        resized.getPixels(pixels, 0, 64, 0, 0, 64, 64)

        val input = FloatArray(64 * 64)
        for (i in pixels.indices) {
            val pixel = pixels[i]
            val gray = (Color.red(pixel) + Color.green(pixel) + Color.blue(pixel)) / 3f / 255f
            input[i] = gray
        }

        val tensor = OnnxTensor.createTensor(env, FloatBuffer.wrap(input), longArrayOf(1, 1, 64, 64))
        val result = session.run(Collections.singletonMap("Input3", tensor))
        val outputTensor = result[0].value as Array<FloatArray>
        val output = outputTensor[0]

        var maxIndex = 0
        var maxValue = output[0]
        for (i in output.indices) {
            if (output[i] > maxValue) {
                maxValue = output[i]
                maxIndex = i
            }
        }

        return emociones[maxIndex]
    }
}