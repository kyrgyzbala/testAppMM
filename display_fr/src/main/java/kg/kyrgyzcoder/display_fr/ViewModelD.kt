package kg.kyrgyzcoder.display_fr

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelD : ViewModel() {

    private var _value = MutableLiveData<Int>()
    val value = _value

    fun changeValue(newValue: Int) {
        _value.value = newValue
    }

    fun getBitmapProgress(value: Int): Bitmap {
        val width = 1000 // (200 / 0.2).toInt()
        val height = 1000 // (200 / 0.2).toInt()
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        canvas.drawColor(Color.TRANSPARENT)
        val marginTop = width * ((100f - value.toFloat()) / 100f)
        val height2 = (height - marginTop)
        if (height2 != 0f) {
            val bitmap2 =
                Bitmap.createBitmap(width, height2.toInt(), Bitmap.Config.ARGB_8888)
            val canvas2 = Canvas(bitmap2)
            canvas2.drawColor(Color.BLUE)
            canvas.drawBitmap(bitmap2, 0f, marginTop, Paint())
        }
        return bitmap
    }

}