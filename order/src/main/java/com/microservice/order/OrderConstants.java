package com.microservice.order;

public final class OrderConstants {
    public OrderConstants(){}

    public static String TOKEN_HEADER = "Authorization";
    public static String TOKEN_PREFIX = "Bearer ";
    
    public class User{
    	public static final String HOST="http://localhost:";
    	public static final String PORT="8080";
    	public static final String MAIN_PATH="/user/v1";
    	public static final String FIND_BY_ID="/findById";
    }
    
    public class Inventory{
    	public static final String HOST="http://localhost:";
    	public static final String PORT="8081";    	
    	public static final String MAIN_PATH="/inventory/v1";
    	public static final String UPDATE_QUANTITY="/update-quantity";
    	public static final String UPDATE_QUANTITY_MANY="/update-quantity-many";
    	public static final String CHECK_QUANTITY="/check-quantity";
    }
    
    public class Order{
    	public static final String MAIN_PATH="order/v1";
    	public static final String FIND_ALL="/findAll";
    	public static final String FIND_BY_ID="/findById";
    	public static final String DO_ORDER="/do-order";
    }
    
    public class Message{
    	public static final String SUCCESS="SUCCESS!";
    	public static final String PRODUCT_NOT_ENOUGH="Product is Not Enough !";
    	public static final String FAILED_UPDATE_PRODUCT="Failed update product";
    }
    
    

}
