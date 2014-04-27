package org.sky.x.tij.c07;

class Base{  
    static void a( ){System.out.println("A");  }  
             void b( ){System.out.println("B"); }  
}  
public class  Inherit extends Base{  
      static void a( ){System.out.println("C");  }  
              void b( ){System.out.println("D"); }  
       public static void main(String args[]){  
                Base b=new Base();  
                Base c=new Inherit();  
                b.a();  
                b.b();  
                c.a();  
                c.b();  
     }  
}