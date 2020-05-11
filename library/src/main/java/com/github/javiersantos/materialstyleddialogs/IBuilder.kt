package com.github.javiersantos.materialstyleddialogs

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView.ScaleType
import androidx.annotation.*
import com.afollestad.materialdialogs.DialogCallback
import com.github.javiersantos.materialstyleddialogs.enums.Duration
import com.github.javiersantos.materialstyleddialogs.enums.Style

internal interface IBuilder {
    /**
     * Set custom view for the dialog.
     *
     * @param customView to apply
     * @return this
     */
    fun setCustomView(customView: View?): MaterialStyledDialog.Builder?

    /**
     * Set custom view for the dialog with optional padding in DP.
     *
     * @param customView to apply
     * @param left       padding left in DP
     * @param top        padding top in DP
     * @param right      padding right in DP
     * @param bottom     padding bottom in DP
     * @return this
     */
    fun setCustomView(
        customView: View?,
        left: Int,
        top: Int,
        right: Int,
        bottom: Int
    ): MaterialStyledDialog.Builder?

    /**
     * Set an style for the dialog. Default: Style.STYLE_HEADER.
     *
     * @param style to apply
     * @return this
     * @see com.github.javiersantos.materialstyleddialogs.enums.Style
     */
    fun setStyle(style: Style?): MaterialStyledDialog.Builder?

    /**
     * Set if the header icon will be displayed with an initial animation. Default: true.
     *
     * @param withAnimation true to enable animation, false otherwise
     * @return this
     */
    fun withIconAnimation(withAnimation: Boolean?): MaterialStyledDialog.Builder?

    /**
     * Set if the dialog will be displayed with an open and close animation. Default: false.
     *
     * @param withAnimation true to enable animation, false otherwise
     * @return this
     */
    fun withDialogAnimation(withAnimation: Boolean?): MaterialStyledDialog.Builder?

    /**
     * Set if the dialog will be displayed with an open and close animation, with custom duration. Default: false, Duration.NORMAL.
     *
     * @param withAnimation true to enable animation, false otherwise
     * @return this
     * @see com.github.javiersantos.materialstyleddialogs.enums.Duration
     */
    fun withDialogAnimation(
        withAnimation: Boolean?,
        duration: Duration?
    ): MaterialStyledDialog.Builder?

    /**
     * Set if the divider will be displayed before the buttons and after the dialog content. Default: false.
     *
     * @param withDivider true to enable animation, false otherwise
     * @return this
     */
    fun withDivider(withDivider: Boolean?): MaterialStyledDialog.Builder?

    /**
     * Set if the header will display a gray/darker overlay. Default: false.
     *
     * @param withDarkerOverlay true to apply a darker overlay, false otherwise
     * @return this
     */
    fun withDarkerOverlay(withDarkerOverlay: Boolean?): MaterialStyledDialog.Builder?

    /**
     * Set an icon for the dialog header
     *
     * @param icon to show
     * @return this
     */
    fun setIcon(icon: Drawable): MaterialStyledDialog.Builder?

    /**
     * Set an icon for the dialog header
     *
     * @param iconRes to show
     * @return this
     */
    fun setIcon(@DrawableRes iconRes: Int?): MaterialStyledDialog.Builder?

    /**
     * Set animation for the dialog icon.
     *
     * @param animResource custom animation
     * @return this
     */
    fun setIconAnimation(@AnimRes animResource: Int): MaterialStyledDialog.Builder?

    /**
     * Set a title for the dialog
     *
     * @param titleRes to show
     * @return this
     */
    fun setTitle(@StringRes titleRes: Int): MaterialStyledDialog.Builder?

    /**
     * Set a title for the dialog
     *
     * @param title to show
     * @return this
     */
    fun setTitle(title: CharSequence): MaterialStyledDialog.Builder?

    /**
     * Set a description for the dialog
     *
     * @param descriptionRes to show
     * @return this
     */
    fun setDescription(@StringRes descriptionRes: Int): MaterialStyledDialog.Builder?

    /**
     * Set a description for the dialog
     *
     * @param description to show
     * @return this
     */
    fun setDescription(description: CharSequence): MaterialStyledDialog.Builder?

    /**
     * Set a color for the dialog header. Default: Theme primary color.
     *
     * @param color for the header
     * @return this
     */
    fun setHeaderColor(@ColorRes color: Int): MaterialStyledDialog.Builder?

    /**
     * Set a color for the dialog header. Default: Theme primary color.
     *
     * @param color for the header
     * @return this
     */
    fun setHeaderColorInt(@ColorInt color: Int): MaterialStyledDialog.Builder?

    /**
     * Set an image for the dialog header.
     *
     * @param drawable image for the header
     * @return this
     */
    fun setHeaderDrawable(drawable: Drawable): MaterialStyledDialog.Builder?

