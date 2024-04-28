package com.phase2.OrdersAndNotificationsManagements.api.controller;
import com.phase2.OrdersAndNotificationsManagements.api.model.Customer;
import com.phase2.OrdersAndNotificationsManagements.api.model.Response;
import com.phase2.OrdersAndNotificationsManagements.server.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AccountController {
    @Autowired
    AccountService accountService;
    Response response = new Response();
    @PostMapping("/createAccoun")
    public Customer signUp(@RequestBody Customer customer){
        return customer;
    }


    @PostMapping("/createAccount")
    public Response singnUp(@RequestBody Customer customer){
        if (customer.getAccount().getUserName() == null || customer.getAccount().getPassword() == null){
            response.setMessage("you must enter your userName and password");
            return response;
        }

        if (accountService.isUsernameTaken(customer.getAccount().getUserName())){
            response.setStatus(false);
            response.setMessage("Username "+customer.getAccount().getUserName()+ " already exists. Please choose a different username.");
        }
        else{
            accountService.createAccount(customer);
            response.setStatus(true);
            response.setMessage("Account created successfully..................");
        }
        return response;
    }

    @PostMapping("/logi")
    public Customer logi(@RequestBody Customer customer){
        return customer;
    }
    @PostMapping("/login")
    public Response login(@RequestBody Customer customer) {
        if (accountService.authenticate(customer.getAccount().getUserName(), customer.getAccount().getPassword())) {
            // test if costumers account is login or not
            if (accountService.isLogin(customer.getAccount().getUserName())){
                response.setMessage("You are already login............!");
                return response;
            }

            // update account to login
            customer.getAccount().setLogin(true);
            accountService.login(customer);

            response.setStatus(true);
            response.setMessage("Login successful.................!");
        } else {
            response.setStatus(false);
            response.setMessage("Invalid username or password. Please try again.");
        }
        return response;
    }


    @PostMapping("/logout")
    public Response logout(@RequestBody Customer customer) {
        if (accountService.authenticate(customer.getAccount().getUserName(), customer.getAccount().getPassword())) {
            // test if costumers account is login or not
            if (!accountService.isLogin(customer.getAccount().getUserName())){
                response.setMessage("You are already logout............!");
                return response;
            }

            // update account to logout
            accountService.logut(customer);
            response.setStatus(true);
            response.setMessage("Logout successful..............!");

        } else {
            response.setStatus(false);
            response.setMessage("Invalid username or password. Please try again.");
        }
        return response;
    }

}

