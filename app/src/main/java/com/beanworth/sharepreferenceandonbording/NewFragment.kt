package com.beanworth.sharepreferenceandonbording

import android.app.Activity
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView

class NewFragment : Fragment() {
lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = (context as Activity).getSharedPreferences("USER",MODE_PRIVATE)
        editor = sharedPreferences.edit()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val name = view?.findViewById<TextView>(R.id.name)
        val password = view?.findViewById<TextView>(R.id.password)
        name?.text = sharedPreferences.getString("name","")
        password?.text = sharedPreferences.getString("password","")
    }
}