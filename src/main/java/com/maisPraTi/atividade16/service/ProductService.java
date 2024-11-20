package com.maisPraTi.atividade16.service;

import com.maisPraTi.atividade16.dto.ProductRequest;
import com.maisPraTi.atividade16.dto.ProductResponse;
import com.maisPraTi.atividade16.model.Product;
import com.maisPraTi.atividade16.repository.ProductRepository;
import com.maisPraTi.atividade16.service.exceptions.DatabaseException;
import com.maisPraTi.atividade16.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.maisPraTi.atividade16.mapper.EntityMapper.*;


@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional
    public ProductResponse insert(ProductRequest request){
        Product newProduct = convertToEntity(request, Product.class);
        newProduct = repository.save(newProduct);
        return convertToDto(newProduct, ProductResponse.class);
    }

    @Transactional(readOnly = true)
    public Optional<ProductResponse> findById(Long id){
        Product product = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto de id " + id + " não localizado."));
        return Optional.of(convertToDto(product, ProductResponse.class));
    }

    @Transactional(readOnly = true)
    public Page<ProductResponse> findAll(Pageable pageable){
        Page<Product> products = repository.findAll(pageable);
        if(products.isEmpty())
            throw new ResourceNotFoundException("Não existem produtos cadastrados.");
        return products.map(product -> convertToDto(product, ProductResponse.class));
    }

    @Transactional
    public ProductResponse update(Long id, ProductRequest request){
        verifyExistsId(id);
        Product updatedProduct = repository.getReferenceById(id);
        convertToEntity(request, updatedProduct);
        updatedProduct = repository.save(updatedProduct);
        return convertToDto(updatedProduct, ProductResponse.class);
    }

    @Transactional
    public void delete(Long id){
        verifyExistsId(id);
        try{
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException("Não é possível deletar esse item pois está associado a outros objetos.");
        }
    }

    @Transactional
    void verifyExistsId(Long id) {
        if (!repository.existsById(id))
            throw new ResourceNotFoundException("Id não localizado: " + id);
    }

}
