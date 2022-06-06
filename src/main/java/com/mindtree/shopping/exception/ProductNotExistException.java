package com.mindtree.shopping.exception;

@SuppressWarnings("serial")
public class ProductNotExistException extends IllegalArgumentException {
    public ProductNotExistException(String msg) {
        super(msg);
    }
}