package org.sky.x.security;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Base64Decode extends InputStream {
	boolean skipBlank;
	int remainder = 0, bitsRemainder = 0, outCount = 0;
	final InputStream inputStream;

	public Base64Decode(InputStream is) {
		this.inputStream = is;
	}

	public Base64Decode(byte[] ba) {
		this(new ByteArrayInputStream(ba));
	}

	public Base64Decode(String text) {
		this(new ByteArrayInputStream(text.getBytes()));
	}

	public void setSkipBlank(boolean skipBlank) {
		this.skipBlank = skipBlank;
	}

	/**
	 * Reads the next byte of data from the input stream. The value byte is
	 * returned as an <code>int</code> in the range <code>0</code> to
	 * <code>255</code>. If no byte is available because the end of the stream
	 * has been reached, the value <code>-1</code> is returned. This method
	 * blocks until input data is available, the end of the stream is detected,
	 * or an exception is thrown.
	 * 
	 * <p>
	 * A subclass must provide an implementation of this method.
	 * 
	 * @return the next byte of data, or <code>-1</code> if the end of the
	 *         stream is reached.
	 * @exception IOException
	 *                if an I/O error occurs.
	 */
	@Override
	public int read() throws IOException {
		for (;;) {
			if (bitsRemainder >= 8) {
				int c = remainder >> (bitsRemainder - 8); // os.write(remainder>>(bitsRemainder-8));
				outCount++;
				bitsRemainder -= 8;
				return c & 0xff; // continue;
			}
			// if( iText>=lenText )
			// return -1;
			int indata;
			if (skipBlank) {
				for (;;) {
					indata = inputStream.read(); // text.charAt(iText++);
													// //is.read();
					if (indata < 0 || indata > ' ')
						break;
				}
			} else {
				indata = inputStream.read(); // text.charAt(iText++);
												// //is.read();
			}
			if (indata < 0)
				return -1;// break;
			if (indata == '=')
				continue;
			remainder = (remainder << 6) | fromBase64Code(indata);
			bitsRemainder += 6;
		}
	}

	public static final int fromBase64Code(int x) {
		if (x >= 'A' && x <= 'Z')
			return x - 'A';
		if (x >= 'a' && x <= 'z')
			return x - 'a' + 26;
		if (x >= '0' && x <= '9')
			return x - '0' + 52;
		if (x == '+')
			return 62;
		if (x == '/')
			return 63;
		throw new IllegalArgumentException("code=" + (char) x + '(' + x + ')');
	}

	public static byte[] decode(String text) throws java.io.IOException {
		return toByteArray(new Base64Decode(text));
	}

	static private int toHex(char c1) {
		if (c1 >= '0' && c1 <= '9')
			return c1 - '0';
		if (c1 >= 'A' && c1 <= 'F')
			return c1 - 'A' + 10;
		if (c1 >= 'a' && c1 <= 'f')
			return c1 - 'a' + 10;
		return -1;
	}

	public static byte[] decodeQ(String text) { // throws java.io.IOException
		// “=68=65=6C=6C=6F”
		final int ltext = text.length();
		byte a[] = new byte[ltext];
		int n = 0;
		for (int i = 0; i < ltext; i++) {
			char c = text.charAt(i);
			if (c == '=') {
				int c1 = toHex(text.charAt(++i));
				int c2 = toHex(text.charAt(++i));
				if (c1 < 0 || c2 < 0)
					throw new java.lang.IllegalArgumentException(text);
				a[n++] = (byte) ((c1 << 4) | c2);
				// if( c1>='0'
			} else {
				a[n++] = (byte) c;
			}
		}
		byte newa[] = new byte[n];
		System.arraycopy(a, 0, newa, 0, n);
		return newa;
	}

	public static byte[] toByteArray(InputStream in) throws IOException {
		if (in == null)
			return null;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		copy(in, out);
		return out.toByteArray();
	}

	static public int copy(InputStream in, OutputStream out) throws IOException {
		int n = 0;
		byte[] buffer = new byte[64 * 1024];
		for (;;) {
			int count = in.read(buffer);
			if (count < 0)
				break;
			out.write(buffer, 0, count);
			n += count;
		}
		return n;
	}

	/*
	 * public static void main(String args[]){ String s = new String(
	 * decodeQ("=68=65=6C=6C=6Fabc") ); System.err.println(s); }
	 */

}
