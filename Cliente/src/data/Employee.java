package data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Date;

public class Employee implements Serializable {

    private int action;
    private int Id;
    private String FirstName;
    private String LastName;
    private String Email;
    private Date BirthDate;
    private int Salary;
    private int Commission;
    private Set<String> Department = new HashSet<>();
    private Set<String> Manager = new HashSet<>();
    private Set<String> Position = new HashSet<>();
    private Set<String> City = new HashSet<>();
    private Set<String> Country = new HashSet<>();
    private String message;
    private int departmentId;
    private int managerId;
    private int positionId;
    private int CityId;
    private int CountryID;
    private String adress;

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(Date BirthDate) {
        this.BirthDate = BirthDate;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int Salary) {
        this.Salary = Salary;
    }

    public int getCommission() {
        return Commission;
    }

    public void setCommission(int Commission) {
        this.Commission = Commission;
    }

    public Set<String> getDepartment() {
        return Department;
    }

    public void setDepartment(Set<String> Department) {
        this.Department = Department;
    }

    public Set<String> getManager() {
        return Manager;
    }

    public void setManager(Set<String> Manager) {
        this.Manager = Manager;
    }

    public Set<String> getPosition() {
        return Position;
    }

    public void setPosition(Set<String> Position) {
        this.Position = Position;
    }

    public Set<String> getCity() {
        return City;
    }

    public void setCity(Set<String> City) {
        this.City = City;
    }

    public Set<String> getCountry() {
        return Country;
    }

    public void setCountry(Set<String> Country) {
        this.Country = Country;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public int getCityId() {
        return CityId;
    }

    public void setCityId(int CityId) {
        this.CityId = CityId;
    }

    public int getCountryID() {
        return CountryID;
    }

    public void setCountryID(int CountryID) {
        this.CountryID = CountryID;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Employee{" + "action=" + action + ", Id=" + Id + ", FirstName=" + FirstName + ", LastName=" + LastName + ", Email=" + Email + ", BirthDate=" + BirthDate + ", Salary=" + Salary + ", Commission=" + Commission + ", Department=" + Department + ", Manager=" + Manager + ", Position=" + Position + ", City=" + City + ", Country=" + Country + ", message=" + message + ", departmentId=" + departmentId + ", managerId=" + managerId + ", positionId=" + positionId + ", CityId=" + CityId + ", CountryID=" + CountryID + ", adress=" + adress + '}';
    }

}
