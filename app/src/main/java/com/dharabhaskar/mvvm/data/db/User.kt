package com.dharabhaskar.mvvm.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

const val CURRENT_USER_ID=0

@Entity
data class User(
    var id:Int?=null,
    var name:String?=null,
    var email:String?=null,
    @SerializedName("email_verified_at")
    var emailVerifiedAt:String?=null,
    @SerializedName("created_at")
    var createdAt:String?=null,
    @SerializedName("updated_at")
    var updatedAt:String?=null
){
    @PrimaryKey
    var uid:Int= CURRENT_USER_ID
}