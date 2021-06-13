package com.kzu404.tutorial01

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Address(val street: String?, val number: Int?) : Parcelable
