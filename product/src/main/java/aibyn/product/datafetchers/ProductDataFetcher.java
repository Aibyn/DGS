package aibyn.product.datafetchers;

import aibyn.product.repository.ProductRepository;
import com.netflix.dgs.codegen.generated.DgsConstants;
import com.netflix.dgs.codegen.generated.types.Product;
import com.netflix.dgs.codegen.generated.types.ProductType;
import com.netflix.graphql.dgs.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@DgsComponent
public class ProductDataFetcher {
    @Autowired
    ProductRepository productRepository;

    @DgsQuery
    public List<Product> products(@InputArgument ProductType type) {
        if (type != null) {
            return productRepository.getProducts().stream().filter(product -> product.getType().equals(type)).collect(Collectors.toList());
        }
        return productRepository.getProducts();
    }



    @DgsEntityFetcher(name = DgsConstants.PRODUCT.TYPE_NAME)
    public Product product(Map<String, Object> values) {
        return productRepository.getProducts().stream().filter((prod) -> Objects.equals(prod.getId(), values.get("id"))).findFirst().get();
    }

}
