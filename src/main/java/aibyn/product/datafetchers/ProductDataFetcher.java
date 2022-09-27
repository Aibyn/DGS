package aibyn.product.datafetchers;

import aibyn.product.repository.ProductRepository;
import com.netflix.dgs.codegen.generated.types.Product;
import com.netflix.dgs.codegen.generated.types.ProductType;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@DgsComponent
public class ProductDataFetcher {
    @Autowired
    ProductRepository productRepository;

    @DgsData(parentType = "Query", field = "products")
    public List<Product> products(@InputArgument ProductType type) {
        if (type != null) {
            return productRepository.getProducts().stream().filter(product -> product.getType().equals(type)).collect(Collectors.toList());
        }
        return productRepository.getProducts();
    }
}
