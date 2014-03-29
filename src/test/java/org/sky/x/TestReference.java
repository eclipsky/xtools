package org.sky.x;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import org.junit.Assert;

public class TestReference {

	public static void main(String[] args) {
		testStrongReference();
		testSoftReference();
		testWeakReference();
	}
	
    private static void testStrongReference(){
		Object referent = new Object();
		Object strongReference = referent;
		referent = null;
		System.gc();
		Assert.assertNotNull(strongReference);
		System.out.println("strongReference="+strongReference);
	}
    
    private static void testSoftReference(){
    	String  str =  "test";
    	SoftReference<String> softreference = new SoftReference<String>(str);
    	str=null;
    	System.gc();
    	Assert.assertNotNull(softreference.get());
		System.out.println("softreference="+softreference);
	}
    
    private static void testWeakReference(){
    	String  str =  "test";
    	WeakReference<String> weakReference = new WeakReference<String>(str);
    	str=null;
    	System.gc();
    	Assert.assertNull(weakReference.get());
    	System.out.println("weakReference="+weakReference);
    }
    
}
