package urraan.internship.chapter2_loginpage.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Bike (
    @PrimaryKey(autoGenerate = false)
    val model_No: String,
    val company: String,
    val engine_capacity: String,
    val price: Int
        )