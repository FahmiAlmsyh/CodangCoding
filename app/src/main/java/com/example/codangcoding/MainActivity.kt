package com.example.codangcoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.codangcoding.adapter.ListPhoneAdapter
import com.example.codangcoding.databinding.ActivityMainBinding
import com.example.codangcoding.model.dataPhone

class MainActivity : AppCompatActivity() {

    private var list = ArrayList<dataPhone>()
    private lateinit var binding: ActivityMainBinding
    private lateinit var rvPhone: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvPhone = binding.rvMain
        rvPhone.setHasFixedSize(true)

        list.addAll(getListPhone())
        showRecycleView()
    }

    private fun showRecycleView() {
        rvPhone.layoutManager = LinearLayoutManager(this)

        val listPhoneAdapter = ListPhoneAdapter(list)
        rvPhone.adapter = listPhoneAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about -> {
                val intent = Intent(this, AboutMeActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return onOptionsItemSelected(item)
    }

    private fun getListPhone(): ArrayList<dataPhone> {
        val name = resources.getStringArray(R.array.name_phone)
        val detail = resources.getStringArray(R.array.detail_phone)
        val image = resources.obtainTypedArray(R.array.image_phone)
        val phones = ArrayList<dataPhone>()

        for (i in name.indices){
            val phone = dataPhone(
                name[i],
                detail[i],
                image.getResourceId(i,-1)
            )
            phones.addAll(listOf(phone))
        }
        return phones
    }
}