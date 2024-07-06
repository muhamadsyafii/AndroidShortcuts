package id.syafii.androidshortcuts.presentation.ui.movie

/*
 * Created by Muhamad Syafii
 * Saturday, 6/7/2024
 * Copyright (c) 2024.
 * All Rights Reserved
 */

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import id.syafii.androidshortcuts.R
import id.syafii.androidshortcuts.R.string
import id.syafii.androidshortcuts.databinding.ActivityMovieBinding

class MovieActivity : AppCompatActivity() {
  private val binding by lazy { ActivityMovieBinding.inflate(layoutInflater) }
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContentView(binding.root)
    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
      val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
      v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
      insets
    }

    initViews()
  }

  private fun initViews() {
    setupToolbar()
  }

  private fun setupToolbar() {
    with(binding.ilToolbar){
      tvTitle.text = getString(string.shortcut_one_short_label)
    }
  }
}