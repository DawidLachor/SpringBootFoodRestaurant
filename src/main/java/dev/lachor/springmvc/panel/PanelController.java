package dev.lachor.springmvc.panel;

import dev.lachor.springmvc.item.ItemRepository;
import dev.lachor.springmvc.order.Order;
import dev.lachor.springmvc.order.OrderRepository;
import dev.lachor.springmvc.order.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/panel/panel")
public class PanelController {

    private OrderRepository orderRepository;
    private ItemRepository itemRepository;

    @Autowired
    public PanelController(OrderRepository orderRepository, ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
    }

    public PanelController() {
    }

    @GetMapping
    public String panel(Model model, @RequestParam(required = false, defaultValue = "all") String status){
        model.addAttribute("orders", findOrders(status));
        return "panel/panel";
    }


    private List<Order> findOrders(String status){
        List<Order> orders = new ArrayList<>();
        if (status.equals("all")){
            orders = orderRepository.findAll();
        } else {
            orders = orderRepository.findByStatus(OrderStatus.valueOf(status.toUpperCase()));
        }
        return orders;
    }


}
