package za.co.andre.proofskills.interviewassignment.data;

/**
 *
 * @author Andr&eacute; Labuschagn&eacute; <andre@ParanoidAndroid.co.za>
 */
public class Employee {
    private User user;
    private Position position;
    private String phone_number;
    private String email;
    private String github_user;
    private String birth_date;
    private String gender;
    private String race;
    private Integer years_worked;
    private Integer age;
    private Integer days_to_birthday;

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * @return the phone_number
     */
    public String getPhone_number() {
        return phone_number;
    }

    /**
     * @param phone_number the phone_number to set
     */
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the github_user
     */
    public String getGithub_user() {
        return github_user;
    }

    /**
     * @param github_user the github_user to set
     */
    public void setGithub_user(String github_user) {
        this.github_user = github_user;
    }

    /**
     * @return the birth_date
     */
    public String getBirth_date() {
        return birth_date;
    }

    /**
     * @param birth_date the birth_date to set
     */
    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the race
     */
    public String getRace() {
        return race;
    }

    /**
     * @param race the race to set
     */
    public void setRace(String race) {
        this.race = race;
    }

    /**
     * @return the years_worked
     */
    public Integer getYears_worked() {
        return years_worked;
    }

    /**
     * @param years_worked the years_worked to set
     */
    public void setYears_worked(Integer years_worked) {
        this.years_worked = years_worked;
    }

    /**
     * @return the age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return the days_to_birthday
     */
    public Integer getDays_to_birthday() {
        return days_to_birthday;
    }

    /**
     * @param days_to_birthday the days_to_birthday to set
     */
    public void setDays_to_birthday(Integer days_to_birthday) {
        this.days_to_birthday = days_to_birthday;
    }
}
