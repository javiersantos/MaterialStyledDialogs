package com.github.javiersantos.materialstyleddialogs

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.DialogInterface.OnShowListener
import android.view.View
import android.view.ViewGroup
import com.afollestad.materialdialogs.internal.MDRootLayout

internal open class DialogBase(context: Context?, theme: Int) :
    Dialog(context!!, theme), OnShowListener {
    protected var view: MDRootLayout? = null
    private var showListener: OnShowListener? = null
    override fun findViewById(id: Int): View {
        return view.findViewById(id)
    }

    override fun setOnShowListener(listener: OnShowListener?) {
        showListener = listener
    }

    fun setOnShowListenerInternal() {
        super.setOnShowListener(this)
    }

    fun setViewInternal(view: View?) {
        super.setContentView(view!!)
    }

    override fun onShow(dialog: DialogInterface) {
        if (showListener != null) showListener!!.onShow(dialog)
    }

    @Deprecated("")
    @Throws(IllegalAccessError::class)
    override fun setContentView(layoutResID: Int) {
        throw IllegalAccessError("setContentView() is not supported in MaterialDialog. Specify a custom view in the Builder instead.")
    }

    @Deprecated("")
    @Throws(IllegalAccessError::class)
    override fun setContentView(view: View) {
        throw IllegalAccessError("setContentView() is not supported in MaterialDialog. Specify a custom view in the Builder instead.")
    }

    @Deprecated("")
    @Throws(IllegalAccessError::class)
    override fun setContentView(
        view: View,
        params: ViewGroup.LayoutParams?
    ) {
        throw IllegalAccessError("setContentView() is not supported in MaterialDialog. Specify a custom view in the Builder instead.")
    }
}