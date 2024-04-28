package com.Ankit.Buyogo_Backend_Assignment_Traini8.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import jakarta.validation.executable.ValidateOnExecution;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long addressId;

    @NotBlank(message = "Invalid input !!..., Provide Detailed Address..")
    @NotNull(message = "Invalid input !!..., Provide Detailed Address..")
    private String detailedAddress;

    @NotBlank(message = "Invalid input !!..., Provide valid Address_City ..")
    @NotNull(message = "Invalid input !!..., Provide Address_City ..")
    private String city;

   @Size(min = 6,max = 6,message = "Invalid input !!..., Pincode accepted only 6 Digits..")
   @NotNull(message = "Invalid input !!..., Provide Address_Pincode ..")
    private String pincode;

    @NotBlank(message = "Invalid input !!..., Provide valid Address_State..")
   @NotNull(message = "Invalid input !!..., Provide Address_State..")
    private String state;
}
