package za.co.andre.proofskills.interviewassignment.data;

/**
 *
 * @author Andr&eacute; Labuschagn&eacute; <andre@ParanoidAndroid.co.za>
 */
public class User {

    private Integer id;
    private String username;
    private String email;
    private String first_name;
    private String last_name;
    private Boolean is_active;
    private Boolean is_staff;
    private Boolean is_superuser;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
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
     * @return the first_name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * @param first_name the first_name to set
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * @return the last_name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * @param last_name the last_name to set
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * @return the is_active
     */
    public Boolean getIs_active() {
        return is_active;
    }

    /**
     * @param is_active the is_active to set
     */
    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    /**
     * @return the is_staff
     */
    public Boolean getIs_staff() {
        return is_staff;
    }

    /**
     * @param is_staff the is_staff to set
     */
    public void setIs_staff(Boolean is_staff) {
        this.is_staff = is_staff;
    }

    /**
     * @return the is_superuser
     */
    public Boolean getIs_superuser() {
        return is_superuser;
    }

    /**
     * @param is_superuser the is_superuser to set
     */
    public void setIs_superuser(Boolean is_superuser) {
        this.is_superuser = is_superuser;
    }
}
