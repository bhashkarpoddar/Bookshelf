package com.example.bookshelf.utils

import com.example.bookshelf.domain.model.networkResult.ResponseResult
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONArray


/**Convert simple object to String with Gson*/
inline fun <reified T : Any> T.toSimpleJson() : String =  Gson().toJson(this, T::class.java)

/**Convert String Json to Object*/
inline fun <reified T : Any> String.fromJsonToObject() : T =  Gson().fromJson(this ,  T::class.java)

/**Convert String List Json to Object*/
inline fun <reified T : Any> String.fromJsonToObjectList() : MutableList <T> =  when( this.isNotEmpty()){
    true -> Gson().fromJson(this, object : TypeToken<MutableList<T>>() {}.type)
    false -> mutableListOf()
}

fun JSONArray.toMutableList(): MutableList<Any> = MutableList(length(), this::get)

inline fun <T> safeCall(action: () -> ResponseResult<T>): ResponseResult<T> {
    return try {
        action()
    } catch (e: Exception) {
        e.printStackTrace()
        ResponseResult.Failure(message = e.message!!, throwable = e)
    }
}