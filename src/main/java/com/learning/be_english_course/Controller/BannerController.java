package com.learning.be_english_course.Controller;

import com.learning.be_english_course.Entity.Banner;
import com.learning.be_english_course.Exception.apiRespone.ApiResponse;
import com.learning.be_english_course.Exception.apiRespone.BaseController;
import com.learning.be_english_course.Service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/banner")
public class BannerController extends BaseController {
    @Autowired
    private BannerService bannerService;
    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ApiResponse<Banner>> uploadBanner(
            @RequestPart("file") MultipartFile file
    ) throws IOException {
        Banner banner = bannerService.createBanner(file);
        return success("them thanh cong" , banner);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Banner>>> getAllBanners() {
        List<Banner> banners = bannerService.getAllBanners();
        return success("DS banner" , banners);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteBanner(@PathVariable int id) {
        bannerService.deleteBanner(id);
        return success("Xóa thành công" , "ID = " + id);
    }
}
