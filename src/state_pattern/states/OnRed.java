package state_pattern.states;

import state_pattern.traffic_light_system.TrafficLight;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

import java.io.File;

public class OnRed implements State {

    TrafficLight trafficLight;

    private long time = 3000;

    private AudioInputStream sound;

    private Clip clip;

    public OnRed() {
        try {
            sound = AudioSystem.getAudioInputStream(new File("sound/red.wav").getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(sound);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public ImageIcon nextState() {
        clip.close();
        trafficLight.setState(new OnOrange());
        return new ImageIcon("images/yellow.png");
    }

    @Override
    public void setTrafficLights(TrafficLight trafficLights) {
        this.trafficLight = trafficLights;
    }

    @Override
    public long getTime() {
        return time;
    }
}


