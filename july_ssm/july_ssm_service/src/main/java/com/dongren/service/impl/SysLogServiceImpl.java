package com.dongren.service.impl;

import com.dongren.dao.SysLogDao;
import com.dongren.domain.SysLog;
import com.dongren.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dongren
 * @create 2019-07-05 11:56
 */
@Service
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogDao sysLogDao;
    @Override
    public void save(SysLog sysLog) throws Exception {
        sysLogDao.save(sysLog);
    }
}
