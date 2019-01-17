package ecommerce.ibrahim.com.ecommerceheady.model

/**
 * Created by Ibrahim on 17-01-2019.
 */
class Ranking{
    var ranking :String? = null
    var products :ArrayList<Product>? = null

    class Product{
        var id :Int? = 0
        var view_count :Int? = 0

    }
}