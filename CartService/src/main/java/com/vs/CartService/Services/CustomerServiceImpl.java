package com.vs.CartService.Services;

import com.vs.CartService.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CustomerServiceImpl implements CartService {

    // Customer repository
    private static final Map<Integer, Product> CART_REPOSITORY_MAP = new HashMap<>();

    static{
        CART_REPOSITORY_MAP.put(1,new Product());
        CART_REPOSITORY_MAP.put(2,new Product());
    }

    // Variable for generating a customer ID
    private static final AtomicInteger CUSTOMER_ID_HOLDER = new AtomicInteger();

    @Override
    public void create(Product customer) {
        final int customerId = CUSTOMER_ID_HOLDER.incrementAndGet();
        customer.setId(customerId);
        CART_REPOSITORY_MAP.put(customerId, customer);
    }



    @Override
    public List<Product> readAll() {
        return new ArrayList<>(CART_REPOSITORY_MAP.values());
    }

    @Override
    public Product read(int id) {
        return CART_REPOSITORY_MAP.get(id);
    }

    @Override
    public boolean update(Product customer, int id) {
        if (CART_REPOSITORY_MAP.containsKey(id)) {
            customer.setId(id);
            CART_REPOSITORY_MAP.put(id, customer);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        return CART_REPOSITORY_MAP.remove(id) != null;
    }
}