package com.banketree.ttplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.dueeeke.videocontroller.StandardVideoController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val URL_AD = "https://gslb.miaopai.com/stream/IR3oMYDhrON5huCmf7sHCfnU5YKEkgO2.mp4"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        video_view.setUrl(URL_AD)
        //必须设置
        video_view.setEnableAudioFocus(false)
        val controller2 = StandardVideoController(this)
        controller2.addDefaultControlComponent(getString(R.string.str_player), false)
        video_view.setVideoController(controller2)
//        video_view.start()
//
        Glide.with(this)
            .load("file:///android_asset/img6.jpg")
            .placeholder(android.R.color.darker_gray)
            .into(controller2.previewImage)
    }

}
