<h1 align="center">MaterialStyledDialogs <a href="https://github.com/javiersantos/MaterialStyledDialogs#how-to-include"><img src="https://jitpack.io/v/javiersantos/MaterialStyledDialogs.svg"></a></h1>
<h4 align="center">Android Library</h4>

<p align="center">
  <a target="_blank" href="https://android-arsenal.com/api?level=11"><img src="https://img.shields.io/badge/API-11%2B-orange.svg"></a>
  <a target="_blank" href="https://travis-ci.org/javiersantos/MaterialStyledDialogs"><img src="https://travis-ci.org/javiersantos/MaterialStyledDialogs.svg?branch=master"></a>
  <a target="_blank" href="http://android-arsenal.com/details/1/3136"><img src="https://img.shields.io/badge/Android%20Arsenal-MaterialStyledDialogs-blue.svg"></a>
  <a target="_blank" href="https://www.paypal.me/javiersantos" title="Donate using PayPal"><img src="https://img.shields.io/badge/paypal-donate-yellow.svg" /></a>
</p>

<p align="center">Android Library that shows a beautiful and customizable Material designed dialog with header. Based on <a target="_blank" href="https://github.com/afollestad/material-dialogs">material-dialogs</a> and inspired by this <a target="_blank" href="https://dribbble.com/shots/2439453-Sprocket-AND-1-3-3-OS-Consistent-Dialogs">dribbble</a>.</p>

