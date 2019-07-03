package com.testingapp.immenseharbor.view.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.testingapp.immenseharbor.App
import com.testingapp.immenseharbor.R
import com.testingapp.immenseharbor.data.models.Department
import com.testingapp.immenseharbor.view.adapters.DepartmentAdapter
import com.testingapp.immenseharbor.viewModel.MainViewModel
import com.testingapp.immenseharbor.viewModel.ViewModelFactory
import kotlinx.android.synthetic.main.app_bar_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity(), DepartmentAdapter.CallBack {


    private lateinit var viewModel: MainViewModel

    companion object{
        fun newIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        with(applicationContext as App) {
            viewModel = androidx.lifecycle.ViewModelProviders.of(this@MainActivity,
                ViewModelFactory(this)
            ).get(MainViewModel::class.java)
        }

        initRecycler()
        initObserver()

        viewModel.departments()
    }

    private fun initRecycler(){
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false) as RecyclerView.LayoutManager?
        }
    }
    private fun initObserver(){
        viewModel.departmentsResult.observe(this, Observer {
            Timber.e(it.toString())
            recyclerView.adapter = DepartmentAdapter(it,this)

        })

        viewModel.departmentsError.observe(this, Observer {
            Timber.e(it)
            Toast.makeText(this,"error", Toast.LENGTH_LONG).show()
        })
    }

    override fun onItemListener(department: Department) {
        var intent = DetailActivity.newIntent(this)
        intent.putExtra("department",department)
        startActivity(intent)
    }


    override fun onDestroy() {
        super.onDestroy()
        viewModel.dispose()
    }
}
