package hw7;

public final class ApplicationGlobalState {

    private static ApplicationGlobalState INSTANCE;

    // Название города вводимое пользователем...
    private String selectedCity = null;

    // Авторизационный токен...
//    private final String API_KEY = "kV9avv9i9oDnAjwgPuc8AhkHz2vzC7hK";
    private final String API_KEY = "0d1tNZJPfzzT3qGokM18FGGxAUpt7hpj";

    private ApplicationGlobalState() {
    }

    // Непотокобезопасный код для упрощения
    public static ApplicationGlobalState getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ApplicationGlobalState();
        }

        return INSTANCE;
    }

    public String getSelectedCity() {
        return selectedCity;
    }

    public void setSelectedCity(String selectedCity) {
        this.selectedCity = selectedCity;
    }

    public String getApiKey() {
        return this.API_KEY;
    }
}
