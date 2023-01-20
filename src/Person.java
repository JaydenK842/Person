public class Person {
    private String firstName;
    private String lastName;
    private String ID;
    private String title;
    private int YOB;

    public Person(String firstName, String lastName, String ID, String title, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        this.YOB = YOB;
    }

    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstname) {
        this.firstName = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    public String fullName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    public String formalName(String title, String firstName, String lastName) {
        return title + " " + fullName(firstName, lastName);
    }

    public int getAge(int YOB) {
        int age = 2023 - YOB;
        return age;
    }

    //public int getAge(int YOB, int year) {}

    public String toCSVDataRecord(String firstName, String lastName, String ID, String title, int YOB) {
        return ID + ", " + title + ", " + firstName + ", " + lastName + ", " + YOB;
    }
}
