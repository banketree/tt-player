package com.ttm.audio.player

import android.content.Context

import com.dueeeke.videoplayer.ijk.IjkPlayer
import tv.danmaku.ijk.media.player.IjkMediaPlayer

class CustomIjkMediaPlayer(context: Context) : IjkPlayer(context) {

    /**
     * 设置IjkMediaPlayer.OPT_CATEGORY_PLAYER相关配置
     */
    fun setPlayerOption(name: String, value: String) {
        mMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, name, value)
    }

    /**
     * 设置IjkMediaPlayer.OPT_CATEGORY_PLAYER相关配置
     */
    fun setPlayerOption(name: String, value: Long) {
        mMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_PLAYER, name, value)
    }

    /**
     * 设置IjkMediaPlayer.OPT_CATEGORY_FORMAT相关配置
     */
    fun setFormatOption(name: String, value: String) {
        mMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_FORMAT, name, value)
    }

    /**
     * 设置IjkMediaPlayer.OPT_CATEGORY_FORMAT相关配置
     */
    fun setFormatOption(name: String, value: Long) {
        mMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_FORMAT, name, value)
    }

    /**
     * 设置IjkMediaPlayer.OPT_CATEGORY_CODEC相关配置
     */
    fun setCodecOption(name: String, value: String) {
        mMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_CODEC, name, value)
    }

    /**
     * 设置IjkMediaPlayer.OPT_CATEGORY_CODEC相关配置
     */
    fun setCodecOption(name: String, value: Long) {
        mMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_CODEC, name, value)
    }

    /**
     * 设置IjkMediaPlayer.OPT_CATEGORY_SWS相关配置
     */
    fun setSwsOption(name: String, value: String) {
        mMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_SWS, name, value)
    }

    /**
     * 设置IjkMediaPlayer.OPT_CATEGORY_SWS相关配置
     */
    fun setSwsOption(name: String, value: Long) {
        mMediaPlayer.setOption(IjkMediaPlayer.OPT_CATEGORY_SWS, name, value)
    }

}
