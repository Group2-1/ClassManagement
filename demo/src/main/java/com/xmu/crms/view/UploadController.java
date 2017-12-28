package com.xmu.crms.view;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xmu.crms.view.vo.UrlVO;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @PostMapping("/avatar")
    public UrlVO uploadAvatar(HttpServletResponse response) {
    	
        response.setStatus(200);
        UrlVO url = new UrlVO();
        url.setUrl("/avatar/3486.png");
        return url;
    }

}
