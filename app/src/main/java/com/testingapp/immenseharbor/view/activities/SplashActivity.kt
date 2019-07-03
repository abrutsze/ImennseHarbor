package com.testingapp.immenseharbor.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.testingapp.immenseharbor.App
import com.testingapp.immenseharbor.R
import com.testingapp.immenseharbor.viewModel.SplashViewModel
import com.testingapp.immenseharbor.viewModel.ViewModelFactory
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit

class SplashActivity : AppCompatActivity() {

    var compositeDisposable = CompositeDisposable();

    private lateinit var viewModel: SplashViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        with(applicationContext as App) {
            viewModel = androidx.lifecycle.ViewModelProviders.of(this@SplashActivity,
                ViewModelFactory(this)
            ).get(SplashViewModel::class.java)
        }


        initObserver()
        compositeDisposable.add(Completable.timer(2,TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe({

            viewModel.registered()
        },{}))
    }

    private fun initObserver(){
        viewModel.registerResult.observe(this, Observer {

            if (it==0){
                openLoginActivity()
            }else{
                openMainActivity()
            }
        })


    }
    private fun openLoginActivity(){
        var intent = LoginActivity.newIntent(this)
        startActivity(intent)
        finish()
    }

    private fun openMainActivity(){
        var intent = MainActivity.newIntent(this)
        startActivity(intent)
        finish()
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        viewModel.dispose()
        super.onDestroy()
    }
}