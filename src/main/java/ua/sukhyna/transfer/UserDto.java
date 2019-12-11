package ua.sukhyna.transfer;

import ua.sukhyna.model.User;

public class UserDto {

    private String name;
    private String surname;

    public UserDto(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public static UserDto from(User user){
        return new UserDto(user.getName(), user.getSurname());
    }
}
