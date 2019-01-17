package ecommerce.ibrahim.com.ecommerceheady

import android.app.Application
import com.android.volley.toolbox.ImageLoader
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import ecommerce.ibrahim.com.ecommerceheady.controller.VolleyController


/**
 * Created by Ibrahim on 17-01-2019.
 */
class AppController: Application(){
    private var mInstance: AppController? = null
    override fun onCreate() {
        super.onCreate()
        mInstance = this
        VolleyController.getInstance(this).getRequestQueue()
        VolleyController.getInstance(this).getImageLoader()
    }

    @Synchronized
    fun getInstance(): AppController? {
        return mInstance
    }




}