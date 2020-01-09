package com.ttm.video.player

import android.content.Context
import android.util.AttributeSet

import com.dueeeke.videoplayer.player.PlayerFactory
import com.dueeeke.videoplayer.player.VideoView

import java.util.HashMap

class IjkVideoView : VideoView<CustomIjkMediaPlayer> {

    private val mPlayerOptions = HashMap<String, Any>()
    private val mFormatOptions = HashMap<String, Any>()
    private val mCodecOptions = HashMap<String, Any>()
    private val mSwsOptions = HashMap<String, Any>()

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    init {
        setPlayerFactory(object : PlayerFactory<CustomIjkMediaPlayer>() {
            override fun createPlayer(context: Context): CustomIjkMediaPlayer {
                return CustomIjkMediaPlayer(context)
            }
        })
    }

    override fun setOptions() {
        super.setOptions()
        for ((key, value) in mPlayerOptions) {
            if (value is String) {
                mMediaPlayer.setPlayerOption(key, value)
            } else if (value is Long) {
                mMediaPlayer.setPlayerOption(key, value)
            }
        }
        for ((key, value) in mFormatOptions) {
            if (value is String) {
                mMediaPlayer.setFormatOption(key, value)
            } else if (value is Long) {
                mMediaPlayer.setFormatOption(key, value)
            }
        }
        for ((key, value) in mCodecOptions) {
            if (value is String) {
                mMediaPlayer.setCodecOption(key, value)
            } else if (value is Long) {
                mMediaPlayer.setCodecOption(key, value)
            }
        }
        for ((key, value) in mSwsOptions) {
            if (value is String) {
                mMediaPlayer.setSwsOption(key, value)
            } else if (value is Long) {
                mMediaPlayer.setSwsOption(key, value)
            }
        }
    }

    /**
     * 开启硬解
     */
    fun setEnableMediaCodec(isEnable: Boolean) {
        val value = if (isEnable) 1 else 0
        addPlayerOption("mediacodec", value.toLong())
        addPlayerOption("mediacodec-auto-rotate", value.toLong())
        addPlayerOption("mediacodec-handle-resolution-change", value.toLong())
        addPlayerOption("mediacodec-hevc", value.toLong())//开启hevc硬解
    }

    /**
     * 开启精准seek，可以解决由于视频关键帧较少导致的seek不准确问题
     */
    fun setEnableAccurateSeek(isEnable: Boolean) {
        addPlayerOption("enable-accurate-seek", (if (isEnable) 1 else 0).toLong())
    }


    fun addPlayerOption(name: String, value: String) {
        mPlayerOptions[name] = value
    }

    fun addPlayerOption(name: String, value: Long) {
        mPlayerOptions[name] = value
    }


    fun addFormatOption(name: String, value: String) {
        mFormatOptions[name] = value
    }

    fun addFormatOption(name: String, value: Long) {
        mFormatOptions[name] = value
    }


    fun addCodecOption(name: String, value: String) {
        mCodecOptions[name] = value
    }

    fun addCodecOption(name: String, value: Long) {
        mCodecOptions[name] = value
    }


    fun addSwsOption(name: String, value: String) {
        mSwsOptions[name] = value
    }

    fun addSwsOption(name: String, value: Long) {
        mSwsOptions[name] = value
    }

}
