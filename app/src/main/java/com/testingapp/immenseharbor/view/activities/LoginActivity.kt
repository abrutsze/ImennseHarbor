package com.testingapp.immenseharbor.view.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import com.testingapp.immenseharbor.App
import com.testingapp.immenseharbor.R
import com.testingapp.immenseharbor.viewModel.LoginViewModel
import com.testingapp.immenseharbor.viewModel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_login.*
import timber.log.Timber

class LoginActivity : AppCompatActivity() {


    companion object{
        fun newIntent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }
    private lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        with(applicationContext as App) {
            viewModel = androidx.lifecycle.ViewModelProviders.of(this@LoginActivity,
                ViewModelFactory(this)
            ).get(LoginViewModel::class.java)
        }

        initObserver()
        login.setOnClickListener{

            if (userName.text!=null && password.text!=null)
                viewModel.login(userName.text.toString(),password.text.toString())

        }

        val toolbar = findViewById<Toolbar>(R.id.toolbar_login)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun initObserver(){
        viewModel.loginResult.observe(this, Observer {
            Timber.e(it.toString())
            var intent = MainActivity.newIntent(this)
            startActivity(intent)
            finish()
        })

        viewModel.loginError.observe(this, Observer {
            Timber.e(it)
            Toast.makeText(this,"error",Toast.LENGTH_LONG).show()
        })
    }
}