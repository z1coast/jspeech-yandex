package ru.z1coast.speech.service.type;

public enum YandexServiceVoice {

    GERMAM_LEA("lea", YandexServiceLanguage.GERMAN),
    ENGLISH_JOHN("john", YandexServiceLanguage.ENGLISH),
    HEBREW_NAOMI_CLASSIC("naomi", "classic", YandexServiceLanguage.HEBREW),
    HEBREW_NAOMI_MODERN("naomi", "modern", YandexServiceLanguage.HEBREW),
    KAZAKH_AMIRA("amira", YandexServiceLanguage.KAZAKH),
    KAZAKH_MADI("madi", YandexServiceLanguage.KAZAKH),
    RUSSIAN_ALENA_NEUTRAL("alena", "neutral", YandexServiceLanguage.RUSSIAN),
    RUSSIAN_ALENA_GOOD("alena", "good", YandexServiceLanguage.RUSSIAN),
    RUSSIAN_FILIPP("filipp", YandexServiceLanguage.RUSSIAN),
    RUSSIAN_ERMIL_NEUTRAL("ermil", "neutral", YandexServiceLanguage.RUSSIAN),
    RUSSIAN_ERMIL_GOOD("ermil", "good", YandexServiceLanguage.RUSSIAN),
    RUSSIAN_JANE_NEUTRAL("jane", "neutral", YandexServiceLanguage.RUSSIAN),
    RUSSIAN_JANE_EVIL("jane", "evil", YandexServiceLanguage.RUSSIAN),
    RUSSIAN_JANE_GOOD("jane", "good", YandexServiceLanguage.RUSSIAN),
    RUSSIAN_MADIRUS("madirus", YandexServiceLanguage.RUSSIAN),
    RUSSIAN_OMAZH_NEUTRAL("omazh", "neutral", YandexServiceLanguage.RUSSIAN),
    RUSSIAN_OMAZH_EVIL("omazh", "evil", YandexServiceLanguage.RUSSIAN),
    RUSSIAN_ZAHAR_NEUTRAL("zahar", "neutral", YandexServiceLanguage.RUSSIAN),
    RUSSIAN_ZAHAR_GOOD("zahar", "good", YandexServiceLanguage.RUSSIAN),
    UZBER_NIGORA("nigora", YandexServiceLanguage.UZBEK);

    private YandexServiceLanguage language;
    private String name;
    private String emotion;

    YandexServiceVoice(String name, String emotion, YandexServiceLanguage language) {
        this.name = name;
        this.emotion = emotion;
        this.language = language;
    }

    YandexServiceVoice(String name, YandexServiceLanguage language) {
        this.name = name;
        this.language = language;
    }

    public String valueRequest() {
        return "&voice=" + this.name + "&lang=" + language + (emotion != null ? "&emotion=" + emotion : "");
    }
}
