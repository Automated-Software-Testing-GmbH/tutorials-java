package models;

import java.util.UUID;

public class User {

    private String name;
    private Integer age;
    private String bio;
    private UUID uuid;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid() {
        this.uuid = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
