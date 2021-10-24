package hw7.serializers.currentConditionsSerializers;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;


/*
    Сериализатор для ответа с endpoint'а о текущей погоде.

    Особенности:
        - Указаны только используемые поля
        - см. пункт Response Parameters

    API DOC URL:
        https://developer.accuweather.com/accuweather-current-conditions-api/apis/get/currentconditions/v1/%7BlocationKey%7D
*/
@JsonIgnoreProperties(ignoreUnknown=true)
public class WeatherResponse {
    private String localObservationDateTime = null;
    private String weatherText = null;
    private Temperature temperature;

    @JsonSetter("LocalObservationDateTime")
    public void setLocalObservationDateTime(String value) {
        this.localObservationDateTime = value;
    }

    // Вычисляемое свойство...
    @JsonGetter("LocalObservationDateTime")
    public String getLocalObservationDateTime() {
        String[] dateParts = this.localObservationDateTime.split("T");
        return dateParts[0];
    }

    @JsonGetter("WeatherText")
    public String getWeatherText() {
        return this.weatherText;
    }

    @JsonSetter("WeatherText")
    public void setWeatherText(String value) {
        this.weatherText = value;
    }

    @JsonGetter("Temperature")
    public Temperature getTemperature() {
        return this.temperature;
    }

    @JsonSetter("Temperature")
    public void setTemperature(Temperature value) {
        this.temperature = value;
    }

    public WeatherResponse() {}
}