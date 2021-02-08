package dev.lachor.springmvc;

import dev.lachor.springmvc.item.Item;
import dev.lachor.springmvc.item.ItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ApplicationController {

    private ItemRepository itemRepository;
    public static List<Item> orders = new ArrayList<>();

    public ApplicationController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        model.addAttribute("orders", orders);
        return "ide";
    }

    @GetMapping("/{add}")
    public String add(@PathVariable(name = "add") String dinner) {
        Optional<Item> item = itemRepository.findItemByNameIgnoreCase(dinner.replaceAll("-", " "));
        item.ifPresent(item1 -> orders.add(item1));
        return "redirect:/";
    }

}
