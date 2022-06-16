package com.example.prakt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.prakt.databinding.ActivityMainBinding
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnOpen.setOnClickListener {

            val disp = App.dm.api
                .checkStudent(
                    binding.fam.text.toString(),
                    binding.name.text.toString(),
                    binding.otche.text.toString(),
                    binding.group.text.toString()
                )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it == "valid"){
                        App.dm.setFam(binding.fam.text.toString())
                        App.dm.setName(binding.name.text.toString())
                        App.dm.setOtche(binding.otche.text.toString())
                        App.dm.setGroup(binding.group.text.toString())
                        startActivity(Intent(this, SecondActivity::class.java))
                    }
                    else {
                        Toast.makeText(this, "Не правильно введены данные", Toast.LENGTH_SHORT).show()
                    }
                }, {

                })

        }
    }
}