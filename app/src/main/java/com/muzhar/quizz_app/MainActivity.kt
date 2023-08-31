package com.muzhar.quizz_app

import android.app.ProgressDialog.show
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.CompoundButton
import android.widget.CompoundButton.OnCheckedChangeListener
import android.widget.RadioButton
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.muzhar.quizz_app.databinding.ActivityMainBinding

class MainActivity :
    AppCompatActivity() {


    lateinit var binding: ActivityMainBinding

    var bamboobiyani:String =""
    var paymentMethod:String =""
    var isPayementSelected = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bambooSwitch.setOnCheckedChangeListener { btnView, isChecked ->

            if (isChecked) {
                bamboobiyani = btnView.text.toString()
                Toast.makeText(this, "${btnView.text}", Toast.LENGTH_SHORT).show()
            } else {
                bamboobiyani=""
                Toast.makeText(this, "Not Checked", Toast.LENGTH_SHORT).show()
            }


        }
        binding.paymentGrp.setOnCheckedChangeListener{grp,btnid ->

            isPayementSelected = true

            when(btnid){
                R.id.cash -> {
                    toast("Cash Clicked")

                    paymentMethod=binding.cash.text.toString()
                }

                R.id.card -> {
                    toast("Card Clicked")
                    paymentMethod=binding.card.text.toString()
                }
            }


        }

        binding.submitbtn.setOnClickListener { v ->
            var name:String = binding.nameEdt.text.toString()

            if(name.isEmpty()){
                binding.nameEdt.error="Name field needed!"
            } else if(!isPayementSelected){
               toast("You have to select a payment a option")
            }
            else{
                toast(name)

                var intent = Intent(this, DetailsActivity::class.java)

                intent.putExtra("name", name)
                intent.putExtra("bm", bamboobiyani)
                intent.putExtra("pmnt", paymentMethod)



                startActivity(intent)
            }


        }


    }

}






