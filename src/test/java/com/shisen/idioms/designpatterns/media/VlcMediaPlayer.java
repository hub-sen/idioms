package com.shisen.idioms.designpatterns.media;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/6/18 11:15
 * </pre>
 */
public class VlcMediaPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("vlcPlayer playing = " + fileName);
    }

    @Override
    public void playMp4(String fileName) {

    }
}
