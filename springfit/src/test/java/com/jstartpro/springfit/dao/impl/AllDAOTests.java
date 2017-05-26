package com.jstartpro.springfit.dao.impl;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ JdbcPlayerDAOTest.class, JdbcStatsDAOTest.class, JdbcTeamDAOTest.class })
public class AllDAOTests {

}
