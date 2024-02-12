package Dtos.RequestDtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class UpdateProductRequestDto {

    int productId;

    String name;

    String description;

    double price;

    long quantity_Available;


}
