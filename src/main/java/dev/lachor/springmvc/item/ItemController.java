package dev.lachor.springmvc.item;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class ItemController {

    private ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/dinner/{dinner}")
    public String dinner(@PathVariable String dinner, Model model){
        Optional<Item> optionalItem = itemRepository.findItemByNameIgnoreCase(dinner.replaceAll("-", " "));
        if (optionalItem.isPresent()) {
            model.addAttribute("dinner", optionalItem.get());
            return "danie";
        }
        return "/";
    }
}
