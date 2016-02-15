package com.github.javiersantos.materialstyleddialogs;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.annotation.UiThread;
import android.support.v4.content.res.ResourcesCompat;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.github.javiersantos.materialstyleddialogs.enums.Duration;
import com.github.javiersantos.materialstyleddialogs.enums.Style;
import com.github.javiersantos.materialstyleddialogs.utils.AnimationUtils;
import com.github.javiersantos.materialstyleddialogs.utils.AndroidUtils;

public class MaterialStyledDialog {
    private final Context context;

    // build() and show()
    private MaterialDialog materialDialog;
    private final MaterialDialog.Builder builder;

    private Style style; // setStyle()
    private Duration duration; // withDialogAnimation()
    private Boolean isIconAnimation, isDialogAnimation, isCancelable, scrollable; // withIconAnimation(), withDialogAnimation(), setCancelable(), setScrollable()
    private Drawable headerDrawable, iconDrawable; // setHeaderDrawable(), setIconDrawable()
    private Integer primaryColor, maxLines; // setHeaderColor(), setScrollable()
    private String title, description; // setTitle(), setDescription()

    // .setPositive(), setNegative() and setNeutral()
    private String positive, negative, neutral;
    private MaterialDialog.SingleButtonCallback positiveCallback, negativeCallback, neutralCallback;

    public MaterialStyledDialog(Context context) {
        this.context = context;
        builder = new MaterialDialog.Builder(context);
        style = Style.STYLE_HEADER;
        isIconAnimation = true;
        isDialogAnimation = false;
        duration = Duration.NORMAL;
        isCancelable = true;
        primaryColor = AndroidUtils.getPrimaryColor(context);
        scrollable = false;
        maxLines = 5;
    }

    /**
     * Set an style for the dialog. Default: Style.STYLE_HEADER.
     *
     * @param style to apply
     * @return this
     * @see Style
     */
    public MaterialStyledDialog setStyle(Style style) {
        this.style = style;
        return this;
    }

    /**
     * Set if the header icon will be displayed with an initial animation. Default: true.
     *
     * @param withAnimation true to enable animation, false otherwise
     * @return this
     * @deprecated use {@link #withIconAnimation(Boolean)} instead
     */
    public MaterialStyledDialog withAnimation(Boolean withAnimation) {
        isIconAnimation = withAnimation;
        return this;
    }

    /**
     * Set if the header icon will be displayed with an initial animation. Default: true.
     *
     * @param withAnimation true to enable animation, false otherwise
     * @return this
     */
    public MaterialStyledDialog withIconAnimation(Boolean withAnimation) {
        isIconAnimation = withAnimation;
        return this;
    }

    /**
     * Set if the dialog will be displayed with an open and close animation. Default: false.
     *
     * @param withAnimation true to enable animation, false otherwise
     * @return this
     */
    public MaterialStyledDialog withDialogAnimation(Boolean withAnimation) {
        isDialogAnimation = withAnimation;
        return this;
    }

    /**
     * Set if the dialog will be displayed with an open and close animation, with custom duration. Default: false, Duration.NORMAL.
     *
     * @param withAnimation true to enable animation, false otherwise
     * @return this
     * @see Duration
     */
    public MaterialStyledDialog withDialogAnimation(Boolean withAnimation, Duration duration) {
        isDialogAnimation = withAnimation;
        this.duration = duration;
        return this;
    }

    /**
     * Set an icon for the dialog header
     * @param icon to show
     * @return this
     */
    public MaterialStyledDialog setIcon(@NonNull Drawable icon) {
        iconDrawable = icon;
        return this;
    }

    /**
     * Set an icon for the dialog header
     * @param iconRes to show
     * @return this
     */
    public MaterialStyledDialog setIcon(@DrawableRes Integer iconRes) {
        iconDrawable = ResourcesCompat.getDrawable(context.getResources(), iconRes, null);
        return this;
    }

    /**
     * Set a title for the dialog
     *
     * @param title to show
     * @return this
     */
    public MaterialStyledDialog setTitle(@NonNull String title) {
        this.title = title;
        return this;
    }

    /**
     * Set a title for the dialog
     *
     * @param resource title to show
     * @return this
     */
    public MaterialStyledDialog setTitle(@StringRes int resource){
        title = context.getString(resource);
        return this;
    }

    /**
     * Set a description for the dialog
     *
     * @param description to show
     * @return this
     */
    public MaterialStyledDialog setDescription(@NonNull String description) {
        this.description = description;
        return this;
    }

    /**
     * Set a description for the dialog
     *
     * @param resource description to show
     * @return this
     */
    public MaterialStyledDialog setDescription(@StringRes int resource){
        description = context.getString(resource);
        return this;
    }

    /**
     * Set a color for the dialog header. Default: Theme primary color.
     *
     * @param color for the header
     * @return this
     */
    public MaterialStyledDialog setHeaderColor(@ColorRes Integer color) {
        primaryColor = AndroidUtils.getColor(context, color);
        return this;
    }

    /**
     * Set an image for the dialog header
     *
     * @param drawable image for the header
     * @return this
     */
    @TargetApi(16)
    public MaterialStyledDialog setHeaderDrawable(@NonNull Drawable drawable) {
        headerDrawable = drawable;
        return this;
    }

    /**
     * Set an image for the dialog header
     *
     * @param drawableRes image for the header
     * @return this
     */
    @TargetApi(16)
    public MaterialStyledDialog setHeaderDrawable(@DrawableRes Integer drawableRes) {
        headerDrawable = ResourcesCompat.getDrawable(context.getResources(), drawableRes, null);
        return this;
    }

