package hw8.serializers.currentConditionsSerializers;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;


/*
    Сериализатор для ответа с endpoint'а о текущей погоде.

    Особенности:
        - Указаны только используемые поля
        - см. пункт Response Parameters -> Temperature -> Metric

    API DOC URL:
        https://developer.accuweather.com/accuweather-current-conditions-api/apis/get/currentconditions/v1/%7BlocationKey%7D
*/
@JsonIgnoreProperties(ignoreUnknown=true)
public class Metric {
    private double value;
    private String unit;

    @JsonGetter("Value")
    public double getValue() {
        return this.value;
    }

    @JsonSetter("Value")
    public void setValue(double value) {
        this.value = value;
    }

    @JsonGetter("Unit")
    public String getUnit() {
        return this.unit;
    }

    @JsonSetter("Unit")
    public void setUnit(String value) {
        this.unit = value;
    }

    public Metric() {}
}