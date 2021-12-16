package com.example.clonegrab.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.clonegrab.model.DataModel
import java.lang.Exception

class SQLiteHelper(context: Context) : SQLiteOpenHelper(
    context,
    DATABASE_NAME, null,
    DATABASE_VERSION
) {
    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "MyData.db"
        private const val TBL_DATA = "tbl_data"
        private const val ID = "id"
        private const val NAME = "name"
        private const val GAME = "game"
        private const val EMAIL = "email"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTblData = ("CREATE TABLE " + TBL_DATA + "("
                + ID + " INTEGER PRIMARY KEY,"
                + NAME + " TEXT,"
                + GAME + " TEXT,"
                + EMAIL + " TEXT" + ")")

        db?.execSQL(createTblData)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TBL_DATA")
    }

    fun insertData(data: DataModel): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(ID, data.id)
        contentValues.put(NAME, data.name)
        contentValues.put(GAME, data.game)
        contentValues.put(EMAIL, data.email)

        val success = db.insert( TBL_DATA, null, contentValues)
        db.close()
        return success
    }

    fun getAllData(): ArrayList<DataModel> {
        val dataList: ArrayList<DataModel> = ArrayList()
        val selectQury = "SELECT * FROM $TBL_DATA"
        val db = this.readableDatabase

        val cursor: Cursor?

        try {
            cursor = db.rawQuery(selectQury, null)
        } catch (e: Exception) {
            e.printStackTrace()
            db.execSQL(selectQury)
            return ArrayList()
        }
        var id : Int
        var name : String
        var game : String
        var email : String

        if (cursor.moveToFirst()){
            Log.d("Main_cursor",cursor.moveToFirst().toString())
            do {
                id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
                name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
                game = cursor.getString(cursor.getColumnIndexOrThrow("game"))
                email = cursor.getString(cursor.getColumnIndexOrThrow("email"))

                val data = DataModel(id = id , name = name , game = game ,email = email)
                dataList.add(data)
            }while (cursor.moveToNext())
        }
        return dataList
    }
    fun updateData(data: DataModel):Int{
        val db = this.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(ID, data.id)
        contentValues.put(NAME, data.name)
        contentValues.put(GAME, data.game)
        contentValues.put(EMAIL, data.email)

        val success = db.update( TBL_DATA, contentValues,"id="+data.id,null)
        db.close()
        return success
    }
}