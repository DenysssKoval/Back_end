package de.ait.shop43.customer.service;

import de.ait.shop43.cart.entity.Cart;
import de.ait.shop43.customer.dto.CustomerRequestDto;
import de.ait.shop43.customer.dto.CustomerResponseDto;
import de.ait.shop43.customer.entity.Customer;
import de.ait.shop43.customer.repository.CustomerRepository;
import de.ait.shop43.exception.CustomerNotFoundException;
import de.ait.shop43.product.entity.Product;
import de.ait.shop43.product.service.ProductService;
import jakarta.transaction.Transactional;
import jdk.javadoc.doclet.DocletEnvironment;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@RequiredArgsConstructor
public class CustomerServiceImp implements CustomerService {
    private final CustomerRepository repository;
    private final ProductService productService;
    private final ModelMapper mapper;

    @Override
    public CustomerResponseDto createCustomer(CustomerRequestDto dto) {
        Customer entity = mapper.map(dto, Customer.class); // dto превращаем в entity
        entity.setActive(true);
        Cart cart = new Cart();
        entity.setCart(cart);
        cart.setCustomer(entity);

        entity = repository.save(entity);
        CustomerResponseDto customerResponseDto = mapper.map(entity, CustomerResponseDto.class);
        return customerResponseDto;

    }

    @Override
    public List<CustomerResponseDto> getCustomer() {
        List<Customer> customers = repository.findAll();
        return customers.stream().map(c->mapper.map(c,CustomerResponseDto.class)).toList();
    }



    @Override
    public CustomerResponseDto getCustomerById(long id) {
        return mapper.map(findCustomerById(id), CustomerResponseDto.class);
    }

    private Customer findCustomerById(long id) {
        String msg = "Customer id: " + id + " not found";
        Customer customer = repository.findById(id).orElseThrow(() -> new CustomerNotFoundException(msg));
        return customer;
    }

    @Override
    @Transactional
    public CustomerResponseDto addProductToCart(Long customerId, Long productId) {
        Customer customer = findCustomerById(customerId);
        Product product = productService.findProductById(productId);
        customer.getCart().addProduct(product);
        return mapper.map(customer, CustomerResponseDto.class);
    }
    @Override
    @Transactional
    public CustomerResponseDto removeProductFromCart(Long customerId, Long productId) {
        Customer customer = findCustomerById(customerId);
        Product product = productService.findProductById(productId);
        customer.getCart().remove(product);
        return mapper.map(customer, CustomerResponseDto.class);
    }
    @Override
    @Transactional
    public CustomerResponseDto changeStatus(Long id, boolean active) {
        Customer customer = findCustomerById(id);
        customer.setActive(active);
        return mapper.map(customer, CustomerResponseDto.class);
    }
}
