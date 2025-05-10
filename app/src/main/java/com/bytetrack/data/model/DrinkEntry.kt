package com.bytetrack.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "drink_entries")
data class DrinkEntry(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val date: Date,
    val type: DrinkType,
    val amount: Float, // in ml
    val calories: Int = 0
)

enum class DrinkType {
    WATER,
    COFFEE,
    TEA,
    SODA,
    JUICE,
    SMOOTHIE,
    ALCOHOL,
    OTHER
} 