package com.example.gimal

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.gimal.databinding.ActivityDbBinding

class DbActivity : AppCompatActivity() {

    val binding by lazy { ActivityDbBinding.inflate(layoutInflater) }

    lateinit var myHelper: myDBHelper
    lateinit var sqlDB: SQLiteDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)
        myHelper = myDBHelper(this)
        binding.btnInit.setOnClickListener {
            sqlDB = myHelper.writableDatabase
            myHelper.onUpgrade(sqlDB, 1, 2) // 인수는 아무거나 입력하면 됨.
            sqlDB.close()
            binding.btnSelect.callOnClick()
        }
        binding.btnInsert.setOnClickListener {
            sqlDB = myHelper.writableDatabase
            sqlDB.execSQL("INSERT INTO groupTBL VALUES ( '"
                    + binding.edtName.text.toString() + "' , '"
                    + binding.edtNumber.text.toString() + "' , "
                    + binding.edtDay.text.toString() + ");")
            sqlDB.close()
            Toast.makeText(applicationContext, "입력됨", Toast.LENGTH_SHORT).show()
            binding.btnSelect.callOnClick()
        }
        binding.btnSelect.setOnClickListener {

            sqlDB = myHelper.readableDatabase
            var cursor: Cursor
            cursor = sqlDB.rawQuery("SELECT * FROM groupTBL;", null)

            var strNames = "물품이름" + "\r\n" + "--------" + "\r\n"
            var strNumbers = "개수" + "\r\n" + "--------" + "\r\n"
            var strDays = "유통기한" + "\r\n" + "--------" + "\r\n"

            while (cursor.moveToNext()) {
                strNames += cursor.getString(0) + "\r\n"
                strNumbers += cursor.getString(1) + "\r\n"
                strDays += cursor.getString(2) + "\r\n"
            }

            binding.edtNameResult.setText(strNames)
            binding.edtNumberResult.setText(strNumbers)
            binding.edtDayResult.setText(strDays)

            cursor.close()
            sqlDB.close()
        }

        /*
        binding.btnUpdate.setOnClickListener {
            sqlDB = myHelper.writableDatabase
            if (binding.edtName.text.toString() !== "") {
                sqlDB.execSQL("UPDATE groupTBL SET gNumber ='"
                        + binding.edtNumber.text + "' WHERE gName = '"
                        + binding.edtName.text + "' WHERE gDay = '"
                        + binding.edtDay.text.toString() + "';")
            }
            sqlDB.close()

            Toast.makeText(applicationContext, "수정됨", Toast.LENGTH_SHORT).show()
            binding.btnSelect.callOnClick()
        }
        */

        binding.btnDelete.setOnClickListener {
            sqlDB = myHelper.writableDatabase
            if (binding.edtName.text.toString() !== "") {
                sqlDB.execSQL("DELETE FROM groupTBL WHERE gName = '"
                        + binding.edtName.text.toString() + "';")
            }
            sqlDB.close()

            Toast.makeText(applicationContext, "삭제됨", Toast.LENGTH_SHORT).show()
            binding.btnSelect.callOnClick()
        }
    }
    inner class myDBHelper(context: Context) : SQLiteOpenHelper(context, "groupDB", null, 1) {

        override fun onCreate(p0: SQLiteDatabase?) {
            p0!!.execSQL("CREATE TABLE  groupTBL ( gName CHAR(20) PRIMARY KEY, gNumber INTEGER, gDay CHAR(20));")
        }

        override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
            p0!!.execSQL("DROP TABLE IF EXISTS groupTBL")
            onCreate(p0)
        }
    }
}