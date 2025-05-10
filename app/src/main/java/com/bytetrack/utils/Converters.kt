package com.bytetrack.utils

import androidx.room.TypeConverter
import com.bytetrack.data.model.DrinkType
import com.bytetrack.data.model.MealType
import java.util.Date

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
    
    @TypeConverter
    fun fromMealType(mealType: MealType): String {
        return mealType.name
    }
    
    @TypeConverter
    fun toMealType(value: String): MealType {
        return enumValueOf(value)
    }
    
    @TypeConverter
    fun fromDrinkType(drinkType: DrinkType): String {
        return drinkType.name
    }
    
    @TypeConverter
    fun toDrinkType(value: String): DrinkType {
        return enumValueOf(value)
    }
} 