package com.shisen.idioms.designpatterns.media;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/6/18 11:16
 * </pre>
 */
public class Mp4MediaPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("mp4Player playing = " + fileName);
    }
}
