package crew8.project.nito.view.home.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import crew8.project.nito.R
import crew8.project.nito.databinding.ActivityHomeBinding
import crew8.project.nito.model.datamodel.Paper
import crew8.project.nito.model.datamodel.Teacher
import crew8.project.nito.view.home.adapter.HomePapersAdapter
import crew8.project.nito.view.home.adapter.HomeTeachersAdapter
import crew8.project.nito.viewModel.home.HomeViewModel
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {


    lateinit var userModel : HomeViewModel
    lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.home = userModel






        imageview_navigation.setOnClickListener {
            drawer_layout.openDrawer(GravityCompat.END,true)
        }


    }

    override fun onStart() {
        super.onStart()

        userModel.init()



        userModel.getTeachersFromServer().observe(this, Observer<ArrayList<Teacher>> {
            it?.let { result ->
                var homeTeachersAdapter = HomeTeachersAdapter(result, this)
                recyclerView_teachers.adapter= homeTeachersAdapter
                homeTeachersAdapter.setOnItemClickListener(object : HomeTeachersAdapter.ClickListener {
                    override fun onClick(teacher: Teacher, aView: View) {

                    }
                })
            }
        })




        userModel.getPapersFromServer().observe(this, Observer<ArrayList<Paper>> {
            it?.let { result ->
                var homePapersAdapter = HomePapersAdapter(result, this)

                recyclerView_papers.adapter= homePapersAdapter
                homePapersAdapter.setOnItemClickListener(object : HomePapersAdapter.ClickListener {
                    override fun onClick(paper: Paper, aView: View) {

                    }
                })
            }
        })



    }
}
