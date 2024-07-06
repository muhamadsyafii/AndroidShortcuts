/*
 * Created by Muhamad Syafii
 * Saturday, 6/7/2024
 * Copyright (c) 2024.
 * All Rights Reserved
 */

package id.syafii.androidshortcuts.utils

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.core.content.pm.ShortcutManagerCompat
import androidx.core.graphics.drawable.IconCompat
import id.syafii.androidshortcuts.R
import id.syafii.androidshortcuts.presentation.ui.movie.MovieActivity

class ShortcutsManager(private val context: Context) {
  companion object {
    const val SHORTCUT_ONE_ID = "shortcut_one_id"
    const val SHORTCUT_TWO_ID = "shortcut_two_id"
  }

  fun createShortcuts() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
      val listOfShortcuts = getShortcutsList()
      ShortcutManagerCompat.setDynamicShortcuts(context, listOfShortcuts)
    }
  }

  @RequiresApi(Build.VERSION_CODES.N_MR1)
  private fun getShortcutsList(): List<ShortcutInfoCompat> {
    val shortcutOne = buildShortcut(
      id = SHORTCUT_ONE_ID,
      shortLabel = context.getString(R.string.shortcut_one_short_label),
      longLabel = context.getString(R.string.shortcut_one_long_label),
      intent = Intent(context, MovieActivity::class.java).apply {
        action = Intent.ACTION_VIEW
      },
      shortcutIcon = R.drawable.ic_shortcut_one
    )


    return listOf(shortcutOne)
  }


  @RequiresApi(Build.VERSION_CODES.N_MR1)
  private fun buildShortcut(
    id: String,
    shortLabel: String,
    longLabel: String,
    intent: Intent,
    shortcutIcon: Int
  ): ShortcutInfoCompat {
    return ShortcutInfoCompat.Builder(context, id)
      .setShortLabel(shortLabel)
      .setLongLabel(longLabel)
      .setIntent(intent)
      .setIcon(IconCompat.createWithResource(context, shortcutIcon))
      .build()
  }
}