package state_pattern.GUI;

import state_pattern.states.State;
import state_pattern.traffic_light_system.TrafficLight;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;


public class GUI {
    JLabel trafficLightLabel, backgroundLabel, carLabel;
    JFrame frame = new JFrame();
    TrafficLight trafficLightsVertical;

    public static void main(String[] args) {
        GUI gui = new GUI();
    }

    public GUI() {
        initialize();
        action();
    }

    public void initialize() {
        frame.setTitle("DAP STATE PATTERN - EDUARDO BARRIOS ");
        this.frame.setLocationRelativeTo(null);

        frame.setBounds(0, 0, 640, 610);
        frame.setBackground(new Color(250, 250, 250));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        trafficLightLabel = new JLabel();
        carLabel = new JLabel();
        backgroundLabel = new JLabel();
        backgroundLabel.setIcon(new ImageIcon("images/bg.jpg"));
        carLabel.setIcon(new ImageIcon("images/car.png"));
        trafficLightLabel.setBounds(380, 350, 40, 70);
        backgroundLabel.setBounds(0, 0, 625, 625);


        trafficLightLabel.setIcon(new ImageIcon("images/blinking.png"));

        trafficLightsVertical = new TrafficLight(trafficLightLabel);

        frame.add(trafficLightLabel);
        frame.add(carLabel);
        frame.add(backgroundLabel);
        frame.setVisible(true);
    }

    public void action() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                trafficLightLabel.setIcon(trafficLightsVertical.nextState());
                move(trafficLightsVertical.getState());
            }
        }, 0, trafficLightsVertical.getState().getTime());
    }
    public void move(State state) {
        int positionCar3 = 500;

        if (state.getClass().getSimpleName().equals("OnRed")) {

            for (int i = 0; i < 70; i++) {

                carLabel.setBounds(260, positionCar3, 50, 110);
                positionCar3 -= 1;
                try {
                    Thread.sleep(10);
                } catch (Exception x) {
                    // Handle exception
                }
            }
        } else if (state.getClass().getSimpleName().equals("OnOrange")) {
            positionCar3 = 360;
            for (int i = 0; i < 300; i++) {

                carLabel.setBounds(260, positionCar3, 50, 110);
                positionCar3 -= 2;

                try {
                    Thread.sleep(3);
                } catch (Exception x) {
                    // Handle exception
                }
            }
        } else if (state.getClass().getSimpleName().equals("OnGreen")) {
            positionCar3 = 500;
            for (int i = 0; i < 300; i++) {

                carLabel.setBounds(260, positionCar3, 50, 110);
                positionCar3 -= 2;

                try {
                    Thread.sleep(3);
                } catch (Exception x) {
                    // Handle exception
                }
            }
        } else if (state.getClass().getSimpleName().equals("BlinkingGreen")) {
            positionCar3 = 500;
            for (int i = 0; i < 300; i++) {

                carLabel.setBounds(260, positionCar3, 50, 110);
                positionCar3 -= 2;

                try {
                    Thread.sleep(3);
                } catch (Exception x) {
                    // Handle exception
                }
            }
        } else if (state.getClass().getSimpleName().equals("OnBlue")) {
            positionCar3 = 500;
            for (int i = 0; i < 300; i++) {

                carLabel.setBounds(260, positionCar3, 50, 110);
                positionCar3 -= 2;

                try {
                    Thread.sleep(3);
                } catch (Exception x) {
                    // Handle exception
                }
            }
        }
    }
}
