package com.github.javiersantos.materialstyleddialogs;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.github.javiersantos.materialstyleddialogs.enums.Duration;
import com.github.javiersantos.materialstyleddialogs.enums.Style;

public class MaterialStyledDialog {
    private Context context;
    private MaterialDialog materialDialog;
    private MaterialDialog.Builder builder;
    private Style style;
    private Duration duration;
    private Boolean isIconAnimation, isDialogAnimation, isCancelable;
    private Drawable headerDrawable, iconDrawable;
    private Integer primaryColor;
    private String title, description;
    private String positive, negative, neutral;
    private MaterialDialog.SingleButtonCallback positiveCallback, negativeCallback, neutralCallback;

    public MaterialStyledDialog(Context context) {
        this.context = context;
        this.builder = new MaterialDialog.Builder(context);
        this.isIconAnimation = true;
        this.isDialogAnimation = false;
        this.duration = Duration.NORMAL;
        this.isCancelable = true;
        this.primaryColor = UtilsLibrary.getPrimaryColor(context);
        this.style = Style.STYLE_HEADER;
    }

    /**
     * Set an style for the dialog. Default: Style.STYLE_HEADER.
     *
     * @param style to apply
     * @return this
     * @see com.github.javiersantos.materialstyleddialogs.enums.Style
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
        this.isIconAnimation = withAnimation;
        return this;
    }

    /**
     * Set if the header icon will be displayed with an initial animation. Default: true.
     *
     * @param withAnimation true to enable animation, false otherwise
     * @return this
     */
    public MaterialStyledDialog withIconAnimation(Boolean withAnimation) {
        this.isIconAnimation = withAnimation;
        return this;
    }

    /**
     * Set if the dialog will be displayed with an open and close animation. Default: false.
     *
     * @param withAnimation true to enable animation, false otherwise
     * @return this
     */
    public MaterialStyledDialog withDialogAnimation(Boolean withAnimation) {
        this.isDialogAnimation = withAnimation;
        return this;
    }

    /**
     * Set if the dialog will be displayed with an open and close animation, with custom duration. Default: false, Duration.NORMAL.
     *
     * @param withAnimation true to enable animation, false otherwise
     * @return this
     * @see com.github.javiersantos.materialstyleddialogs.enums.Duration
     */
    public MaterialStyledDialog withDialogAnimation(Boolean withAnimation, Duration duration) {
        this.isDialogAnimation = withAnimation;
        this.duration = duration;
        return this;
    }

    /**
     * Set an icon for the dialog header
     * @param icon to show
     * @return this
     */
    public MaterialStyledDialog setIcon(@NonNull Drawable icon) {
        this.iconDrawable = icon;
        return this;
    }

    /**
     * Set an icon for the dialog header
     * @param iconRes to show
     * @return this
     */
    public MaterialStyledDialog setIcon(@DrawableRes Integer iconRes) {
        this.iconDrawable = ResourcesCompat.getDrawable(context.getResources(), iconRes, null);
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
     * Set a color for the dialog header. Default: Theme primary color.
     *
     * @param color for the header
     * @return this
     */
    public MaterialStyledDialog setHeaderColor(@ColorRes Integer color) {
        this.primaryColor = UtilsLibrary.getColor(context, color);
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
        this.headerDrawable = drawable;
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
        this.headerDrawable = ResourcesCompat.getDrawable(context.getResources(), drawableRes, null);
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
        this.positive = text;
        this.positiveCallback = callback;
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
        this.negative = text;
        this.negativeCallback = callback;
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
        this.neutral = text;
        this.neutralCallback = callback;
        return this;
    }

    /**
     * Set if the dialog will be hidden when touching outside
     *
     * @param cancelable true to enable, false otherwise
     * @return this
     */
    public MaterialStyledDialog setCancelable(Boolean cancelable) {
        this.isCancelable = cancelable;
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
        if (headerDrawable != null && UtilsLibrary.checkApiGreaterThan(16)) {
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

        // Set icon animation
        if (isIconAnimation) {
            UtilsAnimation.zoomInAndOutAnimation(context, dialogPic);
        }

        return contentView;

    }

}
