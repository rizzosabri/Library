package library.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;
@Data
@Entity
@Table(name="Member")
public class Member extends Person{
    public Member(){
        super();
    }
    @Column(name="registration_date", columnDefinition ="DATETIME", updatable = false,nullable = false)
    private Date registrationDate;
    @Column(name="loan_history")
    private String loanHistory;
    @Column(name="fines")
    private String fines;
    @Column(name="address")
    private String address;
}
