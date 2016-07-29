package com.ispring.api.oauth;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLRUCache {
	
	//
	@Test
	public void testEmptyCache(){
		LRUCache cache=new LRUCache(0);
		Assert.assertEquals(cache.getCapacity(),0);
		
	}
	
	@Test
	public void testInsertCache(){
		int capacity=2;
		LRUCache cache=new LRUCache(capacity);
		cache.set(0,1);
		cache.set(1,3);
		Assert.assertNotEquals(cache.get(0),-1);
		Assert.assertNotEquals(cache.get(1),-1);

	}
	
	@Test
	public void testInsertBeyondCapacity(){
		
		LRUCache cache=new LRUCache(5);
		cache.set(0,1);
		cache.set(1,2);
		cache.set(2,3);
		cache.set(3,4);
		cache.set(4,5);
		int fetchVal=cache.get(1);
		fetchVal=cache.get(4);
		
		fetchVal=cache.get(0);
		cache.set(5,6);
		Assert.assertEquals(cache.get(2), -1);
		
		
	}
	

	
	
	

}
