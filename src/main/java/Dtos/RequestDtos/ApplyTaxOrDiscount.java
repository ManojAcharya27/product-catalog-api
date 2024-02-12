package Dtos.RequestDtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ApplyTaxOrDiscount {

    int productId;

    int tax;

    int discount;
}
