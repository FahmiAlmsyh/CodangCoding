package com.example.codangcoding.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class dataPhone(
    val name: String,
    val detail: String,
    val image: Int
) : Parcelable
