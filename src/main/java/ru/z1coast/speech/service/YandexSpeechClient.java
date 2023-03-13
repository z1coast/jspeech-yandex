package ru.z1coast.speech.service;

import java.io.File;
import java.io.IOException;

public class YandexSpeechClient {

    private final String apiKey;

    private final YandexServiceSynthesis synthesis = new YandexServiceSynthesis();
    private final YandexServiceRecognition recognition = new YandexServiceRecognition();

    public YandexSpeechClient(String apiKey) {
        this.apiKey = apiKey;
    }

    public YandexServiceSynthesis getSynthesis() {
        return synthesis;
    }

    public YandexServiceRecognition getRecognition() {
        return recognition;
    }

    public File synthesis(String text, File file) {
        try {
            return synthesis.request(apiKey, text, file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String recognition(File file) {
        try {
            return recognition.request(apiKey, file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
