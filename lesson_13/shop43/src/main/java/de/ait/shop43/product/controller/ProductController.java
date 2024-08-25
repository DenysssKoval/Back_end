package de.ait.shop43.product.controller;

import de.ait.shop43.product.dto.RequestProductDTO;
import de.ait.shop43.product.dto.ResponseProductDTO;
import de.ait.shop43.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {
    private final ProductService service;


    @GetMapping("/products")
    public List<ResponseProductDTO> getProducts() {
        return service.findAll();

    }

    @PostMapping("/products")
    public ResponseProductDTO createProduct(@RequestBody RequestProductDTO dto) {
        return service.save(dto);
    }

}
