package com.github.javiersantos.materialstyleddialogs.demo

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog
import com.github.javiersantos.materialstyleddialogs.enums.Style
import com.mikepenz.aboutlibraries.LibsBuilder
import com.mikepenz.iconics.IconicsDrawable
import com.mikepenz.iconics.typeface.library.materialdesigniconic.MaterialDesignIconic
import com.mikepenz.iconics.utils.colorInt
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.custom_view.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        // Initialize ToGitHub fab
        toGitHub.setOnClickListener { openGitHubRepo() }

        // Inflate view
        val customView = layoutInflater.inflate(R.layout.custom_view, null)

        // Build some dialogs for the sample app
        val dialogHeader1 = setupDialog1()
        val dialogHeader2 = setupDialog2()
        val dialogHeader3 = setupDialog3()
        val dialogHeader4 = setupDialog4()
        val dialogHeader5 = setupDialog5(customView)
        val dialogHeader6 = setupDialog6()
        val dialogHeader7 = setupDialog7()

        // Show the previous dialogs
        dialog1.setOnClickListener { dialogHeader1.show() }
        dialog2.setOnClickListener { dialogHeader2.show() }
        dialog3.setOnClickListener { dialogHeader3.show() }
        dialog4.setOnClickListener { dialogHeader4.show() }
        dialog5.setOnClickListener { dialogHeader5.show() }
        dialog6.setOnClickListener { dialogHeader6.show() }
        dialog7.setOnClickListener { dialogHeader7.show() }

        // Set onClickListener for custom view
        customView.custom_button.setOnClickListener { dialogHeader5.dismiss() }
    }

    private fun setupDialog1(): MaterialStyledDialog.Builder {
        return MaterialStyledDialog.Builder(this)
            .setIcon(
                IconicsDrawable(this, MaterialDesignIconic.Icon.gmi_google_play).apply {
                    colorInt = Color.WHITE
                }
            )
            .withDialogAnimation(true)
            .setTitle("Awesome!")
            .setDescription("Glad to see you like MaterialStyledDialogs! If you're up for it, we would really appreciate you reviewing us.")
            .setHeaderColor(R.color.dialog_1)
            .setPositiveText("Google Play")
            .onPositive {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id=$packageName")
                    )
                )
            }
            .setNegativeText("Later")
    }

    private fun setupDialog2(): MaterialStyledDialog.Builder {
        return MaterialStyledDialog.Builder(this)
            .setIcon(
                IconicsDrawable(this, MaterialDesignIconic.Icon.gmi_comment_alt).apply {
                    colorInt = Color.WHITE
                }
            )
            .withIconAnimation(false)
            .setDescription("What can we improve? Your feedback is always welcome.")
            .setHeaderColor(R.color.dialog_2)
            .setPositiveText("Feedback")
            .onPositive {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://github.com/javiersantos/MaterialStyledDialogs/issues")
                    )
                )
            }
            .setNegativeText("Not now")
    }

    private fun setupDialog3(): MaterialStyledDialog.Builder {
        return MaterialStyledDialog.Builder(this)
            .setHeaderDrawable(R.drawable.header)
            .setIcon(
                IconicsDrawable(this, MaterialDesignIconic.Icon.gmi_github).apply {
                    colorInt = Color.WHITE
                }
            )
            .withDialogAnimation(true)
            .setTitle("An awesome library?")
            .setDescription("Do you like this library? Check out my other Open Source libraries and apps!")
            .setPositiveText("GitHub")
            .onPositive {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://github.com/javiersantos")
                    )
                )
            }
            .setNegativeText("Not now")
    }

    private fun setupDialog4(): MaterialStyledDialog.Builder {
        return MaterialStyledDialog.Builder(this)
            .setHeaderDrawable(R.drawable.header_2)
            .setTitle("Sweet!")
            .setDescription("Check out my others apps with Material Design available on Google Play. Hope you find them interesting!")
            .setPositiveText("Google Play")
            .onPositive {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/dev?id=9205902632927830308")
                    )
                )
            }
            .setNegativeText("Not now")
    }

    private fun setupDialog5(customView: View?): MaterialStyledDialog {
        return MaterialStyledDialog.Builder(this)
            .setIcon(
                IconicsDrawable(this, MaterialDesignIconic.Icon.gmi_comment_alt).apply {
                    colorInt = Color.WHITE
                }
            )
            .withDialogAnimation(true)
            .setDescription("What can we improve? Your feedback is always welcome.")
            .setHeaderColor(R.color.dialog_2)
            .setCustomView(customView, 20, 20, 20, 0)
            .setPositiveText("Feedback")
            .onPositive {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://github.com/javiersantos/MaterialStyledDialogs/issues")
                    )
                )
            }
            .build()
    }

    private fun setupDialog6(): MaterialStyledDialog.Builder {
        return MaterialStyledDialog.Builder(this)
            .setStyle(Style.HEADER_WITH_TITLE)
            .withDialogAnimation(true)
            .setTitle("Awesome!")
            .setDescription("Glad to see you like MaterialStyledDialogs! If you're up for it, we would really appreciate you reviewing us.")
            .setHeaderColor(R.color.dialog_1)
            .setPositiveText("Google Play")
            .onPositive {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id=$packageName")
                    )
                )
            }
            .setNegativeText("Later")
    }

    private fun setupDialog7(): MaterialStyledDialog.Builder {
        return MaterialStyledDialog.Builder(this)
            .setStyle(Style.HEADER_WITH_TITLE)
            .setHeaderDrawable(R.drawable.header)
            .withDialogAnimation(true)
            .withDarkerOverlay(true)
            .setTitle("An awesome library?")
            .setDescription("Do you like this library? Check out my other Open Source libraries and apps!")
            .setPositiveText("GitHub")
            .onPositive {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://github.com/javiersantos")
                    )
                )
            }
            .setNegativeText("Not now")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.action_about) openLibsDialog()
        return super.onOptionsItemSelected(item)
    }

    private fun openLibsDialog() {
        LibsBuilder()
            .withActivityTitle(getString(R.string.action_about))
            .withAboutIconShown(true)
            .withAboutDescription(getString(R.string.app_description))
            .withAboutVersionShown(true)
            .withAboutAppName(getString(R.string.app_name))
            .withAutoDetect(true)
            .withLicenseShown(true)
            .start(this)
    }

    private fun openGitHubRepo() =
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/javiersantos/MaterialStyledDialogs")))
}