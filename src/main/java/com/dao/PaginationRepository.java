package com.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PaginationRepository extends PagingAndSortingRepository<UserEntity, Integer> {

}
