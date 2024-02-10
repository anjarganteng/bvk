package com.microservice.inventory;

public final class InventoryConstants {
    public InventoryConstants(){}
    
    public static String TOKEN_HEADER = "Authorization";
    public static String TOKEN_PREFIX = "Bearer ";
    
    public class User{
    	public static final String HOST="http://localhost:";
    	public static final String PORT="8080";
    	public static final String MAIN_PATH="/user/v1";
    	public static final String FIND_BY_ID="/findById";
    }
    
    public class Inventory{
    	public static final String MAIN_PATH="inventory/v1";
    	public static final String FIND_ALL="/findAll";
    	public static final String FIND_BY_ID="/findById";
    	public static final String ADD="/add";
    	public static final String UPDATE="/update";
    	public static final String UPDATE_QUANTITY="/update-quantity";
    	public static final String UPDATE_QUANTITY_MANY="/update-quantity-many";
    	public static final String CHECK_QUANTITY="/check-quantity";
    }
    
    public class Message{
    	public static final String SUCCESS="SUCCESS!";
    	public static final String PRODUCT_EMPTY="Product is Not Enough !";
    }
    
    

}
