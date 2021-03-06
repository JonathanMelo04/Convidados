package com.example.convidados.service.repository

import android.content.ContentValues
import android.content.Context
import com.example.convidados.service.constants.DataBaseConstants
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

    fun save(guest: GuestModel): Boolean {

        return try {

            val db = mGuestDataBaseHelper.writableDatabase

            val contentValues = ContentValues()
            contentValues.put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.name)
            contentValues.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, guest.presence)

            db.insert(DataBaseConstants.GUEST.TABLE_NAME, null, contentValues)
            true
        } catch (e: Exception){
            false
        }
    }

    fun update(guest: GuestModel): Boolean {

        return try {

            val db = mGuestDataBaseHelper.writableDatabase

            val contentValues = ContentValues()
            contentValues.put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.name)
            contentValues.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, guest.presence)

            val selection = DataBaseConstants.GUEST.COLUMNS.ID + " = ? "
            val args = arrayOf(guest.id.toString())
            db.update(DataBaseConstants.GUEST.TABLE_NAME, contentValues, selection, args)

            true
        } catch (e: Exception){
            false
        }

    }

    fun delete(guest: GuestModel){

    }

    // CRUD - Create, Read, Update, Delete
}