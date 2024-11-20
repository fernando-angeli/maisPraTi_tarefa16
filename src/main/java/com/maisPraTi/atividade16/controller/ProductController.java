package com.maisPraTi.atividade16.controller;

import com.maisPraTi.atividade16.dto.ProductRequest;
import com.maisPraTi.atividade16.dto.ProductResponse;
import com.maisPraTi.atividade16.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Tag(name = "Produtos", description = "Operações de CRUD para produtos.")
@RestController
@RequestMapping("/api/produtos")
public class ProductController {

    @Autowired
    private ProductService service;

    @Operation(summary = "Cria um novo produtp")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Produto criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping
    public ResponseEntity<ProductResponse> insertProduct(@RequestBody ProductRequest request){
        ProductResponse newProduct = service.insert(request);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newProduct.getId())
                .toUri();
        return ResponseEntity.created(uri).body(newProduct);
    }

    @Operation(summary = "Obtém um produto por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto encontrado"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    @GetMapping("{id}")
    public ResponseEntity<Optional<ProductResponse>> findProductById(@PathVariable Long id){
        Optional<ProductResponse> product = service.findById(id);
        return ResponseEntity.ok().body(product);
    }

    @Operation(summary = "Obtém uma lista páginada de produtos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produtos encontrados"),
    })
    @GetMapping
    public ResponseEntity<Page<ProductResponse>> findAllProducts(Pageable pageable){
        Page<ProductResponse> products = service.findAll(pageable);
        return ResponseEntity.ok().body(products);
    }

    @Operation(summary = "Atualiza um produto informando o ID e os dados por parâmetro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto encontrado"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    })
    @PutMapping("{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id, @RequestBody ProductRequest request){
        ProductResponse updatedProduct = service.update(id, request);
        return ResponseEntity.ok().body(updatedProduct);
    }

    @Operation(summary = "Deleta um cliente informando o ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Produto deletado"),
            @ApiResponse(responseCode = "404", description = "Produto não encontrado"),
            @ApiResponse(responseCode = "409", description = "Para manter integridade do BD não permite a exclusão")
    })
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
