package com.example.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;

public class UserSharedInformation {
    private SharedPreferences sharedPreferences;

    public UserSharedInformation(Context context) {
        sharedPreferences = context.getSharedPreferences("user_info", Context.MODE_PRIVATE);
    }

    public void saveInfo(String fullName, String mail, String gender) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("full_name", fullName);
        editor.putString("user_mail", mail);
        editor.putString("user_gender", gender);
        editor.apply();
    }

    public String getFullName() {
        return sharedPreferences.getString("full_name", "");
    }

    public String getUserMail() {
        return sharedPreferences.getString("user_mail", "");
    }

    public String getUserGender() {
        return sharedPreferences.getString("user_gender", "");
    }

    public void clearAll() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    public void removeFullName() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("full_name");
        editor.apply();
    }

    public void removeUserMail() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("user_mail");
        editor.apply();
    }

    public void removeUserGender() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("user_gender");
        editor.apply();
    }
}
