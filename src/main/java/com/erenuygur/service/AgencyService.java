package com.erenuygur.service;


import com.erenuygur.model.Agency;
import com.erenuygur.model.Customer;
import com.erenuygur.model.Policy;
import com.erenuygur.repository.AgencyRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
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


}
