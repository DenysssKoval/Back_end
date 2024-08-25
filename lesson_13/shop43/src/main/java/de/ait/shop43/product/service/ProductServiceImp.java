package de.ait.shop43.product.service;

import de.ait.shop43.product.dto.RequestProductDTO;
import de.ait.shop43.product.dto.ResponseProductDTO;
import de.ait.shop43.product.entity.Product;
import de.ait.shop43.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductServiceImp implements ProductService {

    private final ProductRepository repository; //подключаем репозиторий
    private final ModelMapper mapper; //подключаем mapper

    @Override
    public List<ResponseProductDTO> findAll() {
        return repository.findAll().stream()
                .map(e-> mapper.map(e,ResponseProductDTO.class))
                .toList();

    }

    public ResponseProductDTO save(RequestProductDTO dto){
        Product entity = mapper.map(dto,Product.class);

        Product newProduct = repository.save(entity);
        return mapper.map(newProduct,ResponseProductDTO.class);
    }
}
