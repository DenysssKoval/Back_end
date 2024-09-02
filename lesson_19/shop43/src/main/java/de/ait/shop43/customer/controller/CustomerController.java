package de.ait.shop43.customer.controller;

import de.ait.shop43.customer.dto.CustomerRequestDto;
import de.ait.shop43.customer.dto.CustomerResponseDto;
import de.ait.shop43.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")

public class CustomerController {
    private final CustomerService service;

    @PostMapping
    public CustomerResponseDto createCustomer(@RequestBody CustomerRequestDto dto) {
        return service.createCustomer(dto);
    }

    @GetMapping
    public List<CustomerResponseDto> getCustomer() {
        return service.getCustomer();
    }

    @GetMapping("/{id}")
    public CustomerResponseDto getCustomerById(@PathVariable(name = "id") long id) {
        return service.getCustomerById(id);
    }

    //customers/3/products/5
    @PutMapping("/{customerId}/products/{productId}")
    public CustomerResponseDto addProductToCart(@PathVariable(name = "customerId") Long customerId,
                                                @PathVariable(name = "productId") Long productId) {
        return service.addProductToCart(customerId, productId);
    }

    @DeleteMapping("/{customerId}/products/{productId}")
    public CustomerResponseDto removeProductFromCart(@PathVariable(name = "customerId") Long customerId,
                                                     @PathVariable(name = "productId") Long productId) {
        return service.removeProductFromCart(customerId, productId);
    }

    @PatchMapping("/{id}")
    public CustomerResponseDto changeStatus(@PathVariable(name = "id") Long id,
                                            @RequestParam(name = "active", defaultValue = "true") boolean active) {
        return service.changeStatus(id, active);
    }
}
