package dev.lachor.springmvc.order;

import dev.lachor.springmvc.item.Item;
import dev.lachor.springmvc.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
public class OrderController {

    private OrderRepository orderRepository;
    private ItemRepository itemRepository;


    @Autowired
    public OrderController(OrderRepository orderRepository, ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;

    }

    public OrderController() {
    }

    @PostMapping("/order")
    public String realize(@Valid @ModelAttribute(name = "finishOrder") Order order, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            List<ObjectError> errors = bindingResult.getAllErrors();
            errors.forEach(err -> System.out.println(err.getDefaultMessage()));
            addModel(model, order);
            return "order";
        }else {
            order.setItems(ClientOrder.getInstance().getItemList());
            order.setStatus(OrderStatus.NEW);
            orderRepository.save(order);
            ClientOrder.getInstance().clear();
            return "realize";
        }

    }
    @GetMapping("/{add}")
    public String add(@PathVariable(name = "add") String dinner) {
        Optional<Item> item = itemRepository.findItemByNameIgnoreCase(dinner.replaceAll("-", " "));
        item.ifPresent(item1 -> ClientOrder.getInstance().add(item1));
        return "redirect:/";
    }

    @GetMapping("/order")
    public String order(Model model) {
        Order order = new Order();
        addModel(model, order);
        return "order";
    }
    private void addModel(Model model, Order order){
        model.addAttribute("orders", ClientOrder.getInstance().getItemList());
        model.addAttribute("sum", sum());
        model.addAttribute("finishOrder", order);
    }

    private BigDecimal sum(){
        return ClientOrder.getInstance().getItemList().stream()
                .filter(Objects::nonNull)
                .map(Item::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
