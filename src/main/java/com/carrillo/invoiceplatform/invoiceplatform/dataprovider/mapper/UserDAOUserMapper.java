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
public class UserDAOUserMapper implements Mapper<UserDAO, User> {
    @Override
    public User map(UserDAO input) {

        User user = new User();

        user.setBills(mapBills(input.getBills()));
        user.setId(input.getId());
        user.setLastName(input.getLastName());
        user.setName(input.getName());
        user.setUUID(input.getUuid());

        return user;
    }

    private List<Bill> mapBills(List<BillDAO> bills) {
        List<Bill> billResponse = new ArrayList<>();

        for (BillDAO billDAO: bills){
            Bill bill = new Bill();
            bill.setAdditional(billDAO.getAdditional());
            bill.setDateOfBilling(billDAO.getDateOfBilling());
            bill.setId(billDAO.getId());
            bill.setTotal(billDAO.getTotal());
            billResponse.add(bill);
        }
        return billResponse;
    }
}
