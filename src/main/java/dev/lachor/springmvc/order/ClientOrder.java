package dev.lachor.springmvc.order;

import dev.lachor.springmvc.item.Item;

import java.util.ArrayList;
import java.util.List;


public class ClientOrder {
    private static ClientOrder instance;
    private List<Item> itemList = new ArrayList<>();


    public static ClientOrder getInstance(){
        if (instance == null)
            synchronized (ClientOrder.class) {
                if (instance == null)
                    instance = new ClientOrder();
            }
        return instance;
    }

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
