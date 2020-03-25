package com.example.aboutme

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val myName=MyName("Arnaud")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)
        binding =DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName=myName



        //findViewById<Button>(R.id.done_button).setOnClickListener { addNickname(it) }
        binding.doneButton.setOnClickListener { addNickname(it) }
    }
    fun addNickname(view: View){
       // val editText=findViewById<EditText>(R.id.nickname_edit)
      //  val nicknameTextView=findViewById<TextView>(R.id.nickname_text)

        binding.apply {
            myName?.nickname=this.nicknameEdit.text.toString()
            //this.nicknameText.text =this.nicknameEdit.text
            binding.nicknameEdit.visibility=View.GONE
            view.visibility=View.GONE
            binding.nicknameText.visibility=View.VISIBLE
            invalidateAll()
        }
       // nicknameTextView.text=editText.text

       // editText.visibility= View.GONE
       // view.visibility= View.GONE
        //nicknameTextView.visibility=View.VISIBLE

        // hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
