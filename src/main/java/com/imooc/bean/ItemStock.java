package com.imooc.bean;

public class ItemStock {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item_stock.id
     *
     * @mbg.generated
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item_stock.stock
     *
     * @mbg.generated
     */
    private Integer stock;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item_stock.item_id
     *
     * @mbg.generated
     */
    private String itemId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item_stock.id
     *
     * @return the value of item_stock.id
     *
     * @mbg.generated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item_stock.id
     *
     * @param id the value for item_stock.id
     *
     * @mbg.generated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item_stock.stock
     *
     * @return the value of item_stock.stock
     *
     * @mbg.generated
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item_stock.stock
     *
     * @param stock the value for item_stock.stock
     *
     * @mbg.generated
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item_stock.item_id
     *
     * @return the value of item_stock.item_id
     *
     * @mbg.generated
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item_stock.item_id
     *
     * @param itemId the value for item_stock.item_id
     *
     * @mbg.generated
     */
    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }
}