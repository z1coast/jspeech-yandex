package ru.z1coast.speech.service.type;

public enum YandexServiceLanguage {

    RUSSIAN("ru-RU"),
    ENGLISH("en-EN"),
    KAZAKH("kk-KK"),
    UZBEK("uz-UZ"),
    GERMAN("de-DE"),
    HEBREW("he-IL");

    private final String language;

    YandexServiceLanguage(String language) {
        this.language = language;
    }

    public String valueRequest() {
        return "&lang=" + this.language;
    }
}
