package com.github.javiersantos.materialstyleddialogs.demo

import android.app.Dialog
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDialogFragment
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.typeface.library.materialdesigniconic.MaterialDesignIconic

class AboutDialog : AppCompatDialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return MaterialStyledDialog.Builder(activity) //.setIcon(new IconicsDrawable(getActivity()).icon(MaterialDesignIconic.Icon.gmi_comment_alt).color(Color.WHITE))
            .setIcon(
                IconicsDrawable(
                    activity!!,
                    MaterialDesignIconic.Icon.gmi_comment_alt
                ).apply { iconicsDrawable: IconicsDrawable ->
                    iconicsDrawable.colorFilter = PorterDuffColorFilter(
                        Color.WHITE,
                        PorterDuff.Mode.DST_OVER
                    )
                    null
                }
            )
            .setTitle(R.string.app_name)
            .setDescription(R.string.app_description)
            .setPositiveText(android.R.string.ok)
            .build()
    }

    companion object {
        fun show(context: AppCompatActivity) {
            val dialog = AboutDialog()
            dialog.show(context.supportFragmentManager, "[ABOUT_DIALOG]")
        }
    }
}