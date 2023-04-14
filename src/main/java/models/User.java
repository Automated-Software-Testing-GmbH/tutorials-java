package models;

import java.util.UUID;

public class User {

    private String name;
    private Integer age;
    private String bio = "";
    private UUID uuid;

    public User(String name, Integer age, String bio) {
        this.name = name;
        this.age = age;
        this.bio = bio;
        genUuid();
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
        genUuid();
    }

    public UUID getUuid() {
        return uuid;
    }

    public void genUuid() {
        this.uuid = UUID.randomUUID();
    }

    public void setUuid(String uuid) {
        this.uuid = UUID.fromString(uuid);
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
