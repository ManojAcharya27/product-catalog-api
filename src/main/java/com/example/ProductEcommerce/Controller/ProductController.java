package com.example.ProductEcommerce.Controller;

import Dtos.RequestDtos.ApplyTaxOrDiscount;
import Dtos.RequestDtos.ProductRequestDto;
import Dtos.RequestDtos.ResponseDto.ProductResponseDto;
import Dtos.RequestDtos.UpdateProductRequestDto;
import com.example.ProductEcommerce.Service.ServiceInterface.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;



    // RestAPI for  Creating Product

    @PostMapping("/addProduct")
    public ResponseEntity CreateProduct(@RequestBody ProductRequestDto productRequestDto){
        System.out.println(productRequestDto.getName()+" "+productRequestDto.getDescription());
        try{
            ProductResponseDto productResponseDto=productService.CreateProduct(productRequestDto);
            return new ResponseEntity(productResponseDto, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


    // Rest API for Retrieving  product
    @GetMapping("/readProduct/{ProductID}")
    public ResponseEntity ReadProduct(@PathVariable("ProductID") int ProductId){
        try {
            ProductResponseDto productResponseDto=productService.ReadProduct(ProductId);
            return new ResponseEntity(productResponseDto, HttpStatus.FOUND);

        } catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


    // RestAPI for updating product
    @PutMapping("/update")
    public ResponseEntity UpdateProduct(@RequestBody UpdateProductRequestDto updateProductRequestDto){
        System.out.println(updateProductRequestDto.getProductId());
        try{
            String message=productService.UpdateProduct(updateProductRequestDto);
            return new ResponseEntity(message,HttpStatus.FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


    // RestAPI for deleting product
    @DeleteMapping("/delete/{ProductId}")
    public ResponseEntity DeleteProduct(@PathVariable("ProductId") int ProductId){
        try {
            String message=productService.DeleteProduct(ProductId);
            return new ResponseEntity(message,HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    // RestAPI for applying Tax or Discount
    @PutMapping("/applyDiscountOrTax")
    public ResponseEntity applyTaxOrDiscount(@RequestBody ApplyTaxOrDiscount applyTaxOrDiscount){
        try{
             String message=productService.applyTaxOrDiscount(applyTaxOrDiscount);
             return new ResponseEntity(message,HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
