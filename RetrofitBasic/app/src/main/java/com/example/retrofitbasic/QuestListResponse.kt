package com.example.retrofitbasic

import com.google.gson.annotations.SerializedName

data class QuestListResponse(val items: List<QuestListItem>)

data class QuestListItem(
    val questId: String,

    @SerializedName("questName")
    val name: String,

    @SerializedName("questSubtitle")
    val subtitle: String,

    @SerializedName("questImage")
    val image: String,

    @SerializedName("description")
    val items: List<RemoteListItem>

)

data class RemoteListItem(
    val type: String,
    val content: String
)






