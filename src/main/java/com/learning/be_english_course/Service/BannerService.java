package com.learning.be_english_course.Service;

import com.cloudinary.utils.ObjectUtils;
import com.learning.be_english_course.Entity.Banner;
import com.learning.be_english_course.Repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class BannerService  {
    @Autowired
    private BannerRepository bannerRepository;
    @Autowired
    private CloudinaryService cloudinaryService;

    public Banner createBanner(MultipartFile file) throws IOException {
        Map<String, Object> result = cloudinaryService.uploadFile(file, "banners");
        String imageUrl = result.get("secure_url").toString();

        Banner banner = new Banner();
        banner.setUrl(imageUrl);
        return bannerRepository.save(banner);
    }


    public List<Banner> getAllBanners() {
        return bannerRepository.findAll();
    }

    public void deleteBanner(int id) {
        bannerRepository.deleteById(id);
    }

}
