package com.example.ServiceBookingSystem.dto;

import java.util.List;

public class AdDetailsForClientDTO {

    private AdDTO adDTO;

    private List<ReviewDto> reviewDtoList;

    public AdDTO getAdDTO() {
        return adDTO;
    }

    public void setAdDTO(AdDTO adDTO) {
        this.adDTO = adDTO;
    }

    public List<ReviewDto> getReviewDtoList() {
        return reviewDtoList;
    }

    public void setReviewDtoList(List<ReviewDto> reviewDtoList) {
        this.reviewDtoList = reviewDtoList;
    }
}
