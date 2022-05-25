package com.example.demoweb.presenter

import android.util.Log
import com.example.demoweb.model.DataStorage
import com.example.demoweb.model.Request
import com.example.demoweb.model.entity.Content

class BasePresenter : IBasePresenter {
    private var request = Request()
    private var currentPosition = 0
    companion object{
    private var currentContent = Content()}

    fun getData() {
        request.getIds()
    }


    fun setImageFragmentContent(): String {
        return currentContent.url

    }

    fun setTextFragment(): String {
        return currentContent.message
    }

    fun loadUrl(): String {
        return currentContent.url
    }

    fun checkIdsIsEmpty(): Boolean {
        return DataStorage.ids.data.isNullOrEmpty()
    }

    fun getContent(onResult: (result: Content) -> Unit) {
        val number = (DataStorage.ids.data[currentPosition].id).toString()
        request.getContent(number)
        { onResult ->
            currentContent = onResult
            onResult(currentContent)
        }
        if (currentPosition == (DataStorage.ids.data.size - 1)) {
            currentPosition = 0
        } else {
            currentPosition++
        }
    }


    fun checkTypeContent(content: Content): String {
        return when (currentContent.type) {
            "text" -> "text"
            "webview" -> "webview"
            "image" -> "image"
            "game" -> "game"
            else -> "null"
        }
    }
}

