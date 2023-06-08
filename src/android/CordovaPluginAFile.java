package com.ppp.CordovaPluginAFile;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.net.Uri;
import android.content.Context;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class CordovaPluginAFile extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        if (action.equals("readTextFromUri")) {
            String uriStr = data.getString(0);
            Uri uri = Uri.parse(uriStr);
            Context context = this.cordova.getActivity().getApplicationContext();
            
            try {
                InputStream inputStream = context.getContentResolver().openInputStream(uri);
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                reader.close();
                inputStream.close();                
                callbackContext.success(stringBuilder.toString());
            } catch (Exception e) {
                callbackContext.error(e.toString());
            }

            return true;
        }

        return false;
    }
}
