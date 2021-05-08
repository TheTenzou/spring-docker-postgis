package ru.tenzou.kotlindatarest.model

import org.locationtech.jts.geom.Point
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
    @Column(name = "restaurant_position")
    var position: Point,
    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var menus: List<Menu>?
)
