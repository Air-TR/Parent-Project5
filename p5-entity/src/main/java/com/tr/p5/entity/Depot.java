package com.tr.p5.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "depot")
public class Depot {
	
    /** 主键id */
    private Integer id;

    /** 仓库名 */
    private String name;

    /** 产地 */
    private String place;

    /** 热量 */
    private Double heat;

    /** 硫份 */
    private Double sulphur;

    /** 含碳量 */
    private Double carbon;

    /** 灰份 */
    private Double ash;

    /** 挥发物 */
    private Double volatiles;

    /** 水份 */
    private Double water;

    /** 总量 */
    private Double totalAmount;

    /** 单价 */
    private Double unitPrice;

    /** 确认人 */
    private String confirmPerson;

    /** 备注 */
    private String remark;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Column
    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    @Column
    public Double getHeat() {
        return heat;
    }

    public void setHeat(Double heat) {
        this.heat = heat;
    }

    @Column
    public Double getSulphur() {
        return sulphur;
    }

    public void setSulphur(Double sulphur) {
        this.sulphur = sulphur;
    }

    @Column
    public Double getCarbon() {
        return carbon;
    }

    public void setCarbon(Double carbon) {
        this.carbon = carbon;
    }

    @Column
    public Double getAsh() {
        return ash;
    }

    public void setAsh(Double ash) {
        this.ash = ash;
    }

    @Column
    public Double getVolatiles() {
        return volatiles;
    }

    public void setVolatiles(Double volatiles) {
        this.volatiles = volatiles;
    }

    @Column
    public Double getWater() {
        return water;
    }

    public void setWater(Double water) {
        this.water = water;
    }

    @Column(name = "total_amount")
    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Column(name = "unit_price")
    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Column(name = "confirm_person")
    public String getConfirmPerson() {
        return confirmPerson;
    }

    public void setConfirmPerson(String confirmPerson) {
        this.confirmPerson = confirmPerson == null ? null : confirmPerson.trim();
    }

    @Column
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
    
}