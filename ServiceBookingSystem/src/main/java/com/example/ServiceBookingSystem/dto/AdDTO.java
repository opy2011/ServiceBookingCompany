package com.example.ServiceBookingSystem.dto;


import org.springframework.web.multipart.MultipartFile;

public class AdDTO {

    private Long id;

    private String serviceName;

    private String description;

    private Double price;


    private MultipartFile img;

    private byte[] returnedImg;

//    private String companyName;

    private Long userId;

    public AdDTO() {

    }

    public AdDTO(String serviceName,Double price,String description,MultipartFile img) {
        this.serviceName = serviceName;
        this.price = price;
        this.description = description;
        this.img = img;
    }

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }

    public byte[] getReturnedImg() {
        return returnedImg;
    }

    public void setReturnedImg(byte[] returnedImg) {
        this.returnedImg = returnedImg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }





    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

//    public String getCompanyName() {
//        return companyName;
//    }

//    public void setCompanyName(String companyName) {
//        this.companyName = companyName;
//    }
}
