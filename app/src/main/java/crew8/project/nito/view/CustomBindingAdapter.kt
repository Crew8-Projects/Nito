package crew8.project.nito.view


import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso


object CustomBindingAdapter {


    @BindingAdapter("image_url")
    @JvmStatic
    fun loadImage(view: ImageView, url: String) {
        Picasso.get().load(url).into(view)
    }
}