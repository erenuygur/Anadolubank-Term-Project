package com.erenuygur.test;

import com.erenuygur.model.Agency;
import com.erenuygur.service.AgencyService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class AgencyServiceTest {
    private AgencyService agencyService;

    @Before
    public void setup() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        agencyService = ctx.getBean(AgencyService.class);
    }


    @Test
    public void getListAgencyTest() throws Exception {
        List<Agency> agencyList = agencyService.listAgency();
        assertThat(agencyList.size()).isNotEqualTo(0);

    }

    @Test
    public void getCreateBarChartTest() throws Exception {
        String actualResult = "" + agencyService.createBarChart();
        boolean expectedResult = true;
        Assert.assertTrue(actualResult, expectedResult);
    }
}
