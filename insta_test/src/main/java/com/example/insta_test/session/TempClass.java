package com.example.insta_test.session;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKey;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public  class TempClass {
    private final static   String SHARED_PREFERENCE_NAME = "INSTASOCIAL";
    private static SharedPreferences.Editor editor  = null;
    private static SharedPreferences savedSession  = null;
    public static SharedPreferences mainData(Context context) throws Exception{
        MasterKey masterKey = new androidx.security.crypto.MasterKey.Builder(context)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build();

        SharedPreferences sharedPreferences  =  EncryptedSharedPreferences.create(
            context,
            SHARED_PREFERENCE_NAME,
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        );


        // use the shared preferences and editor as you normally would
        editor = sharedPreferences.edit();
        savedSession = sharedPreferences;
        return savedSession;
    }

    public static boolean put(String key ,Boolean value) {
        if (key == null || key == "") {
            throw new IllegalArgumentException(WRONG_PAIR);
        }
        editor.putBoolean(key, value);
        return editor.commit();
    }

    public static String WRONG_PAIR = "Key-Value pair cannot be blank or null";

    public static boolean getBoolean(String key) {
        return savedSession.getBoolean(key, false);
    }

    public static Bitmap resizeBitmap(String photoPath, int targetW, int targetH) {
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(photoPath, bmOptions);
        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;

        int scaleFactor = 1;
        if ((targetW > 0) || (targetH > 0)) {
            scaleFactor = Math.min(photoW/targetW, photoH/targetH);
        }

        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;
        bmOptions.inPurgeable = true; //Deprecated API 21

        return BitmapFactory.decodeFile(photoPath, bmOptions);
    }
    public static File savebitmap(String filePath, Bitmap bmp) throws IOException {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 60, bytes);
        File f = new File(filePath);
        if (f.exists())
        {
            f.delete();
        }
        f.createNewFile();
        FileOutputStream fo = new FileOutputStream(f);
        fo.write(bytes.toByteArray());
        fo.close();
        return f;
    }
}