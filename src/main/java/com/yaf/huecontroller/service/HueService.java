package com.yaf.huecontroller.service;

import com.yaf.huecontroller.client.HueClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HueService {

    private final HueClient hueClient;

    @Autowired
    public HueService(HueClient hueClient) {
        this.hueClient = hueClient;
    }

    public void turnLightOn(int id) {
        hueClient.changeLightState(id, true);
    }

    public void turnLightOff(int id) {
        hueClient.changeLightState(id, false);
    }

    public void turnAllLightsOn() {
        hueClient.changeAllLightStates(true);
    }

    public void turnAllLightsOff() {
        hueClient.changeAllLightStates(false);
    }

    public void flick() {
        hueClient.flickLights();
    }

    public void turnLightsOnAndRed() {
        hueClient.changeAllLightStatesOnAndColor(0);
    }

}