    /**
     * Set an image for the dialog header
     *
     * @param drawableRes image for the header
     * @return this
     */
    fun setHeaderDrawable(@DrawableRes drawableRes: Int?): MaterialStyledDialog.Builder?

    /**
     * Set a positive button for the dialog
     *
     * @param text     for the button
     * @param callback action to do
     * @return this
     */
    @Deprecated(
        """use {{@link #setPositiveText(CharSequence)}, {@link #setPositiveText(int)} and {@link #onPositive(MaterialDialog.SingleButtonCallback)}} instead
      """
    )
    fun setPositive(
        text: String?,
        callback: DialogCallback?
    ): MaterialStyledDialog.Builder?

    /**
     * Set a positive button text for the dialog. E.g.: R.string.accept
     *
     * @param buttonTextRes     for the button
     * @return this
     */
    fun setPositiveText(@StringRes buttonTextRes: Int): MaterialStyledDialog.Builder?

    /**
     * Set a positive button text for the dialog. E.g.: "Accept"
     *
     * @param buttonText     for the button
     * @return this
     */
    fun setPositiveText(buttonText: CharSequence): MaterialStyledDialog.Builder?

    /**
     * Set a positive button action for the dialog
     *
     * @param callback     for the button
     * @return this
     */
    fun onPositive(callback: DialogCallback): MaterialStyledDialog.Builder?

    /**
     * Set a negative button for the dialog
     *
     * @param text     for the button
     * @param callback action to do
     * @return this
     */
    @Deprecated(
        """use {{@link #setNegativeText(CharSequence)}, {@link #setNegativeText(int)} and {@link #onNegative(MaterialDialog.SingleButtonCallback)}} instead
      """
    )
    fun setNegative(
        text: String?,
        callback: DialogCallback?
    ): MaterialStyledDialog.Builder?

    /**
     * Set a negative button text for the dialog. E.g.: R.string.cancel
     *
     * @param buttonTextRes     for the button
     * @return this
     */
    fun setNegativeText(@StringRes buttonTextRes: Int): MaterialStyledDialog.Builder?

    /**
     * Set a negative button text for the dialog. E.g.: "Decline"
     *
     * @param buttonText     for the button
     * @return this
     */
    fun setNegativeText(buttonText: CharSequence): MaterialStyledDialog.Builder?

    /**
     * Set a negative button action for the dialog
     *
     * @param callback     for the button
     * @return this
     */
    fun onNegative(callback: DialogCallback): MaterialStyledDialog.Builder?

    /**
     * Set a neutral button for the dialog
     *
     * @param text     for the button
     * @param callback action to do
     * @return this
     */
    @Deprecated(
        """use {{@link #setNeutralText(CharSequence)}, {@link #setNeutralText(int)} and {@link #onNeutral(MaterialDialog.SingleButtonCallback)}} instead
      """
    )
    fun setNeutral(
        text: String?,
        callback: DialogCallback?
    ): MaterialStyledDialog.Builder?

    /**
     * Set a neutral button text for the dialog. E.g.: R.string.later
     *
     * @param buttonTextRes     for the button
     * @return this
     */
    fun setNeutralText(@StringRes buttonTextRes: Int): MaterialStyledDialog.Builder?

    /**
     * Set a neutral button text for the dialog. E.g.: "Maybe later"
     *
     * @param buttonText     for the button
     * @return this
     */
    fun setNeutralText(buttonText: CharSequence): MaterialStyledDialog.Builder?

    /**
     * Set a neutral button action for the dialog
     *
     * @param callback     for the button
     * @return this
     */
    fun onNeutral(callback: DialogCallback): MaterialStyledDialog.Builder?

    /**
     * Set the scale type for the header ImageView.
     *
     * @param scaleType the scale type for the header ImageView
     * @return this
     */
    fun setHeaderScaleType(scaleType: ScaleType?): MaterialStyledDialog.Builder?

    /**
     * Set if the dialog will be hidden when touching outside
     *
     * @param cancelable true to enable, false otherwise
     * @return this
     */
    fun setCancelable(cancelable: Boolean?): MaterialStyledDialog.Builder?

    /**
     * Set if the description will be isScrollable. Default: false.
     *
     * @param scrollable true to enable isScrollable description, false otherwise
     * @return this
     */
    fun setScrollable(scrollable: Boolean?): MaterialStyledDialog.Builder?

    /**
     * Set if the description will be isScrollable, with custom maximum lines. Default: false, 5.
     *
     * @param scrollable true to enable isScrollable description, false otherwise
     * @return this
     */
    fun setScrollable(scrollable: Boolean?, maxLines: Int?): MaterialStyledDialog.Builder?

    /**
     * Set if the dialog will be dismissed when a button is pressed. Default: true.
     *
     * @param dismiss true to dismiss dialog when a button is pressed
     * @return this
     */
    fun autoDismiss(dismiss: Boolean?): MaterialStyledDialog.Builder?
}