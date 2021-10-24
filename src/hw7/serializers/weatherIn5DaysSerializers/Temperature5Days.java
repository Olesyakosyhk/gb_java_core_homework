package hw7.serializers.weatherIn5DaysSerializers;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;


/*
    Сериализатор для ответа с endpoint'а о погоде на 5 дней.

    Особенности:
        - Указаны только используемые поля
        - см. пункт Response Parameters -> DailyForecasts -> Temperature

    API DOC URL:
        https://developer.accuweather.com/accuweather-forecast-api/apis/get/forecasts/v1/daily/5day/%7BlocationKey%7D
*/
@JsonIgnoreProperties(ignoreUnknown=true)
public
class Temperature5Days {
    private MinMaxTemperature minimum;
    private MinMaxTemperature maximum;

    @JsonSetter("Minimum")
    public void setMinimum(MinMaxTemperature value) {
        this.minimum = value;
    }

    @JsonGetter("Minimum")
    public MinMaxTemperature getMinimum() {
        return this.minimum;
    }

    @JsonSetter("Maximum")
    public void setMaximum(MinMaxTemperature value) {
        this.maximum = value;
    }

    @JsonGetter("Maximum")
    public MinMaxTemperature getMaximum() {
        return this.maximum;
    }

    public Temperature5Days() {}
}