package state_pattern.traffic_light_system;

import state_pattern.states.BlinkingGreen;
import state_pattern.states.OnGreen;
import state_pattern.states.State;

import javax.swing.*;

public class TrafficLight {

    State state;

    JLabel image = new JLabel();

    public TrafficLight(JLabel vertical) {
        this.image = vertical;
        setState(new BlinkingGreen());
    }

    public void setState(State state) {
        this.state = state;
        this.state.setTrafficLights(this);
    }

    public State getState() {
        return state;
    }


    public ImageIcon nextState() {
        return this.state.nextState();
    }
}
