package com.dxctraining.ui;

import com.dxctraining.entities.Item;
import com.dxctraining.exceptions.ItemNotFoundException;
import com.dxctraining.exceptions.InvalidArgumentException;
import com.dxctraining.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ItemUi {
    @Autowired
    private IItemService service;


    @PostConstruct
    public void runUi(){
        try {
            Item item1 = new Item("Ayushi");
            Item item2 = new Item("Anuj");
            Item item3 = new Item("Ankit");
            item1 = service.save(item1);
            item2 = service.save(item2);
            item3=service.save(item3);
            int id1 = item1.getId();
            int id2=item2.getId();
            Item fetched1 = service.findItemById(id1);
            System.out.println("fetched item name =" + fetched1.getName());
            
            Item fetched2 = service.findItemById(id2);
            System.out.println("fetched item name =" + fetched2.getName());
        }catch (ItemNotFoundException e){
            e.printStackTrace();
        }

        catch (InvalidArgumentException e){
            e.printStackTrace();
        }
    }



}
