<h1 align="center">MaterialStyledDialogs</h1>
<h4 align="center">Android Library</h4>

<p align="center">
  <a target="_blank" href="https://android-arsenal.com/api?level=11"><img src="https://img.shields.io/badge/API-11%2B-orange.svg"></a>
  <a target="_blank" href="https://travis-ci.org/javiersantos/MaterialStyledDialogs"><img src="https://travis-ci.org/javiersantos/MaterialStyledDialogs.svg?branch=master"></a>
  <a target="_blank" href="https://www.paypal.me/javiersantos" title="Donate using PayPal"><img src="https://img.shields.io/badge/paypal-donate-yellow.svg" /></a>
  <a target="_blank" href="http://patreon.com/javiersantos" title="Donate using Patreon"><img src="https://img.shields.io/badge/patreon-donate-yellow.svg" /></a>
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
    maven {
        url "https://jitpack.io"
    }
}
```

And add the library to your module **build.gradle**:
```Javascript
dependencies {
    compile 'com.github.javiersantos:MaterialStyledDialogs:1.0'
}
```

## Usage
### Basic Dialog
A basic dialog will show the provided title (optional) and description, using your primary color as the header background.

```Java
new MaterialStyledDialog(this)
        .setTitle("Awesome!")
        .setDescription("What can we improve? Your feedback is always welcome.")
        .show();
```
or using the builder...

```Java
MaterialStyledDialog dialog = new MaterialStyledDialog(this)
        .setTitle("Awesome!")
        .setDescription("What can we improve? Your feedback is always welcome.")
        .build();
...
dialog.show();
```


## Customization
```Java
// Set an icon for the dialog header.
.setIcon(R.mipmap.ic_launcher)
```
```Java
// Set if the header icon will be displayed with an initial animation.
// Default: true.
.withAnimation(false)
```
```Java
// Set a color for the dialog header.
// Default: Theme primary color.
.setHeaderColor(R.color.dialog_header)
```
```Java
// Set an image for the dialog header.
// API 16+ required.
.setHeaderDrawable(ContextCompat.getDrawable(this, R.drawable.header))
```
```Java
// Set if the dialog will be hidden when touching outside.
// Default: true.
.setCancelable(false)
```
```Java
// Set a positive, negative and/or neutral button for the dialog.
.setPositive(R.string.button, new MaterialDialog.SingleButtonCallback() {
        @Override
        public void onClick(MaterialDialog dialog, DialogAction which) {
                Log.d("MaterialStyledDialogs", "Do something!");
        }
})
//.setNegative(...)
//.setNeutral(...)
```

## Apps already using this library

<table>
    <tr>
        <td>
            <a href="https://play.google.com/store/apps/details?id=com.materiup.following">
                <img src="http://www.materiup.com/images/logo.png"
                    title="Following: game for Twitter"
                    alt="Following: game for Twitter" height="120">
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
