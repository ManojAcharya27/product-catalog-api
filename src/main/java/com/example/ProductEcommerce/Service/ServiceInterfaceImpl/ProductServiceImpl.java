package com.example.ProductEcommerce.Service.ServiceInterfaceImpl;

import Dtos.RequestDtos.ApplyTaxOrDiscount;
import Dtos.RequestDtos.ProductRequestDto;
import Dtos.RequestDtos.ResponseDto.ProductResponseDto;
import Dtos.RequestDtos.UpdateProductRequestDto;
import com.example.ProductEcommerce.Entity.Product;
import Exceptions.InvalidProductIDException;
import Exceptions.ProductDoesNotExistException;
import com.example.ProductEcommerce.Service.ServiceInterface.ProductService;
import Transformers.ProductTransformers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    List<Product> productList=new ArrayList<>();  // DB


    @Override //method for Creating Product
    public ProductResponseDto CreateProduct(ProductRequestDto productRequestDto) {

        Product product= ProductTransformers.productRequestDtoTOProduct(productRequestDto); // creating Product
        int id=productList.size()+1;
      //  System.out.println("hi");
        product.setProductID(id);
        productList.add(product);   // adding to db

        ProductResponseDto productResponseDto=ProductTransformers.productToProductResponseDto(product); // creating responseDto of Product
        return productResponseDto;
    }

    @Override   // method for reading product
    public ProductResponseDto ReadProduct(int id) throws InvalidProductIDException {

        try{
            ProductResponseDto productResponseDto=null;
            for(int i=0;i<productList.size();i++){
                if(productList.get(i).getProductID()==id){
                  productResponseDto =ProductTransformers.productToProductResponseDto(productList.get(i));
                }
            }
            return productResponseDto;
        }catch (Exception e){
            throw new InvalidProductIDException("Given ProductId is not available");
        }


    }

    @Override    //method for updating product
    public String UpdateProduct(UpdateProductRequestDto updateProductRequestDto) throws InvalidProductIDException {

        try {

            for(int i=0;i<productList.size();i++){
                System.out.println("hI");
                if(productList.get(i).getProductID()==updateProductRequestDto.getProductId()){
                    System.out.println("hI");
                    productList.get(i).setProductID(updateProductRequestDto.getProductId());
                    productList.get(i).setName(updateProductRequestDto.getName());
                    productList.get(i).setPrice(updateProductRequestDto.getPrice());
                    productList.get(i).setDescription(updateProductRequestDto.getDescription());
                    productList.get(i).setQuantity_Available(updateProductRequestDto.getQuantity_Available());
                   return  "Updated Successfully";
                }
            }

        }catch (Exception e){
            throw new InvalidProductIDException("The Product Is not Available");
        }
      return "The Product Is not Available";
    }

    @Override // method for applying tax or discount
    public String applyTaxOrDiscount(ApplyTaxOrDiscount applyTaxOrDiscount) throws InvalidProductIDException {
        try {
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getProductID() == applyTaxOrDiscount.getProductId()) {
                    if (applyTaxOrDiscount.getTax() != 0) {
                        double ans = productList.get(i).getPrice() * (1 + (applyTaxOrDiscount.getTax() / 100.00));
                        productList.get(i).setPrice(ans);
                        String name = productList.get(i).getName();
                        double price = productList.get(i).getPrice();
                        return "The Tax updated Successfully the product details are:" + " " + name + " " + price;
                    } else if(applyTaxOrDiscount.getDiscount()!=0){
                        double ans = productList.get(i).getPrice() * (1 - (applyTaxOrDiscount.getDiscount() / 100.00));
                        productList.get(i).setPrice(ans);
                        String name = productList.get(i).getName();
                        double price = productList.get(i).getPrice();
                        return "The Discount updated Successfully the product details are:" + " " + name + " " + price;
                    }
                }
            }
        }catch (Exception e){
            throw new InvalidProductIDException("The Product Is Not Given");
        }
       return null;
    }

    @Override  //method for deleting product
    public String DeleteProduct(int id) throws ProductDoesNotExistException {
        try {
            for(int i=0;i<productList.size();i++){
                if(productList.get(i).getProductID()==id){
                    productList.remove(productList.get(i));
                    return "Product Remove Successfully";
                }
            }
        }catch (Exception e){
            throw new ProductDoesNotExistException("The Product Does Not Exists");
        }
        return "null";
    }
}
