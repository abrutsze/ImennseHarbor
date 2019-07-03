package com.testingapp.immenseharbor.view.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.testingapp.immenseharbor.R
import com.testingapp.immenseharbor.data.models.Department
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_detail.recyclerView
import timber.log.Timber

class DetailActivity : AppCompatActivity() {

    lateinit var department: Department

    companion object{
        fun newIntent(context: Context): Intent {
            return Intent(context, DetailActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        department = intent.getParcelableExtra("department")
        Timber.e(department.toString())

        address.text = "${department.location?.streetAddress} ${department.location?.city} ${department.location?.stateProvince} ${department.location?.postalCode} ${department.location?.country?.countryName}"

        initRecycler()
        val toolbar = findViewById<Toolbar>(R.id.toolbar_main)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    private fun initRecycler(){
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false) as RecyclerView.LayoutManager?

        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
