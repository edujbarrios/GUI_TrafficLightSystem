package state_pattern.states;

import state_pattern.traffic_light_system.TrafficLight;

import javax.swing.*;

public interface State {


    public ImageIcon nextState();

    public void setTrafficLights(TrafficLight trafficLights);

    public long getTime();

}
