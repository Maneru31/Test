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

//            System.out.println(binding.fio.text.toString())
//            System.out.println(binding.number.text.toString())
//            System.out.println(it) проверка то что данные вводятся

            val disp = App.dm.api
                .checkStudent(
                    binding.fio.text.toString(),
                    binding.number.text.toString()
                )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    if (it == "valid"){
                        App.dm.setFio(binding.fio.text.toString())
                        App.dm.setNumOfStudent(binding.number.text.toString())
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