package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.domain.model.Item;
import com.algaworks.algafood.domain.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class CardapioController {

    @Autowired
    private ItemRepository itemRepository;

        @GetMapping("/cardapio")
        public List<Item> listarItens(){
            return itemRepository.findAll();
        }

        @GetMapping("/cardapio/{itemId}")
        public ResponseEntity<Item> buscarItem(@PathVariable Long itemId){
            Optional<Item> item = itemRepository.findById(itemId);

            if (item.isPresent()){
                return ResponseEntity.ok(item.get());
            }

            return ResponseEntity.notFound().build();
        }

        @PostMapping("/cardapio")
        @ResponseStatus(HttpStatus.CREATED)
        public Item criarItem(@RequestBody Item item){
            return itemRepository.save(item);
        }

        @PutMapping("/cardapio/{itemId}")
        public ResponseEntity<Item> atualizaItem(@PathVariable Long itemId, @RequestBody Item item ){

            if (!itemRepository.existsById(itemId)){
                return ResponseEntity.notFound().build();
            }

            item.setId(itemId);
            item = itemRepository.save(item);

            return ResponseEntity.ok(item);
        }

        @DeleteMapping("/cardapio/{itemId}")
        public ResponseEntity<Item> excluiItem(@PathVariable Long itemId){
            if (!itemRepository.existsById(itemId)){
                return ResponseEntity.notFound().build();
            }

            itemRepository.deleteById(itemId);
            return ResponseEntity.ok().build();
        }
}
