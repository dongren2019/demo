package com.dongren.dao;

import com.dongren.domain.Traveller;

import java.util.List;

/**
 * @author dongren
 * @create 2019-07-03 8:22
 */
public interface TravellerDao {
    List<Traveller> findTravellerListByOId(Integer id);
}
