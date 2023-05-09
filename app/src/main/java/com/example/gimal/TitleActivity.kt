package com.example.gimal

import android.R
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.gimal.databinding.ActivityTitleBinding

class TitleActivity : AppCompatActivity() {

    val binding by lazy { ActivityTitleBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_title)
        setContentView(binding.root)

        binding.name.text = intent.getStringExtra("from1") // 문자열 처리할 땐 간단하게 이렇게
        binding.age.text = "${intent.getIntExtra("from2",0)}" // 정수형은 ${}로 한번 처리해줘야함, 디폴트값 정해줘야함

        // 토스트로 동물 이름 안내
        Toast.makeText(applicationContext,"고마워 ${binding.name.text}아!", Toast.LENGTH_SHORT).show()

        // 스피너로 동물 종 선택
        var data = listOf("선택하세요", "강아지", "고양이", "물고기", "파충류", "새", "기타")
        var adapter = ArrayAdapter<String>(this, R.layout.simple_list_item_1, data)
        binding.spinner.adapter = adapter
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                binding.tvresult.text = data.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        binding.btn1.setOnClickListener {
            var vArray = arrayOf("${binding.name.text}는 건강합니다", "${binding.name.text}은 병원에 있습니다", "${binding.name.text}는 외출중입니다")
            var dlg = AlertDialog.Builder(this@TitleActivity)
            dlg.setTitle("${binding.name.text}의 현재 상태는 어떤가요?")
            dlg.setItems(vArray) {dialog, which ->
                binding.btn1.text = vArray[which]
            }
            dlg.setPositiveButton("닫기", null)
            dlg.show()
        }

        binding.btn2.setOnClickListener {
            val intent = Intent(applicationContext, DbActivity::class.java)
            startActivity(intent)
        }
    }
}