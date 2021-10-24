package hw4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class PhoneBook{
    private HashMap<String, HashSet<String>> data = new HashMap<>();

    // Записать фамилию + номер телефона...
    public void add(String lastName, String phone){
        var lastNameArrayList = this.data.get(lastName) == null ? new HashSet<String>() : this.data.get(lastName);
        lastNameArrayList.add(phone);

        this.data.put(lastName, lastNameArrayList);
    }

    // Получить список номеров по фамилии...
    public Set<String> get(String lastName) {
        return this.data.get(lastName);
    }
}

