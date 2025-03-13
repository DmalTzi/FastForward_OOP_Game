package main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import utilz.LoadSave;

public class Sound {
    Clip clip;
    URL soundURL[] = new URL[10];

    public Sound(){

        soundURL[0] = getClass().getResource("/res/sound/TitleSou.wav");
        soundURL[1] = getClass().getResource("/res/Sound/Result.wav");
        soundURL[2] = getClass().getResource("/res/Sound/Gameplay.wav");

    }

    public void setFile(int i){
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play(){
        clip.start();
    }

    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);

    }

    public void stop(){
        clip.stop();
    }

    public void mute(float n){
        FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            
        // Reduce volume (range: -80.0 to 6.0 dB)
        float volume = n; // Lower is quieter (e.g., -20.0 is very soft)
        volumeControl.setValue(volume);

    }
}   
