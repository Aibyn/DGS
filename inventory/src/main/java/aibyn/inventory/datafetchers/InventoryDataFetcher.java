package aibyn.inventory.datafetchers;

import aibyn.inventory.repository.InventoryRepository;
import com.netflix.dgs.codegen.generated.types.Inventory;
import com.netflix.dgs.codegen.generated.types.Product;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsEntityFetcher;
import com.netflix.graphql.dgs.DgsQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@DgsComponent
public class InventoryDataFetcher {
    @Autowired
    InventoryRepository inventoryRepository;

    @DgsQuery
    public List<Inventory> getInventories() {
        return inventoryRepository.getInventory();
    }
}
