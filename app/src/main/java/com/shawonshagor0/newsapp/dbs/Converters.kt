package com.shawonshagor0.newsapp.dbs

import androidx.room.TypeConverter
import com.shawonshagor0.newsapp.models.Source

class Converters {
    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }
    @TypeConverter
    fun toSource(name: String): Source{
        return Source (name, name)
    }
}