package com.icraft.sample.aws.ec2.controllers;

import com.icraft.sample.aws.ec2.dtos.ResponseData;
import com.icraft.sample.aws.ec2.services.AwsEc2Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/aws/ec2")
@RequiredArgsConstructor
public class AwsEc2Controller {
    private final AwsEc2Service service;

    @GetMapping("sync")
    public ResponseEntity<ResponseData> getEc2(
            @RequestParam("access-key") String accessKey,
            @RequestParam("private-key") String privateKey,
            HttpServletRequest request
    ) {

        service.syncEc2(accessKey, privateKey);

        ResponseData responseData = ResponseData.ofSuccess(request, "success", "success");
        return ResponseEntity.ok(responseData);
    }

}
