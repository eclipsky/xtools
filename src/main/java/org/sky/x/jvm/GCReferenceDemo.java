package org.sky.x.jvm;

import java.lang.ref.SoftReference;

/**
 * @author xieming 2013-11-12 обнГ06:54:18
 */
public class GCReferenceDemo {
	public static void main(String[] args) {
		GCReferenceDemo gc = new GCReferenceDemo();
		gc.testStrongReference();
	}

	void testStrongReference() {
		Object obj = new Object();
		Object strongReference = obj;
		obj = null;
		String test="haha";
		SoftReference<String> softReference = new SoftReference<String>("hha");
		softReference = null;
		System.gc();
		System.out.println(strongReference);
		System.out.println(softReference);
		// assertNotNull();
	}

}
