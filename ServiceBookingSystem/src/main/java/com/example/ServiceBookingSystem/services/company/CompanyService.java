package com.example.ServiceBookingSystem.services.company;

import com.example.ServiceBookingSystem.dto.AdDTO;

import java.io.IOException;
import java.util.List;

public interface CompanyService {

    boolean postAd(Long userId, AdDTO adDTO) throws IOException;

    public List<AdDTO> getAllAds(Long userId);

    public AdDTO getAdById(Long adId);

    public boolean deleteAd(Long adId);
}
