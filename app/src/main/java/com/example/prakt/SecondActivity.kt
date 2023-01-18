package com.example.prakt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.prakt.databinding.ActivitySecondBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.text.SimpleDateFormat
import java.util.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fio = App.dm.getFio()
        val name = App.dm.getNumOfStudent()

        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date()) //время хз как поставить в .request :/

        var addres = binding.spinnerAdress.selectedItem.toString()



        binding.fio.text = fio

        println(fio)
        println(name)
        System.out.println(currentDate)// проверочка

        binding.btnRequest.setOnClickListener {

            addres = binding.spinnerAdress.selectedItem.toString()

            if (binding.count.text.toString() < "0" && binding.count.text.toString() > "6") {
                Toast.makeText(this, "Укажите количество", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(this, "completed", Toast.LENGTH_SHORT).show()
                println(binding.count.text.toString())
                val dps = App.dm.api
                    .request(
                        binding.fio.text.toString(),
                        binding.count.text.toString(),
                        currentDate.toString(), //мб сработает?
                        binding.spinnerAdress.toString()
                    )
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
                    }, {
                        Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                        println(it.message)
                    })
            }
        }

    }
}