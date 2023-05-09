package com.example.gimal

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.gimal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)

        setContentView(binding.root)

        binding.button.setOnClickListener {
            if (binding.edT1.text.toString().trim() == "")
                Toast.makeText(applicationContext, "동물의 이름을 입력하세요!", Toast.LENGTH_SHORT).show()
            else if (binding.edT2.text.toString().trim() == "")
                Toast.makeText(applicationContext, "동물의 나이를 입력하세요!!", Toast.LENGTH_SHORT).show()
            else {
                val intent = Intent(applicationContext, TitleActivity::class.java)
                intent.putExtra("from1", binding.edT1.text.toString())
                intent.putExtra("from2", binding.edT2.text.toString().toInt())
                startActivity(intent)
            }
        }
    }

    //옵션 메뉴
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)
        var mInflater = menuInflater
        mInflater.inflate(R.menu.menu1, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.item_1-> {
                binding.image.rotation = -30f
                return true
            }
            R.id.item_2-> {
                binding.image.rotation = 0f
                return true
            }
            R.id.item_3-> {
                binding.image.rotation = 30f
                return true
            }
        }

        return false
    }
}