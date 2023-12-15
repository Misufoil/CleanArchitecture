package com.example.cleanarchitecturemyapplication.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.cleanarchitecturemyapplication.R
import com.example.cleanarchitecturemyapplication.data.repository.UserRepositoryImpl
import com.example.cleanarchitecturemyapplication.data.storage.UserStorage
import com.example.cleanarchitecturemyapplication.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.cleanarchitecturemyapplication.domain.models.SaveUsernameParam
import com.example.cleanarchitecturemyapplication.domain.models.UserName
import com.example.cleanarchitecturemyapplication.domain.usecase.GetUserNameUseCase
import com.example.cleanarchitecturemyapplication.domain.usecase.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = applicationContext))
    }
    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(userRepository = userRepository)
    }
    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(userRepository = userRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditView = findViewById<EditText>(R.id.dataEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)

        sendButton.setOnClickListener {
            val text = dataEditView.text.toString()
            val param = SaveUsernameParam(name = text)
            val result: Boolean = saveUserNameUseCase.execute(param = param)

            dataTextView.text = "Save result = $result"
        }

        receiveButton.setOnClickListener {
            val userName: UserName = getUserNameUseCase.execute()
            dataTextView.text = "Save result = ${userName.firstName} ${userName.lastName}"
        }

    }
}