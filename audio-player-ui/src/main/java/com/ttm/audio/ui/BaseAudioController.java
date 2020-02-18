package com.ttm.audio.ui;

import android.content.Context;
import android.view.View;

import androidx.annotation.CallSuper;

import com.dueeeke.videoplayer.controller.ControlWrapper;
import com.dueeeke.videoplayer.controller.IControlComponent;
import com.dueeeke.videoplayer.controller.IVideoController;
import com.dueeeke.videoplayer.controller.MediaPlayerControl;
import com.dueeeke.videoplayer.player.VideoView;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 音频控制器
 * Created by dueeeke on 2017/4/7.
 */

public class BaseAudioController implements IVideoController {
    //是否开始刷新进度
    private boolean mIsStartProgress;

    //保存了所有的控制组件
    protected LinkedHashMap<IControlComponent, Boolean> mControlComponents = new LinkedHashMap<>();
    //播放器包装类，集合了MediaPlayerControl的api和IVideoController的api
    protected ControlWrapper mControlWrapper;
    private View view;

    public BaseAudioController(Context context) {
        view = new View(context);
    }

    public void release() {
        view = null;
    }

    /**
     * 重要：此方法用于将{@link VideoView} 和控制器绑定
     */
    @CallSuper
    public void setMediaPlayer(MediaPlayerControl mediaPlayer) {
        mControlWrapper = new ControlWrapper(mediaPlayer, this);
        //绑定ControlComponent和Controller
        for (Map.Entry<IControlComponent, Boolean> next : mControlComponents.entrySet()) {
            IControlComponent component = next.getKey();
            component.attach(mControlWrapper);
        }
    }

    /**
     * {@link VideoView}调用此方法向控制器设置播放状态
     */
    @CallSuper
    public void setPlayState(int playState) {
        handlePlayStateChanged(playState);
    }

    /**
     * {@link VideoView}调用此方法向控制器设置播放器状态
     */
    @CallSuper
    public void setPlayerState(final int playerState) {
        handlePlayerStateChanged(playerState);
    }

    /**
     * 开始刷新进度
     */
    @Override
    public void startProgress() {
        if (mIsStartProgress) return;
        view.post(mShowProgress);
        mIsStartProgress = true;
    }

    /**
     * 停止刷新进度
     */
    @Override
    public void stopProgress() {
        if (!mIsStartProgress) return;
        view.removeCallbacks(mShowProgress);
        mIsStartProgress = false;
    }

    /**
     * 刷新进度Runnable
     */
    private Runnable mShowProgress = new Runnable() {
        @Override
        public void run() {
            int pos = setProgress();
            if (mControlWrapper.isPlaying()) {
                view.postDelayed(mShowProgress, 1000 - (pos % 1000));
            } else {
                mIsStartProgress = false;
            }
        }
    };

    private int setProgress() {
        int position = (int) mControlWrapper.getCurrentPosition();
        int duration = (int) mControlWrapper.getDuration();
        handleSetProgress(duration, position);
        return position;
    }

    private void handlePlayStateChanged(int playState) {
        for (Map.Entry<IControlComponent, Boolean> next
                : mControlComponents.entrySet()) {
            IControlComponent component = next.getKey();
            component.onPlayStateChanged(playState);
        }
        onPlayStateChanged(playState);
    }

    /**
     * 子类重写此方法并在其中更新控制器在不同播放状态下的ui
     */
    @CallSuper
    protected void onPlayStateChanged(int playState) {
        switch (playState) {
            case VideoView.STATE_IDLE:
                break;
            case VideoView.STATE_PLAYBACK_COMPLETED:
                break;
            case VideoView.STATE_ERROR:
                break;
        }
    }

    private void handlePlayerStateChanged(int playerState) {
        for (Map.Entry<IControlComponent, Boolean> next
                : mControlComponents.entrySet()) {
            IControlComponent component = next.getKey();
            component.onPlayerStateChanged(playerState);
        }
        onPlayerStateChanged(playerState);
    }

    /**
     * 子类重写此方法并在其中更新控制器在不同播放器状态下的ui
     */
    @CallSuper
    protected void onPlayerStateChanged(int playerState) {
        switch (playerState) {
            case VideoView.PLAYER_NORMAL:
                break;
            case VideoView.PLAYER_FULL_SCREEN:
                break;
            case VideoView.PLAYER_TINY_SCREEN:
                break;
        }
    }

    private void handleSetProgress(int duration, int position) {
        for (Map.Entry<IControlComponent, Boolean> next
                : mControlComponents.entrySet()) {
            IControlComponent component = next.getKey();
            component.setProgress(duration, position);
        }
        setProgress(duration, position);
    }

    /**
     * 刷新进度回调，子类可在此方法监听进度刷新，然后更新ui
     *
     * @param duration 视频总时长
     * @param position 视频当前时长
     */
    protected void setProgress(int duration, int position) {
    }

    ////////////////////////////
    @Override
    public void startFadeOut() {
    }

    @Override
    public void stopFadeOut() {
    }

    @Override
    public boolean isShowing() {
        return false;
    }

    @Override
    public void setLocked(boolean locked) {
    }

    @Override
    public boolean isLocked() {
        return false;
    }

    @Override
    public void hide() {
    }

    @Override
    public void show() {
    }

    @Override
    public boolean hasCutout() {
        return false;
    }

    @Override
    public int getCutoutHeight() {
        return 0;
    }
}
