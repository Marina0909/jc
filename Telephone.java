package Lesson4;

public class Telephone {
    private String surname;
    private String telephoneN;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTelephoneN() {
        return telephoneN;
    }

    public void setTelephoneN(String telephoneN) {
        this.telephoneN = telephoneN;
    }

    public Telephone(String surname, String telephoneN) {
        this.surname = surname;
        this.telephoneN = telephoneN;
    }

}
