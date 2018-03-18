package ru.tinkoff.fintech2.pojo;

import java.time.LocalDate;

public class Person {

    private String firstName;
    private String lastName;
    private String middleName;
    private int age;
    private String gender;
    private LocalDate birthDate;
    private String birthPlace;
    private String index;
    private final String country = "Россия";
    private String region;
    private String city;
    private String street;
    private int house;
    private int apartment;

    public Person(String firstName, String lastName, String middleName, int age, String gender, LocalDate birthDate, String birthPlace, String index, String region, String city, String street, int house, int apartment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.age = age;
        this.gender = gender;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.index = index;
        this.region = region;
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
    }

    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getMiddleName() {return middleName;}
    public void setMiddleName(String middleName) {this.middleName = middleName;}

    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}

    public String getGender() {return gender;}
    public void setGender(String gender) {this.gender = gender;}

    public LocalDate getBirthDate() {return birthDate;}
    public void setBirthDate(LocalDate birthDate) {this.birthDate = birthDate;}

    public String getBirthPlace() {return birthPlace;}
    public void setBirthPlace(String birthPlace) {this.birthPlace = birthPlace;}

    public String getIndex() {return index;}
    public void setIndex(String index) {this.index = index;}

    public String getCountry() {return country;}

    public String getRegion() {return region;}
    public void setRegion(String region) {this.region = region;}

    public String getCity() {return city;}
    public void setCity(String city) {this.city = city;}

    public String getStreet() {return street;}
    public void setStreet(String street) {this.street = street;}

    public int getHouse() {return house;}
    public void setHouse(int house) {this.house = house;}

    public int getApartment() {return apartment;}
    public void setApartment(int apartment) {this.apartment = apartment;}

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", birthDate=" + birthDate +
                ", birthPlace='" + birthPlace + '\'' +
                ", index=" + index +
                ", country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house=" + house +
                ", apartment=" + apartment +
                '}';
    }
}
