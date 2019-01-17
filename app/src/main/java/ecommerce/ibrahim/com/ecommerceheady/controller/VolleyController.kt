package ecommerce.ibrahim.com.ecommerceheady.controller

import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.toolbox.ImageLoader
import com.android.volley.toolbox.Volley
import ecommerce.ibrahim.com.ecommerceheady.AppController


/**
 * Created by Ibrahim on 17-01-2019.
 */
class VolleyController private constructor(var context: Context?) {

    val url = "https://stark-spire-93433.herokuapp.com/json"

    var mRequestQueue: RequestQueue? = null
    private var mImageLoader: ImageLoader? = null

    // instance method static
    companion object :SingletonHolder<VolleyController, Context>(:: VolleyController)

    fun getRequestQueue(): RequestQueue? {
        if (mRequestQueue == null) {
            // getApplicationContext() is key. It should not be activity context,
            // or else RequestQueue won't last for the lifetime of your app
            mRequestQueue = Volley.newRequestQueue(context!!.applicationContext)
        }
        return mRequestQueue
    }

    init {
        mRequestQueue = getRequestQueue()
    }


    fun getImageLoader(): ImageLoader? {
        getRequestQueue()
        if (mImageLoader == null) {
            mImageLoader = ImageLoader(this.mRequestQueue,
                    LruBitmapCache())
        }
        return this.mImageLoader
    }

}