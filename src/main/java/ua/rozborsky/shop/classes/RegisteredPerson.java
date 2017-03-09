package ua.rozborsky.shop.classes;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import ua.rozborsky.shop.interfaces.Person;

import javax.validation.constraints.*;

/**
 * Created by roman on 09.03.2017.
 */

public class RegisteredPerson implements Person {
    @NotEmpty(message="вкажіть ім'я")
    @Size(min = 2, max = 20, message="ім'я повинно бути довжиною не від 2-х до 20-и символів")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]*$", message="неправильний формат імені")
    private String name;

    @NotEmpty(message="вкажіть прізвище")
    @Size(min = 2, max = 20, message="прізвище повинно бути довжиною не від 2-х до 30-и символів")
    @Pattern(regexp = "^[a-zA-Zа-яА-Я]*$", message="неправильний формат прізвища")
    private String surname;

    @Pattern(regexp = "\\d*", message="лише цифри")
    private String phone;

    @NotEmpty(message="вкажіть e-mail")
    @Email(message="невірний формат e-mail")
    private String eMail;

    private String address;

    @NotEmpty(message="вкажіть пароль")
    @Size(min = 6, max = 15, message="пароль повинен бути довжиною не менше 6-х і не більше 15-и символів")
    private String password;
    private String confirmPassword;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
