package dev.lachor.springmvc.order;

import dev.lachor.springmvc.item.Item;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class ClientOrder {
    private List<Item> itemList = new ArrayList<>();

    public void add(Item item){
        itemList.add(item);
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void clear(){
        itemList.clear();
    }
}
