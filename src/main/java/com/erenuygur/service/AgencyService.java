package com.erenuygur.service;

import com.erenuygur.chart.BarChart;
import com.erenuygur.model.Agency;
import com.erenuygur.repository.AgencyRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

@NoArgsConstructor
@Data
public class AgencyService {
    private AgencyRepository agencyRepository;

    public Agency getAgency(int id) throws Exception {
        return agencyRepository.getAgency(id);
    }

    public List<Agency> listAgency() {
        return agencyRepository.getAllAgency();
    }

    public LinkedHashMap<String, Double> getTotalPaymentByAgency() {
        return this.agencyRepository.getTotalPaymentByAgency();
    }

    public boolean createBarChart() throws IOException {
        try {
            ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
            AgencyService agencyService = ctx.getBean(AgencyService.class);

            BarChart.barChartForByAgency(agencyService.getTotalPaymentByAgency());
            return true;
        } catch (BeansException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
