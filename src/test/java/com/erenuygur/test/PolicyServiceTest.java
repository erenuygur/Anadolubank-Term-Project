package com.erenuygur.test;

import com.erenuygur.model.Policy;
import com.erenuygur.service.PolicyService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class PolicyServiceTest {
    PolicyService policyService;

    @Before
    public void setup() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        policyService = ctx.getBean(PolicyService.class);
    }

    @Test
    public void testListCustomerPolicyTest() throws Exception {
        List<Policy> policyList = policyService.listPolicy();
        assertThat(policyList.size()).isNotEqualTo(0);
    }

    @Test
    public void testCreateBarChartTest() throws Exception {
        String actualResult = "" + policyService.createBarChart();
        boolean expectedResult = true;
        Assert.assertTrue(actualResult, expectedResult);
    }

    @Test
    public void testCreateLineChartTest() throws Exception {
        String actualResult = "" + policyService.createPieChart();
        boolean expectedResult = true;
        Assert.assertTrue(actualResult, expectedResult);
    }
}