![MaterialStyledDialogs](https://raw.githubusercontent.com/javiersantos/MaterialStyledDialogs/master/Screenshots/banner.png)

## Sample Project
You can download the latest sample APK from Google Play:

<a target="_blank" href="https://play.google.com/store/apps/details?id=com.github.javiersantos.materialstyleddialogs.demo"><img src="https://play.google.com/intl/en_us/badges/images/generic/en-play-badge.png" height="60"></a>

## How to include
Add the repository to your project **build.gradle**:
```Javascript
repositories {
	jcenter()
	maven {
		url "https://jitpack.io"
	}
}
```

And add the library to your module **build.gradle**:
```Javascript
dependencies {
	compile 'com.github.javiersantos:MaterialStyledDialogs:2.1'
}
```

## Usage
### Basic Dialog
A basic dialog will show the provided title (optional) and description, using your primary color as the header background. You have access to methods such as `setTitle()`, `setContent()`, `setIcon()`, `setCancelable()`, `dismiss()`, etc. Customizations are explained below.

```Java
new MaterialStyledDialog.Builder(this)
	.setTitle("Awesome!")
	.setDescription("What can we improve? Your feedback is always welcome.")
	.show();
```
or using the builder...

```Java
MaterialStyledDialog dialog = new MaterialStyledDialog.Builder(this)
	.setTitle("Awesome!")
	.setDescription("What can we improve? Your feedback is always welcome.")
	.build();
...
dialog.show();
```

## Customizations ([Wiki](https://github.com/javiersantos/MaterialStyledDialogs/wiki))

### Setting a style

<table align="center">
    <tr>
        <th>
            <img src="https://raw.githubusercontent.com/javiersantos/MaterialStyledDialogs/master/Screenshots/style-1.png" height="400" />
        </td>
        <th>
            <img src="https://raw.githubusercontent.com/javiersantos/MaterialStyledDialogs/master/Screenshots/style-2.png" height="400" />
        </td>
    </tr>
    <tr>
    	<td>Header with Icon (default): .setStyle(Style.HEADER_WITH_ICON)</td>
    	<td>Header with Title: .setStyle(Style.HEADER_WITH_TITLE)</td>
    </tr>
</table>

```Java
new MaterialStyledDialog.Builder(this)
	.setTitle("Awesome!")
	.setDescription("What can we improve? Your feedback is always welcome.")
	.setStyle(Style.HEADER_WITH_ICON)
	//.setStyle(Style.HEADER_WITH_TITLE)
	.show();
```

### Displaying an icon
The dialog icon is displayed in the center of the dialog (as seen it the screenshots).

```Java
new MaterialStyledDialog.Builder(this)
	.setTitle("Awesome!")
	.setDescription("What can we improve? Your feedback is always welcome.")
	.setIcon(R.drawable.ic_launcher)
	//.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_launcher))
	.show();
```

### Using a custom header color
By default, your primary color will be used for the header background. However you can customize this by adding:

```Java
new MaterialStyledDialog.Builder(this)
	.setTitle("Awesome!")
	.setDescription("What can we improve? Your feedback is always welcome.")
	.setHeaderColor(R.color.dialog_header)
	.show();
```

### Using an image as the header background
Customize your dialog by adding a drawable instead of a color.

```Java
new MaterialStyledDialog.Builder(this)
	.setTitle("Awesome!")
	.setDescription("What can we improve? Your feedback is always welcome.")
	.setHeaderDrawable(R.drawable.header)
	//.setHeaderDrawable(ContextCompat.getDrawable(this, R.drawable.heaer))
	.show();
```

### Adding a darker/grey overlay to the header background
Some icons or drawables may fit better when using a darker/grey overlay. Using the `.withDarkerOverlay()` method the library will apply a color filter to the header background. `false` by default.

```Java
new MaterialStyledDialog.Builder(this)
	.setTitle("Awesome!")
	.setDescription("What can we improve? Your feedback is always welcome.")
	.setHeaderDrawable(R.drawable.header)
	.withDarkerOverlay(true)
	.show();
```

### Adding icon and dialog animations
An animation to the icon will be displayed when the dialog is opened. `true` by default.

```Java
new MaterialStyledDialog.Builder(this)
	.setTitle("Awesome!")
	.setDescription("What can we improve? Your feedback is always welcome.")
	.withIconAnimation(true)
	.show();
```

The dialog will be displayed with an animation when it is opened and closed. `false` by default.

```Java
new MaterialStyledDialog.Builder(this)
	.setTitle("Awesome!")
	.setDescription("What can we improve? Your feedback is always welcome.")
	.withDialogAnimation(true)
	//.withDialogAnimation(true, Duration.SLOW)
	.show();
```

### Adding buttons and callbacks
Buttons are showed at the end of the bottom dialog. You can add your own text and actions/callbacks.

```Java
new MaterialStyledDialog.Builder(this)
	.setTitle("Awesome!")
	.setDescription("What can we improve? Your feedback is always welcome.")
	.setPositiveText(R.string.button)
	.onPositive(new MaterialDialog.SingleButtonCallback() {
		@Override
		public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
			Log.d("MaterialStyledDialogs", "Do something!");
	})
	//.setNegativeText(...)
	//.onNegative(...)
	//.setNeutralText(...)
	//.onNeutral(...)
	.show();
```

If no `onPositive(...)`, `onNegative(...)` or `onNeutral(...)` callbacks are provided, then the bottom dialog will be dismissed when tapping de button.

If `autoDismiss()` is turned `false`, then you must manually dismiss the dialog in these callbacks. Auto dismiss is `true` by default.

A divider before the buttons can be added using the `.withDivider(true)` method (`false` by default).

### Dismissing when touching outside
The `setCancelable()` method lets you disable dismissing the bottom dialog when you tap outside the dialog window. `true` by default.

```Java
new MaterialStyledDialog.Builder(this)
	.setTitle("Awesome!")
	.setDescription("What can we improve? Your feedback is always welcome.")
	.setCancelable(true)
	.show();
```

### Adding a custom view
You can add custom view to your bottom dialog just by adding the layout to the `setCustomView()` method.

```Java
new MaterialStyledDialog.Builder(this)
	.setTitle("Awesome!")
	.setDescription("What can we improve? Your feedback is always welcome.")
	.setCustomView(your_custom_view) // Old standard padding: .setCustomView(your_custom_view, 20, 20, 20, 0)
	//.setCustomView(your_custom_view, 10, 20, 10, 20) // int left, int top, int right, int bottom
	.show();
```

A detailed description is available at: https://github.com/javiersantos/MaterialStyledDialogs/wiki/Adding-a-custom-view

### Making the content scrollable
If your dialog content is too long you may prefer to make it scrollable. By using the next method you can specify the minimum number of lines to show the scroll bar (`5 lines` by default).

```Java
new MaterialStyledDialog.Builder(this)
	.setTitle("Awesome!")
	.setDescription("A loooooooooong looooooooooong really loooooooooong content. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam pulvinar sem nibh, et efficitur massa mattis eget. Phasellus condimentum ligula.")
	.setScrollable(true)
	//.setScrollable(true, 10)
	.show();
```

## Apps already using this library
Feel free to send me new projects by submitting an [issue](https://github.com/javiersantos/MaterialStyledDialogs/issues) or a [pull request](https://github.com/javiersantos/MaterialStyledDialogs/pulls).

<table>
    <tr>
        <td>
            <a target="_blank" href="https://play.google.com/store/apps/details?id=com.materiup.following">
                <img src="http://www.materiup.com/following/images/logo.png"
                    title="Following: game for Twitter"
                    alt="Following: game for Twitter" height="120">
            </a>
        </td>
       <td>
            <a target="_blank" href="https://play.google.com/store/apps/details?id=com.frontendart.qualitygate.android">
                <img src="https://lh3.googleusercontent.com/dvIZu7L-bSNdZ3eJ5exx-EuPN_5Pen15SkXhuNwCis8xRvq7fqWoTHgQMZFhUt_69es"
                    title="QualityGate"
                    alt="QualityGate" height="120">
            </a>
        </td>
	<td>
            <a target="_blank" href="https://play.google.com/store/apps/details?id=es.usc.citius.servando.calendula">
                <img src="https://lh6.ggpht.com/yX80u4AqdSxgsJZSoNWlFuDY5Z9BFH_PduEs3w-6uZTXK2M0mNC_3YfgR0VY8CunZoUx=w300-rw"
                    title="Calendula"
                    alt="Calendula" height="120">
            </a>
        </td>
	<td>
            <a target="_blank" href="https://play.google.com/store/apps/details?id=vladyslavpohrebniakov.justtictactoe">
                <img src="https://lh3.googleusercontent.com/BKIeH5z4jOJwgFYqLHVCbe0yJmOQEg5Xphs01dJ86MqS8SZK7YvSc7H1XbaZG5Fqzt8=w300-rw"
                    title="Just tictactoe"
                    alt="Just tictactoe" height="120">
            </a>
        </td>
	<td>
            <a target="_blank" href="https://play.google.com/store/apps/details?id=com.tomer.alwayson">
                <img src="https://lh3.googleusercontent.com/isj-hzZSIF9Cvyroa9adJOLw_QKR6v45IqzXa7LkkNcAakUa71u3ygS_ps5feasnng=w300-rw"
                    title="Always On AMOLED"
                    alt="Always On AMOLED" height="120">
            </a>
        </td>
    </tr>
</table>

## License
	Copyright 2016 Javier Santos

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

	   http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.

	MaterialStyledDialogs includes code from material-dialogs, which is 
	licensed under the MIT license. You may obtain a copy at
	
	   https://github.com/afollestad/material-dialogs/blob/master/LICENSE.txt
