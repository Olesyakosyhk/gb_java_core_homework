package hw8.serializers.weatherIn5DaysSerializers;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;


/*
    Сериализатор для ответа с endpoint'а о погоде на 5 дней.

    Особенности:
        - Указаны только используемые поля
        - см. пункт Response Parameters -> DailyForecasts -> Temperature -> Minimum/Maximum

    API DOC URL:
        https://developer.accuweather.com/accuweather-forecast-api/apis/get/forecasts/v1/daily/5day/%7BlocationKey%7D
*/
@JsonIgnoreProperties(ignoreUnknown=true)
public class MinMaxTemperature {
    private double value;
    private String unit;

    @JsonSetter("Value")
    public void setValue(double value) {
        this.value = value;
    }

    @JsonGetter("Value")
    public double getValue() {
        return this.value;
    }

    @JsonSetter("Unit")
    public void setUnit(String value) {
        this.unit = value;
    }

    @JsonGetter("Unit")
    public String getUnit() {
        return this.unit;
    }

    public MinMaxTemperature() {}
}