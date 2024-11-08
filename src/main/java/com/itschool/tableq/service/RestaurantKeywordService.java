package com.itschool.tableq.service;

import com.itschool.tableq.domain.RestaurantKeyword;
import com.itschool.tableq.domain.User;
import com.itschool.tableq.network.Header;
import com.itschool.tableq.network.Pagination;
import com.itschool.tableq.network.request.RestaurantKeywordRequest;
import com.itschool.tableq.network.response.RestaurantKeywordResponse;
import com.itschool.tableq.network.response.UserResponse;
import com.itschool.tableq.service.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RestaurantKeywordService extends BaseService<RestaurantKeywordRequest, RestaurantKeywordResponse, RestaurantKeyword> {

    @Override
    public Header<List<RestaurantKeywordResponse>> getPaginatedList(Pageable pageable) {
        Page<RestaurantKeyword> entities =  baseRepository.findAll(pageable);

        List<RestaurantKeywordResponse> restaurantKeywordResponsesList = entities.stream()
                .map(entity -> response(entity))
                .collect(Collectors.toList());

        Pagination pagination = Pagination.builder()
                .totalPages(entities.getTotalPages())
                .totalElements(entities.getTotalElements())
                .currentPage(entities.getNumber())
                .currentElements(entities.getNumberOfElements())
                .build();

        return Header.OK(restaurantKeywordResponsesList, pagination);
    }

    @Override
    protected RestaurantKeywordResponse response(RestaurantKeyword restaurantKeyword) {
        return new RestaurantKeywordResponse(restaurantKeyword);
    }

    @Override
    public Header<RestaurantKeywordResponse> create(Header<RestaurantKeywordRequest> request) {
        RestaurantKeywordRequest restaurantKeywordRequest = request.getData();

        RestaurantKeyword restaurantKeyword = RestaurantKeyword.builder()
                .restaurant(restaurantKeywordRequest.getRestaurant())
                .keyword(restaurantKeywordRequest.getKeyword())
                .build();

        baseRepository.save(restaurantKeyword);
        return Header.OK(response(restaurantKeyword));
    }

    @Override
    public Header<RestaurantKeywordResponse> read(Long id) {
        return Header.OK(response(baseRepository.findById(id).orElse(null)));
    }

    @Override
    public Header<RestaurantKeywordResponse> update(Long id, Header<RestaurantKeywordRequest> request) {
        RestaurantKeywordRequest restaurantKeywordRequest = request.getData();
        RestaurantKeyword restaurantKeyword = baseRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not found"));
        restaurantKeyword.update(restaurantKeywordRequest);
        return Header.OK(response(restaurantKeyword));
    }

    @Override
    public Header delete(Long id) {
        return baseRepository.findById(id)
                .map(restaurantKeyword -> {
                    baseRepository.delete(restaurantKeyword);
                    return Header.OK(response(restaurantKeyword));
                })
                .orElseThrow(() -> new IllegalArgumentException("not found"));
    }
}