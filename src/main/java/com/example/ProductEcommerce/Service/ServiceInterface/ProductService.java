package com.example.ProductEcommerce.Service.ServiceInterface;

import Dtos.RequestDtos.ApplyTaxOrDiscount;
import Dtos.RequestDtos.ProductRequestDto;
import Dtos.RequestDtos.ResponseDto.ProductResponseDto;
import Dtos.RequestDtos.UpdateProductRequestDto;
import Exceptions.InvalidProductIDException;
import Exceptions.ProductDoesNotExistException;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    public ProductResponseDto CreateProduct(ProductRequestDto productRequestDto);


    public ProductResponseDto ReadProduct(int id) throws InvalidProductIDException;

    public String UpdateProduct(UpdateProductRequestDto productRequestDto) throws InvalidProductIDException;

    public String applyTaxOrDiscount(ApplyTaxOrDiscount applyTaxOrDiscount) throws InvalidProductIDException;


    public String DeleteProduct(int id) throws ProductDoesNotExistException;
}
