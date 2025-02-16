package com.tacocloud.taco_cloud;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.CreditCardNumber;
import java.util.Date;

import java.util.List;
import java.util.ArrayList;
import lombok.Data;

@Data
public class TacoOrder
{
    private static final long serialVersionUID = 1L;

    private Long id;

    private Date placedAt;

    @NotBlank(message = "Name is required")
    private String deliveryName;

    @NotBlank(message = "Delivery Street is required")
    private String deliveryStreet;

    @NotBlank(message = "Delivery City is required")
    private String deliveryCity;

    @NotBlank(message = "Delivery State is required")
    private String deliveryState;

    @Digits(integer = 5, fraction = 0, message = "Invalid Zipcode")
    private String deliveryZip;

    @CreditCardNumber(message = "Not a Valid Credit Card Number")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2]) ([\\/]) ([2-9][0-9])", message = "Must Be Formatted MM/YY")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;

    private List <Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco)
    {
        this.tacos.add(taco);
    }

}
