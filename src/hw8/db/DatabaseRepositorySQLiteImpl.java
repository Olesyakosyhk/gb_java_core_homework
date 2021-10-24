package hw8.db;

import hw8.ApplicationGlobalState;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DatabaseRepositorySQLiteImpl implements DatabaseRepository {

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    String filename = null;
    String createTableQuery = """
        CREATE TABLE IF NOT EXISTS weather(
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            city TEXT NOT NULL,
            date_time TEXT NOT NULL,
            weather_text TEXT NOT NULL,
            temperature REAL NOT NULL
        );
        """;

    String insertWeatherQuery = "INSERT INTO weather (city, date_time, weather_text, temperature) VALUES (?,?,?,?)";
    String selectWeatherQuery = "SELECT * FROM weather";

    public DatabaseRepositorySQLiteImpl() {
        filename = ApplicationGlobalState.getInstance().getDbFileName();
    }

    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + filename);
        return connection;
    }

    public void createTableIfNotExists() {
        try (Connection connection = getConnection()) {
            connection.createStatement().execute(createTableQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // Сохранение данных погоды в DB...
    @Override
    public boolean saveWeatherData(WeatherData weatherData) throws SQLException {
        try (Connection connection = getConnection();
        PreparedStatement saveWeather = connection.prepareStatement(insertWeatherQuery)) {
            saveWeather.setString(1, weatherData.getCity());
            saveWeather.setString(2, weatherData.getLocalDate());
            saveWeather.setString(3, weatherData.getText());
            saveWeather.setDouble(4, weatherData.getTemperature());
            return saveWeather.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new SQLException("Failure on saving weather object");
    }

    // Получение данных о погоде из DB...
    @Override
    public List<WeatherData> getAllSavedData() throws IOException, SQLException {
        try (Connection connection = getConnection();
        PreparedStatement saveWeather = connection.prepareStatement(selectWeatherQuery)) {
            ResultSet resultSetDB = saveWeather.executeQuery();

            List<WeatherData> resultData = new ArrayList<>();
            while (resultSetDB.next()) {
                resultData.add(
                        new WeatherData(
                                resultSetDB.getString("city"),
                                resultSetDB.getString("date_time"),
                                resultSetDB.getString("weather_text"),
                                resultSetDB.getDouble("temperature")
                        )
                );
            }

            return resultData;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        throw new SQLException("Failure on getting weather objects");
    }
}
