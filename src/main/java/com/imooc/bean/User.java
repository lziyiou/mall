package com.imooc.bean;

public class User {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.id
     *
     * @mbg.generated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.gender
     *
     * @mbg.generated
     */
    private Byte gender;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.age
     *
     * @mbg.generated
     */
    private Integer age;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.telphone
     *
     * @mbg.generated
     */
    private String telephone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.register_mod
     *
     * @mbg.generated
     */
    private String registerMod;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info.third_part_id
     *
     * @mbg.generated
     */
    private String thirdPartId;

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.id
     *
     * @return the value of user_info.id
     * @mbg.generated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.id
     *
     * @param id the value for user_info.id
     * @mbg.generated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.name
     *
     * @return the value of user_info.name
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.name
     *
     * @param name the value for user_info.name
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.gender
     *
     * @return the value of user_info.gender
     * @mbg.generated
     */
    public Byte getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.gender
     *
     * @param gender the value for user_info.gender
     * @mbg.generated
     */
    public void setGender(Byte gender) {
        this.gender = gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.age
     *
     * @return the value of user_info.age
     * @mbg.generated
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.age
     *
     * @param age the value for user_info.age
     * @mbg.generated
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.telphone
     *
     * @return the value of user_info.telphone
     * @mbg.generated
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.telphone
     *
     * @param telephone the value for user_info.telphone
     * @mbg.generated
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.register_mod
     *
     * @return the value of user_info.register_mod
     * @mbg.generated
     */
    public String getRegisterMod() {
        return registerMod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.register_mod
     *
     * @param registerMod the value for user_info.register_mod
     * @mbg.generated
     */
    public void setRegisterMod(String registerMod) {
        this.registerMod = registerMod == null ? null : registerMod.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info.third_part_id
     *
     * @return the value of user_info.third_part_id
     * @mbg.generated
     */
    public String getThirdPartId() {
        return thirdPartId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info.third_part_id
     *
     * @param thirdPartId the value for user_info.third_part_id
     * @mbg.generated
     */
    public void setThirdPartId(String thirdPartId) {
        this.thirdPartId = thirdPartId == null ? null : thirdPartId.trim();
    }
}