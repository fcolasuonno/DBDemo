/*
 * Generated file. It will be overwritten.
 */
package com.bitmastro.debenhams.demo.model;

import com.bitmastro.debenhams.demo.product.ProductCursor;
import com.google.gson.annotations.SerializedName;
import java.util.Date;
import com.bitmastro.debenhams.demo.product.Gender;

/**
 * Model object for the {@code product}.
 */
public class ProductModel{
    @SerializedName("FirstName")
    public String firstName;
    public String lastName;
    public int age;
    public Boolean isBlueEyes;
    public Date dateOfBirth;
    public Float height;
    public long companyId;
    public Gender gender;

    public ProductModel(){}

    public ProductModel(ProductCursor cursor){
        this.firstName = cursor.getFirstName();
        this.lastName = cursor.getLastName();
        this.age = cursor.getAge();
        this.isBlueEyes = cursor.getIsBlueEyes();
        this.dateOfBirth = cursor.getDateOfBirth();
        this.height = cursor.getHeight();
        this.companyId = cursor.getCompanyId();
        this.gender = cursor.getGender();
    }
}