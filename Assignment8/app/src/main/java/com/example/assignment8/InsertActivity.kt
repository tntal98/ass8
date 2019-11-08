package com.example.assignment8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_insert.*
import kotlinx.android.synthetic.main.activity_insert.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InsertActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)
    }
    fun btnaddemp(v: View){

        val api : EmployeeAPI = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EmployeeAPI ::class.java)

        var radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        var selectedId:Int = radioGroup.checkedRadioButtonId
        var radioButton: RadioButton = findViewById(selectedId)

        api.insertStd(

            nameEDT.text.toString(),
            radioButton.text.toString(),
            emailEDT.text.toString(),
            salaryEDT.text.toString().toInt()).enqueue(object : Callback<Employee> {

            override fun onResponse(call: Call<Employee>, response: retrofit2.Response<Employee>) {
                if (response.isSuccessful()){
                    Toast.makeText(applicationContext,"Successfully Inserted", Toast.LENGTH_SHORT).show()
                    finish()
                }else{
                    Toast.makeText(applicationContext,"Error ", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Employee>, t: Throwable) {
                Toast.makeText(applicationContext, "Error onFailure " + t.message, Toast.LENGTH_LONG).show()
            }
        })
    }
    fun btncancel(v:View){
        finish()
    }

}
