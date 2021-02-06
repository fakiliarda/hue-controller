package com.yaf.huecontroller.client;

import com.yaf.huecontroller.common.SecretProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HueClient {

    private SecretProperties secretProperties;
    private final String stateURL = "http://192.168.1.21/api/%s/lights/%s/state";

    public HueClient(SecretProperties secretProperties) {
        this.secretProperties = secretProperties;
    }

    public void changeLightStateById(int id, boolean on) {

        var url = String.format(stateURL, secretProperties.getUsername(), id);
        var restTemplate = new RestTemplate();
        var headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);

        String requestJson = "{\"on\": " + on + "}";
        restTemplate.put(url, requestJson);
    }

    public void changeAllLightStates(boolean on) {

        var url1 = String.format(stateURL, secretProperties.getUsername(), 1);
        var url2 = String.format(stateURL, secretProperties.getUsername(), 2);
        var url3 = String.format(stateURL, secretProperties.getUsername(), 3);

        var restTemplate = new RestTemplate();
        var headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);

        String requestJson = "{\"on\": " + on + "}";

        restTemplate.put(url1, requestJson);
        restTemplate.put(url2, requestJson);
        restTemplate.put(url3, requestJson);

    }

    public void flick() {

        var url1 = String.format(stateURL, secretProperties.getUsername(), 1);
        var url2 = String.format(stateURL, secretProperties.getUsername(), 2);
        var url3 = String.format(stateURL, secretProperties.getUsername(), 3);

        var restTemplate = new RestTemplate();
        var headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);

        String onRequestJson = "{\"on\": " + true + "}";
        String offRequestJson = "{\"on\": " + false + "}";

        for (int i = 0; i < 5; i++) {

            restTemplate.put(url1, offRequestJson);
            restTemplate.put(url2, offRequestJson);
            restTemplate.put(url3, offRequestJson);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            restTemplate.put(url1, onRequestJson);
            restTemplate.put(url2, onRequestJson);
            restTemplate.put(url3, onRequestJson);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }


}
