package pers.desperado.service.impl;

import pers.desperado.dao.ComplaintDao;
import pers.desperado.dao.impl.ComplaintDaoImpl;
import pers.desperado.domain.Complaint;
import pers.desperado.service.ComplainService;

public class ComplainServiceImpl implements ComplainService {

    private ComplaintDao complaintDao = new ComplaintDaoImpl();
    @Override
    public void commitComlaint(Complaint complaint) {
        complaintDao.save(complaint);
    }
}
