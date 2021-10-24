package hw7.utils;


// Конвертер температур...
public class TemperatureConverters {

    public static double FahrenheitCelsius(double value) {

        // Конвертируем фаренгейты в целисии...
        double result = (value - 32) / 1.8;

        // Округляем до десятой...
        result = Math.round(result * 10);
        return result / 10;
    }

}
