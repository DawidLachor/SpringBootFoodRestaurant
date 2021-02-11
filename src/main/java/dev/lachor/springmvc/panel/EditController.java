package dev.lachor.springmvc.panel;

import dev.lachor.springmvc.item.Item;
import dev.lachor.springmvc.order.Order;
import dev.lachor.springmvc.order.OrderRepository;
import dev.lachor.springmvc.order.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("/panel/orders")
public class EditController {

    private OrderRepository orderRepository;

    @Autowired
    public EditController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public EditController() {
    }

    @GetMapping("/{id}")
    public String edit(Model model,@PathVariable Long id){
        Order order = findOrder(id);
        model.addAttribute("order",order);
        model.addAttribute("items",order.getItems());
        model.addAttribute("sum", sum(order.getItems()));
        return "panel/edit";
    }
    @GetMapping("/{id}/change")
    public String changeStatus(@PathVariable Long id){
        Order order = findOrder(id);
        if (order != null){
            int ordinal = order.getStatus().ordinal();
            if (ordinal < OrderStatus.values().length) {
                OrderStatus[] values = OrderStatus.values();
                order.setStatus(values[ordinal + 1]);
                orderRepository.save(order);
            }
        }
        return "redirect:/panel/orders";
    }

    private Order findOrder(Long id){
        Order order;
        Optional<Order> orderById = orderRepository.findById(id);
        order = orderById.orElse(null);
        return order;
    }

    private BigDecimal sum(List<Item> items){
        return items.stream()
                .filter(Objects::nonNull)
                .map(Item::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
