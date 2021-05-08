package ru.tenzou.kotlindatarest.model

import javax.persistence.*

@Entity
@Table(name = "restaurant_type")
data class RestaurantType(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long,
    @Column(name = "type_name")
    var name:String,
    @OneToMany(mappedBy = "type", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var restaurants: List<Restaurant>?
)