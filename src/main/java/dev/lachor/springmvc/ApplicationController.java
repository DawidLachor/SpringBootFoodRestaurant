package dev.lachor.springmvc;

import dev.lachor.springmvc.item.Item;
import dev.lachor.springmvc.item.ItemRepository;
import dev.lachor.springmvc.order.ClientOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ApplicationController {

    private ItemRepository itemRepository;
    private ClientOrder clientOrder;

    public ApplicationController(ItemRepository itemRepository, ClientOrder clientOrder) {
        this.itemRepository = itemRepository;
        this.clientOrder = clientOrder;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        model.addAttribute("orders", clientOrder.getOrder().getItems());
        return "ide";
    }

}
