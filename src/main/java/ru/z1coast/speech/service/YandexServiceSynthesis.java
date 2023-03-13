package ru.z1coast.speech.service;

import ru.z1coast.speech.service.type.YandexServiceVoice;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class YandexServiceSynthesis {

    private YandexServiceVoice voice;
    private String URL = "https://tts.api.cloud.yandex.net/speech/v1/tts:synthesize";

    private float speed;

    public YandexServiceSynthesis() {
        this.voice = YandexServiceVoice.ENGLISH_JOHN;

    }

    public void setVoice(YandexServiceVoice voice) {
        this.voice = voice;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    protected File request(String apiKey, String text, File file) throws IOException {

        URLConnection urlConnection = new URL(URL).openConnection();

        urlConnection.setDoOutput(true);
        urlConnection.setRequestProperty("Authorization", "Api-Key " + apiKey);

        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(urlConnection.getOutputStream());
        outputStreamWriter.write("text=" + this.utf8string(text) + "&format=mp3" + voice.valueRequest() + (speed != 0 ? "&speed="  + speed : ""));


        outputStreamWriter.flush();
        outputStreamWriter.close();

        BufferedInputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
        OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file));

        byte[] bytes = new byte[256];
        int var = 0;

        while ((var = inputStream.read(bytes)) >= 0) {
            outputStream.write(bytes, 0, var);
        }

        outputStream.flush();
        outputStream.close();

        inputStream.close();

        return file;
    }

    private String utf8string(String text) {
        ByteBuffer bytes = StandardCharsets.UTF_8.encode(text);
        return StandardCharsets.UTF_8.decode(bytes).toString();
    }
}
