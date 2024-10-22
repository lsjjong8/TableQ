package com.itschool.tableq.controller.api;

import groovy.util.logging.Slf4j;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Tag(name = "사용자", description = "사용자 관련 API") // 문서에서 쉽게 찾도록 한글로 했음
@RestController
@RequestMapping("/api/user")
public class UserApiController {
}