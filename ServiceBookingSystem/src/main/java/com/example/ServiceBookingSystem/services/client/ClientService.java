package com.example.ServiceBookingSystem.services.client;

import com.example.ServiceBookingSystem.dto.AdDTO;
import com.example.ServiceBookingSystem.dto.AdDetailsForClientDTO;
import com.example.ServiceBookingSystem.dto.ReservationDto;
import com.example.ServiceBookingSystem.dto.ReviewDto;

import java.util.List;

public interface ClientService {
    List<AdDTO> getAllAds();
    List<AdDTO> searchAdByName(String name);

    boolean bookService(ReservationDto reservationDto);
    AdDetailsForClientDTO getAdDetailsByAdId(Long adId);

    List<ReservationDto> getAllBookingsByUserId(Long userId);

    Boolean giveReview(ReviewDto reviewDto);
}
