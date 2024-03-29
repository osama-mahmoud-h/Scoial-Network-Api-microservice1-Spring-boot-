package com.example.server.services;

import com.example.server.models.Post;
import com.example.server.models.Profile;
import com.example.server.payload.request.ProfileRequestDto;
import com.example.server.payload.response.PostResponceDto;
import com.example.server.payload.response.UserResponceDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public interface ProfileService {

    boolean uploadImage(HttpServletRequest httpServletRequest, MultipartFile image);

     boolean updateBio(HttpServletRequest httpServletRequest, String bio);

     boolean updateAbout(HttpServletRequest httpServletRequest, String bio);

    boolean updateSkills(HttpServletRequest httpServletRequest, String[] skills);

    List<Post> getUserPosts(HttpServletRequest httpServletRequest);

     List<Post> getUserStaredPosts(HttpServletRequest httpServletRequest);

     List<UserResponceDto> getFollowers(HttpServletRequest servletRequest);

    List<UserResponceDto> getFollowing(HttpServletRequest servletRequest);

    String follow(HttpServletRequest servletRequest, Long user_id);

    boolean isFollowing(Long followerId, Long followedId);

    Profile getProfile(Long userid);

    Profile updateProfile(HttpServletRequest httpServletRequest, ProfileRequestDto profileDto);

    boolean updateEducation(HttpServletRequest httpServletRequest, String education);

    List<PostResponceDto> allPosts(HttpServletRequest httpServletRequests);
}
