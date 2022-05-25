package com.example.demoweb.model

import com.example.demoweb.model.entity.Content
import com.example.demoweb.model.entity.Ids

interface IRequest {
    fun getIds()
    fun getContent(count: String, onResult:( result:Content)->Unit)
}