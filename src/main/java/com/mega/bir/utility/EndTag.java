package com.mega.bir.utility;

/**
 * The <code>TAG_End</code> tag.
 *
 */
public final class EndTag extends Tag {

	/**
	 * Creates the tag.
	 */
	public EndTag() {
		super("");
	}

	@Override
	public Object getValue() {
		return null;
	}
	
	@Override
	public String toString() {
		return "TAG_End";
	}

}
