package aibyn.product.repository;

import aibyn.product.util.ProductUtil;
import com.netflix.dgs.codegen.generated.types.InputProduct;
import com.netflix.dgs.codegen.generated.types.Product;
import com.netflix.dgs.codegen.generated.types.ProductType;
import graphql.com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductRepository {
    private List<Product> products = Lists.newArrayList(
            Product.newBuilder().id(1).type(ProductType.WEIGHT).name("Cucumber").price(100).build(),
            Product.newBuilder().id(2).type(ProductType.WEIGHT).name("Tomato").price(50).build(),
            Product.newBuilder().id(3).type(ProductType.SINGLE).name("Coca Cola 0.5l").price(200).build(),
            Product.newBuilder().id(4).type(ProductType.SINGLE).name("Fanta 0.5l").price(300).build(),
            Product.newBuilder().id(5).type(ProductType.PACKAGE).name("6 x Coca Cola 0.5l").price(200).build(),
            Product.newBuilder().id(6).type(ProductType.PACKAGE).name("6 x Fanta 0.5l").price(300).build()
    );

    public List<Product> getProducts() {
        return products;
    }

    public void add(InputProduct product) {
        products.add(ProductUtil.convertInput(product));
    }
}
