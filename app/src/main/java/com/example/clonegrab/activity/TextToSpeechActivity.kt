package com.example.clonegrab.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.clonegrab.R
import java.util.*

class TextToSpeechActivity : AppCompatActivity(){
    lateinit var speakBtn : Button
    lateinit var  mTTS : TextToSpeech
    lateinit var textEt : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_to_speech)

        mTTS = TextToSpeech(applicationContext,TextToSpeech.OnInitListener { status ->
            if (status != TextToSpeech.ERROR){
                mTTS.language = Locale("th")
            }
        })
        textEt = findViewById(R.id.edText_input)
        speakBtn = findViewById(R.id.button_speak)
        speakBtn.setOnClickListener {
            val toSpeak = textEt.text.toString()
            if (toSpeak == ""){
                Toast.makeText(this,"1",Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this,"2",Toast.LENGTH_SHORT).show()
                mTTS.speak(toSpeak,TextToSpeech.QUEUE_FLUSH,null)
            }
        }



    }


}