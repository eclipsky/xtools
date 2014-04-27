package org.sky.x.tij.c07;

public class Parcel8 {
	// Argument must be final to use inside
	// anonymous inner class:
	public Destination dest(final String dest) {
		return new Destination() {
			private String label = dest;

			public String readLabel() {
				return label;
			}
		};
	}

	public static void main(String[] args) {
		Parcel8 p = new Parcel8();
		Destination d = p.dest("Tanzania");
	}
} // /:~