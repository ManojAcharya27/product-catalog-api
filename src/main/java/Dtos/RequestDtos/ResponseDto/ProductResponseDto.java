package Dtos.RequestDtos.ResponseDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProductResponseDto {

    int ProductID;

    String Name;

    String Description;

    double Price;

    long Quantity_Available;
}
