package com.Ankit.Buyogo_Backend_Assignment_Traini8.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;


import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class TrainingCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainingCenterId;
    @Column(unique = true)
    @NotNull(message = "Invalid input !!...,  Provide valid Center_Name..")
    @Length(max = 39,message = "maximum length Exceed.. ,Only Less than 40 characters Accepted.. ")
    private String centerName ;

    @NotNull(message = "Invalid input !!...,  Provide valid Center_Code..")
    @Pattern(regexp = "^[A-Z0-9]{12}$",message = "Invalid input !! , Center_Code accepted only 12 AlphaNumeric Characters..")
    private String centerCode ;

    /* Assuming Every Training Center has only one Address thats why here applying OneToOne mapping ,But it can be modified
       Later. Its depends on the UseCases. Here Used UniDirectional mapping Fetching the training_Centers at the same time
       Address will be Fecthing but by Address cant get Training Centers . All things can be modified according to uses Cases.*/
    @NotNull(message = "Invalid input !!...,  Provide valid Center_Address..")
    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_addressId")
    private Address centerAddress;


    private Long studentCapacity;
    private List<String> coursesOffered;
    private LocalDateTime createdOn;

    @Email(message = "Invalid input !! , Provide Valid Email_Address..")
    private String contactEmail;

    @Column(unique = true)
    @NotNull(message = "Invalid input !!...,  Provide valid Phone_Number..")
    @Pattern(regexp = "^[+][0-9]{2}[0-9]{10}",message = "Invalid format !!.. ,Provide Phone_Number in Valid Format (Valid_Format: '+917865435678') ")
    private String contactPhone;

}
