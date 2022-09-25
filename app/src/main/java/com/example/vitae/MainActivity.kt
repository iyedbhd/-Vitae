package com.example.vitae

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns.EMAIL_ADDRESS
import android.view.View
import android.widget.EditText
import android.widget.SeekBar
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun submit(view: View)
    {
        val Name = findViewById<EditText>(R.id.fullnameTxt)
        val Age = findViewById<EditText>(R.id.ageTxt)
        val Email = findViewById<EditText>(R.id.emailTxt)

        if(TextUtils.isEmpty(Name.text) || TextUtils.isEmpty(Age.text) || TextUtils.isEmpty(Email.text))
        {
            Toast.makeText(this,"Error: Empty Field",Toast.LENGTH_LONG).show()
        }
        else if(!EMAIL_ADDRESS.matcher(Email.text).matches())Toast.makeText(this,"Wrong E-mail format",Toast.LENGTH_LONG).show()

        val iOSSeekBar = findViewById<SeekBar>(R.id.iosSkill);
        val androidSeekBar = findViewById<SeekBar>(R.id.androidSkill);
        val flutterSeekBar = findViewById<SeekBar>(R.id.flutterSkill);
        val map = mapOf<String, SeekBar>("IOS" to iOSSeekBar, "Android" to androidSeekBar, "Flutter" to flutterSeekBar)
        var topSkill = "";
        var topSkillScore = 0;
        var failure = true;
        map.forEach(){

            if(it.value.progress>=80 && it.value.progress >topSkillScore)
            {
                failure = false;
                topSkill = it.key;
                topSkillScore = it.value.progress;
            }
            else if(it.value.progress>30)
            {
                failure = false;
            }
        }
        if(failure)
        {
            Toast.makeText(this,"Vous devez travailler vos skills",Toast.LENGTH_LONG).show()
        }
        else if(topSkill != "")
        {
            Toast.makeText(this, "Vous êtes excellent en $topSkill",Toast.LENGTH_LONG).show()
        }
        else
        {
            Toast.makeText(this, "Vous avez de bons skills !",Toast.LENGTH_LONG).show()
        }

    }
    fun reset(view: View)
    {

    }

}