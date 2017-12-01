package main.model;

public class User {

    private Integer idUsers;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String dateofBirth;
    private String cf;
    private String businessname;
    private String vat;
    private String municipality;
    private String postecode;
    private String city;
    private String address;
    private String telephone;
    private String role;

    public User(Integer idUsers, String username, String password, String firstname, String lastname, String dateofBirth, String cf, String businessname, String vat, String municipality, String postecode, String city, String address, String telephone, String role) {
        this.idUsers = idUsers;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateofBirth = dateofBirth;
        this.cf = cf;
        this.businessname = businessname;
        this.vat = vat;
        this.municipality = municipality;
        this.postecode = postecode;
        this.city = city;
        this.address = address;
        this.telephone = telephone;
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (firstname != null ? !firstname.equals(user.firstname) : user.firstname != null) return false;
        if (lastname != null ? !lastname.equals(user.lastname) : user.lastname != null) return false;
        if (dateofBirth != null ? !dateofBirth.equals(user.dateofBirth) : user.dateofBirth != null) return false;
        if (cf != null ? !cf.equals(user.cf) : user.cf != null) return false;
        if (businessname != null ? !businessname.equals(user.businessname) : user.businessname != null) return false;
        if (vat != null ? !vat.equals(user.vat) : user.vat != null) return false;
        if (municipality != null ? !municipality.equals(user.municipality) : user.municipality != null) return false;
        if (postecode != null ? !postecode.equals(user.postecode) : user.postecode != null) return false;
        if (city != null ? !city.equals(user.city) : user.city != null) return false;
        if (address != null ? !address.equals(user.address) : user.address != null) return false;
        if (telephone != null ? !telephone.equals(user.telephone) : user.telephone != null) return false;
        return role != null ? role.equals(user.role) : user.role == null;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (dateofBirth != null ? dateofBirth.hashCode() : 0);
        result = 31 * result + (cf != null ? cf.hashCode() : 0);
        result = 31 * result + (businessname != null ? businessname.hashCode() : 0);
        result = 31 * result + (vat != null ? vat.hashCode() : 0);
        result = 31 * result + (municipality != null ? municipality.hashCode() : 0);
        result = 31 * result + (postecode != null ? postecode.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    public Integer getIdUsers() {
        return idUsers;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(String dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public String getBusinessname() {
        return businessname;
    }

    public void setBusinessname(String businessname) {
        this.businessname = businessname;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public String getPostecode() {
        return postecode;
    }

    public void setPostecode(String postecode) {
        this.postecode = postecode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "USER:" +
                "\n Username='" + username + '\'' +
                "\n Password='" + password + '\'' +
                "\n Firstname='" + firstname + '\'' +
                "\n Lastname='" + lastname + '\'' +
                "\n DateofBirth='" + dateofBirth + '\'' +
                "\n CF='" + cf + '\'' +
                "\n Businessname='" + businessname + '\'' +
                "\n Vat='" + vat + '\'' +
                "\n Municipality='" + municipality + '\'' +
                "\n Postecode='" + postecode + '\'' +
                "\n City='" + city + '\'' +
                "\n Address='" + address + '\'' +
                "\n Telephone='" + telephone + '\'' +
                "\n Role='" + role + '\'';
    }
}