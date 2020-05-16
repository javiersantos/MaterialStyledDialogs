package com.github.javiersantos.materialstyleddialogs.demo

import android.app.Dialog
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDialogFragment
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.typeface.library.materialdesigniconic.MaterialDesignIconic
import com.mikepenz.iconics.utils.colorInt

class AboutDialog : AppCompatDialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return MaterialStyledDialog.Builder(requireContext())
            .setIcon(
                IconicsDrawable(activity!!, MaterialDesignIconic.Icon.gmi_comment_alt).apply {
                    colorInt = Color.WHITE
                }
            )
            .setTitle(R.string.app_name)
            .setDescription(R.string.app_description)
            .setPositiveText(android.R.string.ok)
            .build()
    }

    companion object {
        fun show(context: AppCompatActivity) =
            AboutDialog().show(context.supportFragmentManager, "[ABOUT_DIALOG]")
    }
}