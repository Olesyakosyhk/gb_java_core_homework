package hw8.serializers.weatherIn5DaysSerializers;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

/*
    Сериализатор для ответа с endpoint'а о погоде на 5 дней.

    Особенности:
        - Указаны только используемые поля
        - см. пункт Response Parameters -> DailyForecasts -> Day/Night

    API DOC URL:
        https://developer.accuweather.com/accuweather-forecast-api/apis/get/forecasts/v1/daily/5day/%7BlocationKey%7D
*/
@JsonIgnoreProperties(ignoreUnknown=true)
public class DayNight {
    private String iconPhrase = null;

    @JsonSetter("IconPhrase")
    public void seIconPhrase(String value) {
        this.iconPhrase = value;
    }

    @JsonGetter("IconPhrase")
    public String getIconPhrase() {
        return this.iconPhrase;
    }

    public DayNight() {}
}