    /**
     * Set a positive button for the dialog
     *
     * @param text for the button
     * @param callback action to do
     * @return this
     */
    public MaterialStyledDialog setPositive(@NonNull String text, @NonNull MaterialDialog.SingleButtonCallback callback) {
        positive = text;
        positiveCallback = callback;
        return this;
    }

    /**
     * Set a negative button for the dialog
     *
     * @param text for the button
     * @param callback action to do
     * @return this
     */
    public MaterialStyledDialog setNegative(@NonNull String text, @NonNull MaterialDialog.SingleButtonCallback callback) {
        negative = text;
        negativeCallback = callback;
        return this;
    }

    /**
     * Set a neutral button for the dialog
     *
     * @param text for the button
     * @param callback action to do
     * @return this
     */
    public MaterialStyledDialog setNeutral(@NonNull String text, @NonNull MaterialDialog.SingleButtonCallback callback) {
        neutral = text;
        neutralCallback = callback;
        return this;
    }

    /**
     * Set if the dialog will be hidden when touching outside
     *
     * @param cancelable true to enable, false otherwise
     * @return this
     */
    public MaterialStyledDialog setCancelable(Boolean cancelable) {
        isCancelable = cancelable;
        return this;
    }

    /**
     * Set if the description will be scrollable. Default: false.
     *
     * @param scrollable true to enable scrollable description, false otherwise
     * @return this
     */
    public MaterialStyledDialog setScrollable(Boolean scrollable) {
        this.scrollable = scrollable;
        return this;
    }

    /**
     * Set if the description will be scrollable, with custom maximum lines. Default: false, 5.
     *
     * @param scrollable true to enable scrollable description, false otherwise
     * @return this
     */
    public MaterialStyledDialog setScrollable(Boolean scrollable, Integer maxLines) {
        this.scrollable = scrollable;
        this.maxLines = maxLines;
        return this;
    }

    @UiThread
    public MaterialStyledDialog build() {
        // Set cancelable
        builder.cancelable(isCancelable);

        // Set style
        builder.customView(initStyle(), false);

        // Set positive button
        if (positive != null && positive.length() != 0) {
            builder.positiveText(positive);
            builder.onPositive(positiveCallback);
        }

        // set negative button
        if (negative != null && negative.length() != 0) {
            builder.negativeText(negative);
            builder.onNegative(negativeCallback);
        }

        // Set neutral button
        if (neutral != null && neutral.length() != 0) {
            builder.neutralText(neutral);
            builder.onNeutral(neutralCallback);
        }

        // Build the dialog with the previous configuration
        materialDialog = builder.build();

        // Set dialog animation and animation duration
        if (isDialogAnimation) {
            if (duration == Duration.NORMAL) {
                materialDialog.getWindow().getAttributes().windowAnimations = R.style.MaterialStyledDialogs_DialogAnimationNormal;
            } else if (duration == Duration.FAST) {
                materialDialog.getWindow().getAttributes().windowAnimations = R.style.MaterialStyledDialogs_DialogAnimationFast;
            } else if (duration == Duration.SLOW) {
                materialDialog.getWindow().getAttributes().windowAnimations = R.style.MaterialStyledDialogs_DialogAnimationSlow;
            }
        }

        return this;
    }

    @UiThread
    public MaterialStyledDialog show() {
        if (materialDialog == null) { build(); }
        materialDialog.show();
        return this;
    }

    @UiThread
    public void dismiss() {
        if (materialDialog != null) { materialDialog.dismiss(); }
    }

    @TargetApi(16)
    private View initStyle() {
        LayoutInflater inflater = LayoutInflater.from(context);
        View contentView;

        switch (style) {
            default:
                contentView = inflater.inflate(R.layout.style_dialog_header, null);
                break;
        }

        // Init Views
        LinearLayout dialogHeader = (LinearLayout) contentView.findViewById(R.id.md_styled_header);
        ImageView dialogPic = (ImageView) contentView.findViewById(R.id.md_styled_dialog_pic);
        TextView dialogTitle = (TextView) contentView.findViewById(R.id.md_styled_dialog_title);
        TextView dialogDescription = (TextView) contentView.findViewById(R.id.md_styled_dialog_description);

        // Set header color or drawable
        if (headerDrawable != null && AndroidUtils.checkApiGreaterThan(16)) {
            dialogHeader.setBackground(headerDrawable); // TODO API<16
        } else {
            dialogHeader.setBackgroundColor(primaryColor);
        }

        // Set header icon
        if (iconDrawable != null) {
            dialogPic.setImageDrawable(iconDrawable);
        }

        // Set dialog title
        if (title != null && title.length() != 0) {
            dialogTitle.setText(title);
        } else {
            dialogTitle.setVisibility(View.GONE);
        }

        // Set dialog description
        dialogDescription.setText(description);

        // Set scrollable
        dialogDescription.setVerticalScrollBarEnabled(scrollable);
        if (scrollable) {
            dialogDescription.setMaxLines(maxLines);
            dialogDescription.setMovementMethod(new ScrollingMovementMethod());
        } else {
            dialogDescription.setMaxLines(Integer.MAX_VALUE);
        }

        // Set icon animation
        if (isIconAnimation) {
            AnimationUtils.zoomInAndOutAnimation(context, dialogPic);
        }

        return contentView;

    }

}
