package ru.tenzou.kotlindatarest.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import ru.tenzou.kotlindatarest.model.RestaurantType

@RepositoryRestResource
interface RestaurantTypeRepository : JpaRepository<RestaurantType, Long>