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
import crew8.project.nito.R
import crew8.project.nito.model.datamodel.Paper
import crew8.project.nito.model.datamodel.Teacher
import kotlinx.android.synthetic.main.listview_papers.view.*
import kotlinx.android.synthetic.main.listview_teachers.view.*
import kotlinx.android.synthetic.main.listview_teachers.view.img_home_teacher

class HomePapersAdapter(val items: ArrayList<Paper>, val context: Context) :
    RecyclerView.Adapter<HomePapersAdapter.ViewHolderHomePapers>() {

    lateinit var mClickListener: ClickListener

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderHomePapers {
        return ViewHolderHomePapers(LayoutInflater.from(context).inflate(R.layout.listview_papers, parent, false))

    }

    override fun onBindViewHolder(holder: ViewHolderHomePapers, position: Int) {
        var itemPostion = items[position]

        holder.textviewName.text = itemPostion.paperName
        holder.textviewType.text = itemPostion.paperType
        holder.textviewTime.text = itemPostion.paperTime



        val requestOptions = RequestOptions()
        requestOptions.placeholder(R.drawable.ic_profile_users)
        requestOptions.centerCrop()
        requestOptions.error(R.drawable.ic_profile_users)


        val requestListener = object :
            RequestListener<Bitmap> { override fun onLoadFailed(e: GlideException?, model: Any, target: Target<Bitmap>, isFirstResource: Boolean): Boolean {
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
            .load(itemPostion.paperCoverImage)
            .apply(requestOptions)
            .listener(requestListener)
            .into(holder.imageViewCover)


    }


    fun setOnItemClickListener(aClickListener: ClickListener) {
        mClickListener = aClickListener
    }

    interface ClickListener {
        fun onClick(paper: Paper, aView: View)
    }

    inner class ViewHolderHomePapers(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val textviewName = view.textview_home_paper_name
        val textviewType = view.textview_home_paper_type
        val textviewTime = view.textview_home_paper_time

        val imageViewCover = view.img_home_papers

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            mClickListener.onClick(items[adapterPosition], p0!!)
        }
    }
}