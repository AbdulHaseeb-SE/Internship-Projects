package urraan.internship.whatsappui

import android.content.Context
import androidx.appcompat.content.res.AppCompatResources
import androidx.lifecycle.ViewModel
import urraan.internship.whatsappui.models.CallTypes
import urraan.internship.whatsappui.models.CallsDataClass
import urraan.internship.whatsappui.models.ChatDataClass
import urraan.internship.whatsappui.models.StatusDataClass

class MainViewModel : ViewModel() {
    fun getChatList(context: Context): List<ChatDataClass> {
        return listOf(
            ChatDataClass(
                contactName = "Haris Iqbal",
                contactImage = AppCompatResources.getDrawable(context, R.drawable.harisiqbal),
                recentChatMessage = "Hi, How are you?",
                chatDateTime = "17/11/21"
            ),
            ChatDataClass(
                contactName = "Hassan Azeem",
                contactImage = AppCompatResources.getDrawable(context, R.drawable.bugatt),
                recentChatMessage = "Hey, What's up?",
                chatDateTime = "18/11/21"
            ),
            ChatDataClass(
                contactName = "Shahabdin",
                contactImage = AppCompatResources.getDrawable(
                    context,
                    R.drawable.hitman_vi_game_2014_premiere_92922_1280x720
                ),
                recentChatMessage = "Assalam-o-Alaikum Bro.",
                chatDateTime = "19/11/21"
            )
        )
    }

    fun getStatusList(context: Context): List<StatusDataClass> {
        return listOf(
            StatusDataClass(
                statusPersonName = "Shahabdin",
                statusThumbnail = AppCompatResources.getDrawable(context, R.drawable.bugatt),
                statusTime = "Today, 12:06 AM"
            ),
            StatusDataClass(
                statusPersonName = "Haris Iqbal",
                statusThumbnail = AppCompatResources.getDrawable(
                    context,
                    R.drawable.hitman_vi_game_2014_premiere_92922_1280x720
                ),
                statusTime = "Today, 01:25 PM"
            ),
            StatusDataClass(
                statusPersonName = "Abdul Haseeb",
                statusThumbnail = AppCompatResources.getDrawable(
                    context,
                    R.drawable.alone_boy_dark_pc_wallpaper_hd
                ),
                statusTime = "Yesterday, 11:30 PM"
            ),
            StatusDataClass(
                statusPersonName = "Hassan Azeem",
                statusThumbnail = AppCompatResources.getDrawable(context, R.drawable.halo),
                statusTime = "Today, 01:25 PM"
            ),
            StatusDataClass(
                statusPersonName = "Abdul Haseeb",
                statusThumbnail = AppCompatResources.getDrawable(
                    context,
                    R.drawable.alone_boy_dark_pc_wallpaper_hd
                ),
                statusTime = "Yesterday, 11:30 PM"
            ),
            StatusDataClass(
                statusPersonName = "Hassan Azeem",
                statusThumbnail = AppCompatResources.getDrawable(context, R.drawable.halo),
                statusTime = "Today, 01:25 PM"
            ),
            StatusDataClass(
                statusPersonName = "Haris Iqbal",
                statusThumbnail = AppCompatResources.getDrawable(
                    context,
                    R.drawable.hitman_vi_game_2014_premiere_92922_1280x720
                ),
                statusTime = "Yesterday, 11:30 PM"
            )
        )
    }

    fun getCallData(context: Context): List<CallsDataClass> {
        return listOf(
            CallsDataClass(
                callerName = "Haris Iqbal",
                callerImage = AppCompatResources.getDrawable(context, R.drawable.bugatt),
                callTypeImage = CallTypes.RECEIVED_CALL,
                callTime = "Today, 03:24 PM"
            ),
            CallsDataClass(
                callerName = "Shahabdin",
                callerImage = AppCompatResources.getDrawable(context, R.drawable.alone_boy_dark_pc_wallpaper_hd),
                callTypeImage = CallTypes.OUTGOING_CALL,
                callTime = "Yesterday, 07:59 AM"
            ),
            CallsDataClass(
                callerName = "Hassan Azeem",
                callerImage = AppCompatResources.getDrawable(context, R.drawable.dota_2_shadow_fiend_art_dark_111921_1280x720),
                callTypeImage = CallTypes.MISSED_CALL,
                callTime = "November 15, 2021, 08:13 PM"
            ),
            CallsDataClass(
                callerName = "Haris Iqbal",
                callerImage = AppCompatResources.getDrawable(context, R.drawable.bugatt),
                callTypeImage = CallTypes.RECEIVED_CALL,
                callTime = "November 15, 2021, 07:35 PM"
            ),
            CallsDataClass(
                callerName = "Haris Iqbal",
                callerImage = AppCompatResources.getDrawable(context, R.drawable.alone_boy_dark_pc_wallpaper_hd),
                callTypeImage = CallTypes.OUTGOING_CALL,
                callTime = "Yesterday, 07:59 AM"
            ),
            CallsDataClass(
                callerName = "Haris Iqbal",
                callerImage = AppCompatResources.getDrawable(context, R.drawable.bugatt),
                callTypeImage = CallTypes.MISSED_CALL,
                callTime = "Today, 03:24 PM"
            ),
        )
    }


}