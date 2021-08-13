package edu.miu.cs545.project.onlinestore.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SellerDTO {
    UserDTO user;
    private long id;
    private boolean approved;
    private String companyName;
}

