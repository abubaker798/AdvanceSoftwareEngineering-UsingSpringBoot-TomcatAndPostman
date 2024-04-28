package com.phase2.OrdersAndNotificationsManagements.server;

import com.phase2.OrdersAndNotificationsManagements.Common;
import com.phase2.OrdersAndNotificationsManagements.api.model.Account;
import com.phase2.OrdersAndNotificationsManagements.api.model.Customer;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AccountService{

    public void createAccount(Customer customer){

        System.out.println(customer.getAccount().getUserName());
        Common.customers.put(customer.getAccount().getUserName(),customer);
    }


    public void login(Customer customer) {
        customer.getAccount().setLogin(true);
        updateAccount(customer);
    }


    public void logut(Customer customer) {
        customer.getAccount().setLogin(false);
        updateAccount(customer);
    }


    public void updateAccount(Customer customer){
        Common.customers.replace(customer.getAccount().getUserName(), customer);
    }


    public Account getAccount(String userName) {
        try {
            return Common.customers.get(userName).getAccount();

        }
        catch (Exception e){
            System.out.println("Exception in getPerson as " + e.getMessage());
        }
        return null;
    }


    public boolean isLogin(String user_name){
        Account account = getAccount(user_name);
        return account.isLogin();
    }




    public boolean isUsernameTaken(String userName) {

        Account account = getAccount(userName);

        if(account == null)
            return false;

        return Common.customers.get(userName).getAccount() == account;
    }

    public boolean authenticate(String userName, String password) {
        Account account = getAccount(userName);
        if(account == null)
            return false;

        return (Objects.equals(account.getUserName(), userName) && Objects.equals(account.getPassword(), password));
    }
}

