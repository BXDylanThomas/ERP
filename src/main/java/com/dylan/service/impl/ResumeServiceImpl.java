package com.dylan.service.impl;

import com.dylan.dao.ResumeDao;
import com.dylan.model.Resume;
import com.dylan.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ResumeDao resumeDao;

    @Override
    public boolean addResume(Resume resume) {
        if(resume==null || resume.getAccId()<=0){
            return false;
        }
        return resumeDao.addResume(resume);
    }

    @Override
    public boolean updateResume(Resume resume) {
        if(resume==null || resume.getAccId()<=0){
            return false;
        }
        return resumeDao.updateResume(resume);
    }

    @Override
    public Resume queryResumeBy_accId(int accId) {
        if(accId<=0){
            return null;
        }
        return resumeDao.queryResumeBy_accId(accId);
    }
}
