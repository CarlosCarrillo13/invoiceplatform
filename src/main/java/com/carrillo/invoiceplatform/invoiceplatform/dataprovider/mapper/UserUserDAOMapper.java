package com.carrillo.invoiceplatform.invoiceplatform.dataprovider.mapper;

import com.carrillo.invoiceplatform.invoiceplatform.dataprovider.dao.entities.BillDAO;
import com.carrillo.invoiceplatform.invoiceplatform.dataprovider.dao.entities.UserDAO;
import com.carrillo.invoiceplatform.invoiceplatform.domain.entities.Bill;
import com.carrillo.invoiceplatform.invoiceplatform.domain.entities.User;
import com.carrillo.invoiceplatform.invoiceplatform.util.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserUserDAOMapper implements Mapper<User, UserDAO> {

    @Override
    public UserDAO map(User input) {
        return UserDAO.builder()
                .bills(input.getBills()!=null?mapBills(input.getBills()):null)
                .id(input.getId()!=null?input.getId():null)
                .name(input.getName())
                .uuid(input.getUUID())
                .lastName(input.getLastName())
                .email(input.getEmail())
                .build();
    }

    private List<BillDAO> mapBills(List<Bill> bills) {
        List<BillDAO> billDAOS = new ArrayList<>();
        for (Bill bill: bills){
            BillDAO billDAO = BillDAO.builder()
                    .additional(bill.getAdditional())
                    .dateOfBilling(bill.getDateOfBilling())
                    .id(bill.getId())
                    .total(bill.getTotal())
                    .build();
            billDAOS.add(billDAO);
        }
        return billDAOS;
    }
}
