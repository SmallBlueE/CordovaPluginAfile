# Cordova Plugin: Read Text File via Android Intent

This Cordova plugin is designed to read text files through Android Intents, supporting Android SDK 31.
## Installation

cordova plugin add cordova-plugin-afile



## Usage

You can use this plugin in your Cordova project by following the example below:

```javascript
window.plugins.intentShim.getIntent(function(intent) {
    // Log the intent object
    console.log(intent);

    // Extract the content URI from the intent
    let contentUri = intent.data;
    console.log(contentUri);

    // Use the plugin to read text from the URI
    window.CordovaPluginAFile.readTextFromUri(contentUri, 
        function(data) {
            // Success callback: log the read data
            console.log(data);
        }, 
        function(err) {
            // Error callback: log the error message
            console.log(err);
        }
    );
}, function() {
    // Failure callback for getting the intent
    console.log('Failed to get the intent');
});
```

This code retrieves the current intent using `window.plugins.intentShim.getIntent()`, extracts the content URI from the intent, and then uses the `window.CordovaPluginAFile.readTextFromUri()` method to read the text from the file located at the URI. The read data is then logged to the console.

## Support

This plugin is tested and confirmed to work under Android SDK 31. Please ensure your project meets this requirement.

## Troubleshooting

If you encounter any issues while using this plugin, please check the logged error messages for clues about what might be going wrong. If you're unable to resolve the issue, please consider opening an issue on the plugin's GitHub page.