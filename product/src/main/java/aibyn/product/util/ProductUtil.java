package aibyn.product.util;

import com.netflix.dgs.codegen.generated.types.InputProduct;
import com.netflix.dgs.codegen.generated.types.Product;

public class ProductUtil {

    public static Product convertInput(InputProduct product) {
        return Product.newBuilder()
                .name(product.getName())
                .price(product.getPrice())
                .type(product.getType()
                ).build();
    }
}
