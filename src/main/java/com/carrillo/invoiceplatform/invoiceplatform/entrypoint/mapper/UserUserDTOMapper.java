package com.carrillo.invoiceplatform.invoiceplatform.entrypoint.mapper;

import com.carrillo.invoiceplatform.invoiceplatform.domain.entities.Bill;
import com.carrillo.invoiceplatform.invoiceplatform.domain.entities.User;
import com.carrillo.invoiceplatform.invoiceplatform.entrypoint.dto.BillDTO;
import com.carrillo.invoiceplatform.invoiceplatform.entrypoint.dto.UserDTO;
import com.carrillo.invoiceplatform.invoiceplatform.util.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserUserDTOMapper implements Mapper<User, UserDTO> {


    @Override
    public UserDTO map(User input) {
        return UserDTO.builder()
                .bills(mapBills(input.getBills()))
                .email(input.getEmail())
                .id(input.getId())
                .name(input.getName())
                .lastName(input.getLastName())
                .build();
    }

    private List<BillDTO> mapBills(List<Bill> bills) {
        List<BillDTO> billDTOS = new ArrayList<>();
        for (Bill bill: bills){
            BillDTO billDTO = BillDTO.builder()
                    .additional(bill.getAdditional())
                    .dateOfBilling(bill.getDateOfBilling())
                    .id(bill.getId())
                    .total(bill.getTotal())
                    .build();
            billDTOS.add(billDTO);
        }
        return billDTOS;
    }
}
