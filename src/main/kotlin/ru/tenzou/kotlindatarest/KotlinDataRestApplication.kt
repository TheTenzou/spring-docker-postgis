package ru.tenzou.kotlindatarest

import org.locationtech.jts.geom.Coordinate
import org.locationtech.jts.geom.GeometryFactory
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import ru.tenzou.kotlindatarest.model.Menu
import ru.tenzou.kotlindatarest.model.Restaurant
import ru.tenzou.kotlindatarest.model.RestaurantType
import ru.tenzou.kotlindatarest.repository.MenuRepository
import ru.tenzou.kotlindatarest.repository.RestaurantRepository
import java.time.LocalDate

@SpringBootApplication
class KotlinDataRestApplication {
    private val log = LoggerFactory.getLogger(KotlinDataRestApplication::class.java)

    @Bean
    fun init(
        menuRepository: MenuRepository,
        restaurantRepository: RestaurantRepository
    ) = CommandLineRunner {
        val menu = Menu(
            id = 0L,
            restaurant = null,
            date = LocalDate.now(),
            title = "first menu title",
            text = "text of menu"
        )

        val type = RestaurantType(
            id = 0L,
            name = "Restaurant Type",
            restaurants = null
        )

        val restaurant = Restaurant(
            id = 0L,
            name = "First restaurant",
            type = type,
            location = "some new street",
            menus = arrayListOf(menu),
            position = GeometryFactory().createPoint(
                Coordinate(1.0, 1.0)
            )
        )


        menu.restaurant = restaurant

        restaurantRepository.save(restaurant)
        log.info("new restaurant is ${restaurant.id}")
    }
}

fun main(args: Array<String>) {
    runApplication<KotlinDataRestApplication>(*args)
}
