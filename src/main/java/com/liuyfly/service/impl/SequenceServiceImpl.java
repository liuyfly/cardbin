package com.liuyfly.service.impl;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.beans.factory.annotation.Autowired;

import com.liuyfly.biz.dal.dao.SequenceDAO;
import com.liuyfly.biz.dal.dataobject.SequenceDO;
import com.liuyfly.service.SequenceService;

public class SequenceServiceImpl implements SequenceService {
    @Autowired
    private SequenceDAO sequenceDAO;

    private String      name;

    private Long        step;

    private final Lock  lock;

    public SequenceServiceImpl() {
        this.lock = new ReentrantLock();
    }

    @Override
    public Long nextValue() {
        this.lock.lock();
        try {
            Long currentValue = getCurrentValue();
            Long newSequence = currentValue.longValue() + step.longValue();
            int updateCount = updateValue(currentValue, newSequence);
            if (updateCount > 0) {
                return newSequence;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.lock.unlock();
        }
        return null;
    }

    private Long getCurrentValue() {
        SequenceDO sequenceDO = new SequenceDO();
        sequenceDO.setName(name);
        List<SequenceDO> list = sequenceDAO.findListByExample(sequenceDO);
        Long sequence = null;
        if (list != null && list.size() > 0) {
            SequenceDO sequenceDO2 = list.get(0);
            sequence = sequenceDO2.getValue();
            return sequence;
        }
        return null;
    }

    private Integer updateValue(Long oldSequence, Long newSequence) {
        SequenceDO sequenceDO = new SequenceDO();
        sequenceDO.setName(name);
        sequenceDO.setValue(newSequence);
        sequenceDO.setOldValue(oldSequence);
        return sequenceDAO.updateSequenceDO(sequenceDO).intValue();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStep() {
        return step;
    }

    public void setStep(Long step) {
        this.step = step;
    }

}
