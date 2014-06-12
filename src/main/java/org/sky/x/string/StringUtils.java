package org.sky.x.string;

/**
 * @author xieming  2013-10-15 下午04:03:01
 */
public class StringUtils {
	
	String s;
	
	int t;
	
	byte b;

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + b;
		result = prime * result + ((s == null) ? 0 : s.hashCode());
		result = prime * result + t;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StringUtils other = (StringUtils) obj;
		if (b != other.b)
			return false;
		if (s == null) {
			if (other.s != null)
				return false;
		} else if (!s.equals(other.s))
			return false;
		if (t != other.t)
			return false;
		return true;
	}
	
}
