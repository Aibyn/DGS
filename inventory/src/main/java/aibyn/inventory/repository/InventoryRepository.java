package aibyn.inventory.repository;

import com.netflix.dgs.codegen.generated.types.Inventory;
import com.netflix.dgs.codegen.generated.types.Product;
import graphql.com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryRepository {
    private List<Inventory> inventories = Lists.newArrayList(
            Inventory.newBuilder().count(2).product(Product.newBuilder().id(1).build()).build(),
            Inventory.newBuilder().count(3).product(Product.newBuilder().id(2).build()).build(),
            Inventory.newBuilder().count(4).product(Product.newBuilder().id(3).build()).build(),
            Inventory.newBuilder().count(5).product(Product.newBuilder().id(4).build()).build(),
            Inventory.newBuilder().count(6).product(Product.newBuilder().id(5).build()).build(),
            Inventory.newBuilder().count(7).product(Product.newBuilder().id(6).build()).build()
    );

    public List<Inventory> getInventory() {
        return inventories;
    }
}
