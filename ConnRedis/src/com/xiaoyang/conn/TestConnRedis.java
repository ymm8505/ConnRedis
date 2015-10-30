package com.xiaoyang.conn;

import java.util.List;

import redis.clients.jedis.Jedis;

public class TestConnRedis {
	public static void main(String[] args) {
		
		String localhost = "192.168.157.128";
		// Connecting to Redis server on localhost
		Jedis jedis = new Jedis(localhost);
		System.out.println("Connection to server sucessfully");
		// set the data in redis string
		jedis.set("tutorial-name", "Redis tutorial");
		// Get the stored data and print it
		System.out.println("Stored string in redis:: "	+ jedis.get("tutorial-name"));
		
		System.out.println("Stored string in redis:: "	+ jedis.get("foo"));
		
		//store data in redis list
	      jedis.lpush("tutorial-list", "Redis");
	      jedis.lpush("tutorial-list", "Mongodb");
	      jedis.lpush("tutorial-list", "Mysql");
	     // Get the stored data and print it
	     List<String> list = jedis.lrange("tutorial-list", 0 ,5);
	     for(int i=0; i<list.size(); i++) {
	       System.out.println("Stored string in redis:: "+list.get(i));
	     }
	     
	    /* //store data in redis list
	     // Get the stored data and print it
	     List<String> list2 =  jedis.keys("*");
	     for(int i=0; i<list2.size(); i++) {
	       System.out.println("List of stored keys:: "+list2.get(i));
	     }*/
	}
}

