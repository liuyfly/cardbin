package com.liuyfly.dto;

import java.io.Serializable;
import java.util.Date;

public class CardBinDTO implements Serializable {

    private static final long serialVersionUID = 3065703051990813811L;

    private Long    id;

    private String  instCode;

    private String  instName;

    private String  cardName;

    private String  pan;

    private Integer panLen;

    private String  panPri;

    private Integer panPriLen;

    private String  cardType;

    private Date    createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstCode() {
        return instCode;
    }

    public void setInstCode(String instCode) {
        this.instCode = instCode;
    }

    public String getInstName() {
        return instName;
    }

    public void setInstName(String instName) {
        this.instName = instName;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public Integer getPanLen() {
        return panLen;
    }

    public void setPanLen(Integer panLen) {
        this.panLen = panLen;
    }

    public String getPanPri() {
        return panPri;
    }

    public void setPanPri(String panPri) {
        this.panPri = panPri;
    }

    public Integer getPanPriLen() {
        return panPriLen;
    }

    public void setPanPriLen(Integer panPriLen) {
        this.panPriLen = panPriLen;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return String
                .format("CardBinDTO [id=%s, instCode=%s, instName=%s, cardName=%s, pan=%s, panLen=%s, panPri=%s, panPriLen=%s, cardType=%s, createTime=%s]",
                        id, instCode, instName, cardName, pan, panLen, panPri, panPriLen, cardType, createTime);
    }

}
