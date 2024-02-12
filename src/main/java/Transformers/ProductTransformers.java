package Transformers;

import Dtos.RequestDtos.ProductRequestDto;
import Dtos.RequestDtos.ResponseDto.ProductResponseDto;
import com.example.ProductEcommerce.Entity.Product;

import java.sql.SQLOutput;

public class ProductTransformers {

    public  static Product productRequestDtoTOProduct(ProductRequestDto productRequestDto){
        Product product=new Product();
       // System.out.println(productRequestDto.getQuantity_Available());
        product.setName(productRequestDto.getName());
        product.setPrice(productRequestDto.getPrice());
        product.setDescription(productRequestDto.getDescription());
        product.setQuantity_Available(productRequestDto.getQuantity_Available());
        return product;
    }

    public static ProductResponseDto productToProductResponseDto(Product product){
        ProductResponseDto productResponseDto=new ProductResponseDto();
        productResponseDto.setProductID(product.getProductID());
        productResponseDto.setDescription(product.getDescription());
        productResponseDto.setName(product.getName());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setQuantity_Available(product.getQuantity_Available());
        return productResponseDto;
    }
}
