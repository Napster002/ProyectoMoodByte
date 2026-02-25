package com.example.moodbyte.components.chatbotcomponents

import android.content.Context
import android.graphics.Bitmap
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.face.FaceDetection
import com.google.mlkit.vision.face.FaceDetectorOptions
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

class DetectorCara(context: Context) {

    private val detector = FaceDetection.getClient(
        FaceDetectorOptions.Builder()
            .setPerformanceMode(FaceDetectorOptions.PERFORMANCE_MODE_FAST)
            .build()
    )

    suspend fun hayCara(bitmap: Bitmap): Boolean {

        return suspendCancellableCoroutine { continuation ->

            val image = InputImage.fromBitmap(bitmap, 0)

            detector.process(image)
                .addOnSuccessListener { faces ->
                    continuation.resume(faces.isNotEmpty())
                }
                .addOnFailureListener {
                    continuation.resume(false)
                }
        }
    }
}