package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;


@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        if (product.getProductId() == null) {
            UUID uuid = UUID.randomUUID();
            product.setProductId(uuid.toString());
        }

        productData.add(product);
        return product;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public void delete(String productId) {
        Product productToDelete = null;

        for(Product product : productData) {
            if (product.getProductId().equals(productId)) {
                productToDelete = product;
                break;
            }
        }

        if (productToDelete != null) {
            productData.remove(productToDelete);
        }
    }

    public Product findById(String productId) {
        for (Product product : productData) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    public Product edit(Product product) {
        for (Product data : productData) {
            if  (data.getProductId().equals(product.getProductId())) {
                data.setProductName(product.getProductName());
                data.setProductQuantity(product.getProductQuantity());
                return data;
            }
        }
        return null;
    }
}