package cn.freeteam.model;

import java.io.Serializable;

public class Func implements Serializable{
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column func.id
     *
     * @mbggenerated Fri Dec 16 16:07:41 CST 2011
     */
	private String hasChildren;
    private String id;
    private String target;
	private String iconCls;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column func.name
     *
     * @mbggenerated Fri Dec 16 16:07:41 CST 2011
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column func.isOk
     *
     * @mbggenerated Fri Dec 16 16:07:41 CST 2011
     */
    private String isok;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column func.orderNum
     *
     * @mbggenerated Fri Dec 16 16:07:41 CST 2011
     */
    private Integer ordernum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column func.url
     *
     * @mbggenerated Fri Dec 16 16:07:41 CST 2011
     */
    private String url;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column func.parId
     *
     * @mbggenerated Fri Dec 16 16:07:41 CST 2011
     */
    private String parid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column func.id
     *
     * @return the value of func.id
     *
     * @mbggenerated Fri Dec 16 16:07:41 CST 2011
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column func.id
     *
     * @param id the value for func.id
     *
     * @mbggenerated Fri Dec 16 16:07:41 CST 2011
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column func.name
     *
     * @return the value of func.name
     *
     * @mbggenerated Fri Dec 16 16:07:41 CST 2011
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column func.name
     *
     * @param name the value for func.name
     *
     * @mbggenerated Fri Dec 16 16:07:41 CST 2011
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column func.isOk
     *
     * @return the value of func.isOk
     *
     * @mbggenerated Fri Dec 16 16:07:41 CST 2011
     */
    public String getIsok() {
        return isok;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column func.isOk
     *
     * @param isok the value for func.isOk
     *
     * @mbggenerated Fri Dec 16 16:07:41 CST 2011
     */
    public void setIsok(String isok) {
        this.isok = isok == null ? null : isok.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column func.orderNum
     *
     * @return the value of func.orderNum
     *
     * @mbggenerated Fri Dec 16 16:07:41 CST 2011
     */
    public Integer getOrdernum() {
        return ordernum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column func.orderNum
     *
     * @param ordernum the value for func.orderNum
     *
     * @mbggenerated Fri Dec 16 16:07:41 CST 2011
     */
    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column func.url
     *
     * @return the value of func.url
     *
     * @mbggenerated Fri Dec 16 16:07:41 CST 2011
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column func.url
     *
     * @param url the value for func.url
     *
     * @mbggenerated Fri Dec 16 16:07:41 CST 2011
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column func.parId
     *
     * @return the value of func.parId
     *
     * @mbggenerated Fri Dec 16 16:07:41 CST 2011
     */
    public String getParid() {
        return parid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column func.parId
     *
     * @param parid the value for func.parId
     *
     * @mbggenerated Fri Dec 16 16:07:41 CST 2011
     */
    public void setParid(String parid) {
        this.parid = parid == null ? null : parid.trim();
    }

	public String getHasChildren() {
		return hasChildren;
	}

	public void setHasChildren(String hasChildren) {
		this.hasChildren = hasChildren;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	
}