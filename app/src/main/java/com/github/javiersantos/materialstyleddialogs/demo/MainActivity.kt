package com.github.javiersantos.materialstyleddialogs.demo

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog
import com.github.javiersantos.materialstyleddialogs.enums.Style
import com.mikepenz.aboutlibraries.LibsBuilder
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.typeface.library.materialdesigniconic.MaterialDesignIconic

class MainActivity : AppCompatActivity() {
    private var context: Context? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this
        val toolbar =
            findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        //inflate view
        val inflater =
            getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val customView = inflater.inflate(R.layout.custom_view, null)
        val dismissButton =
            customView.findViewById<Button>(R.id.custom_button)

        // Build some dialogs for the sample app
        val dialogHeader_1: MaterialStyledDialog.Builder = MaterialStyledDialog.Builder(context)
            .setIcon(
                IconicsDrawable(context).icon(MaterialDesignIconic.Icon.gmi_google_play)
                    .color(Color.WHITE)
            )
            .withDialogAnimation(true)
            .setTitle("Awesome!")
            .setDescription("Glad to see you like MaterialStyledDialogs! If you're up for it, we would really appreciate you reviewing us.")
            .setHeaderColor(R.color.dialog_1)
            .setPositiveText("Google Play")
            .onPositive(object : SingleButtonCallback() {
                fun onClick(dialog: MaterialDialog, which: DialogAction) {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/apps/details?id=" + context.getPackageName())
                        )
                    )
                }
            })
            .setNegativeText("Later")
        val dialogHeader_2: MaterialStyledDialog.Builder = MaterialStyledDialog.Builder(context)
            .setIcon(
                IconicsDrawable(context).icon(MaterialDesignIconic.Icon.gmi_comment_alt)
                    .color(Color.WHITE)
            )
            .withIconAnimation(false)
            .setDescription("What can we improve? Your feedback is always welcome.")
            .setHeaderColor(R.color.dialog_2)
            .setPositiveText("Feedback")
            .onPositive(object : SingleButtonCallback() {
                fun onClick(dialog: MaterialDialog, which: DialogAction) {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://github.com/javiersantos/MaterialStyledDialogs/issues")
                        )
                    )
                }
            })
            .setNegativeText("Not now")
        val dialogHeader_3: MaterialStyledDialog.Builder = MaterialStyledDialog.Builder(context)
            .setHeaderDrawable(R.drawable.header)
            .setIcon(
                IconicsDrawable(context).icon(MaterialDesignIconic.Icon.gmi_github)
                    .color(Color.WHITE)
            )
            .withDialogAnimation(true)
            .setTitle("An awesome library?")
            .setDescription("Do you like this library? Check out my other Open Source libraries and apps!")
            .setPositiveText("GitHub")
            .onPositive(object : SingleButtonCallback() {
                fun onClick(dialog: MaterialDialog, which: DialogAction) {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://github.com/javiersantos")
                        )
                    )
                }
            })
            .setNegativeText("Not now")
        val dialogHeader_4 = MaterialStyledDialog.Builder(context)
            .setHeaderDrawable(R.drawable.header_2)
            .setTitle("Sweet!")
            .setDescription("Check out my others apps with Material Design available on Google Play. Hope you find them interesting!")
            .setPositiveText("Google Play")
            .onPositive(object : SingleButtonCallback() {
                fun onClick(dialog: MaterialDialog, which: DialogAction) {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/apps/dev?id=9205902632927830308")
                        )
                    )
                }
            })
            .setNegativeText("Not now")
        val dialogHeader_5: MaterialStyledDialog = MaterialStyledDialog.Builder(context)
            .setIcon(
                IconicsDrawable(context).icon(MaterialDesignIconic.Icon.gmi_comment_alt)
                    .color(Color.WHITE)
            )
            .withDialogAnimation(true)
            .setDescription("What can we improve? Your feedback is always welcome.")
            .setHeaderColor(R.color.dialog_2)
            .setCustomView(customView, 20, 20, 20, 0)
            .setPositiveText("Feedback")
            .onPositive(object : SingleButtonCallback() {
                fun onClick(dialog: MaterialDialog, which: DialogAction) {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://github.com/javiersantos/MaterialStyledDialogs/issues")
                        )
                    )
                }
            }).build()
        val dialogHeader_6 = MaterialStyledDialog.Builder(context)
            .setStyle(Style.HEADER_WITH_TITLE)
            .withDialogAnimation(true)
            .setTitle("Awesome!")
            .setDescription("Glad to see you like MaterialStyledDialogs! If you're up for it, we would really appreciate you reviewing us.")
            .setHeaderColor(R.color.dialog_1)
            .setPositiveText("Google Play")
            .onPositive(object : SingleButtonCallback() {
                fun onClick(dialog: MaterialDialog, which: DialogAction) {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/apps/details?id=" + context.getPackageName())
                        )
                    )
                }
            })
            .onPositive()
            .setNegativeText("Later")
        val dialogHeader_7 = MaterialStyledDialog.Builder(context)
            .setStyle(Style.HEADER_WITH_TITLE)
            .setHeaderDrawable(R.drawable.header)
            .withDialogAnimation(true)
            .withDarkerOverlay(true)
            .setTitle("An awesome library?")
            .setDescription("Do you like this library? Check out my other Open Source libraries and apps!")
            .setPositiveText("GitHub")
            .onPositive(object : SingleButtonCallback() {
                fun onClick(dialog: MaterialDialog, which: DialogAction) {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://github.com/javiersantos")
                        )
                    )
                }
            })
            .setNegativeText("Not now")

        // Init the card views
        val dialogHeaderView_1 = findViewById<CardView>(R.id.dialog_1)
        val dialogHeaderView_2 = findViewById<CardView>(R.id.dialog_2)
        val dialogHeaderView_3 = findViewById<CardView>(R.id.dialog_3)
        val dialogHeaderView_4 = findViewById<CardView>(R.id.dialog_4)
        val dialogHeaderView_5 = findViewById<CardView>(R.id.dialog_5)
        val dialogHeaderView_6 = findViewById<CardView>(R.id.dialog_6)
        val dialogHeaderView_7 = findViewById<CardView>(R.id.dialog_7)

        // Show the previous dialogs
        dialogHeaderView_1.setOnClickListener { dialogHeader_1.show() }
        dialogHeaderView_2.setOnClickListener { dialogHeader_2.show() }
        dialogHeaderView_3.setOnClickListener { dialogHeader_3.show() }
        dialogHeaderView_4.setOnClickListener { dialogHeader_4.show() }
        dialogHeaderView_5.setOnClickListener { dialogHeader_5.show() }
        dialogHeaderView_6.setOnClickListener { dialogHeader_6.show() }
        dialogHeaderView_7.setOnClickListener { dialogHeader_7.show() }

        //custom viewGroup child events
        dismissButton.setOnClickListener { dialogHeader_5.dismiss() }
    }

    fun toGithub(view: View?) {
        startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://github.com/javiersantos/MaterialStyledDialogs")
            )
        )
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                LibsBuilder()
                    .withActivityStyle(ActivityStyle.LIGHT_DARK_TOOLBAR)
                    .withActivityTitle(resources.getString(R.string.action_about))
                    .withAboutIconShown(true)
                    .withAboutDescription(resources.getString(R.string.app_description))
                    .withAboutVersionShown(true)
                    .withAboutAppName(resources.getString(R.string.app_name))
                    .withAutoDetect(true)
                    .withLicenseShown(true)
                    .start(this)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}