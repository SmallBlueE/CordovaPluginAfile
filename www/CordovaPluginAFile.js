var exec = require('cordova/exec');

exports.readTextFromUri = function(uri, success, error) {
    exec(success, error, 'CordovaPluginAFile', 'readTextFromUri', [uri]);
};
