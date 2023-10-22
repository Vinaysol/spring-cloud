package com.vs.CartService.Services;

import com.vs.CartService.model.Product;

import java.util.List;

public interface CartService {

    /**
     * Creates a new customer
     * @param product - Customer to be created
     */
    void create(Product product);

    /**
     * Returns a list of all existing customers
     * @return List of customers
     */
    List<Product> readAll();

    /**
     * Returns a customer based on its ID
     * @param id - Customer ID
     * @return - Customer object with the given ID
     */
    Product read(int id);

    /**
     * Updates the customer with the given ID,
     * according to the passed customer
     * @param customer - Customer to use to update the data
     * @param id - ID of the customer you want to update
     * @return - true if the data has been updated, otherwise false
     */
    boolean update(Product customer, int id);

    /**
     * Deletes the customer with the given ID
     * @param id - ID of the customer to be deleted
     * @return - true if the customer was deleted, otherwise false
     */
    boolean delete(int id);
}