package com.primus.company.model;

import com.primus.address.model.Address;
import com.primus.generic.BusinessModel;

import javax.persistence.*;

@Entity
@Table(name ="COMPANIES")
public class Company extends BusinessModel {


    String companyCode;
    String companyName;
    Address address ;

    @Column(name  ="COMPANY_CODE")
    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    @Column(name  ="COMPANY_NAME")
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }


    @ManyToOne(cascade= CascadeType.DETACH)
    @JoinColumn(name  ="ADDRESS_ID")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
