package dev.lachor.springmvc.order;

import dev.lachor.springmvc.ApplicationController;
import dev.lachor.springmvc.item.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Controller
public class OrderController {

    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping("/order")
    public String realize(@Valid @ModelAttribute(name = "finishOrder") Order order, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            List<ObjectError> errors = bindingResult.getAllErrors();
            errors.forEach(err -> System.out.println(err.getDefaultMessage()));

            addModel(model, order);
            return "order";
        }else {
            orderRepository.save(order);
            ApplicationController.orders.clear();
            return "realize";
        }

    }

    @GetMapping("/order")
    public String order(Model model) {
        Order order = new Order();
        addModel(model, order);
        return "order";
    }
    private void addModel(Model model, Order order){
        model.addAttribute("orders", ApplicationController.orders);
        model.addAttribute("sum", sum());
        model.addAttribute("finishOrder", order);
    }

    private BigDecimal sum(){
        return ApplicationController.orders.stream()
                .filter(Objects::nonNull)
                .map(Item::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
