package crew8.project.nito.view.home.adapter

import android.content.Context
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.squareup.picasso.Picasso
import crew8.project.nito.R
import crew8.project.nito.model.datamodel.Teacher
import kotlinx.android.synthetic.main.listview_teachers.view.*

class HomeTeachersAdapter(val items: ArrayList<Teacher>, val context: Context) :
    RecyclerView.Adapter<HomeTeachersAdapter.ViewHolderHomeTeachers>() {

    lateinit var mClickListener: ClickListener

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderHomeTeachers {
        return ViewHolderHomeTeachers(LayoutInflater.from(context).inflate(R.layout.listview_teachers, parent, false))

    }

    override fun onBindViewHolder(holder: ViewHolderHomeTeachers, position: Int) {
        var itemPostion = items[position]

        holder.textviewName.text = itemPostion.teacherName
        holder.textviewSubject.text = itemPostion.teacherSubject
        holder.textviewClass.text = itemPostion.teacherYear

        val requestOptions = RequestOptions()
        requestOptions.placeholder(R.drawable.ic_profile_users)
        requestOptions.centerCrop()
        requestOptions.error(R.drawable.ic_profile_users)


        val requestListener = object : RequestListener<Bitmap> { override fun onLoadFailed(e: GlideException?, model: Any, target: Target<Bitmap>, isFirstResource: Boolean): Boolean {
                return false
            }
            override fun onResourceReady(
                resource: Bitmap,
                model: Any,
                target: Target<Bitmap>,
                dataSource: DataSource,
                isFirstResource: Boolean
            ): Boolean {
                return false
            }
        }

        Glide.with(context)
            .asBitmap()
            .load(itemPostion.teacherCoverImage)
            .apply(requestOptions)
            .listener(requestListener)
            .into(holder.imageViewCover)



        /*  val requestOptions = RequestOptions()
          requestOptions.placeholder(R.drawable.ic_profile_users)
          requestOptions.error(R.drawable.ic_profile_users)

          val requestListener = object : RequestListener<Bitmap> {
              override fun onLoadFailed(
                 e: GlideException?,
                  model: Any,
                  target: Target<Bitmap>,
                  isFirstResource: Boolean
              ): Boolean {
                  return false
              }
              override fun onResourceReady(
                  resource: Bitmap,
                  model: Any,
                  target: Target<Bitmap>,
                  dataSource: DataSource,
                  isFirstResource: Boolean
              ): Boolean {
                  return false
              }
          }


          Glide.with(context)
              .asBitmap()
              .load(itemPostion.teacherCoverImage)
              .apply(requestOptions)
              .listener(requestListener)
              .into(holder.imageViewCover)
  */





    }


    fun setOnItemClickListener(aClickListener: ClickListener) {
        mClickListener = aClickListener
    }

    interface ClickListener {
        fun onClick(teacher: Teacher, aView: View)
    }

    inner class ViewHolderHomeTeachers(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val textviewName = view.textview_home_teachername
        val textviewSubject = view.textview_home_teachersubject
        val textviewClass = view.textview_home_teacherclass

        val imageViewCover = view.img_home_teacher

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            mClickListener.onClick(items[adapterPosition], p0!!)
        }
    }
}