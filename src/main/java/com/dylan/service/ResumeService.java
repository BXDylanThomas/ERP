package com.dylan.service;

import com.dylan.model.Resume;

public interface ResumeService {


    //添加简历
    boolean addResume(Resume resume);

    //更新简历
    boolean updateResume(Resume resume);

    //通过账号id  查询简历
    Resume queryResumeBy_accId(int accId);
}
