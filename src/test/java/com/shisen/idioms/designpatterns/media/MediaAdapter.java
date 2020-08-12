package com.shisen.idioms.designpatterns.media;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/6/18 11:17
 * </pre>
 */
public class MediaAdapter implements MediaPlayer {

    private AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String fileType){
        switch (fileType) {
            case "vlc":
                this.advancedMediaPlayer = new VlcMediaPlayer();
                break;
            case "mp4":
                this.advancedMediaPlayer = new Mp4MediaPlayer();
        }
    }

    @Override
    public void play(String fileName, String fileType) {
        switch (fileType){
            case "vlc":
                advancedMediaPlayer.playVlc(fileName);
                break;
            case "mp4":
                advancedMediaPlayer.playMp4(fileName);
        }
    }
}
