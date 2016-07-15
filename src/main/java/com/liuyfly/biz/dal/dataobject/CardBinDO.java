package com.liuyfly.biz.dal.dataobject;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据对象
 * 
 * @since 2016-07-05
 */
public class CardBinDO implements Serializable {

    private static final long serialVersionUID = 146771045607600396L;

    private Long              id;

    private String            instCode;

    private String            instName;

    private String            cardName;

    private String            pan;

    private Integer              panLen;

    private String            panPri;

    private Integer              panPriLen;

    private String            cardType;

    private Date              createTime;

    public CardBinDO() {
        super();
    }

    public CardBinDO(Long id, String instCode, String instName, String cardName, String pan, Integer panLen,
                     String panPri, Integer panPriLen, String cardType, Date createTime) {
        this.id = id;
        this.instCode = instCode;
        this.instName = instName;
        this.cardName = cardName;
        this.pan = pan;
        this.panLen = panLen;
        this.panPri = panPri;
        this.panPriLen = panPriLen;
        this.cardType = cardType;
        this.createTime = createTime;
    }

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
                .format("CardBinDO [id=%s, instCode=%s, instName=%s, cardName=%s, pan=%s, panLen=%s, panPri=%s, panPriLen=%s, cardType=%s, createTime=%s]",
                        id, instCode, instName, cardName, pan, panLen, panPri, panPriLen, cardType, createTime);
    }
}
