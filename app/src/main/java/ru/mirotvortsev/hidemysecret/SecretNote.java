package ru.mirotvortsev.hidemysecret;

public class SecretNote {
    private String title;
    private String description;

    SecretNote(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }


}
