package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.domain.model.Item;
import com.algaworks.algafood.domain.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;

@RestController
public class CardapioController {

    @Autowired
    private ItemRepository itemRepository;

        @GetMapping("/cardapio")
        public List<Item> listarItens(){
            return itemRepository.findAll();
        }
}
