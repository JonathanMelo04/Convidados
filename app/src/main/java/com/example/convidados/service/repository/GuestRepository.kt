package com.example.convidados.service.repository

import android.content.Context
import com.example.convidados.service.model.GuestModel
import java.util.ArrayList

class GuestRepository private constructor(context: Context) {

    private var mGuestDataBaseHelper: GuestDataBaseHelper = GuestDataBaseHelper(context)

    companion object {

        private lateinit var repository: GuestRepository

        fun getInstance(context: Context): GuestRepository {

            if (!::repository.isInitialized) {
                repository = GuestRepository(context)
            }
            return GuestRepository(context)
        }
    }

    fun getAll():List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()
        return list
    }

    fun getPresent():List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()
        return list
    }

    fun getAbsent():List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()
        return list
    }

    fun save(guest: GuestModel){

    }

    fun update(guest: GuestModel){

    }

    fun delete(guest: GuestModel){

    }

    // CRUD - Create, Read, Update, Delete
}