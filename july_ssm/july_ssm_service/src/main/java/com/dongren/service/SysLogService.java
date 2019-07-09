package com.dongren.service;

import com.dongren.domain.SysLog; /**
 * @author dongren
 * @create 2019-07-05 11:56
 */
public interface SysLogService {
    void save(SysLog sysLog) throws Exception;
}
