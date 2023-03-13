package ru.z1coast.speech.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import ru.z1coast.speech.service.type.YandexServiceLanguage;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;

public class YandexServiceRecognition {

    private String URL = "https://stt.api.cloud.yandex.net/speech/v1/stt:recognize";
    private YandexServiceLanguage language;

    public YandexServiceRecognition() {
        this.language = YandexServiceLanguage.ENGLISH;
    }

    public void setLanguage(YandexServiceLanguage language) {
        this.language = language;
    }

    protected String request(String apiKey, File file) throws IOException {

        byte[] bytes = Files.readAllBytes(file.toPath());

        URLConnection urlConnection = new URL(URL + "?" + language.valueRequest()).openConnection();

        urlConnection.setDoOutput(true);
        urlConnection.setRequestProperty("Authorization", "Api-Key " + apiKey);

        DataOutputStream outputStream = new DataOutputStream(urlConnection.getOutputStream());
        outputStream.write(bytes, 0, bytes.length);
        outputStream.flush();
        outputStream.close();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

        String var;
        StringBuffer sb = new StringBuffer();

        while ((var = bufferedReader.readLine()) != null) sb.append(var);

        bufferedReader.close();

        JsonObject jsonObject = new Gson().fromJson(sb.toString(), JsonObject.class);

        if(jsonObject.get("result") == null) throw new RuntimeException("Result is null from request");

        return jsonObject.get("result").getAsString();
    }
}
