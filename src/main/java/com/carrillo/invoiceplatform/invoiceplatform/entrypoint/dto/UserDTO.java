package com.carrillo.invoiceplatform.invoiceplatform.entrypoint.dto;

import com.carrillo.invoiceplatform.invoiceplatform.domain.entities.Bill;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
public class UserDTO {

    private Long id;

    private String name;

    private String lastName;

    private String uuid;

    @Email
    @NotNull
    private String email;

    private List<BillDTO> bills;
}
