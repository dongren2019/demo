package com.dongren.dao;

import com.dongren.domain.Member;

/**
 * @author dongren
 * @create 2019-07-03 7:57
 */
public interface MemberDao {
    Member findMemberById(Integer id);
}
