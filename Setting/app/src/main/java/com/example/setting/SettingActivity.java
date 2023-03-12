package com.example.setting;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.EditTextPreference;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import androidx.preference.PreferenceScreen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        getSupportFragmentManager().beginTransaction().replace(R.id.setting, new SettingsFragment()).commit();

    }
    public static class SettingsFragment extends PreferenceFragmentCompat
    {
        @Override
        public void onCreatePreferences(@Nullable Bundle savedInstanceState, @Nullable String rootKey) {
            setPreferencesFromResource(R.xml.main_preference, rootKey);
            EditTextPreference edit_text_preference = findPreference("editText_pref");
            edit_text_preference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(@NonNull Preference preference, Object newValue) {

                    return true;
                }
            });

            ListPreference backgroundColor_pref = findPreference("backgroundColor_pref");
            backgroundColor_pref.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                @Override
                public boolean onPreferenceChange(@NonNull Preference preference, Object newValue) {
                    return true;
                }
            });

            PreferenceScreen preferenceScreen = getPreferenceScreen();
            Preference backToMainButton = new Preference(requireContext());
            backToMainButton.setTitle("Back to Main");
            backToMainButton.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(@NonNull Preference preference) {
                    startActivity(new Intent(requireContext(), MainActivity.class));
                    return true;
                }
            });

            preferenceScreen.addPreference(backToMainButton);
        }
    }
}