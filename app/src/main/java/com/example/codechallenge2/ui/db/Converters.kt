package com.example.codechallenge2.ui.db


import androidx.room.TypeConverter
import com.example.codechallenge2.ui.models.Rating

class Converters {

    @TypeConverter
     fun fromRating(rating: Rating): Double {
         return rating.rate
     }

    @TypeConverter
    fun toRating(rate : Double): Rating {
        return Rating(rate,rate)
    }
}