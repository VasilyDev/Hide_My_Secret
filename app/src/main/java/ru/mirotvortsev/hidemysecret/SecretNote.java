package ru.mirotvortsev.hidemysecret;

public class SecretNote {
    private final String title;
    private final String description;
    private final int id;

    SecretNote(String title, String description, int id) {
        this.title = title;
        this.description = description;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }


    public int getId() {
        return id;
    }
}
