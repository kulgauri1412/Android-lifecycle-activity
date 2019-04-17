package com.example.demo1

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val TAG="MainActivity"    //String for LogCat documentation

    //Creating String to get value from textview and save it in bundle
    var savestart: String="Savestart"
    var savecreate: String="Savecreate"
    var saveresume: String="Saveresume"
    var savepause: String="savepause"
    var saverestart: String="Saverestart"
    var savestop: String="Savestop"
    var savedestroy: String="Savedestroy"
    var saveinstance: String="Saveinstance"
    var saverestore: String="Saverestore"


    //Creating counters for Activity Lifecycle
    private var onCreateCounter: Int=0
    private var onStartCounter: Int=0
    private var onResumeCounter: Int=0
    private var onPauseCounter: Int=0
    private var onStopCounter: Int=0
    private var onRestartCounter: Int=0
    private var onDestroyCounter: Int=0
    private var onSaveCounter: Int=0
    private var onRestoreCounter: Int=0

    //Initializing all TextView
    lateinit var textView: TextView
    lateinit var textView2: TextView
    lateinit var textView3: TextView
    lateinit var textView4: TextView
    lateinit var textView5: TextView
    lateinit var textView6: TextView
    lateinit var textView7: TextView
    lateinit var textView8: TextView
    lateinit var textView9: TextView

    //creating string object for shared preferences
    val sharedString: String="SharedString"


    //Start of Activity lifecycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var sharedPreferences: SharedPreferences=getSharedPreferences("sharedString", Context.MODE_PRIVATE)

        if (savedInstanceState != null) {
            onCreateCounter=sharedPreferences.getInt("oncreate", 0)
            onStartCounter=sharedPreferences.getInt("onstart", 0)
            onResumeCounter=sharedPreferences.getInt("onresume", 0)
            onPauseCounter=sharedPreferences.getInt("onpause", 0)
            onStopCounter=sharedPreferences.getInt("onstop", 0)
            onRestartCounter=sharedPreferences.getInt("onrestart", 0)
            onDestroyCounter=sharedPreferences.getInt("ondestroy", 0)
            onSaveCounter=sharedPreferences.getInt("onsave", 0)
            onRestoreCounter=sharedPreferences.getInt("onrestore", 0)

        }
        setContentView(R.layout.activity_main)

        textView=findViewById<TextView>(R.id.textView)

        onCreateCounter=sharedPreferences.getInt("oncreate", 0)

        onCreateCounter+=1
        var editor=sharedPreferences.edit()
        editor.putInt("oncreate", onCreateCounter)
        editor.apply()

        textView.text=resources.getString(R.string.text_View) + onCreateCounter.toString()

        // Calling shredpreference data of onPause , onReset, onStop, onDestroy, onSaveInstance & onRestoreInstance

        textView4=findViewById(R.id.textView4)
        onPauseCounter=sharedPreferences.getInt("onpause", 0)
        textView4.text=resources.getString(R.string.textView4) + " $onPauseCounter"

        textView5=findViewById(R.id.textView5)
        onRestartCounter=sharedPreferences.getInt("onrestart", 0)
        textView5.text=resources.getString(R.string.textView5) + " $onRestartCounter"

        textView6=findViewById(R.id.textView6)
        onStopCounter=sharedPreferences.getInt("onstop", 0)
        textView6.text=resources.getString(R.string.textView6) + " $onStopCounter"

        textView7=findViewById(R.id.textView7)
        onDestroyCounter=sharedPreferences.getInt("ondestroy", 0)
        textView7.text=resources.getString(R.string.textView7) + " $onDestroyCounter"

        textView8=findViewById(R.id.textView8)
        onSaveCounter=sharedPreferences.getInt("onsave", 0)
        textView8.text=resources.getString(R.string.textView8) + " $onSaveCounter"

        textView9=findViewById(R.id.textView9)
        onRestoreCounter=sharedPreferences.getInt("onrestore", 0)
        textView9.text=resources.getString(R.string.textView9) + " $onRestoreCounter"

        Log.i(TAG, "onCreate $onCreateCounter ") //Logs that shows information and value of count

        //initialize button for button click reset
        val buttonClick=findViewById<Button>(R.id.button)
        buttonClick?.setOnClickListener {
            sendMessage()
        }

    }


    override fun onStart() {
        super.onStart()
        val sharedPreferences: SharedPreferences=getSharedPreferences("sharedString", Context.MODE_PRIVATE)
        textView2=findViewById<TextView>(R.id.textView2)

        onStartCounter=sharedPreferences.getInt("onstart", 0)
        onStartCounter+=1

        textView2.text=resources.getString(R.string.textView2) + onStartCounter.toString()

        var editor=sharedPreferences.edit()
        editor.putInt("onstart", onStartCounter)
        editor.apply()

        Log.i(TAG, "onStart $onStartCounter")


    }

    override fun onResume() {
        super.onResume()
        val sharedPreferences: SharedPreferences=getSharedPreferences("sharedString", Context.MODE_PRIVATE)
        textView3=findViewById<TextView>(R.id.textView3)

        onResumeCounter=sharedPreferences.getInt("onresume", 0)
        onResumeCounter+=1

        textView3.text=resources.getString(R.string.textView3) + onResumeCounter.toString()

        var editor=sharedPreferences.edit()
        editor.putInt("onresume", onResumeCounter)
        editor.apply()

        Log.i(TAG, "onResume $onResumeCounter")

    }

    override fun onPause() {
        super.onPause()
        val sharedPreferences: SharedPreferences=getSharedPreferences("sharedString", Context.MODE_PRIVATE)

        onPauseCounter=sharedPreferences.getInt("onpause", 0)
        onPauseCounter+=1

        textView4.text=resources.getString(R.string.textView4) + onPauseCounter.toString()

        var editor=sharedPreferences.edit()
        editor.putInt("onpause", onPauseCounter)
        editor.apply()

        Log.i(TAG, "onPause $onPauseCounter")

    }

    override fun onStop() {
        super.onStop()
        val sharedPreferences: SharedPreferences=getSharedPreferences("sharedString", Context.MODE_PRIVATE)

        onStopCounter=sharedPreferences.getInt("onstop", 0)
        onStopCounter+=1

        textView6.text=resources.getString(R.string.textView6) + onStopCounter.toString()

        var editor=sharedPreferences.edit()
        editor.putInt("onstop", onStopCounter)
        editor.apply()

        Log.i(TAG, "onStop $onStopCounter")
    }

    override fun onRestart() {
        super.onRestart()
        val sharedPreferences: SharedPreferences=getSharedPreferences("sharedString", Context.MODE_PRIVATE)

        onRestartCounter=sharedPreferences.getInt("onrestart", 0)
        onRestartCounter+=1

        textView5.text=resources.getString(R.string.textView5) + onRestartCounter.toString()

        var editor=sharedPreferences.edit()
        editor.putInt("onrestart", onRestartCounter)
        editor.apply()

        Log.i(TAG, "onRestart $onRestartCounter")
    }

    override fun onDestroy() {
        super.onDestroy()
        val sharedPreferences: SharedPreferences=getSharedPreferences("sharedString", Context.MODE_PRIVATE)

        onDestroyCounter=sharedPreferences.getInt("ondestroy", 0)
        onDestroyCounter+=1

        textView7.text=resources.getString(R.string.textView7) + onDestroyCounter.toString()

        var editor=sharedPreferences.edit()
        editor.putInt("ondestroy", onDestroyCounter)
        editor.apply()

        Log.i(TAG, "onDestroy $onDestroyCounter")
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        val sharedPreferences: SharedPreferences=getSharedPreferences("sharedString", Context.MODE_PRIVATE)

        onSaveCounter=sharedPreferences.getInt("onsave", 0)
        onSaveCounter+=1

        textView8.text=resources.getString(R.string.textView8) + onSaveCounter.toString()

        var editor=sharedPreferences.edit()
        editor.putInt("onsave", onSaveCounter)
        editor.apply()

        Log.i(TAG, "onSaveInstance $onSaveCounter")

        savestart=textView2.getText().toString()
        savecreate=textView.getText().toString()
        saveresume=textView3.getText().toString()
        savepause=textView4.getText().toString()
        saverestart=textView5.getText().toString()
        savestop=textView6.getText().toString()
        savedestroy=textView7.getText().toString()
        saveinstance=textView8.getText().toString()
        saverestore=textView9.getText().toString()


        outState?.putString("create", savecreate)
        outState?.putString("start", savestart)
        outState?.putString("resume", saveresume)
        outState?.putString("pause", savepause)
        outState?.putString("restart", saverestart)
        outState?.putString("stop", savestop)
        outState?.putString("destroy", savedestroy)
        outState?.putString("save", saveinstance)
        outState?.putString("restore", saverestore)


        Log.i(
            TAG,
            "onSaveInstanceState $savecreate $savestart $saveresume $savepause $saverestart $savestop $savedestroy $saveinstance $saverestore"
        )
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        val sharedPreferences: SharedPreferences=getSharedPreferences("sharedString", Context.MODE_PRIVATE)

        onRestoreCounter=sharedPreferences.getInt("onrestore", 0)
        onRestoreCounter+=1

        textView9.text=resources.getString(R.string.textView9) + onRestoreCounter.toString()

        var editor=sharedPreferences.edit()
        editor.putInt("onrestore", onRestoreCounter)
        editor.apply()

        Log.i(TAG, "onRestoreInstance $onRestoreCounter")

        val create=savedInstanceState?.getString("create")
        val start=savedInstanceState?.getString("start")
        val resume=savedInstanceState?.getString("resume")
        val pause=savedInstanceState?.getString("pause")
        val restart=savedInstanceState?.getString("restart")
        val stop=savedInstanceState?.getString("stop")
        val destroy=savedInstanceState?.getString("destroy")
        val save=savedInstanceState?.getString("save")
        val restore=savedInstanceState?.getString("restore")


        Log.i(TAG, "onRestoreInstanceState $create $start $resume $pause $restart $stop $destroy $save $restore")
    }

    //Set shared preferences to zero onClick of reset button
    @SuppressLint("SetTextI18n")
    private fun sendMessage() {
        val sharedPreferences: SharedPreferences=getSharedPreferences("sharedString", Context.MODE_PRIVATE)
        var editor=sharedPreferences.edit()

        //Set shared preference value  to zero
        onCreateCounter=sharedPreferences.getInt("oncreate", 0)
        onResumeCounter=sharedPreferences.getInt("onresume", 0)
        onStartCounter=sharedPreferences.getInt("onstart", 0)
        onPauseCounter=sharedPreferences.getInt("onpause", 0)
        onStopCounter=sharedPreferences.getInt("onstop", 0)
        onRestartCounter=sharedPreferences.getInt("onrestart", 0)
        onDestroyCounter=sharedPreferences.getInt("ondestroy", 0)
        onSaveCounter=sharedPreferences.getInt("onsave", 0)
        onRestoreCounter=sharedPreferences.getInt("onrestore", 0)

        onCreateCounter=0
        onResumeCounter=0
        onStartCounter=0
        onPauseCounter=0
        onStopCounter=0
        onRestartCounter=0
        onDestroyCounter=0
        onSaveCounter=0
        onRestoreCounter=0

        editor.putInt("oncreate", onCreateCounter)
        editor.putInt("onresume", onResumeCounter)
        editor.putInt("onstart", onStartCounter)
        editor.putInt("onpause", onPauseCounter)
        editor.putInt("onrestart", onRestartCounter)
        editor.putInt("onstop", onStopCounter)
        editor.putInt("ondestroy", onDestroyCounter)
        editor.putInt("onsave", onSaveCounter)
        editor.putInt("onrestore", onRestoreCounter)

        editor.apply()

        textView.text=resources.getString(R.string.text_View) + onCreateCounter.toString()

        textView3.text=resources.getString(R.string.textView3) + onResumeCounter.toString()

        textView2.text=resources.getString(R.string.textView2) + onStartCounter.toString()

        textView4.text=resources.getString(R.string.textView4) + onPauseCounter.toString()

        textView5.text=resources.getString(R.string.textView5) + onRestartCounter.toString()

        textView6.text=resources.getString(R.string.textView6) + onStopCounter.toString()

        textView7.text=resources.getString(R.string.textView7) + onDestroyCounter.toString()

        textView8.text=resources.getString(R.string.textView8) + onSaveCounter.toString()

        textView9.text=resources.getString(R.string.textView9) + onRestoreCounter.toString()

        Log.i(
            TAG,
            "onReset ${textView.text}${textView2.text} ${textView3.text} ${textView4.text} ${textView5.text} ${textView6.text} ${textView7.text} ${textView8.text} ${textView9.text}"
        ) //Logs show value of activity after reset


        Toast.makeText(this@MainActivity, resources.getString(R.string.reset_click), Toast.LENGTH_SHORT).show() //set shared preference value of onStart to ze

    }

}







