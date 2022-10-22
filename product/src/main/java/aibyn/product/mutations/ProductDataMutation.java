package aibyn.product.mutations;

import aibyn.product.repository.ProductRepository;
import com.netflix.dgs.codegen.generated.types.InputProduct;
import com.netflix.dgs.codegen.generated.types.Product;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DgsComponent
public class ProductDataMutation {

    @Autowired
    ProductRepository productRepository;

    @DgsMutation
    public List<Product> addProduct(@InputArgument InputProduct product) {
        productRepository.add(product);
        return productRepository.getProducts();
    }
}
