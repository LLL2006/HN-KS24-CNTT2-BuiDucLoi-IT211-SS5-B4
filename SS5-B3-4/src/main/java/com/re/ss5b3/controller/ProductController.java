package com.re.ss5b3.controller;


import com.re.ss5b3.model.entity.Product;
import com.re.ss5b3.model.response.ApiDataResponse;
import com.re.ss5b3.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<ApiDataResponse<?>> getAllProducts() {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Lấy danh sách thành công",
                productService.getAllProducts(),
                HttpStatus.OK
        ),  HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiDataResponse<?>> getProductById(@PathVariable Long id) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Lấy thông tin sản phẩm thành công",
                productService.getProductById(id),
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiDataResponse<?>> addProduct(@Valid @RequestBody Product product) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Thêm sản phẩm thành công",
                productService.addProduct(product),
                HttpStatus.CREATED
        ),  HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiDataResponse<?>> updateFull(@PathVariable Long id,@Valid @RequestBody Product product) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Cập nhật toàn bộ sản phẩm thành công",
                productService.updateFull(id, product),
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiDataResponse<?>> updatePartial(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Cập nhật một phần sản phẩm thành công",
                productService.updatePartial(id, updates),
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiDataResponse<?>> deleteProduct(@PathVariable Long id) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Xóa sản phẩm thành công",
                productService.deleteProduct(id),
                HttpStatus.NO_CONTENT
        ), HttpStatus.NO_CONTENT);
    }
}
