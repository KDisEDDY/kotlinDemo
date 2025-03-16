package com.eddyjyliu.modulea.ui

import android.content.Context
import android.graphics.*
import android.util.DisplayMetrics
import android.view.WindowManager
import android.widget.ImageView
import androidx.lifecycle.ViewModel
import com.eddyjyliu.modulea.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * ViewModel
 */
class AViewModel: ViewModel() {
    private lateinit var context: Context

    fun attachContext(context: Context) {
        this.context = context
    }


    public fun setImageBitmap(imageView: ImageView) {
        var bitmap: Bitmap? = null
        GlobalScope.launch(Dispatchers.Main) {
            val fileIs = context.resources.openRawResource(R.raw.long_image)
            val decoder = BitmapRegionDecoder.newInstance(fileIs, false)
            val displayMetrics = DisplayMetrics()
            (context.applicationContext.getSystemService(Context.WINDOW_SERVICE)
                    as? WindowManager)?.defaultDisplay?.getMetrics(displayMetrics)
            bitmap = getBitmapFromAssets(bitmap, decoder,
                displayMetrics.widthPixels, displayMetrics.heightPixels)
            imageView.setImageBitmap(bitmap)
//            findViewById<AppCompatImageView>(R.id.img).setImageBitmap(bitmap)
        }
    }

    private suspend fun getBitmapFromAssets(
        bitmap: Bitmap?,
        decoder: BitmapRegionDecoder,
        width: Int,
        height: Int
    ): Bitmap? {
        var bitmap1 = bitmap
        withContext(Dispatchers.IO) {
            val options = BitmapFactory.Options()
            bitmap1 = decoder.decodeRegion(
                Rect(
                    0, 0, width,
                    height
                ), options
            )
        }
        return bitmap1
    }
}