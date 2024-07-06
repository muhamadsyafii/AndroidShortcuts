/*
 * Created by Muhamad Syafii
 * Saturday, 6/7/2024
 * Copyright (c) 2024.
 * All Rights Reserved
 */

package id.syafii.androidshortcuts.presentation.ui.main

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import id.syafii.androidshortcuts.R
import id.syafii.androidshortcuts.R.id
import id.syafii.androidshortcuts.R.layout
import id.syafii.androidshortcuts.databinding.ActivityMainBinding
import id.syafii.androidshortcuts.utils.ShortcutsManager

class MainActivity : AppCompatActivity() {
  private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContentView(binding.root)
    ViewCompat.setOnApplyWindowInsetsListener(findViewById(id.main)) { v, insets ->
      val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
      v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
      insets
    }
    initViews()
  }

  private fun initViews() {
    setupToolbar()
    setupShortcuts()
    with(binding){
      tvName.text = getString(R.string.label_welcome)
    }
  }

  private fun setupShortcuts() {
    val shortcutsManager = ShortcutsManager(this@MainActivity)
    shortcutsManager.createShortcuts()
  }

  private fun setupToolbar() {
    with(binding.ilToolbar){
      tvTitle.text = getString(R.string.label_home)
    }
  }
}