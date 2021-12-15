package com.example.convidados.service.repository

import com.example.convidados.service.model.GuestModel
import java.util.ArrayList

class GuestRepository {

    fun getAll():List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()
        return list
    }

    fun save(guest: GuestModel){

    }
}