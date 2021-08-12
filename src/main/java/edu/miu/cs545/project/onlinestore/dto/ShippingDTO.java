package edu.miu.cs545.project.onlinestore.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ShippingDTO {
    private long id;
    private String receiverFirstName;
    private String receiverLastName;
    private String receiverPhone;
    private LocalDate deliveredDate;
    private String receiverStreet;
    private String receiverCity;
    private String receiverState;
    private String receiverCountry;
    private String receiverZipcode;
}
