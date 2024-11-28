package com.mkdev.goldlocker

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.mkdev.goldlocker.adapter.ImagePagerAdapter
import com.mkdev.goldlocker.databinding.ActivityGoldLockerBinding
import com.mkdev.goldlocker.viewmodel.ImageViewModel

class GoldLockerActivity : AppCompatActivity() {
    lateinit var binding: ActivityGoldLockerBinding
    private lateinit var imageViewModel: ImageViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGoldLockerBinding.inflate(layoutInflater)
        setContentView(binding.root)



        imageViewModel = ViewModelProvider(this).get(ImageViewModel::class.java)

        //observer
        imageViewModel.images.observe(this){images->
            val adapter = ImagePagerAdapter(images)
            binding.viewPagerSlider.adapter = adapter
            binding.dotsIndicator.setViewPager2(binding.viewPagerSlider)
        }

    }
}