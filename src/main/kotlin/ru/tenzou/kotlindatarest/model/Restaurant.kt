package ru.tenzou.kotlindatarest.model

import org.springframework.data.rest.core.annotation.RestResource
import javax.persistence.*

@Entity
@Table(name = "restaurant")
data class Restaurant(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    @Column(name = "restaurant_name")
    var name: String,
    @Column(name = "restaurant_location")
    var location: String,
    @Column(name = "restaurant_lat")
    var lat: Double,
    @Column(name = "restaurant_lon")
    var lon: Double,
    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @RestResource(exported = false)
    var menus: List<Menu>
)
