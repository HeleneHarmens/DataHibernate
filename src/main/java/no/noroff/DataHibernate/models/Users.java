package no.noroff.DataHibernate.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {

    // INSTANCE VARIABLES

    @Id
    //@GeneratedValue(generator = "incrementer")
    //@GenericGenerator(name = "incrementer", strategy = "increment")
    //@GeneratedValue
    @Column(name = "userID", unique = true)
    public int userID;

    @Column(name = "userName", nullable = false)
    private String userName;

    @Column(name = "userEmail", nullable = false)
    private String userEmail;

    //@JsonIgnore
    @Column(name = "userPassword", nullable = false)
    private String userPassword;



    // CONSTRUCTORS
    public Users(){
    }


    // GETTERS & SETTERS
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }


    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }


    public String getUserPassword() {
        return userPassword;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }


    //@JsonIgnore
    public String getUserPasswordHidden() {
        String userPasswordHidden = "";
        for (int i = 0; i < userPassword.length(); i++){
            userPasswordHidden +="*";
        }
        return userPasswordHidden;
    }


    // OVERRIDE METHOD

    @Override
    public String toString() {
        String userPasswordHidden = "*****";

        String usrNameText ="";
        if (userName.length() >= 8){
            usrNameText = "\t\t";
        } else {
            usrNameText = "\t\t\t";
        }

        return "userID: " + userID +
                "\t\t" + userName +
                usrNameText + userEmail+
                "  (pw: " + userPasswordHidden + ")";
    }


    public String returnUserID (int ID) {
        String string = getUserID() + "";
        return string;
    }

}
