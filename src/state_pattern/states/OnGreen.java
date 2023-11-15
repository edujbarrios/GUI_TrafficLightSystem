package state_pattern.states;

import javax.sound.sampled.AudioInputStream;

import state_pattern.traffic_light_system.TrafficLight;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;

import java.io.File;

public class OnGreen implements State {

    TrafficLight trafficLight;

    private AudioInputStream sound;

    private Clip clip;

    private long time = 3000;

    public OnGreen() {
        try {
            sound = AudioSystem.getAudioInputStream(new File("sound/green.wav").getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(sound);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ImageIcon nextState() {
        clip.close();
        trafficLight.setState(new BlinkingGreen());
        return new ImageIcon("images/blinking.png");
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
