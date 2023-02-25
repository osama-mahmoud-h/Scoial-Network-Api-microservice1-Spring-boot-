package com.example.server.controllers;


import com.example.server.payload.request.ProfileRequestDto;
import com.example.server.payload.response.ResponseHandler;
import com.example.server.services.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping("/upload-image")
    public ResponseEntity<?> uploadImage(HttpServletRequest httpServletRequest,
                                         @RequestParam("image")MultipartFile image
    ){
        boolean imageUloaded = profileService.uploadImage(httpServletRequest,image);
        return ResponseHandler.generateResponse(
                imageUloaded ? "image Uploaded successfully" : "error while uploading image",
                imageUloaded ? HttpStatus.OK : HttpStatus.BAD_REQUEST,
                imageUloaded ? true : false
        );
    }

    @PutMapping("/update")
    public ResponseEntity<?> addBio(HttpServletRequest httpServletRequest,
                                    @RequestBody ProfileRequestDto profileDto
    ){
        return ResponseHandler.generateResponse("Profile updated successfully",
                HttpStatus.OK,
                profileService.updateProfile(httpServletRequest,profileDto)
                );
    }

    @GetMapping("/{userid}")
    public ResponseEntity<?> getProfile(@PathVariable("userid") Long userId){
        return ResponseHandler.generateResponse("Profile get successfully",
                HttpStatus.OK,
                profileService.getProfile(userId)
        );
    }

}