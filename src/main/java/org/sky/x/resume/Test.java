package org.sky.x.resume;

interface Contents {  
    int value();  
}  
interface Destination {  
    String readLabel();  
}  
class Good {  
	private int value = 10;
	private static int valueS = 11;
	public Good(String a){
		System.out.println("From String");
		
	}
	public Good(int b){
		System.out.println("From int");
		
	}
    private class Content implements Contents {  
        private int i = 11;  
        public static final int j = 10;
        public int value() {
        	System.out.println(j*value);
            return i;  
        }
    }  
    protected class GDestination implements Destination {  
        private String label;  
        private GDestination(String whereTo) {
        	System.out.println(whereTo);
            label = whereTo;  
        }  
        public String readLabel() {  
            return label;  
        }  
    }  
    public Destination dest(String s) {  
        return new GDestination(s);  
    }  
    public Contents cont() {  
        return new Content();  
    }  
    public static void main(String[] args){
    	System.out.println("I'm Good");
    	Good p = new Good("a");  
    	Contents c = p.cont();
    	c.value();
    	Destination d = p.dest("Beijing");  
    	
    	Good.Content c1 = p.new Content();
    	Good.GDestination d2 = p.new GDestination("Hainan");
    }
    public Contents getInstance(final int i){
    	return new Contents(){
    		public int value(){
    			return i*9;
    		};
    	};
    }
    public Good getGood(final int i){
    	return new Good(i){

    	};
    }
}  
class Test {  
    public static void main(String[] args) {  
        Good p = new Good("a");
        Contents c = p.cont();
        c.value();
        Destination d = p.dest("Beijing");  
    }  
}  