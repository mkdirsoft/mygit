package com.flx.flxoa.info.market.entity;
// Generated 2018-12-25 18:31:19 by Hibernate Tools 5.0.6.Final

/**
 * HxSource generated by hbm2java
 */
public class HxSource implements java.io.Serializable {

	private String sourceCode;
	private String sourceName;
	private Byte sourceType;
	private String sort;

	public HxSource() {
	}

	public HxSource(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public HxSource(String sourceCode, String sourceName, Byte sourceType, String sort) {
		this.sourceCode = sourceCode;
		this.sourceName = sourceName;
		this.sourceType = sourceType;
		this.sort = sort;
	}

	public String getSourceCode() {
		return this.sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public String getSourceName() {
		return this.sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public Byte getSourceType() {
		return this.sourceType;
	}

	public void setSourceType(Byte sourceType) {
		this.sourceType = sourceType;
	}

	public String getSort() {
		return this.sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

}
