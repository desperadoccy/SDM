package pers.desperado.dao;

import pers.desperado.domain.Complaint;

public interface ComplaintDao {
    /**
     * 存储投诉信息
     */
    void save(Complaint complaint);
}
