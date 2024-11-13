package com.tacocloud.taco_cloud;

import java.util.List;
import java.util.ArrayList;
import lombok.Data;

public class TacoOrder
{
    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
    private String ccNumber;
    private String ccExiration;
    private String ccCVV;

    private List <Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco)
    {
        this.tacos.add(taco);
    }

}
