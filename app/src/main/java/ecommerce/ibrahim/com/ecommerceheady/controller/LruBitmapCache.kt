package ecommerce.ibrahim.com.ecommerceheady.controller

import android.graphics.Bitmap
import android.util.LruCache
import com.android.volley.toolbox.ImageLoader


/**
 * Created by Ibrahim on 17-01-2019.
 */
internal class LruBitmapCache @JvmOverloads constructor(sizeInKiloBytes: Int = defaultLruCacheSize) : LruCache<String, Bitmap>(sizeInKiloBytes), ImageLoader.ImageCache {

    protected override fun sizeOf(key: String, value: Bitmap): Int {
        return value.rowBytes * value.height / 1024
    }

    override fun getBitmap(url: String): Bitmap {
        return get(url)
    }

    override fun putBitmap(url: String, bitmap: Bitmap) {
        put(url, bitmap)
    }

    companion object {
        val defaultLruCacheSize: Int
            get() {
                val maxMemory = (Runtime.getRuntime().maxMemory() / 1024).toInt()

                return maxMemory / 8
            }
    }
}