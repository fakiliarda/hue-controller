package com.yaf.huecontroller.controller;

import com.yaf.huecontroller.service.HueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HueController {

    @Autowired
    private HueService hueService;

    @GetMapping("turn-light-on")
    public void turnLightOn(@RequestHeader int lightId) {
        hueService.turnLightOn(lightId);
    }

    @GetMapping("turn-light-off")
    public void turnLightOff(@RequestHeader int lightId) {
        hueService.turnLightOff(lightId);
    }

    @GetMapping("turn-all-lights-on")
    public void turnAllLightsOn() {
        hueService.turnAllLightsOn();
    }

    @GetMapping("turn-all-lights-off")
    public void turnAllLightsOff() {
        hueService.turnAllLightsOff();
    }

    @GetMapping("turn-all-lights-on-and-red")
    public void turnAllLightsOnAndRed() {
        hueService.turnLightsOnAndRed();
    }

    @GetMapping("flick")
    public void flick() {
        hueService.flick();
    }

}
