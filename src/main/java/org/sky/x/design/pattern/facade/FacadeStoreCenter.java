package org.sky.x.design.pattern.facade;

import org.sky.x.design.pattern.facade.impl.ClothingStoreImpl;
import org.sky.x.design.pattern.facade.impl.EleStoreImpl;

public class FacadeStoreCenter {

	public void getStore(){
		clothingStoreImpl.getClothing();
		eleStoreImpl.getEle();
	}
	
    public FacadeStoreCenter(){
    	clothingStoreImpl = new ClothingStoreImpl();
    	eleStoreImpl = new EleStoreImpl();
	}
	
	@SuppressWarnings("unused")
	private ClothingStore clothingStoreImpl;
	private EleStore eleStoreImpl;
	
	public static void main(String[] args) {
		new FacadeStoreCenter().getStore();
	}

}
