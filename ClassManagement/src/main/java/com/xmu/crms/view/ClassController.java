package com.xmu.crms.view;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xmu.crms.view.vo.ClassVO;

/**
 * class controller
 * @author lingyun
 *
 */
@RestController
@RequestMapping("/class")
public class ClassController {

    @GetMapping
    public Object selectClasses() {

        return new ClassVO[]{

                new ClassVO(23, "周三1-2节", "邱明", "公寓405", new CourseVO(2, "OOAD", 6))

        };

    }

}