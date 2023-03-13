<div align="center">

# jspeech-yandex
#### Speech recognition and text-to-speech synthesis

</div>

## Dependencies
```xml
<dependency>
   <groupId>com.google.code.gson</groupId>
   <artifactId>gson</artifactId>
   <version>2.8.9</version>
</dependency>
```

№№ Usage example

Setting the language and voice for the client. By default, there are ENGLISH settings.
```java
YandexSpeechClient client = new YandexSpeechClient("<Your API KEY>"); 

client.getRecognition().setLanguage(YandexServiceLanguage.RUSSIAN); // 
client.getSynthesis().setVoice(YandexServiceVoice.RUSSIAN_ALENA_GOOD);
```

Recognize speech:
```java
File yourFile = new File("test.ogg"); // file format required by Yandex
String textResponse = client.recognition(yourFile);
```

Text-to-speech synthesis:
```java
File yourFile = new File("test.mp3");//Yandex will return the file in MP3 format
File fileResponse = client.synthesis("Привет мир!", yourFile); 
```

## Contact me
VK: **[Link](https://vk.com/z1coast)**
