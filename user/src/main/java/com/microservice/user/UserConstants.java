package com.microservice.user;

public final class UserConstants {
    public UserConstants(){}

    public static String TOKEN_HEADER = "Authorization";
    public static String TOKEN_PREFIX = "Bearer ";
    
    public class Auth{
    	public static final String MAIN_PATH="auth/v1";
    	public static final String LOGIN="/login";
    }
    
    public class User{
    	public static final String MAIN_PATH="user/v1";
    	public static final String ADD="/add";
    	public static final String FIND_ALL="/findAll";
    	public static final String FIND_BY_ID="/findById";
    }
    
    public class Message{
    	public static final String SUCCESS="SUCCESS!";
    	public static final String PRODUCT_EMPTY="Product is Not Enough !";
    }
    
    

}
