package dev.lachor.springmvc.order;

import dev.lachor.springmvc.ApplicationController;
import dev.lachor.springmvc.item.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {

    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping("/order/realize")
    public String realize(@RequestParam String addres, @RequestParam String phone){

        Order order = new Order(ApplicationController.orders, addres, phone, OrderStatus.NEW);
        orderRepository.save(order);
        ApplicationController.orders.clear();
        return "realize";
    }
}
