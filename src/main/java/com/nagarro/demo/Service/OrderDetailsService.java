package com.nagarro.demo.Service;

import com.nagarro.demo.model.Order;
import com.nagarro.demo.model.OrderDetails;
import com.nagarro.demo.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderDetailsService {


    public OrderDetails getOrderDetails(){
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.exchange("http://user-service:8081/user/1", HttpMethod.GET,null
                , User.class).getBody();
        List<Order> order = restTemplate.exchange("http://order-service:8082/order/1", HttpMethod.GET,null
                ,new ParameterizedTypeReference<List<Order>>(){}).getBody();
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setUserDetails(user);
        orderDetails.setOrders(order);
        return orderDetails;
    }
}
