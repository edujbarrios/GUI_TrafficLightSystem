package state_pattern.states;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import java.io.File;
import java.util.Random;

import state_pattern.traffic_light_system.TrafficLight;

public class OnBlue implements State {

    TrafficLight trafficLight;
    private AudioInputStream sound;
    private Clip clip;
    private long time = 3000;

    //Modificacion para usar random
    private Random random = new Random();

    public OnBlue() {
        try {
            sound = AudioSystem.getAudioInputStream(new File("sound/green.wav").getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(sound);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Implementacion del random
    public ImageIcon nextState() {
        clip.close();
        int choice = random.nextInt(4); // Numero random entre 0 y 3
        switch (choice) {
            case 0:
                trafficLight.setState(new OnGreen());
                return new ImageIcon("images/green.png");
            case 1:
                trafficLight.setState(new OnOrange());
                return new ImageIcon("images/yellow.png");
            case 2:
                trafficLight.setState(new OnRed());
                return new ImageIcon("images/red.png");
            case 3:
                trafficLight.setState(new BlinkingGreen());
                return new ImageIcon("images/blinking.png");
            default:

                break;
        }
        return null;
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