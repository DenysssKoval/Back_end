package de.ait.shop43.product.controller;

import de.ait.shop43.product.dto.RequestProductDTO;
import de.ait.shop43.product.dto.ResponseProductDTO;
import de.ait.shop43.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {
    private final ProductService service;



    @GetMapping("/products")
    public List<ResponseProductDTO> getProducts(@RequestParam(name="title", required = false, defaultValue = "") String title){
        if (title.isEmpty()) {
            return service.findAll();
        } else {
            return service.findByTitle(title);
        }
    }

    @PostMapping("/products")
    public ResponseProductDTO createProduct(@RequestBody RequestProductDTO dto){
        return service.save(dto);
    }

    @PutMapping("/products/{id}")
    public ResponseProductDTO updateProduct(@RequestBody RequestProductDTO dto, @PathVariable Long id){
        return service.update(id, dto);
    }
    //PATCH  products/3?active=true    /// localhost:8080/products/32 ? active=true
    @PatchMapping ("/products/{id}")
    public ResponseProductDTO setActive(@PathVariable(name = "id") Long productId,
                                        @RequestParam(name = "active", required = true) boolean active){


        return  service.updateActiveStatus(productId, active);

    }



}
