package com.example.prakt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.prakt.databinding.ActivitySecondBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fam = App.dm.getFam()
        val name = App.dm.getName()
        val otche = App.dm.getOtche()
        val group = App.dm.getGroup()

        binding.fam2.text = fam
        binding.name2.text = name
        binding.otche2.text = otche
        binding.group2.text = group

        binding.btnRequest.setOnClickListener {

            if (binding.count.text.toString() == "0") {
                Toast.makeText(this, "Укажите количество", Toast.LENGTH_SHORT).show()

            } else {
                val dps = App.dm.api
                    .request(
                        binding.fam2.text.toString(),
                        binding.name2.text.toString(),
                        binding.otche2.text.toString(),
                        binding.group2.text.toString(),
                        binding.count.text.toString().toInt()
                    )
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
                    }, {

                    })
            }
        }

    }
}