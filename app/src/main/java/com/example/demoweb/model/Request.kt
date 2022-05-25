package com.example.demoweb.model

import android.os.Build
import android.util.Log
import com.beust.klaxon.Klaxon
import com.example.demoweb.model.constants.Constants
import com.example.demoweb.model.entity.Content
import com.example.demoweb.model.entity.Ids
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

class Request : IRequest {
    override fun getIds() {
        var ids = Ids()
        GlobalScope.launch(Dispatchers.IO) {

            val url = URL(Constants.LAUNCH_LINK)

            with(url.openConnection() as HttpURLConnection) {
                requestMethod = "GET"  // optional default is GET
                var link = ""
                inputStream.bufferedReader().use {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        it.lines().forEach { line ->
                            link += line
                            ids = Klaxon().parse<Ids>(link)!!
                            DataStorage.ids = ids

                        }
                    }
                }


            }
        }
    }

    override fun getContent(count: String, onResult: (result: Content) -> Unit) {
        var content = Content()
        GlobalScope.launch(Dispatchers.IO) {

            val url = URL(Constants.MAIN_LINK + count)

            with(url.openConnection() as HttpURLConnection) {
                requestMethod = "GET"  // optional default is GET
                var link = ""
                inputStream.bufferedReader().use {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        it.lines().forEach { line ->
                            link += line

                            content = Klaxon().parse<Content>(link)!!
                            onResult(content)


                        }
                    }
                }

            }
        }
    }
}

