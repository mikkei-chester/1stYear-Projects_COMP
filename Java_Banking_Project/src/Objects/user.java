package Objects;

import java.sql.Date;

public class user {
    private long id;
    private String fname;
    private String lname;
    private String mname;
    private String gender;
    private String username;
    private String password;
    private String pin;
    private String contactNum;
    private int    age;
    private Date   dateCreated;

    public user() {}

    public user(long id, String fname, String lname, String mname, String gender,
                String username, String password, String pin,
                String contactNum, int age, Date dateCreated) {
        this.fname      = fname;
        this.lname      = lname;
        this.mname      = mname;
        this.gender     = gender;
        this.username   = username;
        this.password   = password;
        this.pin        = pin;
        this.contactNum = contactNum;
        this.age        = age;
        this.dateCreated = dateCreated;
    }
    
    public long getId()           { return id;}
    public String getFname()      { return fname; }
    public String getLname()      { return lname; }
    public String getMname()      { return mname; }
    public String getGender()     { return gender; }
    public String getUsername()   { return username; }
    public String getPassword()   { return password; }
    public String getPin()        { return pin; }
    public String getContactNum() { return contactNum; }
    public int    getAge()        { return age; }
    public Date   getDateCreated(){ return dateCreated; }

    public void setId(long id)                   { this.id = id;    }
    public void setFname(String fname)           { this.fname = fname; }
    public void setLname(String lname)           { this.lname = lname; }
    public void setMname(String mname)           { this.mname = mname; }
    public void setGender(String gender)         { this.gender = gender; }
    public void setUsername(String username)     { this.username = username; }
    public void setPassword(String password)     { this.password = password; }
    public void setPin(String pin)               { this.pin = pin; }
    public void setContactNum(String contactNum) { this.contactNum = contactNum; }
    public void setAge(int age)                  { this.age = age; }
    public void setDateCreated(Date dateCreated) { this.dateCreated = dateCreated; }
}