package com.mostafa.data.local.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class Converters {


    @TypeConverter
    fun nasaEntityToString(keywords: List<String>): String {
        return Gson().toJson(keywords)
    }


    @TypeConverter
    fun stringToNasaEntity(data: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(data, listType)
    }




}