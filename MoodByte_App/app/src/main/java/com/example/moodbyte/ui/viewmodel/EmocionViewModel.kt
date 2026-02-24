package com.example.moodbyte.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class EmocionViewModel: ViewModel() {
    var EmocionGenerada by mutableStateOf<String>("Regular")
        private set

    fun setEmocion(emo: String){
        EmocionGenerada=emo
    }
    fun getEmocion():String{
        return EmocionGenerada
    }
}