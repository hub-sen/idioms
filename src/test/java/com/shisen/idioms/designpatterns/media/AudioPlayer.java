package com.shisen.idioms.designpatterns.media;

/**
 * <pre>
 * Description
 * @author shishi
 * 2020/6/18 11:22
 * </pre>
 */
public class AudioPlayer implements MediaPlayer {

    private MediaAdapter mediaAdapter;

    @Override
    public void play(String fileName, String fileType) {
        MediaAdapter mediaAdapter = new MediaAdapter(fileType);
        mediaAdapter.play(fileName,fileType);
    }

    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("11","vlc");
        audioPlayer.play("22","mp4");
    }
}
