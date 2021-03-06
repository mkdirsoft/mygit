package com.flx.flxoa.info.market.entity;
// Generated 2018-11-9 19:09:53 by Hibernate Tools 5.1.7.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * HxEnum generated by hbm2java
 */
@Entity
@Table(name = "hx_enum", catalog = "flxoa")
public class HxEnum implements java.io.Serializable {

	private Integer enumId;
	private String enumName;
	private String enumValue;
	private Integer enumIntValue;

	public HxEnum() {
	}

	public HxEnum(String enumName, String enumValue, Integer enumIntValue) {
		this.enumName = enumName;
		this.enumValue = enumValue;
		this.enumIntValue = enumIntValue;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "EnumID", unique = true, nullable = false)
	public Integer getEnumId() {
		return this.enumId;
	}

	public void setEnumId(Integer enumId) {
		this.enumId = enumId;
	}

	@Column(name = "EnumName", length = 50)
	public String getEnumName() {
		return this.enumName;
	}

	public void setEnumName(String enumName) {
		this.enumName = enumName;
	}

	@Column(name = "EnumValue", length = 50)
	public String getEnumValue() {
		return this.enumValue;
	}

	public void setEnumValue(String enumValue) {
		this.enumValue = enumValue;
	}

	@Column(name = "EnumIntValue")
	public Integer getEnumIntValue() {
		return this.enumIntValue;
	}

	public void setEnumIntValue(Integer enumIntValue) {
		this.enumIntValue = enumIntValue;
	}

	public void setDeleteFlag(String string) {
		// TODO Auto-generated method stub
		
	}

}
