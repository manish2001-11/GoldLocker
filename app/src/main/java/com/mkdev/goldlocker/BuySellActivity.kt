package com.mkdev.goldlocker

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.mkdev.goldlocker.adapter.ImagePagerAdapter
import com.mkdev.goldlocker.databinding.ActivityBuySellBinding
import com.mkdev.goldlocker.viewmodel.ImageViewModel
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class BuySellActivity : AppCompatActivity() {
    private lateinit var imageViewModel: ImageViewModel
    lateinit var binding: ActivityBuySellBinding
    lateinit var viewPager2: ViewPager2
    lateinit var dotsIndicator: DotsIndicator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

binding = ActivityBuySellBinding.inflate(layoutInflater)
        setContentView(binding.root)


        imageViewModel = ViewModelProvider(this).get(ImageViewModel::class.java)

        //observer
        imageViewModel.images.observe(this){images->
            val adapter = ImagePagerAdapter(images)
            binding.viewPagerSlider.adapter = adapter
            binding.dotsIndicator.setViewPager2(binding.viewPagerSlider)
        }



//        val timeValues = arrayOf("12:00 AM", "12:30 AM", "1:00 AM", "1:30 AM", "11:30 PM")
//
//        // Set up the ArrayAdapter for the Spinner
//        val adapter =
//            ArrayAdapter(this, android.R.layout.simple_spinner_item, timeValues)
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//
//        // val spinner: Spinner = findViewById(R.id.spinner)
//        binding.spinner.adapter = adapter


        val adapter = ArrayAdapter(
            this,
            R.layout.spinner_item,  // Custom layout for the selected item
            listOf("103.4%  growth in 5 years", "103.4%  growth in 5 years")
        )
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item)  // Custom layout for dropdown items
        binding.spinner.adapter = adapter

//     binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//        val selectedTime = timeValues[position]
//        // Do something with the selected time
//    }
//
//    override fun onNothingSelected(parent: AdapterView<*>?) {
//        // Handle nothing selected
//    }
//}
        binding.TotalGoldInLocker.setOnClickListener{
            val intent = Intent(this, GoldLockerActivity::class.java)
            startActivity(intent)
        }

    }

}