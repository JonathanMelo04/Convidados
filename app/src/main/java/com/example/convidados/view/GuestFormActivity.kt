package com.example.convidados.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.convidados.viewmodel.GuestFormViewModel
import com.example.convidados.R
import com.example.convidados.databinding.ActivityGuestFormBinding

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityGuestFormBinding
    private lateinit var mViewModel: GuestFormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGuestFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mViewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)

        setListeners()
        observe()
    }

    override fun onClick(v: View?) {
        val id = v!!.id
        if(id == R.id.button_save){

            val name = binding.editName.text.toString()
            val presence = binding.radioPresence.isChecked

            mViewModel.save(name, presence)

        }
    }

    private fun observe(){
        mViewModel.saveGuest.observe(this, Observer {
            if(it){
                Toast.makeText(applicationContext, "Sucesso" , Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext, "Falha" , Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setListeners(){
        binding.buttonSave.setOnClickListener(this)
    }
}